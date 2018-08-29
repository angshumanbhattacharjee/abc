package com.capgemini.ShoppingServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dal.OperationDao;

@WebServlet("/RetrieveServlet")
public class RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RetrieveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doCommon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
    {
    	OperationDao op=new OperationDao();
   	 RequestDispatcher requestDispatcher=null;
   	 String productID=request.getParameter("productID");
   	 String product=op.adminRetrieve(productID);
   	  request.setAttribute("TextValue",product);
  	 requestDispatcher=request.getRequestDispatcher("jspFiles/retrieveshow.jsp");
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