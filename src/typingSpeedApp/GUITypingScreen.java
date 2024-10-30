
 
package typingSpeedApp;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.util.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




public class GUITypingScreen {
	
	
	Color defaultBackgroundColor = new Color(94, 117, 148);
	Font wordsDisplayedFont = new Font ("Arial", Font.BOLD, 25);
	Font menuInstructionsFont = new Font ("Arial", Font.BOLD, 12);
	LogicTypingScreen mainLogic;
	String filePath;
	int letterIndex;
	int wordsTyped;
	int time;
	Timer timer;
	int timeMS = 1000;
	int userTimeChoice = 15;
	JLabel timerLabel;
	


	
	public GUITypingScreen (String filePath) {
		this.filePath = filePath;
		mainLogic = new LogicTypingScreen (filePath);
		letterIndex = 0;
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
		JTextPane wordsToType = new JTextPane();
		wordsToType.setFocusable(false);
		String wordsInField = mainLogic.getWordsForOutput();
		wordsToType.setText(wordsInField);
		wordsToType.setBounds(75, 280, 1600, 210);
		wordsToType.setFont(wordsDisplayedFont);
		wordsToType.setBorder(BorderFactory.createEmptyBorder());
		wordsToType.setBackground(defaultBackgroundColor);
		wordsToType.setOpaque(true);

		
		
		JTextPane wordsInput = new JTextPane();
		wordsInput.setBounds(75, 520, 1600, 260);
		wordsInput.setOpaque(true);
		wordsInput.setBackground(defaultBackgroundColor);
		wordsInput.setBorder(BorderFactory.createEmptyBorder());
		wordsInput.setFont(wordsDisplayedFont);
		
		
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
		
		JTextField WPM = new JTextField();
		WPM.setText("WPM: ");
		WPM.setBounds(379 , 261, 150, 10);
		WPM.setOpaque(false);
		WPM.setBorder(BorderFactory.createEmptyBorder());
		WPM.setBackground(defaultBackgroundColor);
		WPM.setFont(menuInstructionsFont);
		WPM.setEditable(false);
		WPM.setFocusable(false);
		
		JTextField accuracy = new JTextField();
		accuracy.setText("Accuracy: ");
		accuracy.setBounds(445 , 261, 150, 10);
		accuracy.setOpaque(false);
		accuracy.setBorder(BorderFactory.createEmptyBorder());
		accuracy.setBackground(defaultBackgroundColor);
		accuracy.setFont(menuInstructionsFont);
		accuracy.setEditable(false);
		accuracy.setFocusable(false);
		
		JLabel timerLabel = new JLabel("0");
		timerLabel.setBounds(550 , 261, 150, 10);
		timerLabel.setVisible(true);
		timerLabel.setBackground(defaultBackgroundColor);
		timerLabel.setFont(menuInstructionsFont);
		timerLabel.setBorder(BorderFactory.createEmptyBorder());
		
		
		
		
		window.add(wordsToType);
		window.add(wordsInput);
		window.add(escToRestart);
		window.add(fifteenSecButton);
		window.add(thirtySecButton);
		window.add(sixtySecButton);
		window.add(WPM);
		window.add(accuracy);
		window.add(timerLabel);
		window.setVisible(true);
		
		wordsInput.requestFocusInWindow();
		
		typingScreenButtonListener listener = new typingScreenButtonListener (wordsInput, window, wordsInField, letterIndex);
		
		fifteenSecButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				userTimeChoice = 15;
				setTimerTime (userTimeChoice);
			}
		});
		
		thirtySecButton.addActionListener (new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				userTimeChoice = 30;
				setTimerTime (userTimeChoice);
			}
		});
		
		sixtySecButton.addActionListener (new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				userTimeChoice = 60;
				setTimerTime (userTimeChoice);
			}
		});
		
		wordsInput.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed (KeyEvent e) {
				startTimer(userTimeChoice);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}


			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
	
	public void setTimerTime (int startTime) {
		time = startTime;
		timerLabel.setText(Integer.toString(time));
		System.out.print("STT called time : " + time);
	}
	
	public void startTimer (int startTime) {
		System.out.print("start timer accessed");
		time = startTime;
		timerLabel.setText(Integer.toString(time));
		
		System.out.print("Starting timer, time : " + time);
		
		timer = new Timer (timeMS, new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (time > 0) {
					time--;
					timerLabel.setText(Integer.toString(time));
				}
				
				else {
					timer.stop();
				}
			}
		});
		timer.start();
	}
	
	
	
	
}
