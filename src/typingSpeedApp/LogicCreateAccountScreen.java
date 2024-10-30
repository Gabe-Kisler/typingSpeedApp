package typingSpeedApp;

import java.io.*;
import java.util.*;


public class LogicCreateAccountScreen {

	ArrayList<String> userNames;
	ArrayList<String> passwords;
	
	public LogicCreateAccountScreen (String usersFilePath) {
		userNames = new ArrayList<>();
		passwords = new ArrayList<>();
		try {
			loadUsersFromFile (usersFilePath);
		} catch (FileNotFoundException e) {
			
		}
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
	
	public boolean userNameExists (String userNameString) {
		System.out.print("userNameExists method test");
		
		String trimmedUser = userNameString.trim();
		
		for (String userName : userNames) {
			if (trimmedUser.equals(userName.trim())) {
				return true;
			}
			
		}
		
		return false;
	}
	
	public void updatePassword (String newPass) {
		
	}
}
