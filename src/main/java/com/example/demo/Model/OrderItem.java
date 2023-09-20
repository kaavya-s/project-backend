package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue
	private int oid;
	
	private String name;
	private int amt;
	private double price;
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(int oid, String name, int amt, double price) {
		super();
		this.oid = oid;
		this.name = name;
		this.amt = amt;
		this.price = price;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
