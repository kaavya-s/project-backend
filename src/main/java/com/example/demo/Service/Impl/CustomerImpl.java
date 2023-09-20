package com.example.demo.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.CustomerDTO;
import com.example.demo.Dto.LoginDTO;
import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepo;
import com.example.demo.Response.LoginnResponse;
import com.example.demo.Service.CustomerService;

@Service
public class CustomerImpl implements CustomerService{
	@Autowired 
    private CustomerRepo cr;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustid(),
                customerDTO.getCustomername(),
                customerDTO.getEmail(),
               this.passwordEncoder.encode(customerDTO.getPassword()),
               customerDTO.getAddress(),
               customerDTO.getPhone()
        );
        cr.save(customer);
        return customer.getCustomername();
    }
    CustomerDTO customerDTO;
    @Override
    public LoginnResponse  loginCustomer(LoginDTO loginDTO) {
        String msg = "";
        Customer customer1 = cr.findByEmail(loginDTO.getEmail());
        if (customer1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = customer1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Customer> customer = cr.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (customer.isPresent()) {
                    return new LoginnResponse("Login Success", true);
                } else {
                    return new LoginnResponse("Login Failed", false);
                }
            } else {
                return new LoginnResponse("password Not Match", false);
            }
        }else {
            return new LoginnResponse("Email not exits", false);
        }
    }

}
