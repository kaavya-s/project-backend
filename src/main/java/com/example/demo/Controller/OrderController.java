package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Service.OrderService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
	@Autowired
	OrderService os;
	
	@PostMapping("/save")
    public List<Order> createOrder(@RequestBody List<Order> ss) {
        return (List<Order>)os.saveOrder(ss);
	}
	
	@GetMapping("/getList")
	public List<Order> showList()
	{
		return os.show();
	}
	@DeleteMapping("delete/{id}")
	public String delid(@PathVariable int id) {
		os.deletecid(id);
		return "Deleted successfully";
	}
	@PutMapping("/update/{id}")
	public String modbyid(@PathVariable int id,@RequestBody Order c) {
		return os.updatebyid(id, c);
	}
}