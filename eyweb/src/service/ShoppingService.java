package service;

import java.util.Set;

import model.CustomerMasterDTO;
import model.ItemDetails;
import model.ItemMasterDTO;
import model.ItemTransactionMasterDTO;

public interface ShoppingService {
	public Set<ItemMasterDTO> loadAllItems(String shopid);
	public int getInvNo(int custno,String dateinstring);
	public Set<ItemMasterDTO> buyItems(Set<ItemTransactionMasterDTO> itemtransactionmasterdtoset);
	public CustomerMasterDTO getCustomerDetails(int customerno);
	public Set<ItemDetails> getItemDetails(int invno);
}
