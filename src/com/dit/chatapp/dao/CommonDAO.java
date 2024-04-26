package com.dit.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// To get the values from the config file
import  static com.dit.chatapp.utils.ConfigReader.getValue;

public interface CommonDAO {
	public static Connection createconnection() throws ClassNotFoundException, SQLException{
//		loading the driver class for establishing the connection
//		driver class is called on run time if there is any mistake while writing the class name, so we used ClassNotFoundException
		
//		step 1 load the driver
		Class.forName(getValue("DRIVER"));
//		Making a Connection
		final String CONNECTION_STRING =getValue("CONNECTION_URL");
		final String USER_ID =getValue("USER_ID");
		final String PASSWORD =getValue("PASSWORD");
		Connection con=DriverManager.getConnection(CONNECTION_STRING, USER_ID, PASSWORD);
		if(con!=null) {
			System.out.println("Connection Created ..");
//			con.close();
		}
		return con;
	}

}
