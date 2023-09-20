package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Order;
import com.example.demo.Repository.OrderRepo;

@Service
public class OrderService {
	@Autowired
	OrderRepo or;
	
	public void placeOrder(Order o)
	{
		or.save(o);
	}

}
