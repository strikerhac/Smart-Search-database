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
    

     public List getbyname(String cityname) { 
    	 this.session = factory.openSession(); 
	     this.t = session.beginTransaction();
	     
	     String hql = "FROM Country c WHERE c.city = : parameter";
	     Query query = session.createQuery(hql);
	     query.setParameter("parameter",cityname);
	     List results = query.list();
	    
	     t.commit();
	     session.close();
	     return results;
     }
     
     public List getbylat(double lat) { 
    	 this.session = factory.openSession(); 
	     this.t = session.beginTransaction();
	     
	     String hql = "FROM Country c WHERE c.latitude = : parameter";
	     Query query = session.createQuery(hql);
	     query.setParameter("parameter",lat);
	     List results = query.list();
	    
	     t.commit();
	     session.close();
	     return results;
     }
     
     public List getbylong(double lon) { 
    	 this.session = factory.openSession(); 
	     this.t = session.beginTransaction();
	     
	     String hql = "FROM Country c WHERE c.latitude = : parameter";
	     Query query = session.createQuery(hql);
	     query.setParameter("parameter",lon);
	     List results = query.list();
	    
	     t.commit();
	     session.close();
	     return results;
     }
     
     public List getnearbylocs(String cityname, int max) { 
    	 this.session = factory.openSession(); 
	     this.t = session.beginTransaction();
	     List results = null;
	    
	     t.commit();
	     session.close();
	     return results;
     }
     
     List<Country> findAll() {
    	 this.session = factory.openSession(); 
	     this.t = session.beginTransaction();
	     
         List<Country> records = session.createQuery("from Country").list();
         t.commit();
	     session.close();
         return records;
     }
     
     
}











