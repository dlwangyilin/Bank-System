package com.yilin.controller;

import com.yilin.dao.CustomerDAO;
import com.yilin.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // inject the customer DAO
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        // get customers from DAO
        List<Customer> theCustomers = customerDAO.getCustomers();
        model.addAttribute("customers", theCustomers);
        // add customers into the model
        return "list-customers";
    }
}
