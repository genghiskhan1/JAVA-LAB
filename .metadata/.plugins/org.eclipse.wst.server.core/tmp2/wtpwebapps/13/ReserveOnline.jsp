<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FLIGHT RESERVATION</title>
</head>
<body>
<form action="ViewDetails.jsp" method="post">
FLIGHT NUMBER: <input type="text" name="flno"/>
DATE: <input type="text" name="date"/>
CUSTOMER NAME: <input type="text" name="name"/>
CUSTOMER PHONE NUMBER: <input type="text" name="phone"/>
<input type="submit" value="RESERVE"/>
<a href="day.jsp" target="">SEARCH!</a>
</form>
</body>
</html>