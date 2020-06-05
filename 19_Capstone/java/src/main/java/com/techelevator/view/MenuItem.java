package com.techelevator.view;

public class MenuItem {

	private String itemName;
	private String itemCost;
	private String itemCategory;
//	private int itemCount = 5;
	
	public MenuItem(String itemName, String itemCost, String itemCategory) {
		this.itemName=itemName;
		this.itemCost=itemCost;
		this.itemCategory=itemCategory;
//		this.itemCount=itemCount;
	}
	
	public String getMenuItemName() {
		return itemName;
	}
	public String getMenuItemCost() {
		return itemCost;
	}
	public String getMenuItemCategory() {
		return itemCategory;
	}
//	public int getItemCount() {
//		return itemCount;
//	}
//	public void setItemCount(int numberOfItemBought) {
//		itemCount = (itemCount - numberOfItemBought);
//	}
//	
}
