package com.lab9.smartsearch;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class DBhandler {
	private Configuration config;
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	private ServiceRegistry serviceRegistry;

	public DBhandler() {
		config = new Configuration();
		config.addAnnotatedClass(Country.class);
		config.configure();
		this.serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		this.factory = config.buildSessionFactory(serviceRegistry);
	}

	public void save(Country c) {
		this.session = factory.openSession();
		this.t = session.beginTransaction();

		session.save(c);

		t.commit();
		session.close();
	}

	List<Country> findAll() {
		this.session = factory.openSession();
		this.t = session.beginTransaction();

		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from Country");
		@SuppressWarnings("unchecked")
		List<Country> records = query.list();

		t.commit();
		session.close();
		return records;
	}

}
