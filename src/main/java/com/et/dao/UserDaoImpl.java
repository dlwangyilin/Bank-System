package com.et.dao;

import com.et.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String theUserName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public List<User> getUsers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<User> query = currentSession.createQuery("from User order by lastName", User.class);
		// execute query
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	public void saveUser(User theUser) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save the customer
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public User getUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, id);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from User where id=:userId");
		query.setParameter("userId", id);
		query.executeUpdate();
	}

	@Override
	public List<User> searchUsers(String theSearchName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		// only search by name if theSearchName is not empty
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery =currentSession.createQuery("from User where lower(firstName) like :theName or lower(lastName) like :theName", User.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		}
		else {
			// theSearchName is empty ... so just get all customers
			theQuery =currentSession.createQuery("from User", User.class);
		}

		// execute query and get result list
		List<User> users = theQuery.getResultList();

		// return the results
		return users;

	}

}
