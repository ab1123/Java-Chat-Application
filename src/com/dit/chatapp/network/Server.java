package com.dit.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.Port;

import com.dit.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers=new ArrayList<ServerWorker>();// contains all the client socket
	 public Server() throws IOException {
		// TODO Auto-generated constructor stub
		 int PORT=Integer.parseInt( ConfigReader.getValue("PORT"));
			serverSocket=new ServerSocket(PORT);
			
			System.out.println("Server Starts and Waiting for the Client to joins..");
			handleClientRequest();
	}
		
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket=serverSocket.accept();// Handshaking
//			Per client per thread
			ServerWorker serverWorker=new ServerWorker(clientSocket,this);
//			As we lost the old object so we add in the arraylist to avoid this situation
			workers.add(serverWorker);
			serverWorker.start();
		}
		
	}
//	Single Client
//	public Server() throws IOException {
//		int PORT=Integer.parseInt( ConfigReader.getValue("PORT"));
//		serverSocket=new ServerSocket(PORT);
//		System.out.println("Server is Started and Waiting for the Client Connection ...");
//	Socket socket=serverSocket.accept();//Handshaking with the client
//	System.out.println("Client Joins the server");
//	InputStream in= socket.getInputStream();
//	byte arr[] =in.readAllBytes();
//	String str=new String(arr); // Bytes into String
//	System.out.println("Message Received from Client ... "+str);
//	in.close();
//	socket.close();
//	}
	public static void main(String[] args) throws IOException {
		Server server=new Server();
	
		
	}

}
