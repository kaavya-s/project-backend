package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Repository.OrderRepo;

@Service
public class OrderService {
	@Autowired
	OrderRepo or;

	public List<Order> saveOrder(List<Order> ss) {
        return (List<Order>)or.saveAll(ss);
    }
	
	
	public List<Order> show(){
		return or.findAll();
	}

	public void deletecid(int id)
	{
		or.deleteById(id);
	}
	public String updatebyid(int id,Order c)
	{
		or.saveAndFlush(c);
		if(or.existsById(id))
		{
			return "Updated successfully";
		}
		else
		{
			return "Enter valid order id";
		}
	}
}
