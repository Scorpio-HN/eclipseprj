package com.cssl.test07;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Send {

	public static void main(String[] args) throws IOException {
		String mess="康乾盛世";
		System.out.println("ffffffffffff");
		byte[] bys=mess.getBytes();
		InetAddress ia = InetAddress.getByName("localhost");
		DatagramPacket dp1=new DatagramPacket(bys,0,bys.length,ia,7788);

		DatagramSocket ds=new DatagramSocket();
		
		ds.send(dp1);
		
		byte[] bys2=new byte[1024];
		DatagramPacket dp2=new DatagramPacket(bys2,0,bys2.length);
		ds.receive(dp2);
		System.out.println("收到了2；"+new String(dp2.getData(),0,dp2.getData().length));
		
		
		
	}

}
