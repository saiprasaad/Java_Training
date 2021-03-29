package service;

import java.util.Set;

import model.CustomerMasterDTO;
import model.ItemDetails;
import model.ItemMasterDTO;
import model.ItemTransactionMasterDTO;
import model.TotalDetails;

public interface ShoppingService {
	public Set<ItemMasterDTO> loadAllItems(String shopid);
	public int getInvNo(int custno,String dateinstring);
	public String getInvdate(int custno);
	public Set<ItemMasterDTO> buyItems(Set<ItemTransactionMasterDTO> itemtransactionmasterdtoset);
	public CustomerMasterDTO getCustomerDetails(int customerno);
	public Set<ItemDetails> getItemDetails(int invno);
	public void createXML(int invno,TotalDetails totaldetails);
	public void createPDF(int invno,String invdate);
	public void createExcel(int invno,String invdate);
	public void sendMail(String name,int invno,int custno);
	public void sendSMS(TotalDetails totaldetails,int custno);
}
