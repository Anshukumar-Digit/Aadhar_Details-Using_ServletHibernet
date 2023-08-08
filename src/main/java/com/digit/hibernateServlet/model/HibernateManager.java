package com.digit.hibernateServlet.model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.hibernateServlet.bean.AadharDetails;
public class HibernateManager {

	
	private Session session;
	public HibernateManager() {
		Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder=new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory=configuration.buildSessionFactory(builder.buildServiceRegistry());
		session=sessionFactory.openSession();
		System.out.println("Connected to pf..........");
	}
	
	public boolean saveObj(AadharDetails s1) {
		Transaction tran=session.beginTransaction();
		session.save(s1);
		tran.commit();
		System.out.println("object saved");
		return true;
	}
	
	
	public boolean update(String id) {
		Transaction tran=session.beginTransaction();
 
        AadharDetails s=(AadharDetails)session.get(AadharDetails.class,id);
		s.setName(s.getName());
		session.update(s);
		System.out.println("Update success");
		tran.commit();
		return true;
	}
	public boolean delete(String id) {
		Transaction tran=session.beginTransaction();
		
		
        AadharDetails s=(AadharDetails)session.get(AadharDetails.class,id);
	    session.delete(s);
		System.out.println("Delete success");
		tran.commit();
		
		
		
		
		return true;
	}

	public AadharDetails viewDetails(String id) {
		// TODO Auto-generated method stub
		//Transaction tran=session.beginTransaction();
		session.beginTransaction();
		AadharDetails s=(AadharDetails) session.get(AadharDetails.class, id);
		//System.out.println(s.getName()+" "+s.getAddress());
		return s;
	}

	
}
