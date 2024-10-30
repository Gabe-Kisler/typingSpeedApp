package typingSpeedApp;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUICreateAccountScreen {
	String usersFilePath;
	
	public GUICreateAccountScreen (String usersFilePath) {
		this.usersFilePath = usersFilePath;
		
	}
	
	public void initializeNewUserGUI () {
		
	
		String filePath = "C:\\Programming\\typingSpeedApp\\words.csv";
		Color defaultBackgroundColor = new Color(94, 117, 148);
		Color buttonColor = new Color (129, 152, 184);
		Color grey = new Color (102, 106, 106);
		Font wordsDisplayedFont = new Font ("Arial", Font.BOLD, 25);
		Font menuInstructionsFont = new Font ("Arial", Font.BOLD, 12);
		Font loginFont2 = new Font ("Arial", Font.BOLD, 13);
		Font loginFont = new Font ("Arial", Font.BOLD, 40);
		LogicTypingScreen mainLogic;
		LogicLoginScreen loginLogic;
		
		//create login screen window
		JFrame window = new JFrame();
		window.setSize(300, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(defaultBackgroundColor);
		window.setLayout(null);
		
		
		//display 'Login'
		JTextField login = new JTextField();
		login.setEditable(false);
		login.setBounds(68, 60, 250, 100);
		login.setFont(loginFont);
		login.setText("Register");
		login.setOpaque(false);
		login.setBackground(defaultBackgroundColor);
		login.setBorder(BorderFactory.createEmptyBorder());
		login.setFocusable(false);
		
		//display 'user name: '
		JTextField userName = new JTextField();
		userName.setEditable(false);
		userName.setBounds(68, 135, 100, 20);
		userName.setFont(menuInstructionsFont);
		userName.setText("user name: ");
		userName.setOpaque(false);
		userName.setBackground(defaultBackgroundColor);
		userName.setBorder(BorderFactory.createEmptyBorder());
		userName.setFocusable(false);
		
		
		//user name text field
		JTextField newUserNameTextField = new JTextField();
		newUserNameTextField.setText(null);
		newUserNameTextField.setBounds(68, 155, 150, 25);
		newUserNameTextField.setFont(menuInstructionsFont);
		newUserNameTextField.setBorder(BorderFactory.createLineBorder(grey));
		newUserNameTextField.setBackground(buttonColor);
		
		//display 'password: '
		JTextField password = new JTextField();
		password.setEditable(false);
		password.setBounds(68, 185, 100, 20);
		password.setFont(menuInstructionsFont);
		password.setText("password: ");
		password.setOpaque(false);
		password.setBackground(defaultBackgroundColor);
		password.setBorder(BorderFactory.createEmptyBorder());
		password.setFocusable(false);
		
		//password text field
		JTextField newPasswordTextField = new JTextField();
		newPasswordTextField.setText(null);
		newPasswordTextField.setBounds(68, 205, 150, 25);
		newPasswordTextField.setFont(menuInstructionsFont);
		newPasswordTextField.setBorder(BorderFactory.createBevelBorder(100));
		newPasswordTextField.setBackground(buttonColor);
		
		//display 'password: '
		JTextField confirmPassword = new JTextField();
		confirmPassword.setEditable(false);
		confirmPassword.setBounds(68, 236, 150, 20);
		confirmPassword.setFont(menuInstructionsFont);
		confirmPassword.setText("confirm password: ");
		confirmPassword.setOpaque(false);
		confirmPassword.setBackground(defaultBackgroundColor);
		confirmPassword.setBorder(BorderFactory.createEmptyBorder());
		confirmPassword.setFocusable(false);
		
		//password text field
		JTextField confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setText(null);
		confirmPasswordTextField.setBounds(68, 256, 150, 25);
		confirmPasswordTextField.setFont(menuInstructionsFont);
		confirmPasswordTextField.setBorder(BorderFactory.createBevelBorder(100));
		confirmPasswordTextField.setBackground(buttonColor);
		
	
		
		// set 'create Account' button
		JButton createAccountButton = new JButton();
		createAccountButton.setText("create account");
		createAccountButton.setFont(loginFont2);
		createAccountButton.setBounds(68, 290, 150, 20);
		createAccountButton.setBackground(buttonColor);
		createAccountButton.setVisible(true);
		createAccountButton.setHorizontalTextPosition(SwingConstants.LEFT );
		createAccountButton.setHorizontalAlignment(SwingConstants.LEFT);
		createAccountButton.setBorder(BorderFactory.createLineBorder(grey));
		createAccountButton.setFocusable(false);
		

		createAccountButton.addActionListener(new CreateAccountButtonListener(newUserNameTextField, 
				newPasswordTextField, createAccountButton, window, usersFilePath, confirmPasswordTextField));
		
		window.setVisible(true);
		window.add(newUserNameTextField);
		window.add(userName);
		window.add(newPasswordTextField);
		window.add(password);
		window.add(createAccountButton);
		window.add(login);
		window.add(confirmPassword);
		window.add(confirmPasswordTextField);
		
	}
	

}
