package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import model.CustomerMasterDAO;
import model.CustomerMasterDAOImpl;
import model.CustomerMasterDTO;
import model.InvoiceMasterDAO;
import model.InvoiceMasterDAOImpl;
import model.InvoiceMasterDTO;
import model.ItemDetails;
import model.ItemMasterDAO;
import model.ItemMasterDAOImpl;
import model.ItemMasterDTO;
import model.ItemTransactionMasterDAO;
import model.ItemTransactionMasterDAOImpl;
import model.ItemTransactionMasterDTO;
import model.UserDAO;
import model.UserDAOImpl;

public class ShoppingServiceImpl implements Cloneable,ShoppingService{
	Properties prop;
	public ShoppingServiceImpl(Properties prop) {
		this.prop=prop;
	}
	private static ShoppingServiceImpl shoppingServiceImpl;
	
	public static ShoppingServiceImpl getShoppingServiceImpl(Properties prop) {
		if(shoppingServiceImpl==null) {
			shoppingServiceImpl=new ShoppingServiceImpl(prop);
			return shoppingServiceImpl;
		}
		else {
			return shoppingServiceImpl.createClone();
		}
	}
	public ShoppingServiceImpl createClone() {
		try {
			return (ShoppingServiceImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Set<ItemMasterDTO> loadAllItems(String category) {
		Set<ItemMasterDTO> itemmasterdtoset=new HashSet<ItemMasterDTO>();
		ItemMasterDAO itemDao=ItemMasterDAOImpl.getItemDAOImpl(prop);
		itemmasterdtoset=itemDao.getItemMasterAll(category);
		return itemmasterdtoset;
	}
	@Override
	public Set<ItemMasterDTO> buyItems(Set<ItemTransactionMasterDTO> itemtransactionmasterdtoset) {
		ItemTransactionMasterDAO itemtransactiondao=ItemTransactionMasterDAOImpl.getItemTransactionMasterDAOImpl(prop);
		Set<ItemMasterDTO> items=new HashSet<ItemMasterDTO>();
		for(ItemTransactionMasterDTO itemtransactionmasterdto:itemtransactionmasterdtoset) {
		itemtransactiondao.insertItem(itemtransactionmasterdto);
		ItemMasterDTO itemmasterdto=new ItemMasterDTO();
		ItemMasterDAO itemmasterdao=ItemMasterDAOImpl.getItemDAOImpl(prop);
		itemmasterdto=itemmasterdao.getItemMaster(itemtransactionmasterdto.getItemno());
		items.add(itemmasterdto);
		}
		return items;
	}
	@Override
	public int getInvNo(int custno,String dateinstring) {
		InvoiceMasterDAO invoicemaster=InvoiceMasterDAOImpl.getInvoiceMasterDAOImpl(prop);
		InvoiceMasterDTO invmasterdto=new InvoiceMasterDTO();
		invmasterdto.setCustomerno(custno);
		invmasterdto.setInvdate(dateinstring);
		int invno=invoicemaster.insertInvoice(invmasterdto);
		return invno;
	}
	@Override
	public CustomerMasterDTO getCustomerDetails(int customerno) {
		CustomerMasterDAO customerdao=CustomerMasterDAOImpl.getCustomerMasterDAOImpl(prop);
		CustomerMasterDTO customerdto=new CustomerMasterDTO();
		customerdto=customerdao.getCustomerMaster(customerno);
		return customerdto;
	}
	@Override
	public Set<ItemDetails> getItemDetails(int invno) {
		ItemTransactionMasterDAO itemtransactionmasterdao=ItemTransactionMasterDAOImpl.getItemTransactionMasterDAOImpl(prop);
		Set<ItemDetails> itemdetails=new HashSet<ItemDetails>(); 
		itemdetails=itemtransactionmasterdao.getItemDetails(invno);
		return itemdetails;
	}

}
