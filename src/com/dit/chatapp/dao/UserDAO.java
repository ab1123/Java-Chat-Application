package com.dit.chatapp.dao;

import java.lang.invoke.StringConcatFactory;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dit.chatapp.dto.userdto;
import com.dit.chatapp.utils.Encryption;

//USER CRUD 
// user stuff is added in the database 
public class UserDAO {
	public boolean islogin(userdto userdto) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	final 	String SQL="select userid from users where userid=? and password=?";
		try {
			connection =CommonDAO.createconnection();
			pstmt=connection.prepareStatement(SQL);
			pstmt.setString(1, userdto.getUserid());
			String encrypt= Encryption.passwordEncrpt(new String(userdto.getPassword()));
			pstmt.setString(2, encrypt);
			rs=pstmt.executeQuery();
			return rs.next();
			
			
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(connection!=null) {
				connection.close();
			}
			
		}
		
	}
	
	
public int add(userdto userdto) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
	System.out.println("Rec "+userdto.getUserid()+" "+userdto.getPassword());
	Connection connection=null;
	Statement stmt=null; // run the query 
	try { // Guarded Region
	connection=CommonDAO.createconnection();// step-1 connection build from the database
//	step-2 sql query
	stmt=connection.createStatement();
//	 insert into users (userid,password) values('ram','ram12');
	int record=stmt.executeUpdate("insert into users (userid,password) values('"+userdto.getUserid()+"','"+Encryption.passwordEncrpt( new String(userdto.getPassword()))+"')");// Insert, update, delete
	return record;		
	}finally { // Always execute
		if(stmt!=null) {
		stmt.close();
		}
		if(connection!=null) {
		connection.close();
		}
	}
	
	
	
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
