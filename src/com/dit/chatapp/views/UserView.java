package com.dit.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	int counter;
	public UserView() {
		counter=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on closing window is closed 
		setSize(500,500); // size of window
		setResizable(false); // don't allow to maximise
//		setLocation(100, 50); // location of the window
		setTitle("Login Page"); // Title
		setLocationRelativeTo(null); // In centre
		
		JLabel welcome=new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		Container container=this.getContentPane();// frame ke ander aak container bna leye hai jisme sab cheze aayenge
		container.add(welcome);
		container.setLayout(null); // this use default border layout
		welcome.setBounds(100,70,200,60);
		JButton button = new JButton("Count");
//		ActionListener is an interface extends the EventListener class 
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				counter++;
				welcome.setText("Count "+counter);
			}
		});
		button.setBounds(100,300,200,50);
		container.add(button);
		setVisible(true); // frame displayed
		
	}

	public static void main(String[] args) {
		UserView userView= new UserView();
		
	}

}
