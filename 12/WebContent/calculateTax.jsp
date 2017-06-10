<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<% 
String name=request.getParameter("name");
String work=request.getParameter("work");
String gender=request.getParameter("gender");
Float income=Float.parseFloat(request.getParameter("income"));
float tax;
if(income<100000)
{
 tax=0;
}
else if(income<500000)
{
	tax=(float)0.15*income;
}
else
{
	tax=(float)0.2*income;
}
session.setAttribute("name", name);
session.setAttribute("gender", gender);
session.setAttribute("work",work);
session.setAttribute("income",income);
session.setAttribute("tax",tax);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CALCULATE TAX-IT DEPT</title>
</head>
<body>
<label>Name :<%=session.getAttribute("name") %></label><br>
<label>ORGANISATION :<%=session.getAttribute("org") %></label><br>
<label>GENDER :<%=session.getAttribute("gender") %></label><br>
<label>SALARY :<%=session.getAttribute("income") %></label><br>
<label>TAX :<%=session.getAttribute("tax") %></label><br>
<form action="exit.jsp" method="get">
<input type="submit" value="logout">
</form>
</body>
</html>