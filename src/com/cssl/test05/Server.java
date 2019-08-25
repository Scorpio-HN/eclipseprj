package com.cssl.test05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		System.out.println("Server start");
		ServerSocket ss=new ServerSocket(6666);
		while(true) {
			Socket socket = ss.accept();
			Mythread mythread = new Mythread(socket);
			new Thread(mythread).start();;
		}
	}

}
