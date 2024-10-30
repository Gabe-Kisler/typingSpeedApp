package typingSpeedApp;


import javax.swing.*;
import javax.swing.text.*;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

public class typingScreenButtonListener implements KeyListener, ActionListener{
	JTextPane wordsInput = new JTextPane();
	JFrame window = new JFrame ();
	String wordsInField;
	int letterIndex;
	int keysPressed = 0;
	int wordsTyped = 0;
	 
	public typingScreenButtonListener (JTextPane wordsInput, JFrame window, String wordsInField, int letterIndex) {
		this.wordsInput = wordsInput;
		this.window = window;
		this.wordsInField = wordsInField;
		this.letterIndex = letterIndex;
		this.wordsInput.addKeyListener(this);
	}
	
	
		@Override
		public void keyPressed (KeyEvent e) {
		
				
				char userInput = e.getKeyChar();
				
				String userInputAsString = Character.toString(userInput);

				StyledDocument doc = wordsInput.getStyledDocument();
				
				SimpleAttributeSet correct = new SimpleAttributeSet();
				SimpleAttributeSet incorrect = new SimpleAttributeSet();
				
				Color grey = new Color (191, 191, 191);
				Color red = new Color (148, 62, 62);
				
				StyleConstants.setBackground(correct, grey);
				StyleConstants.setBackground(incorrect, red);
				
				
				if (e.getKeyCode() == 8) {
					try {
						letterIndex--;
						doc.remove(doc.getLength() - 1, 1);
					} catch (BadLocationException e1) {
						
					}
				}
				
				
	
				else if (letterIndex < wordsInField.length() && (Character.isLetter(userInput) || Character.isSpace(userInput))) {
					
					try {
						if (wordsInField.charAt(letterIndex) == userInput) {
								doc.insertString(doc.getLength(), userInputAsString, correct);
							}
								else {
								doc.insertString(doc.getLength(), userInputAsString, incorrect);
							}
							
							letterIndex++;
							keysPressed++;
						
					
					}
					catch (BadLocationException ex) {
							
					}
				}
				
			if (keysPressed >= 5) {
				wordsTyped++;
			}
					
				e.consume();
			}
		

	
	


	@Override
	public void actionPerformed(ActionEvent e) {

	}



	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
