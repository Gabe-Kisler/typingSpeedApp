package typingSpeedApp;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class WordsForTest {
	
	ArrayList<String> words;
	
	public WordsForTest (String filePath) {
		this.words = new ArrayList<>();
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
				words.add(word);
			}
		}
		
		catch (Exception e) {
			System.out.print("An error occurred while opening the file");
		}
	}
}
