package encryptor;

//import java.io.*;

public class Encryptor {
	
	public static final float VERSION = 1.0f;
	
	/*public static void main(String[] args) {
		try {
		    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    String str = "";
		    System.out.print("Enter function(encryptOTP,decryptOTP,rot13): ");
		    str = in.readLine();
		    str.toLowerCase();
		    if(str.equals("rot13")) {
		    	String text = "";
		    	System.out.print("Enter text: ");
			    text = in.readLine();
			    System.out.print("result: " + rot13(text));
		    } else if(str.equals("encryptOTP")) {
		    	String text = "";
		    	String key = "";
		    	System.out.print("Enter text: ");
			    text = in.readLine();
			    System.out.print("Enter key: ");
			    key = in.readLine();
			    System.out.print("result: " + encryptOTP(text,key));
		    } else if(str.equals("decryptOTP")) {
		    	String text = "";
		    	String key = "";
		    	System.out.print("Enter text: ");
			    text = in.readLine();
			    System.out.print("Enter key: ");
			    key = in.readLine();
			    System.out.print("result: " + decryptOTP(text,key));
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	public static String encryptOTP(String plaintext, String key) throws IllegalArgumentException {
		if(plaintext.length() != key.length())
			throw new IllegalArgumentException("Key must be the same length as the text");
		
		char[] letters = plaintext.toCharArray();
		for(int i = 0; i < letters.length; i++) {
			letters[i] = (char) (letters[i] + Integer.parseInt(String.valueOf(key.charAt(i))));
		}
		return String.copyValueOf(letters);
	}

	public static String decryptOTP(String cyphertext, String key) throws IllegalArgumentException  {
		if(cyphertext.length() != key.length())
			throw new IllegalArgumentException("Key must be the same length as the text");

		char[] letters = cyphertext.toCharArray();
		for(int i = 0; i < letters.length; i++) {
			letters[i] = (char) (letters[i] - Integer.parseInt(String.valueOf(key.charAt(i))));
		}
		return String.copyValueOf(letters);
	}
	
	private static final char[] ALPHABET =     {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private static final char[] ROT_ALPHABET = {'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m'};
	private static final char[] NUMBERS =     {'0','1','2','3','4','5','6','7','8','9'};
	private static final char[] ROT_NUMBERS = {'5','6','7','8','9','0','1','2','3','4'};
	public static String rot13(String text) {
		char[] temp = text.toCharArray();
		for(int i = 0; i < temp.length; i++) {
			char current = temp[i];
			if(Character.isDigit(current))
				temp[i] = ROT_NUMBERS[indexOf(NUMBERS,current)];
			else
				temp[i] = ROT_ALPHABET[indexOf(ALPHABET,current)];
		}
		return String.valueOf(temp);
	}

	private static int indexOf(char[] charArr, char letter) {
		for(int i = 0; i < charArr.length; i++)
			if(charArr[i] == letter)
				return i;
		return -1;
	}
}