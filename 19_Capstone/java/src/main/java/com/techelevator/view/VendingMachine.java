package com.techelevator.view;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
	private Scanner in;
	private int customerBalance = 0;
	private int itemCount = 5;
	Map<String, MenuItem> inventory = new LinkedHashMap<String, MenuItem>();
	
	
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
			MenuItem menuItemObject = new MenuItem(itemWords[1], itemWords[2], itemWords[3], itemCount);
	//put slot number in the value & put the item object into the value of our map
			inventory.put(itemWords[0], menuItemObject);
			}
		}
	catch (Exception e) {
		System.out.println("Couldn't find the input file.");
	}
}
	
	public void displayItemsInInventory() {
		List<String> listOfKeys = new ArrayList<>(inventory.keySet());
		for(String slot : listOfKeys)
		{
			MenuItem item = inventory.get(slot);
		   System.out.println(slot + " " + item.getMenuItemName() + " " + item.getMenuItemCost());   
		}
	}
	
	public void purchaseItemsOptions() {
		System.out.println("1) Feed Money");
		System.out.println("2) Select Product");
		System.out.println("3) Finish Transaction");
		System.out.println(" ");
		System.out.println("Please choose an option >>>");
		String userInputForPurchaseItemsOption = in.nextLine();
		try {
			if(userInputForPurchaseItemsOption == "1") {
				System.out.println("How much would you like to deposit?");
				String userInputForAmountToDeposit = in.nextLine();
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
					String userInputForSlotNumber = in.nextLine();
					setCustomerBalance(customerBalance - itemPrice);
					for(String : inventory) {
						if(inventory.containsKey(userInputForSlotNumber)) {
							//decrement the itemCount in Map
							inventory.get(userInputForSlotNumber)
						}
					}
					//update inventory and balance of vending machine story 3
					if (inventory.get(userInputForSlotNumber).toString().contains("Chip")) {
					System.out.println("Crunch Crunch, Yum!");
					}
					else if (inventory.get(userInputForSlotNumber).toString().contains("Candy")) {
						System.out.println("Munch Munch, Yum!");
					}
					else if (inventory.get(userInputForSlotNumber).toString().contains("Drink")) {
						System.out.println("Glug Glug, Yum!");
					}
					else if (inventory.get(userInputForSlotNumber).toString().contains("Gum")) {
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
	

