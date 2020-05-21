package com.yilin.controller;

import com.yilin.dao.CustomerDAO;
import com.yilin.entity.Customer;
import com.yilin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // inject customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        // get customers from service
        List<Customer> theCustomers = customerService.getCustomers();
        model.addAttribute("customers", theCustomers);
        // add customers into the model
        return "list-customers";
    }
}
