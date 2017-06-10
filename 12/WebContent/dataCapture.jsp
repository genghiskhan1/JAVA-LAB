<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<% 
String username=request.getParameter("name");
String password=request.getParameter("pass");
int valid=0,status;
if(username.equals("admin"))
{
	if(password.equals("admin"))
	{
		
	}
	else
	{
		valid=1;
	}
}
else
{
	valid=2;
}
session.setAttribute("user",username);

if(session.getAttribute("status") == null)
	status=0;
else
	status = (Integer)session.getAttribute("status");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INCOME TAX DEPARTMENT</title>
</head>
<body>
<% 
if(valid==1||valid==2)
{
 response.sendRedirect("login.html");
}
%>
<h3>WELCOME <%=session.getAttribute("user") %></h3>
<form action="calculate.jsp" method="get">
<label>NAME: <input type="text" name="name"/></label>
<label>PLACE WORK</label>
<select name="work">
<option value="ms">MICROSOFT</option>
<option value="google">GOOGLE</option>
<option value="apple">APPLE</option>
</select>
<label>GENDER: MALE<input type="radio" value="male" name="gender"/>FEMALE<input type="radio" name="gender" value="female"/></label>
<label> ANNUAL INCOME<input type="text" name="income"/></label>
<input type="submit" value="CalculateTax">
</form>
</body>
</html>