package com.yilin.dao;

import com.yilin.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // create a query
        Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
        // execute query
        List<Customer> customers = query.getResultList();
        return customers;
    }
}
