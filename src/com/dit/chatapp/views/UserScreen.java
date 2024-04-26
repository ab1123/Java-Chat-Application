package com.dit.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.dit.chatapp.dao.UserDAO;
import com.dit.chatapp.dto.userdto;
import com.dit.chatapp.utils.UserInfo;

public class UserScreen extends JFrame{
	private JTextField useridtxt;
	private JPasswordField passwordField;

	
	public static void main(String[] args) throws Exception{
	UserScreen window = new UserScreen();
					
	}
	UserDAO userDAO=new UserDAO();
	private void dologin() {
		String userid=useridtxt.getText();
		char[] password=passwordField.getPassword();
		userdto userdto=new userdto(userid, password);
		try {
			String message="";
			if(userDAO.islogin(userdto)){
				message="Welcome "+userid;
				UserInfo.USER_NAME=userid;
				JOptionPane.showMessageDialog(this,message);
				setVisible(false);
				dispose();
				DashBoard dashBoard=new DashBoard(message);
				dashBoard.setVisible(true);
			}else {
				message="Invalid UserId or Password ...";
				JOptionPane.showMessageDialog(this,message);
			}
//			JOptionPane.showMessageDialog(this,message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void register() {
//		get the text value
		String userid=useridtxt.getText();
		char[] password=passwordField.getPassword();
		userdto userdto=new userdto(userid, password);
		try {
		int result =userDAO.add(userdto);
		if(result>0) {
//			JOptionPane is used to display the poping message over the window
			JOptionPane.showMessageDialog(this, "Register Successfully ...");
//			System.out.println("Record Added ...");
		}else {
			JOptionPane.showMessageDialog(this, "Register Failed ...");
//			System.out.println("Record Not Added ...");
		}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB Issue ...");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Some Generic Exception Raised");
			e.printStackTrace(); // where is the exception
		}
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		setFont(new Font("Dialog", Font.PLAIN, 16));
		setResizable(false);
		setTitle("Login Page");
		
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(335, 55, 134, 33);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBackground(new Color(0, 64, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(371, 137, 306, 33);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel useridlbl = new JLabel("User ID");
		useridlbl.setBounds(195, 137, 84, 33);
		useridlbl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getContentPane().add(useridlbl);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setBounds(195, 202, 119, 33);
		pwdlbl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getContentPane().add(pwdlbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(371, 202, 306, 33);
		getContentPane().add(passwordField);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dologin();
			}
		});
		loginbt.setBounds(246, 304, 119, 44);
		loginbt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setBounds(472, 304, 119, 44);
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(registerbt);
		setBackground(new Color(255, 255, 255));
		setSize( 862, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
