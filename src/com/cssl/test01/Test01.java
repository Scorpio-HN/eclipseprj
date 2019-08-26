package com.cssl.test01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * http https ftp --tcp
 * 端口号：65000个 8080 3306 2000以下的端口 预留给大厂
 * ip:全球唯一一台电脑的
 * DNS:域名解析器 将域名转成ip地址
 * */
public class Test01 {
 public static void main(String[] args) throws UnknownHostException {
	//测试提交代码
	 //我做了一些替换功能
	 InetAddress n1=InetAddress.getLocalHost();
	System.out.println("n1:"+n1);
	System.out.println("n2:"+n1.getHostName());
	System.out.println("n3:"+n1.getHostAddress());
	System.out.println("********************");
	InetAddress n2 = InetAddress.getByName("www.baidu.com");
	System.out.println("n1:"+n2);
	System.out.println("n2:"+n2.getHostName());
	System.out.println("n3:"+n2.getHostAddress());
	System.out.println("********千寻************");
	InetAddress n3 = InetAddress.getByName("14.215.177.38");
	System.out.println("n1:"+n3);
	System.out.println("n2:"+n3.getHostName());
	System.out.println("n3:"+n3.getHostAddress());
}
}
