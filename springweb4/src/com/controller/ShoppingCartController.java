package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Items;
import com.model.Users;
import com.service.LoginService;
import com.service.ShoppingService;
import com.model.Items;

@Controller
@RequestMapping("login")
public class ShoppingCartController {
	@Autowired
	private ShoppingService shoppingService;
	
	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	
	@RequestMapping(value="loadWelcome", method=RequestMethod.POST)
	public ModelAndView loadWelcomeForm(Users user,ModelAndView mandv) {
		System.out.println(user);
		mandv.addObject("user",user);
		mandv.setViewName("welcome");
		return mandv;
	}
	

@RequestMapping(value="loadJewellery", method=RequestMethod.POST)
public ModelAndView loadJewellery(HttpServletRequest request,ModelAndView mandv) {
	List<Items> items=new ArrayList<Items>();
	items=shoppingService.loadAllItems("jewellery");
	mandv.addObject("jewellery",items);
	mandv.setViewName("shop1");
	return mandv;
}

@RequestMapping(value="loadGrocery", method=RequestMethod.POST)
public ModelAndView loadGrocery(HttpServletRequest request,ModelAndView mandv) {
	List<Items> items=new ArrayList<Items>();
	items=shoppingService.loadAllItems("grocery");
	String[] selectedItems = request.getParameterValues("selected");
	for(int i=0;i<selectedItems.length;i++) {
		String qty=request.getParameter(selectedItems[i]);
		hm.put(Integer.parseInt(selectedItems[i]),Integer.parseInt(qty));
	}
	mandv.addObject("grocery",items);
	mandv.setViewName("shop2");
	return mandv;
}

@RequestMapping(value="loadFruits", method=RequestMethod.POST)
public ModelAndView loadFruits(HttpServletRequest request,ModelAndView mandv) {
	List<Items> items=new ArrayList<Items>();
	items=shoppingService.loadAllItems("fruits");
	String[] selectedItems = request.getParameterValues("selected");
	for(int i=0;i<selectedItems.length;i++) {
		String qty=request.getParameter(selectedItems[i]);
		hm.put(Integer.parseInt(selectedItems[i]),Integer.parseInt(qty));
	}
//	shoppingService.createInvoice(hm);
	mandv.addObject("fruits",items);
	mandv.setViewName("shop3");
	return mandv;
}

@RequestMapping(value="loadInvoice", method=RequestMethod.POST)
public ModelAndView loadInvoice(HttpServletRequest request,ModelAndView mandv) {
	List<Items> items=new ArrayList<Items>();
	String[] selectedItems = request.getParameterValues("selected");
	for(int i=0;i<selectedItems.length;i++) {
		String qty=request.getParameter(selectedItems[i]);
		hm.put(Integer.parseInt(selectedItems[i]),Integer.parseInt(qty));
	}
	System.out.println(hm);
	shoppingService.createInvoice(hm);
	mandv.addObject("fruits",items);
	mandv.setViewName("shop3");
	return mandv;
}



}
