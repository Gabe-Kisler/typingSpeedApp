
 
package typingSpeedApp;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.Color;



public class typingSpeedAppGUI {
	
	
	Color defaultBackgroundColor = new Color(94, 117, 148);
	Font wordsDisplayedFont = new Font ("Arial", Font.BOLD, 25);
	Font menuInstructionsFont = new Font ("Arial", Font.BOLD, 12);
	MainLogic mainLogic;

	
	public typingSpeedAppGUI (String filePath) {
		mainLogic = new MainLogic (filePath);
		initializeGUI();
	}

	public void initializeGUI () {;
		//creates main window for application
		JFrame window = new JFrame();
		window.setSize(1800, 900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(defaultBackgroundColor);
		window.setLayout(null);
		
		
		//main area where text is printed to be typed
		JTextArea wordsToType = new JTextArea();
		wordsToType.setVisible(true);
		wordsToType.setLineWrap(true);
		wordsToType.setWrapStyleWord(true);
		wordsToType.setText(mainLogic.getWordsForOutput());
		wordsToType.setFont(wordsDisplayedFont);
		JScrollPane scrollPane = new JScrollPane(wordsToType);
		scrollPane.setBounds (75, 275, 1600, 200);
		
		wordsToType.setOpaque(false);
		wordsToType.setBackground(defaultBackgroundColor);
		wordsToType.setBorder(BorderFactory.createEmptyBorder());
		
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getViewport().setBackground(defaultBackgroundColor);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		//text field for restart button (instruction)
		JTextField escToRestart = new JTextField();
		escToRestart.setText("Press esc to restart test");
		escToRestart.setBounds(75 , 260, 150, 10);
		escToRestart.setOpaque(false);
		escToRestart.setBorder(BorderFactory.createEmptyBorder());
		escToRestart.setBackground(defaultBackgroundColor);
		escToRestart.setFont(menuInstructionsFont);
		escToRestart.setEditable(false);
		escToRestart.setFocusable(false);
		
		
		JButton fifteenSecButton = createTimeButton (15, 225, 254);
		JButton thirtySecButton = createTimeButton (30, 275, 254);
		JButton sixtySecButton = createTimeButton (60, 325, 254);
		
		
		
		

		window.add(scrollPane);
		window.add(escToRestart);
		window.add(fifteenSecButton);
		window.add(thirtySecButton);
		window.add(sixtySecButton);
		window.setVisible(true);
	}
	
	
	public JButton createTimeButton (int time, int X, int Y) {
		JButton timeButton = new JButton ();
		timeButton.setBounds(X, Y, 50, 25);
		timeButton.setText(Integer.toString(time));
		timeButton.setOpaque(false);
		timeButton.setBorder(BorderFactory.createEmptyBorder());
		timeButton.setFont(menuInstructionsFont);
		timeButton.setBackground(defaultBackgroundColor);
		timeButton.setFocusPainted(false);
	
		
		
		return timeButton;
	}
	
	
}
