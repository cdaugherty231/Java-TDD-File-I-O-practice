package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		int numberOfWords = 0;
		int numberOfSentences = 0;
		File inputFile = getInputFileFromUser();
		if (inputFile != null) {
			try(Scanner fileScanner = new Scanner(inputFile)) {
				while(fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					line = line.replaceAll("\\s+", " ");
					String[] words = line.trim().split(" |\\: ");
					for(int i=0;i<words.length;i++) {
						String nextWord = words[i];
						if (nextWord.endsWith(".")||nextWord.endsWith("!")||nextWord.endsWith("?")) {
						numberOfSentences++;
						}
					}
					if(!(line.isEmpty())) {
					numberOfWords += words.length;
					}
				}
				System.out.println("Word Count: " + numberOfWords);
				System.out.println("Sentence Count: " + numberOfSentences);
			} catch (FileNotFoundException e) {
				System.out.println("Unable to find file "+e.getMessage());
				e.printStackTrace();
			}
		}
	}

	
	
	
	
	
	
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
	
			
			System.out.print("Please enter path to input file >>> ");
			String path = userInput.nextLine();
		
			File inputFile = new File(path);
			if(inputFile.exists() == false) { // checks for the existence of a file
				System.out.println(path+" does not exist");
				inputFile = null;
			} else if(inputFile.isFile() == false) {
				System.out.println(path+" is not a file");
				inputFile = null;
			}
		
			return inputFile;
		
	}
}
