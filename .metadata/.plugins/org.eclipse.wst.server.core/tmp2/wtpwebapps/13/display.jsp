<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FLIGHT SCHEDULE</title>
</head>
<body>
<% 
String a=request.getParameter("day");
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight","root","root");
	if(conn!=null)
	{
		out.println("CONNECTION SUCCESSFUL");
		Statement s=conn.createStatement();
		ResultSet rs=s.executeQuery("Select *from flights where weekdays='"+a+"'");
		while(rs.next())
		{
			int x=rs.getInt("flight_no");
			String y=rs.getString("airline_name");
			String z=rs.getString("weekdays");
			String temp=x+" "+y+" "+z;
			out.print("<p>"+temp+"</p>");
		}
		
	}
}catch(Exception e){e.printStackTrace();}
%>
</body>
</html>