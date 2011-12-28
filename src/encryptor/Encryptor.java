package encryptor;
/***
 * Encrypts & Decrypts using multiple methods
 * 
 * @author KyleBrodie
 * @version 1.0
 *
 */
public class Encryptor {
	
	public static final float VERSION = 1.0f;
	
	/***
	 * Encrypts with the One time pad method
	 * 
	 * @param plaintext the text to be encrypted
	 * @param key the key with which the plaintext will be encrypted
	 * @return an encrypted version of the provided plaintext
	 * @throws IllegalArgumentException for not provided an equal length plaintext and key
	 */
	public static String encryptOTP(String plaintext, String key) throws IllegalArgumentException {
		if(alphaNumericLength(plaintext) != key.length())
			throw new IllegalArgumentException("Key must be the same length as the text");
		try {
			Integer.parseInt(key);
		} catch(NumberFormatException ne) {
			throw new IllegalArgumentException("Key must only consist of numbers");
		}
		
		char[] letters = plaintext.toCharArray();
		
		int keyIndex = 0; //separate indexes because the key does not have spaces and all non alpha-numeric characters are skipped
		for(int i = 0; i < letters.length; i++) {
			if(!Character.isLetterOrDigit(letters[i])) continue;
			letters[i] = (char) (letters[i] + Integer.parseInt(String.valueOf(key.charAt(keyIndex++))));
		}
		
		return String.copyValueOf(letters);
	}
	
	/***
	 * 
	 * @param s String to check
	 * @return the number of alpha-numeric characters
	 */
	private static int alphaNumericLength(String s) {
		int length = 0;
		for(int i = 0; i < s.length(); i++)
			if(Character.isLetterOrDigit(s.charAt(i)))
				length++;
		return length;
	}

	/***
	 * Decrypts a one time pad cypher
	 * 
	 * @param cyphertext the cyphertext to be decrypted
	 * @param key the key necessary to decrypt the cyphertext
	 * @return a decrypted version of the provided cyphertext
	 * @throws IllegalArgumentException for not providing an equal length cyphertext and key
	 */
	public static String decryptOTP(String cyphertext, String key) throws IllegalArgumentException {
		if(alphaNumericLength(cyphertext) != key.length())
			throw new IllegalArgumentException("Key must be the same length as the text");
		try {
			Integer.parseInt(key);
		} catch(NumberFormatException ne) {
			throw new IllegalArgumentException("Key must only consist of numbers");
		}

		char[] letters = cyphertext.toCharArray();
		
		int keyIndex = 0; //separate indices because the key does not have spaces and all non alpha-numeric characters are skipped
		for(int i = 0; i < letters.length; i++) {
			if(!Character.isLetterOrDigit(letters[i])) continue;
			letters[i] = (char) (letters[i] - Integer.parseInt(String.valueOf(key.charAt(keyIndex++))));
		}
		
		return String.copyValueOf(letters);
	}
	
	/***
	 * The standard online ROT13 encryption (for letters, and ROT5 for numbers)
	 * 
	 * @param text the string to be encrypted
	 * @return an encrypted version of the provided text string
	 */
	public static String rot13(String text) {
		char[] temp = text.toCharArray();
		for(int i = 0; i < temp.length; i++) {
			char current = temp[i];
			
			if(!Character.isLetterOrDigit(current)) continue;
			
			if(Character.isDigit(current))
				temp[i] = ROT5_NUMBERS[indexOf(NUMBERS,current)];
			else
				temp[i] = ROT13_ALPHABET[indexOf(ALPHABET,current)];
		}
		return String.valueOf(temp);
	}
	private static final char[] ALPHABET =     {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private static final char[] ROT13_ALPHABET = {'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m'};
	private static final char[] NUMBERS =     {'0','1','2','3','4','5','6','7','8','9'};
	private static final char[] ROT5_NUMBERS = {'5','6','7','8','9','0','1','2','3','4'};

	/***
	 * returns the index of a certain character in a specified array.
	 * 
	 * @param charArr the array to be searched
	 * @param letter the character to search for
	 * @return the index of the specific char in the array or -1 if not in the array
	 */
	private static int indexOf(char[] charArr, char letter) {
		for(int i = 0; i < charArr.length; i++)
			if(charArr[i] == letter)
				return i;
		return -1;
	}
}