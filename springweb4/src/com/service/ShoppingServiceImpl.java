package com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerMasterDAO;
import com.dao.InvoiceMasterDAO;
import com.dao.ItemMasterDAO;
import com.dao.ItemTransactionMasterDAO;
import com.dao.UserDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.Customer;
import com.model.Invoice;
import com.model.ItemDetails;
import com.model.ItemTransaction;
import com.model.Items;
import com.model.TotalDetails;
import com.model.Users;



@Service
@Transactional
public class ShoppingServiceImpl implements ShoppingService{

	@Autowired
	private UserDAO userDao;
	@Autowired
	private ItemMasterDAO itemDao;
	@Autowired
	private InvoiceMasterDAO invoiceDao;
	@Autowired
	private CustomerMasterDAO customerDao;
	@Autowired
	private ItemTransactionMasterDAO itemTransactionDao;
	@Autowired
	private ShoppingService shoppingService;

	
	
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public ItemMasterDAO getItemDao() {
		return itemDao;
	}
	public void setItemDao(ItemMasterDAO itemDao) {
		this.itemDao = itemDao;
	}
	
	@Override
	public List<Items> loadAllItems(String category) {
		List<Items> itemmasterdtoset=new ArrayList<Items>();
		itemmasterdtoset=itemDao.getItemMasterAll(category);
		return itemmasterdtoset;
	}
	@Override
	public int getInvNo(int custno, String dateinstring) {
		Invoice invoice=new Invoice();
		invoice.setCustomerno(custno);
		invoice.setInvdate(dateinstring);
		System.out.println(invoice);
		return invoiceDao.insertInvoice(invoice);
	}
	@Override
	public String getInvdate(int invno) {
		String date=invoiceDao.getDate(invno);
		return date;
	}
	@Override
	public List<Items> buyItems(List<ItemTransaction> itemtransactionmasterdtoset) {
		List<Items> items=new ArrayList<Items>();
		for(ItemTransaction itemtransactionmasterdto:itemtransactionmasterdtoset) {
		itemTransactionDao.insertItem(itemtransactionmasterdto);
		Items itemmasterdto=new Items();
		itemmasterdto=itemDao.getItemMaster(itemtransactionmasterdto.getItemno());
		items.add(itemmasterdto);
		}
		return items;
	}
	@Override
	public Customer getCustomerDetails(int customerno) {
		return customerDao.getCustomerMaster(customerno);
	}
	@Override
	public List<ItemDetails> getItemDetails(int invno) {
		System.out.println("Invoice No "+invno);
		List<ItemDetails> itemdetails=new ArrayList<ItemDetails>(); 
		itemdetails=itemTransactionDao.getItemDetails(invno);
		return itemdetails;
	}
	@Override
	public void createXML(int invno, TotalDetails totaldetails) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createPDF(int invno, String invdate) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createExcel(int invno, String invdate) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sendMail(String name, int invno, int custno) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sendSMS(TotalDetails totaldetails, int custno) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public TotalDetails createInvoice(HashMap<Integer, Integer> hm) {
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateinstring=formatter.format(date);
		shoppingService.getInvNo(1, dateinstring);
		int invno=shoppingService.getInvNo(1, dateinstring);
		dateinstring=shoppingService.getInvdate(invno);
		List<ItemTransaction> items=new ArrayList<ItemTransaction>();
		Iterator hmIterator = hm.entrySet().iterator();
		 while (hmIterator.hasNext()) {
			 	ItemTransaction itemtransactionmasterdto=new ItemTransaction();
	            Map.Entry mapElement = (Map.Entry)hmIterator.next();
	            int itemqty = ((int)mapElement.getValue());
	            int itemno = ((int)mapElement.getKey());
	            itemtransactionmasterdto.setInvno(invno);
	            itemtransactionmasterdto.setItemno(itemno);
	            itemtransactionmasterdto.setItemqty(itemqty);
	            items.add(itemtransactionmasterdto);
	         
	        }
		 System.out.println("Items "+items);
		List<Items> itemdetails=new ArrayList<Items>();
		itemdetails=shoppingService.buyItems(items);
		System.out.println(itemdetails);
		TotalDetails totaldetails=new TotalDetails();
		totaldetails.setCustomemasterdto(shoppingService.getCustomerDetails(1));
		totaldetails.setItemdetails(shoppingService.getItemDetails(invno));
		totaldetails.setInvdate(dateinstring); // to be updated
		System.out.println(totaldetails);
		return null;
	}


	


}
