package com.dao;

import java.util.List;
import java.util.Set;

import com.model.Items;

public interface ItemMasterDAO {
	public int insertItemDetails(Items itemMasterDTO);
	public int deleteItemDetails(int itemno);
	public int updateItemDetails(Items itemMasterDTO);
	public Items getItemMaster(int itemno);
	public List<Items> getItemMasterAll(String category);
}
