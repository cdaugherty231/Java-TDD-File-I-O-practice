package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {

		String searchWord = getSearchWord();
		File inputFile = getInputFileFromUser();
		String wordThatReplacesSearchWord = getWordThatReplacesSearchWord();
		
		//create a file
		File newFile = new File("alices_adventures_in_wonderland_copy.txt");
		//create print writer
		PrintWriter printWriter;

		if (inputFile != null) {
			try(Scanner fileScanner = new Scanner(inputFile)) {
				printWriter = new PrintWriter(newFile);
				while(fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					line = line.replaceAll(searchWord,wordThatReplacesSearchWord);
						
					printWriter.println(line);
				}
				printWriter.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("Unable to find file "+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		
	}

	//Get file from user
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
	
			
			System.out.print("Please enter path to input file >>> ");
			String path = userInput.nextLine();
		
			File inputFile = new File(path);
			if(inputFile.exists() == false) { // checks for the existence of a file
				System.out.println(path+" does not exist");
				inputFile = null;
				System.exit(0);
			} else if(inputFile.isFile() == false) { // checks if it is even a file
				System.out.println(path+" is not a file");
				inputFile = null;
				System.exit(0);
			}
		
			return inputFile;
		
	}
	//Get search word from user
	private static String getSearchWord() {
		System.out.println("Enter the word you want to replace: ");
		Scanner userInput = new Scanner(System.in);
		String searchWord = userInput.nextLine();
		return searchWord;
	}
	
	//get replacing word
	private static String getWordThatReplacesSearchWord() {
		System.out.println("Enter the word you want to replace it with: ");
		Scanner userInput = new Scanner(System.in);
		String searchWord = userInput.nextLine();
		return searchWord;
	}
}