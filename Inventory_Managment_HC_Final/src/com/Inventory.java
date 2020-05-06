package com;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class Inventory {

	public Connection connect() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/items management", "root", "");
			// For testing
			System.out.println("Successfully connected---1");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// inserting an items .........................

	public String insertItem(String code, String name, String price, String desc) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database";
			}
			// create a prepared statement
			String query = "insert into items" + "(`itemID`,`itemCode`,`itemName`,`itemPrice`,`itemDesc`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, code);
			preparedStmt.setString(3, name);
			preparedStmt.setDouble(4, Double.parseDouble(price));
			preparedStmt.setString(5, desc);

			// execute the statement
			preparedStmt.execute();
//		 System.out.print("successfuly inserted");
			con.close();
			
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" +
			newItems + "\"}";
			
			//output = "Inserted successfully";
			
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
					System.err.println(e.getMessage());
		}
		return output;
	}

	// read the items from database and display----------------------

	public String readItems()
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{
	return "Error while connecting to the database for reading.";
	}
	// Prepare the html table to be displayed
	output = "<table border='1'><tr><th>Product Code</th>"
			+ "<th>Product Name</th><th>Product Price</th>"
			+"<th>Product Description</th>"
			+ "<th>Update</th><th>Remove</th></tr>";
	String query = "select * from items";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	// iterate through the rows in the result set
	while (rs.next())
	{
	String itemID = Integer.toString(rs.getInt("itemID"));
	String itemCode = rs.getString("itemCode");
	String itemName = rs.getString("itemName");
	String itemPrice = Double.toString(rs.getDouble("itemPrice"));
	String itemDesc = rs.getString("itemDesc");
	
	
	// Add into the html table
	output += "<tr><td><input id='hidItemIDUpdate'"
			+ "name='hidItemIDUpdate' type='hidden'"
			+ "value='" + itemID + "'>" + itemCode + "</td>";
	output += "<td>" + itemName + "</td>";
	output += "<td>" + itemPrice + "</td>";
	output += "<td>" + itemDesc + "</td>";
	// buttons
	output += "<td><input name='btnUpdate' type='button'"
			+ "value='Update'"
			+ "class='btnUpdate btn btn-secondary'></td>"
			+ "<td><input name='btnRemove' type='button'"
			+ "value='Remove'"
			+ "class='btnRemove btn btn-danger' data-itemid='"
	+ itemID + "'>" + "</td></tr>";
	}
	con.close();
	// Complete the html table
	output += "</table>";
	}
	catch (Exception e)
	{
	output = "Error while reading the items.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
	
	
	
	
	
	// update items ---------------------------------------------

	public String updateItem(String ID, String code, String name, String price, String desc) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE items SET itemCode=?,itemName=?,itemPrice=?,itemDesc=? WHERE itemID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, code);
			preparedStmt.setString(2, name);
			preparedStmt.setDouble(3, Double.parseDouble(price));
			preparedStmt.setString(4, desc);
 			preparedStmt.setInt(5, Integer.parseInt(ID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" +
			newItems + "\"}";
			
			//output = "Updated successfully";
			
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while updating the item.\"}";
					System.err.println(e.getMessage());
		}
		return output;
	}

	// delete items--------------------------------------

	public String deleteItem(String itemID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from items where itemID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(itemID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" +
			newItems + "\"}";
			
			//output = "Deleted successfully";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the item.\"}";
					System.err.println(e.getMessage());
		}
		return output;
	}

}