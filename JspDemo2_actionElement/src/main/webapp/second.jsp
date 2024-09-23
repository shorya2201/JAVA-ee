<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <jsp:useBean id="obj" class="com.bean.StudentBean">
    <jsp:setProperty name="obj" property="*" ></jsp:setProperty>
    </jsp:useBean>
    
    <h1><jsp:getProperty property="rollno" name="obj"/></h1>
    <h2><jsp:getProperty property="name" name="obj"/></h2>
    <h3><jsp:getProperty property="course" name="obj"/></h3>