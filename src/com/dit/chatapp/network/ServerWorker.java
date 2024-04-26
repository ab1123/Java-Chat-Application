package com.dit.chatapp.network;
//Thread=Worker
// Worker need a Job to perform
// For Job u give runnable
//public class ServerWorker implements Runnable{
//	public class ServerWorker extends Thread{
//		public void run() {
////		Job to Perform
////		Logic
//			
//			
//		}
//	public static void main(String[] args) {
////		ServerWorker job=new ServerWorker();
//		ServerWorker worker=new ServerWorker();
//		worker.start();
////		Assigning a Job/Worker
////		Thread worker=new Thread(job);
////		worker.start();
//	}
//
//	
//
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.Buffer;

public class ServerWorker extends Thread{
	private Socket clientSocket;
	private InputStream in;
	private OutputStream out;
	private Server server;
	public ServerWorker(Socket clientSocket,Server server) throws IOException {
		this.server=server;
		this.clientSocket=clientSocket;
		in = clientSocket.getInputStream();// Read the client data
		out=clientSocket.getOutputStream();// client data write
		System.out.println("New Client Comes");
		
	}
	@Override
	public void run() {
//		Read the data from the Client and Broadcast the data to all
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String line;
		try {
		while(true) {
				line=br.readLine();
				if(line.equalsIgnoreCase("quit")) {
					break; // Client chat end
				}
//				out.write(line.getBytes()); Client send
//				Broadcast to all
				for(ServerWorker serverWorker: server.workers) {
					line=line+"\n";
					serverWorker.out.write(line.getBytes());
				}
			} 
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
			if(br!=null) {
				br.close();
			}
			if(in!=null) {
				in.close();
			}
			if(out!=null) {
				out.close();
			}
			if(clientSocket!=null) {
				clientSocket.close();
			}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}