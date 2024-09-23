package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DbConnection;

/**
 * Servlet implementation class servletDB
 */
@WebServlet("/servletDB")
public class servletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("user");
	String pass = request.getParameter("pass");
	String email = request.getParameter("email");
	String country = request.getParameter("country");
	
	String query = "INSERT INTO employee(name,password,email,country) VALUES( ?,?,?,? )";
	
	try {
		Connection conn = DbConnection.takeConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, pass);
		ps.setString(3, email);
		ps.setString(4, country);
		ps.executeUpdate();
//		conn.commit();
//		PrintWriter pw = response.getWriter();
//		pw.print("Data inserted Successfully");
		conn.close();
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	}

}
