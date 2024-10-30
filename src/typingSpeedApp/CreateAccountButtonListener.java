package typingSpeedApp;

import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import javax.swing.JOptionPane;

public class CreateAccountButtonListener implements ActionListener {
	 JTextField newUserField;
	 JTextField newPassField;
	 JButton createAccountButton;
	 JFrame window;
	 String usersFilePath;
	 JTextField confirmNewPassField;
	 
	 public CreateAccountButtonListener (JTextField newUserField, JTextField newPassField, JButton createAccountButton, JFrame window, String usersFilePath, JTextField confirmNewPassField) {
		 this.newUserField = newUserField;
		 this.newPassField = newPassField;
		 this.createAccountButton = createAccountButton;
		 this.window = window;
		 this.usersFilePath = usersFilePath;
		 this.confirmNewPassField = confirmNewPassField;
	 }
	

	 	

		@Override
		public void actionPerformed(ActionEvent e) {
			String newUser = newUserField.getText();
			String newPass = newPassField.getText();
			String confirmNewPass = confirmNewPassField.getText();
		
			LogicCreateAccountScreen logic = new LogicCreateAccountScreen (usersFilePath);
			GUILoginScreen loginGUI = new GUILoginScreen (usersFilePath);
			
			if (logic.userNameExists(newUser)) {
				JOptionPane.showMessageDialog(window, "Account already exists");
				window.dispose();
				loginGUI.initializeLoginGUI();
				
			}
			
			else if (!logic.userNameExists(newUser) && !newPass.equals(confirmNewPass)) {
				JOptionPane.showMessageDialog(window, "passwords do not match, please try again");
			}
			
			else {
			
			
			try {
				System.out.print("TRY BLOCK");
				logic.addUsersToFile(usersFilePath, newUser, newPass);
				JOptionPane.showMessageDialog(window, "Account added successfully");
				window.dispose();
				loginGUI.initializeLoginGUI();
				
			}
			catch (IOException e1) {
				System.err.println("Error: " + e1.getMessage());
			}
				
					
				}
		}
			
	}


		
	

		


