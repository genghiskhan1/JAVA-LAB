<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
    <%
    Connection conn=null;
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/XE","root","");
    }catch(Exception e){}
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TSHIRTS ORDERED</title>
</head>
<body>
<h1> ORDER </h1>
<%
Statement s=conn.createStatement();
int count=0;
String sql="Select *from Tshirt";
ResultSet rs=s.executeQuery(sql);
%>
<table border="1">
<thead>
 <th>Order Id</th>
 <th>Tag</th>
 <th>Pocket</th>
 <th>COLOR</th>
 <th>ACCESSORIES</th>
</thead>
<tbody>
<%while(rs.next()) { %>
<tr>
<td><% ++count; %></td>
<td><% rs.getString("tag"); %></td>
<td><% if(rs.getInt("pocket")==0)
	    out.print("NO");
	   else
	    out.print("YES");
	%></td>
	<td><% rs.getString("color");%></td>
	<td><% rs.getString("acc"); %></td>
	</tr>
	<% } %>
</tbody>
</table>
</body>
</html>
