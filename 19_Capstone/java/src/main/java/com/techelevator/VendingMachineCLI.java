package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachine;

public class VendingMachineCLI{
	// String of Menu options
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	
	//Array of Strings with Menu options
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	
	//Create object called menu from menu
	private Menu menu;
	//create object called vendingMachine
	private VendingMachine vendingMachine = new VendingMachine();
	
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	//Getting choice from customer
	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vendingMachine.displayItemsInInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase      1) Feed Money     2) Select Product     3) Finish Transaction 
				vendingMachine.purchaseItemsOptions();
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		
		Menu menu = new Menu(System.in, System.out);
		//created and object called cli from VendingMachineCLI
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		//used the method called run() 
		cli.run();
	}
}

