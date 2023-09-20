package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Order {
	@Id
	@GeneratedValue
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public double getTotamt() {
		return totamt;
	}
	public void setTotamt(double totamt) {
		this.totamt = totamt;
	}
	public Order(int id, List<OrderItem> items, double totamt) {
		super();
		this.id = id;
		this.items = items;
		this.totamt = totamt;
	}
	@OneToMany(cascade=CascadeType.ALL)
	private List<OrderItem> items ;
	private double totamt;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
}
