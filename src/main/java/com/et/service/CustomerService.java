package com.et.service;

import com.et.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String theSearchName);
}
