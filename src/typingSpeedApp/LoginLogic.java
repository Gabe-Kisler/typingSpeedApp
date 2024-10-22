package typingSpeedApp;

import java.io.*;
import java.util.*;

public class LoginLogic {

	String filePath = "C:\\Programming\\typingSpeedApp\\words.csv";
	ArrayList<String> userNames;
	ArrayList<String> passwords; 
	
	public LoginLogic (String usersFilePath) {
		userNames = new ArrayList<>();
		passwords = new ArrayList<>();
		
		try {
			loadUsersFromFile (usersFilePath);
		} catch (FileNotFoundException e) {
			
		}
	}
	
	
	public boolean isUser (String userNameString, String passwordString) {
		for (String userName : userNames) {
			if (userNameString.equals(userName)) {
				int indexOfUser = userNames.indexOf(userNameString);
				if (passwordString.equals(passwords.get(indexOfUser))) {
					return true;
				}
			}
		}
	return false;
	}
	
	
	public void loadUsersFromFile (String usersFilePath) throws FileNotFoundException {
		File usersFile = new File (usersFilePath);
		
		try (Scanner scanner = new Scanner(usersFile)) {
			scanner.nextLine();
			
			
			while (scanner.hasNext()) {
				String currLine = scanner.nextLine();
				String[] userNamePassword = currLine.split(",");
				
				String userName = userNamePassword[0];
				String password = userNamePassword[1];
				
				if (userNamePassword.length >= 2) {
					
				userName.trim();
				password.trim();
				userNames.add(userName);
				passwords.add(password);
				}
				
				else {
					System.out.print("Invalid");
				}
				
			}
			
			
			
		}
	}
}
			
		

