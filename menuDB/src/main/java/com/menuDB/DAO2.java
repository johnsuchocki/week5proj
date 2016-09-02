package com.menuDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO2 {
	public static final String JBDC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	
	public static void connToDB() {
		try {
			Class.forName(JBDC_DRIVER);

			System.out.println("Connecting to the database");			
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database");
			System.out.println("");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Database connection failed.");
			e.printStackTrace();
		}
	}// connect method
	
	public static ArrayList<MenuItem> readFromDB() {
		ArrayList<MenuItem> itemsToAdd = new ArrayList<>();

		connToDB();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM menu.menu_options;");

			while (RES_SET.next()) {
				MenuItem item = new MenuItem();

				item.setMenuID(RES_SET.getString("menu_id"));
				item.setFoodName(RES_SET.getString("food_name"));
				item.setCost(RES_SET.getString("cost"));
				item.setTimeServed(RES_SET.getString("time_served"));
				item.setHealthyMenu(RES_SET.getString("healthy_menu"));

				itemsToAdd.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itemsToAdd;
	}// read method
	
	public static void addToDB(MenuItem item) {
		connToDB();

		try {

			PREP_STMT = CONN.prepareStatement(addToTable);
			PREP_STMT.setString(1, item.getFoodName());
			PREP_STMT.setString(2, item.getCost());
			PREP_STMT.setString(3, item.getTimeServed());
			PREP_STMT.setString(4, item.getHealthyMenu());

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// add method
	
	private static String addToTable = "INSERT INTO menu.menu_options (food_name, cost, time_served, healthy_menu)"
			+ " VALUES " + "(?, ?, ?, ?);"; // add prepared statement string

	public static void deleteFromDB(String menuID) {
		connToDB();

		try {
			STMT = CONN.createStatement();
			STMT.executeUpdate("DELETE FROM menu.menu_options WHERE menu_id = '" + menuID + "';");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// delete method
	
	public static MenuItem findInDB(String menuID) {
		connToDB();

		MenuItem itemInDB = new MenuItem();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM menu.menu_options WHERE menu_id = '" + menuID + "';");

			while (RES_SET.next()) {
				itemInDB.setMenuID(RES_SET.getString("menu_id"));
				itemInDB.setFoodName(RES_SET.getString("food_name"));
				itemInDB.setCost(RES_SET.getString("cost"));
				itemInDB.setTimeServed(RES_SET.getString("time_served"));
				itemInDB.setHealthyMenu(RES_SET.getString("healthy_menu"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemInDB;
	}// find individual method
	
	public static void updateDB(MenuItem itemToUpdate) {
		connToDB();

		try {

			PREP_STMT = CONN.prepareStatement(updateTable);
			PREP_STMT.setString(1, itemToUpdate.getMenuID());
			PREP_STMT.setString(2, itemToUpdate.getFoodName());
			PREP_STMT.setString(3, itemToUpdate.getCost());
			PREP_STMT.setString(4, itemToUpdate.getTimeServed());
			PREP_STMT.setString(5, itemToUpdate.getHealthyMenu());
			PREP_STMT.setString(6, itemToUpdate.getMenuID());
			
			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// update method
	
	private static String updateTable = "UPDATE menu.menu_options " + "SET "
			+ "menu_id = ?, food_name = ?, cost = ?, time_served = ?, healthy_menu = ? " + "WHERE menu_id = ?;";
}
