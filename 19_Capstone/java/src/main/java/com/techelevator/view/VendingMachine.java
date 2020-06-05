package com.techelevator.view;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
	
	
	private int customerBalance = 0;
	private int itemCount = 5;
	
	Map<String, MenuItem> mapOfItems = new LinkedHashMap<String, MenuItem>();
	Map<String, Integer> mapOfInventory = new LinkedHashMap<String, Integer>();
	Map<String, Integer> mapOfPrices = new LinkedHashMap<String, Integer>();
	
	public VendingMachine() {
	File inputFile = new File("VendingMachine.txt");
	//Scan the vending machine data file
	try(Scanner fileScanner = new Scanner(inputFile)){
	//while there is more items loop through	
		while(fileScanner.hasNextLine()) {		
			String nextItemLineInFile = fileScanner.nextLine();	
	//put items into array of strings and split them by a |		
			String[] itemWords = nextItemLineInFile.split("\\|");
	//make a object with the item name, item cost and item category
			MenuItem menuItemObject = new MenuItem(itemWords[1], itemWords[2], itemWords[3]);
	//put slot number in the value & put the item object into the value of our map
			mapOfItems.put(itemWords[0], menuItemObject);
	//put slot number as key and put inital item count in the value
			mapOfInventory.put(itemWords[0], itemCount);
	//put slot number as key and put cost of item in the value
	//this is giving us a stop in our loop
//			mapOfPrices.put(itemWords[0], Integer.parseInt(itemWords[2]));
			}
		}
	catch (Exception e) {
		System.out.println("Couldn't find the input file.");
	}
}
	
	public void displayItemsInInventory() {
		List<String> listOfKeys = new ArrayList<>(mapOfItems.keySet());
		for(String slot : listOfKeys)
		{
			if(mapOfInventory.get(slot).equals(0)) {
				 System.out.println("SOLD OUT");
			}
			else {MenuItem item = mapOfItems.get(slot);
		   System.out.println(slot + " " + item.getMenuItemName() + " " + item.getMenuItemCost());   
			}
		}
	}
	
	public void purchaseItemsOptions() {
		Scanner userInputScanner = new Scanner(System.in);
		System.out.println("1) Feed Money");
		System.out.println("2) Select Product");
		System.out.println("3) Finish Transaction");
		System.out.println(" ");
		System.out.println("Please choose an option >>>");
		String userInputForPurchaseItemsOption = userInputScanner.nextLine();
		try {
			if(userInputForPurchaseItemsOption.equals("1")) {
				System.out.println("How much would you like to deposit?");
				String userInputForAmountToDeposit = userInputScanner.nextLine();
				setCustomerBalance(Integer.parseInt(userInputForAmountToDeposit));
				System.out.println("Your current balance is "+ getCustomerBalance(customerBalance));
			}
			else if(userInputForPurchaseItemsOption.equals("2")) {
				if(customerBalance <=0) {
					//then they dont get shit
					System.out.println("Your balance is 0");
					purchaseItemsOptions();
				}
				else { 
					System.out.println("Enter Item Slot Number: ");
					String userInputForSlotNumber = userInputScanner.nextLine();
					//updated new customer balance
					setCustomerBalance(customerBalance - mapOfPrices.get(userInputForSlotNumber));
					//update inventory map
					mapOfInventory.replace(userInputForSlotNumber, (mapOfInventory.get(userInputForSlotNumber)-1));
					//update inventory and balance of vending machine story 3
					if (mapOfItems.get(userInputForSlotNumber).toString().contains("Chip")) {
					System.out.println("Crunch Crunch, Yum!");
					}
					else if (mapOfItems.get(userInputForSlotNumber).toString().contains("Candy")) {
						System.out.println("Munch Munch, Yum!");
					}
					else if (mapOfItems.get(userInputForSlotNumber).toString().contains("Drink")) {
						System.out.println("Glug Glug, Yum!");
					}
					else if (mapOfItems.get(userInputForSlotNumber).toString().contains("Gum")) {
						System.out.println("Chew Chew, Yum!");
					}
					purchaseItemsOptions();
				}
			}
			else if(userInputForPurchaseItemsOption.equals("3")) {
				
			}
			else {
				System.out.println("Please enter valid selection!");
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		
	}
	
	
	public int getCustomerBalance(int customerBalance) {
		return customerBalance;
	}
	public void setCustomerBalance(int depositedAmount) {
		this.customerBalance = depositedAmount;
	}
}	
	

