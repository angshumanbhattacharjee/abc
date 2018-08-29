package com.capgemini.ShoppingServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dal.OperationDao;

import javax.servlet.RequestDispatcher;
@WebServlet("/OperationsServlet")
public class OperationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public OperationsServlet() {
        super();
        
    }
    protected void doCommon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
    {
    	OperationDao op=new OperationDao();
   	 RequestDispatcher requestDispatcher=null;
   	 String productID=request.getParameter("pid");
   	 String productName=request.getParameter("pd");
   	 float productPrice=Float.parseFloat(request.getParameter("price"));
   	 op.adminAdd(productID,productName,productPrice);
   	 requestDispatcher=request.getRequestDispatcher("jspFiles/OperationProcessing.jsp");
   	 requestDispatcher.forward(request, response); 
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			doCommon(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			doCommon(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
