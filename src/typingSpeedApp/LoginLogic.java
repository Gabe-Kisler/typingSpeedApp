package typingSpeedApp;

import java.io.*;
import java.util.*;

public class LoginLogic {

	String filePath = "C:\\Programming\\typingSpeedApp\\words.csv";
	String usersFilePath = "C:\\Programming\\typingSpeedApp\\users.csv";
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
		String trimmedUser = userNameString.trim();
		String trimmedPassword = passwordString.trim();
		
		for (String userName : userNames) {
			if (trimmedUser.equals(userName.trim())) {
				int indexOfUser = userNames.indexOf(userName);
				if (trimmedPassword.equals(passwords.get(indexOfUser).trim())) {
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
		
				
				if (userNamePassword.length >= 2) {
				String userName = userNamePassword[0].trim();
				String password = userNamePassword[1].trim();
				
				userNames.add(userName);
				passwords.add(password);
				
				}
				
				else {
					System.out.print("Invalid");
				}
				
			}
			
			
			
		}
	}
	
	public void addUsersToFile (String usersFilePath, String newUser, String newPassword) throws IOException {
		System.out.print("addUsers method test");
		File usersFile = new File (usersFilePath);
		
		try (FileWriter writer = new FileWriter(usersFile, true)) {
			
			if (userNames.contains(newUser.trim())) {
				throw new IOException ("User already exists");
			}
			
			writer.append(newUser);
			writer.append(",");
			writer.append(newPassword);
			writer.append("\n");
			
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
	
			
			
		}
	}
}

		

