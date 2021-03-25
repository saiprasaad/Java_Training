package service;

import java.util.Set;

import model.ItemMasterDTO;

public interface ShoppingService {
	public Set<ItemMasterDTO> loadAllItems();
}
