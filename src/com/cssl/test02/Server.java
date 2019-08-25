package com.cssl.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//模拟服务器
public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(8888);
		System.out.println("server start");
		Socket socket = ss.accept();//阻塞式方法  接受请求
		System.out.println("谁："+socket.getInetAddress());
		//发生数据
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		
		
		//读取服务器返回数据
		byte[] bys=new byte[1024];
		int len=-1;
		while((len=in.read(bys))!=-1) {
			System.out.println("客户端说："+new String(bys,0,len));
		}
		socket.shutdownInput();
		//先发数据
		out.write("你说什么我听不懂".getBytes());
	   socket.shutdownOutput();
	
	}
}
