package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.model.Customer;
import com.model.ItemDetails;
import com.model.ItemTransaction;
import com.model.Items;
import com.model.TotalDetails;



public interface ShoppingService {
	public List<Items> loadAllItems(String shopid);
	public int getInvNo(int custno,String dateinstring);
	public String getInvdate(int custno);
	public List<Items> buyItems(List<ItemTransaction> itemtransactionmasterdtoset);
	public Customer getCustomerDetails(int customerno);
	public List<ItemDetails> getItemDetails(int invno);
	public void createXML(int invno,TotalDetails totaldetails);
	public void createPDF(int invno,String invdate);
	public void createExcel(int invno,String invdate);
	public void sendMail(String name,int invno,int custno);
	public void sendSMS(TotalDetails totaldetails,int custno);
	public TotalDetails createInvoice(HashMap<Integer,Integer> hm);
}
