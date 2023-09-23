package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.CustomerDTO;
import com.example.demo.Dto.LoginDTO;
import com.example.demo.Response.LoginnResponse;
import com.example.demo.Service.CustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/customer")
public class CustomerController {
	@Autowired(required = true)
    private CustomerService cs;
    @PostMapping("/savec")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        String id = cs.addCustomer(customerDTO);
        return id;
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginDTO loginDTO)
    {
        LoginnResponse loginResponse = cs.loginCustomer(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
