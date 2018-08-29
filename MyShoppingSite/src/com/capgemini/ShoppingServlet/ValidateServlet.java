package com.capgemini.ShoppingServlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dal.*;

@WebServlet("/ValidateServlet")

public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	  
	protected void doCommon(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String userName=request.getParameter("uname");
		String password=request.getParameter("pass");
		
		RequestDispatcher requestdispathcher=null;
		
		UserDAO userCheck=new UserDAO();
		try
		{
			if(userCheck.getUserType(userName,password).equals("user"))
			{
				requestdispathcher=request.getRequestDispatcher("/user.jsp");
			}
			else if(userCheck.getUserType(userName,password).equals("admin"))
			{
				requestdispathcher=request.getRequestDispatcher("/admin.jsp");
			
			}
			requestdispathcher.forward(request, response);
		}
		
		catch (InvalidUserException i)
		
		{
			requestdispathcher=request.getRequestDispatcher("/incorrectuser.jsp");

			requestdispathcher.forward(request, response);
		}
		catch (SQLException i)
		
		{
			i.printStackTrace();
		}
		}

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doCommon(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doCommon(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
