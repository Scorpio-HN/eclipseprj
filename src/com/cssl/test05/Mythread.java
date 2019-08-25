package com.cssl.test05;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Mythread implements Runnable {

	private Socket socket=null;
	
	
	
	public Mythread(Socket socket) {
		super();
		this.socket = socket;
	}



	@Override
	public void run() {
		OutputStream out=null;
		try {
			out = socket.getOutputStream();
			out.write("hello shuaige".getBytes());
			socket.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
