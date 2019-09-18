<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Integer id=(Integer)request.getAttribute("ID");
String name=(String) request.getAttribute("NAME");
Integer salary=(Integer) request.getAttribute("SALARY");
out.println(id+" "+name+" "+salary);
%>
<br/>
<H4>My Name is <b>${name}</b> and ID is ${id} and my Salary is ${salary} </H4>
</body>
</html>