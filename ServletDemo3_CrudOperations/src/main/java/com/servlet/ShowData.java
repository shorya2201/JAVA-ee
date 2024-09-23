package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DbConnection;

/**
 * Servlet implementation class ShowData
 */
@WebServlet("/ShowData")
public class ShowData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			Connection conn = DbConnection.takeConnection();
			
			String q = "Select * from employee";
			PreparedStatement ps = conn.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			pw.print("<table border = '1>");
			pw.print("<tr><td>ID</td><td>Name</td><td>Password</td><td>Email</td><td>Country</td></tr>");
		while(rs.next()) {
			pw.print("<tr>");
			pw.print("<td>" + rs.getString(1) + "</td>");
			pw.print("<td>" + rs.getString(2) + "</td>");
			pw.print("<td>" + rs.getString(3) + "</td>");
			pw.print("<td>" + rs.getString(4) + "</td>");
			pw.print("<td>" + rs.getString(5) + "</td>");
			pw.print("</tr>");
			
		}
			pw.print("</table>");
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
