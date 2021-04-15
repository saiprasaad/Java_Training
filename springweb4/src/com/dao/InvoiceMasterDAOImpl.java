package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Invoice;

@Repository
public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {
	@Autowired
	private SessionFactory factory;
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public int insertInvoice(Invoice invMasterDTO) {
		Session session=factory.getCurrentSession();
		System.out.println(invMasterDTO);
		session.save(invMasterDTO);
		session.flush();
		int invno= invMasterDTO.getInvno();
		System.out.println("Invoice No "+invno);
		return invno;
	}

	@Override
	public int deleteInvoice(int invno) {
		Session session=factory.getCurrentSession();
	    Query query = session.createQuery("DELETE from Invoice where invno = :invno");
	    query.setInteger("invno", invno);
	     int row = query.executeUpdate();
		return row;
	}
	
	@Override
	public Invoice getInvoiceMaster(int invno) {
		Session session=factory.getCurrentSession();
		Query query=session.createQuery("from Invoice where invno = :invno");
		query.setInteger("invno", invno);
		Invoice invoice = (Invoice) query.uniqueResult();
		return invoice;
	}
	@Override
	public List<Invoice> getInvoiceMasterAll() {
		Session session=factory.getCurrentSession();
		Query query=session.createQuery("from Invoice");
		List<Invoice> invoicelist = (List<Invoice>) query.list();
		return invoicelist;
	}

	@Override
	public String getDate(int invno) {
		Session session=factory.getCurrentSession();
		Query query=session.createQuery("select invdate from Invoice where invno = :invno");
		query.setInteger("invno", invno);
		String date= (String) query.uniqueResult();
		return date;
	}
	@Override
	public int updateInvoice(Invoice invMasterDTO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void test() {
		System.out.println("Hi");
	}
}