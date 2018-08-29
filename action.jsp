<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String name=request.getParameter("uname");
String nname=request.getParameter("nickname");
Integer hitsCount = (Integer)application.getAttribute("hitCounter");
 
         if( hitsCount ==null || hitsCount == 0 ) {
            /* First visit */
            hitsCount = 1;
         } else {
            /* return visit */
            		if(hitsCount%2==0){
            			 out.print("Welcome: "+nname);
            		}
            		else {
            			out.println("Welcome: "+name);
            		}
            hitsCount += 1;
         }
         application.setAttribute("hitCounter", hitsCount);
      %>
      <% out.print("Counter: "+hitsCount); %>
</body>
</html>