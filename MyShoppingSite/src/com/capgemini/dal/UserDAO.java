package com.capgemini.dal;

import java.sql.*;

import com.capgemini.util.ConnectionFactory;

public class UserDAO 
{
	Connection con;
	Statement st;
	ResultSet resultSet;
	public UserDAO() 
	{
		
		try {
			 con= ConnectionFactory.getConnection();
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUserType(String userName, String password ) throws SQLException, InvalidUserException 
	{
		st=con.createStatement();
	    resultSet=st.executeQuery("select * from USERTABLE");
		while(resultSet.next()) 
		{
			if(resultSet.getString(1).equals(userName) && resultSet.getString(2).equals(password)) 
			{
				return (resultSet.getString(3));
			}
		}
		throw new InvalidUserException();
		// TODO Auto-generated method stub
		
	}
	
}
