package com.jsproject.companyapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsproject.companyapp.CompanyDatabase;
import com.jsproject.companyapp.Customer;
import com.jsproject.companyapp.dto.CustomerRequest;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    

    @PostMapping
    public String addCustomer(@RequestBody CustomerRequest req) {
        CompanyDatabase database = CompanyDatabase.getInstance();
        if (database.insertCustomer(req.getName())) {
            return "Customer added: " + req.getName();
        } else {
            return "Customer not added";
        }
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return CompanyDatabase.getInstance().getAllCustomers();
    }
}
