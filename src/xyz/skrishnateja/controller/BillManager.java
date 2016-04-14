package xyz.skrishnateja.controller;


import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import xyz.skrishnateja.model.Bill;
import xyz.skrishnateja.util.HibernateUtil;

public class BillManager extends HibernateUtil {

	public Bill add(Bill bill) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		System.out.println(bill.toString());
		session.save(bill);
		session.getTransaction().commit();
		return bill;
	}
	public Bill delete(int sno) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Bill bill = (Bill) session.load(Bill.class, sno);
		System.out.println(bill.toString());
		if(null != bill) {
			session.delete(bill);
		}
		session.getTransaction().commit();
		return bill;
	}

	public List<Bill> list() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Bill> bills = null;
		try {
			
			bills = (List<Bill>)session.createQuery("from Bill").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return bills;
	}
public List<Bill> edit(int sno) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Bill> bill = null;
		try {
			
			bill = (List<Bill>)session.createQuery("from Bill where sno='"+sno+"'").list();
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return bill;
	}
}
