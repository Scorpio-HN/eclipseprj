package com.cssl.test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket socket=new Socket("localhost",9999);
		
		ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(new Users("张三","123",100));
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line=null;
		while((line=bf.readLine())!=null) {
			System.out.println("服务器说："+line);
		}
	
	}

}
