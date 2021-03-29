package model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;
import service.ShoppingService;
import service.ShoppingServiceImpl;

/**
 * Servlet implementation class InvoiceAction
 */
public class InvoiceAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String shopid=request.getParameter("shopid");
		HttpSession session=request.getSession();
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateinstring=formatter.format(date);
		Properties prop=(Properties)request.getServletContext().getAttribute("properties");
		ShoppingService shoppingService=ShoppingServiceImpl.getShoppingServiceImpl(prop);
		int invno=shoppingService.getInvNo((int)session.getAttribute("custno"), dateinstring);
		session.setAttribute("invno",invno);
		HashMap<Integer,Integer> hm=(HashMap<Integer, Integer>) session.getAttribute("itemsselected");
		String[] selectedItems = request.getParameterValues("selected");
		for(int i=0;i<selectedItems.length;i++) {
			String qty=request.getParameter(selectedItems[i]);
			hm.put(Integer.parseInt(selectedItems[i]),Integer.parseInt(qty));
		}
		Set<ItemTransactionMasterDTO> items=new HashSet<ItemTransactionMasterDTO>();
		Iterator hmIterator = hm.entrySet().iterator();
		 while (hmIterator.hasNext()) {
			 	ItemTransactionMasterDTO itemtransactionmasterdto=new ItemTransactionMasterDTO();
	            Map.Entry mapElement = (Map.Entry)hmIterator.next();
	            int itemqty = ((int)mapElement.getValue());
	            int itemno = ((int)mapElement.getKey());
	            itemtransactionmasterdto.setInvno(invno);
	            itemtransactionmasterdto.setItemno(itemno);
	            itemtransactionmasterdto.setItemqty(itemqty);
	            items.add(itemtransactionmasterdto);
	         
	        }
		Set<ItemMasterDTO> itemdetails=new HashSet<ItemMasterDTO>();
		itemdetails=shoppingService.buyItems(items);
		session.setAttribute("itemsbought",itemdetails);
		TotalDetails totaldetails=new TotalDetails();
		System.out.println((int)session.getAttribute("custno"));
		totaldetails.setCustomemasterdto(shoppingService.getCustomerDetails((int)session.getAttribute("custno")));
		totaldetails.setItemdetails(shoppingService.getItemDetails(invno));
		totaldetails.setInvdate(dateinstring); // to be updated
		System.out.println(totaldetails);
		session.setAttribute("totaldetails", totaldetails);
		return shopid;
	}

}
