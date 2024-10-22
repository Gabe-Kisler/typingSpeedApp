package typingSpeedApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class MainLogic {
	
	ArrayList<String> words;
	String currentWord;
	
	public MainLogic (String filePath) {
		words = new ArrayList<>();
		try {
			loadWordsFromFile(filePath);
		} catch (FileNotFoundException e) {
			
		}
		
			
	}
	
	public ArrayList<String> getWords () {
		return this.words;
	}
	
	public void loadWordsFromFile (String filePath) throws FileNotFoundException {
		File wordsFile = new File(filePath);
		
		if (!wordsFile.exists()) {
			throw new FileNotFoundException ("File could not be loaded");
		}
		
		try (Scanner scanner = new Scanner(wordsFile)) {
			scanner.useDelimiter(",");
			
			while (scanner.hasNext()) {
				String word = scanner.next();
				word.trim();
				words.add(word);
			}
		}
		
		catch (Exception e) {
			System.out.print("An error occurred while opening the file");
		}
	}
	
	public String getWordsForOutput () {
		StringBuilder wordOutput = new StringBuilder();
		Random random = new Random ();
		
		while (wordOutput.length() < 1000) {
			int nextIndex = random.nextInt(words.size());
			
			wordOutput.append(words.get(nextIndex)).append(" ");
		}
		
		return wordOutput.toString();
	}
}
