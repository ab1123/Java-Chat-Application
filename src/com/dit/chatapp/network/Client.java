package com.dit.chatapp.network;

import java.awt.TextArea;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.invoke.StringConcatFactory;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.dit.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	ClientWorker worker;
	JTextArea textArea;
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		int PORT=Integer.parseInt( ConfigReader.getValue("PORT"));
		socket=new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		out=socket.getOutputStream();
		in=socket.getInputStream();
		this.textArea=textArea;
		readMessage();
//		System.out.println("Client Comes ");
//		System.out.println("Enter the message Send to the Server");
//		Scanner scanner=new Scanner(System.in);
//		String message=scanner.nextLine();
//		OutputStream out = socket.getOutputStream(); // Write Bytes on Network
//		out.write(message.getBytes()); // message send over the network
//		System.out.println("Message Send to Server ...");
//		scanner.close();
//		out.close();
//		socket.close();
	}
	public void sendMessage (String message) throws IOException {
		message=message+"\n";
		out.write(message.getBytes());
		
	}
	public void readMessage() {
		worker=new ClientWorker(in,textArea); // Calling a read thread
		worker.start();
	}

	

}
