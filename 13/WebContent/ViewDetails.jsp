<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW RESERVATION</title>
</head>
<body>
<%
Random ran=new Random();
int slno=ran.nextInt(500)+1;
int a=Integer.parseInt(request.getParameter("flno"));
String b=request.getParameter("date");
String c=request.getParameter("name");
String d=request.getParameter("phone");

try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight","root","root");
	if(conn!=null)
	{
		out.println("CONNECTED");
		Statement s=conn.createStatement();
		String sql="Insert into seatreservation values('"+a+"','"+b+"','"+slno+"','"+c+"','"+d+"')";
		s.executeUpdate(sql);
		String sql1="select *from flight where flight_no='"+a+"'";
		ResultSet rs=s.executeQuery(sql1);
		while(rs.next())
		{
			String x=rs.getString("airline_name");
			String y=rs.getString("weekdays");
			System.out.println(x+y);
			String temp=a+" "+b+" "+slno+" "+c+" "+d; 
			System.out.println(temp);
			out.print("FLIGHT RESERVATION DETAILS ARE:"+temp);
		}
	}
}catch(Exception e){e.printStackTrace();}
%>

</body>
</html>