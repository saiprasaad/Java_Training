package com.dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.ItemDetails;
import com.model.ItemTransaction;
import com.model.Items;



@Repository
public class ItemTransactionMasterDAOImpl implements ItemTransactionMasterDAO{
	@Autowired
	private SessionFactory factory;
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public int insertItem(ItemTransaction itemTransactionMasterDTO) {
		System.out.println("Item Trasaction Insert "+itemTransactionMasterDTO);
			Session session=factory.getCurrentSession();
			session.save(itemTransactionMasterDTO);
			return 0;
	}

	@Override
	public int deleteItem(int invno, int itemno) {
		Session session=factory.getCurrentSession();
	    Query query = session.createQuery("DELETE from ItemTransaction where itemno = :itemno and invno = :invno");
	    query.setInteger("itemno", itemno);
	    query.setInteger("invno", invno);
	     int row = query.executeUpdate();
		return row;
	}

	@Override
	public int updateItem(ItemTransaction itemTransactionMasterDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemTransaction getItemTransactionMaster(int invno, int itemno) {
		Session session=factory.getCurrentSession();
		Query query=session.createQuery("from ItemTransaction where itemno = :itemno and invno = :invno");
		query.setInteger("itemno", itemno);
		query.setInteger("invno", invno);
		ItemTransaction itemtransaction = (ItemTransaction) query.uniqueResult();
		return itemtransaction;
	}

	@Override
	public Set<ItemTransaction> getItemTransactionMasterAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ItemTransaction> getItemTransactionMasterAllByInvno(int invoiceno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ItemDetails> getItemDetails(int invno) {
		try {
			Session session=factory.getCurrentSession();
			List<ItemDetails> itemdetailsset=new ArrayList<ItemDetails>();
			System.out.println("getItemDetails");
			String querystring="select ItemTransaction.itemno,itemqty,itemprice,itemunit from ItemTransaction,Items where Items.itemno in(SELECT itemno from Items where ItemTransaction.itemno=Items.itemno) and invno = :invno";
			Query query=session.createQuery(querystring);
			query.setInteger("itemno", invno);
			System.out.println("Returns "+query.list());
//			System.out.println(ps);
//			while(rs.next()) {
//				ItemDetails itemdetails=new ItemDetails();
//				itemdetails.setItemno(rs.getInt("itemno"));
//				itemdetails.setItemqty(rs.getInt("itemqty"));
//				itemdetails.setItemdescription(rs.getString("itemdescription"));
//				itemdetails.setItemprice(rs.getInt("itemprice"));
//				itemdetails.setItemunit(rs.getString("itemunit"));
//				itemdetailsset.add(itemdetails);
//			}
			
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
