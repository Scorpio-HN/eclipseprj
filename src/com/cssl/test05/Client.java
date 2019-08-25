package com.cssl.test05;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("127.0.0.1",6666);
		InputStream in = socket.getInputStream();
		int line=-1;
		byte[] bys=new byte[1024];
		while((line=in.read(bys))!=-1) {
			System.out.println("服务器说："+new String(bys,0,line));
		}
		socket.shutdownInput();
		
	}
}
