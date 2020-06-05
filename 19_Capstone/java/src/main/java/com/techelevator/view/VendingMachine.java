package com.techelevator.view;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VendingMachine {
	
	
	private double customerBalance = 0;
	private int itemCount = 5;
	
	public Map<String, MenuItem> mapOfItems = new LinkedHashMap<String, MenuItem>();
	public Map<String, Integer> mapOfInventory = new LinkedHashMap<String, Integer>();
	public Map<String, String> mapOfPrices = new LinkedHashMap<String, String>();
	
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
			mapOfPrices.put(itemWords[0], (itemWords[2]));
			}
		}
	catch (Exception e) {
		System.out.println("Couldn't find the input file.");
	}
}
	public MenuItem getMenuItem(String slotNumber) {
		return mapOfItems.get(slotNumber);
	}
	public Set<String> getValidSlots(){
		return mapOfItems.keySet();
	}
	
	public void displayItemsInInventory() {
		List<String> listOfKeys = new ArrayList<>(mapOfItems.keySet());
		for(String slot : listOfKeys)
		{
			if(mapOfInventory.get(slot).equals(0)) {
				 System.out.println("SOLD OUT");
			}
			else {MenuItem item = mapOfItems.get(slot);
		   System.out.println(slot + " " + item.getMenuItemName() + " $" + item.getMenuItemCost());   
			}
		}
	}
	
	public String purchaseItem(String userInputForSlotNumber) {
		//update customer balance
		customerBalance = (customerBalance - mapOfItems.get(userInputForSlotNumber).getMenuItemCost());
		//update inventory 
		mapOfInventory.replace(userInputForSlotNumber, (mapOfInventory.get(userInputForSlotNumber)-1));
		//output the noise of the item purchased
		return mapOfItems.get(userInputForSlotNumber).makeNoise();
		
		

	}
	
	public double getCustomerBalance() {
		return customerBalance;
	}
	public void setCustomerBalance(double customerBalance) {
		this.customerBalance=customerBalance;
	}
	
	public void addCustomerBalance(int depositedAmount) {
		this.customerBalance += depositedAmount;
	}
	public void removeCustomerBalance(double chargedAmount) {
		this.customerBalance -= chargedAmount;
	}
	
	
}	
	

