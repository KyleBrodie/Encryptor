package encryptor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
/***
 * Auto-generated source for GUI, built with WindowBuilder.
 * Provides user interface for Encryptor functions
 * 
 * @author KyleBrodie
 * @version 1.0
 *
 */
public class EncryptorGUI {

	private JFrame frmEncryptor;
	private JTextField txtKey;
	private JTextField txtText;
	private JTextField ans;
	private final Action action = new EncryptAction();
	private final Action action_1 = new DecryptAction();
	private final Action action_2 = new RotAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptorGUI window = new EncryptorGUI();
					window.frmEncryptor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EncryptorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEncryptor = new JFrame();
		frmEncryptor.setResizable(false);
		frmEncryptor.setTitle("Encryptor " + Encryptor.VERSION);
		frmEncryptor.setBounds(100, 100, 360, 160);
		frmEncryptor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmEncryptor.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Text:");
		
		txtText = new JTextField();
		txtText.setToolTipText("enter the text to be encrypted or decrypted");
		txtText.setText("text");
		txtText.setColumns(10);
		
		JLabel label = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("Key:");
		
		JLabel label_1 = new JLabel("");
		
		txtKey = new JTextField();
		txtKey.setToolTipText("enter the key for encryption/decryption or number of rotations for ROT");
		txtKey.setText("key");
		txtKey.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		
		JLabel label_3 = new JLabel("");
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setAction(action);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setAction(action_1);
		
		JButton btnRot = new JButton("ROT");
		btnRot.setAction(action_2);
		
		JLabel lblResults = new JLabel("Results:");
		
		ans = new JTextField();
		ans.setEditable(false);
		ans.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addComponent(label)
							.addGap(26)
							.addComponent(label_1)
							.addGap(56)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(label_2)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtText, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtKey, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
										.addGap(6)
										.addComponent(lblResults)
										.addGap(9)
										.addComponent(ans, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
									.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
										.addComponent(btnEncrypt)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnDecrypt)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnRot))))))
					.addGap(74))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtKey, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEncrypt)
						.addComponent(btnDecrypt)
						.addComponent(btnRot))
					.addGap(4)
					.addComponent(label_1)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label)
									.addGap(45))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(label_3)
										.addComponent(label_2))
									.addGap(82))))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblResults)
								.addComponent(ans, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		panel.setLayout(gl_panel);
	}

	
	private class EncryptAction extends AbstractAction {
		public EncryptAction() {
			putValue(NAME, "Encrypt");
			putValue(SHORT_DESCRIPTION, "action that calls the encryptor's encrypt method");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				String result = Encryptor.encryptOTP(txtText.getText(), txtKey.getText());
				ans.setText(result);
			} catch (IllegalArgumentException ie) {
				ans.setText(ie.getMessage());
			}
		}
	}
	private class DecryptAction extends AbstractAction {
		public DecryptAction() {
			putValue(NAME, "Decrypt");
			putValue(SHORT_DESCRIPTION, "action that calls the encryptor's decrypt method");
		}
		public void actionPerformed(ActionEvent e) {
			try {	
				String result = Encryptor.decryptOTP(txtText.getText(), txtKey.getText());
				ans.setText(result);
			} catch (IllegalArgumentException ie) {
				ans.setText(ie.getMessage());
			}
		}
	}
	private class RotAction extends AbstractAction {
		public RotAction() {
			putValue(NAME, "ROT13");
			putValue(SHORT_DESCRIPTION, "action that calls the encryptor's ROT method");
		}
		public void actionPerformed(ActionEvent e) {
			String result = Encryptor.rot13(txtText.getText());
			ans.setText(result);
		}
	}
}
