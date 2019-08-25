package com.cssl.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//模拟客户端
public class Clien {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//创建一个客户端
		Socket socket=new Socket("127.0.0.1",8888);
		System.out.println("client start");
		//发生数据
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		//先发数据
		out.write("你好".getBytes());
		socket.shutdownOutput();
		
		//读取服务器返回数据
		byte[] bys=new byte[1024];
		int len=-1;
		while((len=in.read(bys))!=-1) {
			System.out.println("服务器说："+new String(bys,0,len));
		}
		socket.shutdownInput();
		
	}
}
