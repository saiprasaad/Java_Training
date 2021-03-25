package model;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ShoppingService;
import service.ShoppingServiceImpl;

public class ShoppingAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	Properties prop=(Properties)request.getServletContext().getAttribute("properties");
	ShoppingService shoppingService=ShoppingServiceImpl.getShoppingServiceImpl(prop);
	Set<ItemMasterDTO> jewelitems=new HashSet<ItemMasterDTO>();
	jewelitems=shoppingService.loadAllItems();
	String shopid=request.getParameter("shopid");
	System.out.println(jewelitems);
	request.setAttribute("jewellery", jewelitems);
	// TODO Auto-generated method stub
//	return "shop.success";
	return "shop.success";
}
}
