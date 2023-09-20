package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Order;
import com.example.demo.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	OrderService os;
	
	@PostMapping("/place")
	public void saveOrder(@RequestBody Order o)
	{
		os.placeOrder(o);
	}
	

}
