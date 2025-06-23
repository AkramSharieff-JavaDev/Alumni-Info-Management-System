package com.alumni;

public class DBConnection {
	  public static Connection initialize() throws ClassNotFoundException, SQLException {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    return DriverManager.getConnection("jdbc:mysql://localhost:3306/alumni_db", "root", "yourpassword");
	  }
	}
