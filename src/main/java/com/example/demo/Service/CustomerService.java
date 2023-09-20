package com.example.demo.Service;

import com.example.demo.Dto.CustomerDTO;
import com.example.demo.Dto.LoginDTO;
import com.example.demo.Response.LoginnResponse;


public interface CustomerService {

	String addCustomer(CustomerDTO customerDTO);
	LoginnResponse loginCustomer(LoginDTO loginDTO);
}
