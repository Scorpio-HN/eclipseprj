package com.cssl.test06;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(5555);
		System.out.println("server start******");
		while(true) {
			Socket socket = ss.accept();
			new ServerReaderThread(socket).start();
			new ServerWriteThred(socket).start();
		}
		
		
		
		
		
	}
}
class ServerReaderThread extends Thread{
	private Socket socket=null;
	

	public ServerReaderThread(Socket socket) {
		super();
		this.socket = socket;
	}


	@Override
	public void run() {
		try {
			InputStream in = socket.getInputStream();
			InputStreamReader sr=new InputStreamReader(in);
			char[] chs=new char[1024];
			int len=-1;
			while((len=sr.read(chs))!=-1) {
				System.out.println("client say:"+new String(chs,0,len));
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
class ServerWriteThred extends Thread{
	private Socket socket=null;
	
	public ServerWriteThred(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		Scanner input=new Scanner(System.in);
		try {
			 OutputStream out = socket.getOutputStream();
			 OutputStreamWriter sw=new OutputStreamWriter(out);
			while(true) {
				String  mess=input.next();
				sw.write(mess);
				sw.flush();
				if("quit".equals(mess)) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}