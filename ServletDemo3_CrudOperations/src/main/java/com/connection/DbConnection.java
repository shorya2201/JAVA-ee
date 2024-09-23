package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection takeConnection() {
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/training";
			String user = "root";
			String pass = "shorya2201";

			con = DriverManager.getConnection(url,user,pass);
			con.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
