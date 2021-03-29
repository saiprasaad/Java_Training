package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;
import service.ShoppingService;
import service.ShoppingServiceImpl;

public class LoginAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String uname=request.getParameter("uname");
	String upass=request.getParameter("upass");
	Properties prop=(Properties)request.getServletContext().getAttribute("properties");
	HttpSession session=request.getSession();
	LoginService loginService=LoginServiceImpl.getLoginServiceImpl(prop);
	ShoppingService shoppingService=ShoppingServiceImpl.getShoppingServiceImpl(prop);
	if(loginService.checkUser(uname, upass)) {
		
		if(loginService.checkFlag(uname)) {
			int custno=loginService.getcustno(uname);
			session.setAttribute("uname", uname);
			session.setAttribute("custno", custno);
			loginService.updateFlag(uname, 1);
			
			return "login.success";
		}
		else {
			
			return "login.already";
		}
	}
	else {
		return "login.failure";
	}
}
}
