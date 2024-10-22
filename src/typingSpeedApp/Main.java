package typingSpeedApp;

public class Main {
	public static void main (String[] args) {
		
		
		String filePath = "C:\\Programming\\typingSpeedApp\\words.csv";
		String usersFilePath = "C:\\Programming\\typingSpeedApp\\users.csv";
		
		loginScreenGUI loginGUI = new loginScreenGUI (usersFilePath);
		//typingSpeedAppGUI gui = new typingSpeedAppGUI(filePath);
		
		
	}
}
