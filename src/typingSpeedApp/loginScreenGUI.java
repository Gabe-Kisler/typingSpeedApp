package typingSpeedApp;

import java.awt.*;
import javax.swing.*;

public class loginScreenGUI {	
	
	String filePath = "C:\\Programming\\typingSpeedApp\\words.csv";
	Color defaultBackgroundColor = new Color(94, 117, 148);
	Color buttonColor = new Color (129, 152, 184);
	Color grey = new Color (102, 106, 106);
	Font wordsDisplayedFont = new Font ("Arial", Font.BOLD, 25);
	Font menuInstructionsFont = new Font ("Arial", Font.BOLD, 12);
	Font loginFont2 = new Font ("Arial", Font.BOLD, 13);
	Font loginFont = new Font ("Arial", Font.BOLD, 40);
	String usersFilePath;
	MainLogic mainLogic;
	LoginLogic loginLogic;
	
	public loginScreenGUI (String usersFilePath) {
		this.usersFilePath = usersFilePath;
		loginLogic = new LoginLogic(usersFilePath);
	}
	
	public void initializeLoginGUI() {
		
		//create login screen window
		JFrame window = new JFrame();
		window.setSize(1800, 900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(defaultBackgroundColor);
		window.setLayout(null);
		
		
		//display 'Login'
		JTextField login = new JTextField();
		login.setEditable(false);
		login.setBounds(700, 200, 250, 100);
		login.setFont(loginFont);
		login.setText("Login");
		login.setOpaque(false);
		login.setBackground(defaultBackgroundColor);
		login.setBorder(BorderFactory.createEmptyBorder());
		login.setFocusable(false);
		
		//display 'user name: '
		JTextField userName = new JTextField();
		userName.setEditable(false);
		userName.setBounds(700, 275, 100, 20);
		userName.setFont(menuInstructionsFont);
		userName.setText("user name: ");
		userName.setOpaque(false);
		userName.setBackground(defaultBackgroundColor);
		userName.setBorder(BorderFactory.createEmptyBorder());
		userName.setFocusable(false);
		
		//user name text field
		JTextField userNameTextField = new JTextField();
		userNameTextField.setText(null);
		userNameTextField.setBounds(700, 295, 150, 25);
		userNameTextField.setFont(menuInstructionsFont);
		userNameTextField.setBorder(BorderFactory.createLineBorder(grey));
		userNameTextField.setBackground(buttonColor);
		
		//display 'password: '
		JTextField password = new JTextField();
		password.setEditable(false);
		password.setBounds(700, 318, 100, 20);
		password.setFont(menuInstructionsFont);
		password.setText("password: ");
		password.setOpaque(false);
		password.setBackground(defaultBackgroundColor);
		password.setBorder(BorderFactory.createEmptyBorder());
		password.setFocusable(false);
		
		//password text field
		JTextField passwordTextField = new JTextField();
		passwordTextField.setText(null);
		passwordTextField.setBounds(700, 338, 150, 25);
		passwordTextField.setFont(menuInstructionsFont);
		passwordTextField.setBorder(BorderFactory.createBevelBorder(100));
		passwordTextField.setBackground(buttonColor);
		
		
		// set 'login' button
		JButton loginButton = new JButton();
		loginButton.setText("Login");
		loginButton.setFont(loginFont2);
		loginButton.setBounds(700, 372, 150, 20);
		loginButton.setBackground(buttonColor);
		loginButton.setVisible(true);
		loginButton.setHorizontalTextPosition(SwingConstants.LEFT );
		loginButton.setHorizontalAlignment(SwingConstants.LEFT);
		loginButton.setBorder(BorderFactory.createLineBorder(grey));
		loginButton.setFocusable(false);
		
		
		JButton newUserButton = new JButton();
		newUserButton.setText("Sign Up");
		newUserButton.setFont(loginFont2);
		newUserButton.setBounds(700, 390, 150, 20);
		newUserButton.setBackground(buttonColor);
		newUserButton.setVisible(true);
		newUserButton.setHorizontalTextPosition(SwingConstants.LEFT );
		newUserButton.setHorizontalAlignment(SwingConstants.LEFT);
		newUserButton.setBorder(BorderFactory.createLineBorder(grey));
		newUserButton.setFocusable(false);
		
		
		
		
		
		loginButton.addActionListener(new LoginButtonListener(window, userNameTextField, 
				passwordTextField, usersFilePath, filePath, loginButton, newUserButton, null, null, null,
				null));
		newUserButton.addActionListener(new LoginButtonListener(window, userNameTextField, 
				passwordTextField, usersFilePath, filePath, loginButton, newUserButton, null, null, null,
				null));
		
		window.setVisible(true);
		window.add(userNameTextField);
		window.add(userName);
		window.add(passwordTextField);
		window.add(password);
		window.add(loginButton);
		window.add(newUserButton);
		window.add(login);
	}
	
	public void initializeNewUserGUI () {
		
		//create login screen window
		JFrame window = new JFrame();
		window.setSize(1800, 900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(defaultBackgroundColor);
		window.setLayout(null);
		
		
		//display 'Login'
		JTextField login = new JTextField();
		login.setEditable(false);
		login.setBounds(695, 200, 250, 100);
		login.setFont(loginFont);
		login.setText("Register");
		login.setOpaque(false);
		login.setBackground(defaultBackgroundColor);
		login.setBorder(BorderFactory.createEmptyBorder());
		login.setFocusable(false);
		
		//display 'user name: '
		JTextField userName = new JTextField();
		userName.setEditable(false);
		userName.setBounds(700, 275, 100, 20);
		userName.setFont(menuInstructionsFont);
		userName.setText("user name: ");
		userName.setOpaque(false);
		userName.setBackground(defaultBackgroundColor);
		userName.setBorder(BorderFactory.createEmptyBorder());
		userName.setFocusable(false);
		
		
		//user name text field
		JTextField newUserNameTextField = new JTextField();
		newUserNameTextField.setText(null);
		newUserNameTextField.setBounds(700, 295, 150, 25);
		newUserNameTextField.setFont(menuInstructionsFont);
		newUserNameTextField.setBorder(BorderFactory.createLineBorder(grey));
		newUserNameTextField.setBackground(buttonColor);
		
		//display 'password: '
		JTextField password = new JTextField();
		password.setEditable(false);
		password.setBounds(700, 318, 100, 20);
		password.setFont(menuInstructionsFont);
		password.setText("password: ");
		password.setOpaque(false);
		password.setBackground(defaultBackgroundColor);
		password.setBorder(BorderFactory.createEmptyBorder());
		password.setFocusable(false);
		
		//password text field
		JTextField newPasswordTextField = new JTextField();
		newPasswordTextField.setText(null);
		newPasswordTextField.setBounds(700, 338, 150, 25);
		newPasswordTextField.setFont(menuInstructionsFont);
		newPasswordTextField.setBorder(BorderFactory.createBevelBorder(100));
		newPasswordTextField.setBackground(buttonColor);
		
		//display 'password: '
		JTextField confirmPassword = new JTextField();
		confirmPassword.setEditable(false);
		confirmPassword.setBounds(700, 364, 150, 20);
		confirmPassword.setFont(menuInstructionsFont);
		confirmPassword.setText("confirm password: ");
		confirmPassword.setOpaque(false);
		confirmPassword.setBackground(defaultBackgroundColor);
		confirmPassword.setBorder(BorderFactory.createEmptyBorder());
		confirmPassword.setFocusable(false);
		
		//password text field
		JTextField confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setText(null);
		confirmPasswordTextField.setBounds(700, 382, 150, 25);
		confirmPasswordTextField.setFont(menuInstructionsFont);
		confirmPasswordTextField.setBorder(BorderFactory.createBevelBorder(100));
		confirmPasswordTextField.setBackground(buttonColor);
		
	
		
		// set 'login' button
		JButton createAccountButton = new JButton();
		createAccountButton.setText("create account");
		createAccountButton.setFont(loginFont2);
		createAccountButton.setBounds(700, 415, 150, 20);
		createAccountButton.setBackground(buttonColor);
		createAccountButton.setVisible(true);
		createAccountButton.setHorizontalTextPosition(SwingConstants.LEFT );
		createAccountButton.setHorizontalAlignment(SwingConstants.LEFT);
		createAccountButton.setBorder(BorderFactory.createLineBorder(grey));
		createAccountButton.setFocusable(false);
		

		createAccountButton.addActionListener(new LoginButtonListener(window, null, null, 
				usersFilePath, filePath, null, null, createAccountButton, newUserNameTextField,
				newPasswordTextField, confirmPasswordTextField));
		
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
