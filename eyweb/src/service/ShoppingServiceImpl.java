package service;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import model.ItemMasterDAO;
import model.ItemMasterDAOImpl;
import model.ItemMasterDTO;
import model.UserDAO;
import model.UserDAOImpl;

public class ShoppingServiceImpl implements ShoppingService{
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
	public Set<ItemMasterDTO> loadAllItems() {
		Set<ItemMasterDTO> itemmasterdtoset=new HashSet<ItemMasterDTO>();
		ItemMasterDAO itemDao=ItemMasterDAOImpl.getItemDAOImpl(prop);
		itemmasterdtoset=itemDao.getItemMasterAll();
		return itemmasterdtoset;
	}

}
