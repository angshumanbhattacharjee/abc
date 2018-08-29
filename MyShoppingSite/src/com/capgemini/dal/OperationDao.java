package com.capgemini.dal;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.util.ConnectionFactory;

import java.sql.*;

public class OperationDao 
{
	public Connection connection;
    public Statement statement;
    public ResultSet resultSet;
    

    public OperationDao () {
                    try {
                        connection = ConnectionFactory.getConnection();              
                    } catch (Exception e) {
                                    e.printStackTrace();
                    }
    }
    
    public void adminAdd(String pID,String pName,float pPrice) throws SQLException
	{
    	 statement = connection.createStatement();
    	
    	String query = "INSERT INTO ITEM " +
                "VALUES ('"+pID+"','"+pName+"',"+pPrice+")";
    	
    	try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    public String adminRetrieve(String pID) throws SQLException
   	{
       	 statement = connection.createStatement();
         resultSet = statement.executeQuery("select * from ITEM");

         while (resultSet.next()) {
                         if (resultSet.getString(1).equals(pID)) 
                         {
                           return  "ItemId = "+resultSet.getString(1)+" ItemName = "+resultSet.getString(2)+" ItemPrice= "+resultSet.getString(3);            
                         }
   	}
    return "Item does not exist";
   	}
    public void adminUpdate(String pID,String pName,float pPrice) throws SQLException
	{
    	 statement = connection.createStatement();
    	
    	String query = "INSERT INTO ITEM " +
                "VALUES ('"+pID+"','"+pName+"',"+pPrice+")";
    	
    	try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public void adminDelete(String pID,String pName,float pPrice) throws SQLException
	{
        statement = connection.createStatement();
	   try 
	   {
	          statement.executeUpdate("DELETE * FROM ITEM WHERE ITEMID ="+pID);
	   } 
	   catch (SQLException e) 
	   {
	          e.printStackTrace();
	   }
}
}
