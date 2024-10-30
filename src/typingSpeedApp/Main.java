package typingSpeedApp;

public class Main {
	public static void main (String[] args) {
		
		
		String filePath = "C:\\Programming\\typingSpeedApp\\words.csv";
		String usersFilePath = "C:\\Programming\\typingSpeedApp\\users.csv";
		
		GUILoginScreen loginGUI = new GUILoginScreen (usersFilePath);
		loginGUI.initializeLoginGUI();
		//typingSpeedAppGUI gui = new typingSpeedAppGUI(filePath);
		
		
	}
}
