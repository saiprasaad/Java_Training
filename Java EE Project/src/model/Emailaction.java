package model;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ShoppingService;
import service.ShoppingServiceImpl;

/**
 * Servlet implementation class Emailaction
 */
public class Emailaction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Properties prop=(Properties)request.getServletContext().getAttribute("properties");
		HttpSession session=request.getSession();
		ShoppingService shoppingService=ShoppingServiceImpl.getShoppingServiceImpl(prop);
		shoppingService.sendMail((String)session.getAttribute("uname"),(int)session.getAttribute("invno"),(int)session.getAttribute("custno"));
		return "shop3";
	}
	
}
