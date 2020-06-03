package com.techelevator;

public class KataStringCalculator {

	//Passing in a String like this "", "1", "1,2,3,4,5,8"
	int sumOfNumbers= 0;
	
	public int add(String numbers) {
		if (numbers == "") {
			return sumOfNumbers;
		}
		if (numbers.length()==1) {
			return Integer.parseInt(numbers);
		}
		if (numbers.length() > 1) {
			String [] arrayNumbers = new String[numbers.length()];	
			arrayNumbers = numbers.split(",|\\n");
			//do for loop to go through each number in the array and add them to a sumOfNumbers
			for (String number : arrayNumbers) {
				sumOfNumbers += Integer.parseInt(number);
				
		}return sumOfNumbers;
			
			
		}
		
		return sumOfNumbers;
	}
	
	
}
