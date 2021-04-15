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
import com.model.Items;

@Repository
public class ItemMasterDAOImpl implements ItemMasterDAO{
	@Autowired
	private SessionFactory factory;
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public int insertItemDetails(Items itemMasterDTO) {
		try {
			Session session=factory.getCurrentSession();
			session.persist(itemMasterDTO);
			return 0;
		}catch(Exception e) {}
		return 0;
	}

	@Override
	public int deleteItemDetails(int itemno) {
		Session session=factory.getCurrentSession();
	    Query query = session.createQuery("DELETE from Items where itemno = :itemno");
	    query.setInteger("itemno", itemno);
	     int row = query.executeUpdate();
		return row;
		
	}


	@Override
	public Items getItemMaster(int itemno) {
		Session session=factory.getCurrentSession();
		Query query=session.createQuery("from Items where itemno = :itemno");
		query.setInteger("itemno", itemno);
		Items item = (Items) query.uniqueResult();
		return item;
	
	}

	@Override
	public List<Items> getItemMasterAll(String category) {
		Session session=factory.getCurrentSession();
		Query query=session.createQuery("from Items where category = :category");
		query.setString("category", category);
		List<Items> itemlist = query.list();
		System.out.println(itemlist);
		return itemlist;
	
	}
	@Override
	public int updateItemDetails(Items itemMasterDTO) {
	return 0;
	}

	

}
