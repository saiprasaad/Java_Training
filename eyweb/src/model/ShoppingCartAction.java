package model;

import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;
import service.ShoppingService;
import service.ShoppingServiceImpl;

public class ShoppingCartAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String shopid=request.getParameter("shopid");
	
//	HttpSession session=request.getSession();
//	Enumeration<String> e=request.getParameterNames();
//	while(e.hasMoreElements()) {
//		String name=e.nextElement();
//		String value=request.getParameter(name);
//		session.setAttribute(name, value);
//	}
//	
	return shopid;
}
}
