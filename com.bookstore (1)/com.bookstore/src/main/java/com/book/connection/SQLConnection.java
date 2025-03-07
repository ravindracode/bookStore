package com.book.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

		public static String url="jdbc:mysql://localhost:3306/bookstore";
		public static String username="root";
		public static String password="Ravi@123";
		
		static Connection con;
		
		public static Connection connect() {
			
			try {
				//load the driver 
				Class.forName("com.mysql.cj.jdbc.Driver");
				// Established the connection
				 con = DriverManager.getConnection(url,username,password);
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	

}
