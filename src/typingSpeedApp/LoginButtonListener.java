package typingSpeedApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LoginButtonListener implements ActionListener {
	JTextField userNameTextField;
	JTextField passwordTextField;
	JTextField newUserNameTextField;
	JTextField newPasswordTextField;
	JTextField confirmPasswordTextField;
	JButton loginButton;
	JButton newUserButton;
	JButton createAccountButton;
	String usersFilePath;
	String filePath;
	JFrame window;
	
	public LoginButtonListener (JFrame window, JTextField userNameTextField, JTextField passwordTextField, 
		String usersFilePath, String filePath, JButton loginButton, JButton newUserButton, 
		JButton createAccountButton, JTextField newUserNameTextField, JTextField newPasswordTextField,
		JTextField confirmPasswordTextField) {
		
		this.userNameTextField = userNameTextField;
		this.passwordTextField = passwordTextField;
		this.newUserNameTextField = newUserNameTextField;
		this.newPasswordTextField = newPasswordTextField;
		this.confirmPasswordTextField = confirmPasswordTextField;
		this.createAccountButton = createAccountButton;
		this.loginButton = loginButton;
		this.newUserButton = newUserButton;
		this.usersFilePath = usersFilePath;
		this.filePath = filePath;
		this.window = window;

	}
	
	
	@Override
	public void actionPerformed (ActionEvent e) {
		
		if (e.getSource() == loginButton) {
	
			String userNameString = userNameTextField.getText();
			String passwordString = passwordTextField.getText();
		
			LoginLogic logic = new LoginLogic(usersFilePath);
		
			if (logic.isUser(userNameString, passwordString)) {
				window.dispose();
				typingSpeedAppGUI gui = new typingSpeedAppGUI(filePath);
			}	
		
			else {
				JOptionPane.showMessageDialog(window, "ERROR");
				System.out.println("Username: " + userNameString);
				System.out.println("Password: " + passwordString);
				System.out.println("Is valid user: " + logic.isUser(userNameString, passwordString));
				}
		
			}
		
	else if (e.getSource() == newUserButton) {
		
		loginScreenGUI callNewUserGUI = new loginScreenGUI ("hi");
		callNewUserGUI.initializeNewUserGUI();
		
	}
		
	else if (e.getSource() == createAccountButton) {
		
			JOptionPane.showMessageDialog(window, "button pressed");
			String newUser = newUserNameTextField.getText();
			String newPass = newPasswordTextField.getText();
			String confirmNewPass = confirmPasswordTextField.getText();
		
			  System.out.println("New User: " + newUser);
			  System.out.println("New Password: " + newPass);
			  System.out.println("Confirm Password: " + confirmNewPass);
			
			if (!newPass.equals(confirmNewPass)) {
				return;
			}
			
			LoginLogic logic = new LoginLogic (usersFilePath);
			try {
				System.out.print("TRY BLOCK");
				logic.addUsersToFile(usersFilePath, newUser, newPass);
			}
			catch (IOException e1) {
				System.err.println("Error: " + e1.getMessage());
			}
				
					
				}
				
			}
		}
	
			
	
	

