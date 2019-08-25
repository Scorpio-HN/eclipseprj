package com.cssl.test03;

import java.io.Serializable;

public class Users  implements Serializable{

	private String name;
	private String password;
	private double money;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", password=" + password + ", money=" + money + "]";
	}
	public Users(String name, String password, double money) {
		super();
		this.name = name;
		this.password = password;
		this.money = money;
	}
	public Users() {
		super();
	}
	
	
	
}
