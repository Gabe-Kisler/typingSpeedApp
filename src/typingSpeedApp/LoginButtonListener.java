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
	JButton loginButton;
	JButton newUserButton;
	String usersFilePath;
	String filePath;
	JFrame window;
	
	public LoginButtonListener (JFrame window, JTextField userNameTextField, JTextField passwordTextField, 
		String usersFilePath, String filePath, JButton loginButton, JButton newUserButton) {
		
		this.userNameTextField = userNameTextField;
		this.passwordTextField = passwordTextField;
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
		
			LogicLoginScreen logic = new LogicLoginScreen(usersFilePath);
			LogicCreateAccountScreen AccLogic = new LogicCreateAccountScreen(usersFilePath);
		
			if (logic.isUser(userNameString, passwordString)) {
				window.dispose();
				GUITypingScreen gui = new GUITypingScreen(filePath);
			}	
		
			else if (!logic.isUser(userNameString, passwordString) && AccLogic.userNameExists(userNameString) ) {
				JOptionPane.showMessageDialog(window, "Incorrect password, please try again");
	
			}

			else {
				JOptionPane.showMessageDialog(window, "Unknown username, please create an account or try again");
			}
		}
		
		
	else if (e.getSource() == newUserButton) {
		
		window.dispose();
		GUICreateAccountScreen AccGUI = new GUICreateAccountScreen (usersFilePath);
		AccGUI.initializeNewUserGUI();
		
	}
	}
}
	
			
	
	

