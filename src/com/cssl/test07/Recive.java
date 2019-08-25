package com.cssl.test07;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

public class Recive {

	public static void main(String[] args) throws IOException {
		System.out.println("xxxxxxxxxxxx");
		byte[] bys=new byte[1024];
		DatagramPacket dp1=new DatagramPacket(bys, bys.length);
		DatagramSocket ds=new DatagramSocket(7788);
		ds.receive(dp1);
		
		//取出
		String mess=new String(dp1.getData(),0,dp1.getLength());
		System.out.println("收到了："+mess);
		
		
		String mess2="天气真的好凉快";
		byte[] bys2=mess2.getBytes();
		SocketAddress socketAddress = dp1.getSocketAddress();
		DatagramPacket dp2=new DatagramPacket(bys2,0, bys2.length,socketAddress);
		
		ds.send(dp2);
	}
}
