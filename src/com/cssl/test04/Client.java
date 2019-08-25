package com.cssl.test04;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("127.0.0.1",7777);
		System.out.println("client start");
		Scanner input=new Scanner(System.in);
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		
		while(true) {
			dos.writeUTF(input.next());
			dos.flush();
			System.out.println("服务器回复："+dis.readUTF());
		}
		
		
		
		
	}
}
