<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
String name= request.getParameter("username");
    response.sendRedirect("https://www.google.com/search?q="+name);
    %>