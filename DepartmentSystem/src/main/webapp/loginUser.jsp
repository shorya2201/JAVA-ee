<%@page import="com.servlet.verifyLogin"%>
<%@page import="com.connection.DbConnection"%>
<%@page import= "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
String user = request.getParameter("user");
String pass = request.getParameter("pass");
String role = request.getParameter("role");



if(request.getAttribute("status").equals("true")) {
	 session.setAttribute("username" , user);
	if(role.equals("finance"))
		response.sendRedirect("finance.jsp");
	else if(role.equals("legal"))
		response.sendRedirect("legal.jsp");
	else if(role.equals("management"))
		response.sendRedirect("management.jsp");
	else
		response.sendRedirect("login.jsp?status=false");
}

%>
    	