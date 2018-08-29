<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1 align="center">Z Bank- Your Perfect Bank</h1>
<% java.util.Calendar calendar = new java.util.GregorianCalendar();
java.util.Date date = calendar.getTime();
DateFormat format=new SimpleDateFormat("dd-MM-yyyy");
String dateval=format.format(date);
int hour = calendar.get(Calendar.HOUR_OF_DAY);
 %>
 <p>
 <%
 if(hour<12) out.print("Good Morning");
 if(hour>=12) out.print("Good Evening");%>
 <% out.print(dateval); %> 
 </p>
 <h4>Thanks for your great support!!!</h4>
 <%Integer hitsCount = (Integer)application.getAttribute("hitCounter");
         if( hitsCount ==null || hitsCount == 0 ) {
        	 out.println("Welcome Username");
            hitsCount = 1;
         } else {
            hitsCount += 1;
            
         }
         application.setAttribute("hitCounter", hitsCount);
         
      %>
         <p>You are our valuable visitor number: <%= hitsCount%></p>
      <% if(hitsCount%2==0){
      	out.println("Hello Nickname");
      }
      else out.println("Hello Username"); %>
</body>
</html>