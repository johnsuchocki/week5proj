package com.menuDB;

public class MenuItem {

	private String menuID = null;
	private String foodName = null;
	private String cost = null;
	private String timeServed = null;
	private String healthyMenu = null;

	public MenuItem() {
		super();
	}

	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getTimeServed() {
		return timeServed;
	}

	public void setTimeServed(String timeServed) {
		this.timeServed = timeServed;
	}

	public String getHealthyMenu() {
		return healthyMenu;
	}

	public void setHealthyMenu(String healthyMenu) {
		this.healthyMenu = healthyMenu;
	}

}
