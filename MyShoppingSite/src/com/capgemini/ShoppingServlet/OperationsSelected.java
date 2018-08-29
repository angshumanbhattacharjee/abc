package com.capgemini.ShoppingServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OperationsSelected")
public class OperationsSelected extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
    public OperationsSelected() {
        super();
        
    }
    
    protected void doCommon(HttpServletRequest request, HttpServletResponse response) throws Exception {

//    	String delete= request.getParameter("delete");
//    	String update= request.getParameter("update");
//    	String pid= request.getParameter("pid");
//    	String price= request.getParameter("price");
    	RequestDispatcher rd = null;
        String selected =(String)request.getParameter("operations");
        System.out.println(selected);
//        RequestDispatcher rd = null;
        if(selected.equals("add"))
        	rd = request.getRequestDispatcher("/Updation_Deletion.jsp");
        else if(selected.equals("retrieve"))
        	rd = request.getRequestDispatcher("/Retrieve");
        rd.forward(request,response);
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
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		OperationsSelected op= new OperationsSelected();
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		try {
			op.doCommon(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}