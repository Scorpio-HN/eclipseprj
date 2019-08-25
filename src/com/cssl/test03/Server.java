package com.cssl.test03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket ss=new ServerSocket(9999);
		Socket socket = ss.accept();
		ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
		Users user=(Users) ois.readObject();
		System.out.println("user:"+user);
		
		socket.shutdownInput();
		socket.getOutputStream().write("收到了".getBytes());
		socket.shutdownOutput();
		
	}

}
