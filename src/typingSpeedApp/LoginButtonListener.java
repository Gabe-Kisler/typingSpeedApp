package typingSpeedApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class LoginButtonListener implements ActionListener {
	JTextField userName;
	JTextField password;
	String usersFilePath;
	String filePath;
	JFrame window;
	
	public LoginButtonListener (JFrame window, JTextField userName, JTextField password, String usersFilePath, String filePath) {
		this.userName = userName;
		this.password = password;
		this.usersFilePath = usersFilePath;
		this.filePath = filePath;
		this.window = window;
	}
	
	
	public void actionPerformed (ActionEvent e) {
		String userNameString = userName.getText();
		String passwordString = password.getText();
		
		LoginLogic logic = new LoginLogic(usersFilePath);
		
		if (logic.isUser(userNameString, passwordString)) {
			window.dispose();
			typingSpeedAppGUI gui = new typingSpeedAppGUI(filePath);
			JOptionPane.showMessageDialog(window,"Button pressed");
		}	
		
		else {
			JOptionPane.showMessageDialog(window, "ERROR");
		}
		
	}
}
