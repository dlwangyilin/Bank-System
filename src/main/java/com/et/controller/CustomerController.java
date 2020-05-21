package com.et.controller;

import com.et.entity.Customer;
import com.et.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        // create model attribute to bind data
        Customer theCustomer = new Customer();
        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
        Customer theCustomer = customerService.getCustomer(id);
        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id) {
        // delete the customer
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}