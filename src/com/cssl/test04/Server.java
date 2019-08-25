package com.cssl.test04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(7777);
		System.out.println("server start");
		Scanner input=new Scanner(System.in);
		while(true) {
			//监听客户端请求
			Socket socket = ss.accept();
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			while(true) {
				
				System.out.println("客户说："+dis.readUTF());
				dos.writeUTF(input.next());
				dos.flush();
			}
		}
		
	}
}
