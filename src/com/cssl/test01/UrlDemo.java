package com.cssl.test01;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {

	public static void main(String[] args) throws MalformedURLException {
		URL url=new URL("http://www.baidu.com:6565/index.php?action=admin&&id=123");
		System.out.println("协议："+url.getProtocol());
		System.out.println("域名："+url.getHost());
		System.out.println("端口："+url.getPort());
		System.out.println("资源："+url.getFile());
		System.out.println("参数："+url.getQuery());

	}

}
