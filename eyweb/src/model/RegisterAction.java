package model;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;

/**
 * Servlet implementation class RegisterAction
 */
public class RegisterAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("hello");
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		Properties prop=(Properties)request.getServletContext().getAttribute("properties");
		HttpSession session=request.getSession();
		
		LoginService loginService=LoginServiceImpl.getLoginServiceImpl(prop);
		UserDTO userDTO=new UserDTO();
		userDTO.setUname(uname);
		userDTO.setUpass(upass);

			if(loginService.registerUser(userDTO)>0) {

				return "register.success";
			}
		else {
			return "register";
		}
	}
}
