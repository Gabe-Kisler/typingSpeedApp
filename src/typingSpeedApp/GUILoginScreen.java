package typingSpeedApp;

import java.awt.*;
import javax.swing.*;

public class GUILoginScreen {	
	
	String filePath = "C:\\Programming\\typingSpeedApp\\words.csv";
	Color defaultBackgroundColor = new Color(94, 117, 148);
	Color buttonColor = new Color (129, 152, 184);
	Color grey = new Color (102, 106, 106);
	Font wordsDisplayedFont = new Font ("Arial", Font.BOLD, 25);
	Font menuInstructionsFont = new Font ("Arial", Font.BOLD, 12);
	Font loginFont2 = new Font ("Arial", Font.BOLD, 13);
	Font loginFont = new Font ("Arial", Font.BOLD, 40);
	String usersFilePath;
	LogicTypingScreen mainLogic;
	LogicLoginScreen loginLogic;
	
	public GUILoginScreen (String usersFilePath) {
		this.usersFilePath = usersFilePath;
		loginLogic = new LogicLoginScreen(usersFilePath);
	}
	
	public void initializeLoginGUI() {
		
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
		login.setText("Login");
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
		JTextField userNameTextField = new JTextField();
		userNameTextField.setText(null);
		userNameTextField.setBounds(68, 155, 150, 25);
		userNameTextField.setFont(menuInstructionsFont);
		userNameTextField.setBorder(BorderFactory.createLineBorder(grey));
		userNameTextField.setBackground(buttonColor);
		
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
		JPasswordField passwordTextField = new JPasswordField();
		passwordTextField.setText(null);
		passwordTextField.setBounds(68, 205, 150, 25);
		passwordTextField.setFont(menuInstructionsFont);
		passwordTextField.setBorder(BorderFactory.createBevelBorder(100));
		passwordTextField.setBackground(buttonColor);
		
		
		// set 'login' button
		JButton loginButton = new JButton();
		loginButton.setText("Login");
		loginButton.setFont(loginFont2);
		loginButton.setBounds(68, 240, 150, 20);
		loginButton.setBackground(buttonColor);
		loginButton.setVisible(true);
		loginButton.setHorizontalTextPosition(SwingConstants.LEFT );
		loginButton.setHorizontalAlignment(SwingConstants.LEFT);
		loginButton.setBorder(BorderFactory.createLineBorder(grey));
		loginButton.setFocusable(false);
		
		
		JButton newUserButton = new JButton();
		newUserButton.setText("Sign Up");
		newUserButton.setFont(loginFont2);
		newUserButton.setBounds(68, 270, 150, 20);
		newUserButton.setBackground(buttonColor);
		newUserButton.setVisible(true);
		newUserButton.setHorizontalTextPosition(SwingConstants.LEFT );
		newUserButton.setHorizontalAlignment(SwingConstants.LEFT);
		newUserButton.setBorder(BorderFactory.createLineBorder(grey));
		newUserButton.setFocusable(false);
		
		
		
		
		
		loginButton.addActionListener(new LoginButtonListener(window, userNameTextField, 
				passwordTextField, usersFilePath, filePath, loginButton, newUserButton));
		newUserButton.addActionListener(new LoginButtonListener(window, userNameTextField, 
				passwordTextField, usersFilePath, filePath, loginButton, newUserButton));
		
		window.setVisible(true);
		window.add(userNameTextField);
		window.add(userName);
		window.add(passwordTextField);
		window.add(password);
		window.add(loginButton);
		window.add(newUserButton);
		window.add(login);
		
		userNameTextField.requestFocusInWindow();
	}



}
