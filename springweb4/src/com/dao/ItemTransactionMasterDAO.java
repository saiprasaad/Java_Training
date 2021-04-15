package com.dao;

import java.util.ArrayList;
import java.util.Set;

import com.model.ItemDetails;
import com.model.ItemTransaction;
import com.model.Items;


public interface ItemTransactionMasterDAO {
	public int insertItem(ItemTransaction itemTransactionMasterDTO);
	public int deleteItem(int invno,int itemno);
	public int updateItem(ItemTransaction itemTransactionMasterDTO);
	public ItemTransaction getItemTransactionMaster(int invno,int itemno);
	public Set<ItemTransaction> getItemTransactionMasterAll();
	public Set<ItemTransaction> getItemTransactionMasterAllByInvno(int invoiceno);
	public ArrayList<ItemDetails> getItemDetails(int invno);
}
