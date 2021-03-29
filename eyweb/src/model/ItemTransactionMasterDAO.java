package model;

import java.util.Set;

import model.ItemMasterDTO;

public interface ItemTransactionMasterDAO {
	public int insertItem(ItemTransactionMasterDTO itemTransactionMasterDTO);
	public int deleteItem(int invno,int itemno);
	public int updateItem(ItemTransactionMasterDTO itemTransactionMasterDTO);
	public ItemTransactionMasterDTO getItemTransactionMaster(int invno,int itemno);
	public Set<ItemTransactionMasterDTO> getItemTransactionMasterAll();
	public Set<ItemTransactionMasterDTO> getItemTransactionMasterAllByInvno(int invoiceno);
	public Set<ItemDetails> getItemDetails(int invno);
}
