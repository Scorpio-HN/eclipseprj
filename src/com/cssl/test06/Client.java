package com.cssl.test06;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("client start");
		 Socket s=new Socket("127.0.0.1", 5555);
		 new ClientReaderThread(s).start();
		 new ClientWriteThred(s).start();
	
	
	
	
	
	}
}

class ClientReaderThread extends Thread{
	private Socket socket=null;
	

	public ClientReaderThread(Socket socket) {
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
				System.out.println("server say:"+new String(chs,0,len));
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
class ClientWriteThred extends Thread{
	private Socket socket=null;
	
	public ClientWriteThred(Socket socket) {
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
