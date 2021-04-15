package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Customer;
import com.model.Users;
import com.service.CustomerService;
import com.service.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="loadIndex", method=RequestMethod.GET)
	public ModelAndView loadIndexForm(ModelAndView mandv) {
//		mandv.addObject("user",user);
		mandv.setViewName("index");
		return mandv;
	}
	
	@RequestMapping(value="loadForm", method=RequestMethod.GET)
	public ModelAndView loadLoginForm(ModelAndView mandv) {
		Users user=new Users();
		mandv.addObject("user",user);
		mandv.setViewName("login");
		return mandv;
	}
	
	@RequestMapping(value="loadRegister", method=RequestMethod.GET)
	public ModelAndView loadRegisterForm(ModelAndView mandv) {
		Customer customer=new Customer();
		mandv.addObject("customerdetails",customer);
		mandv.setViewName("register");
		return mandv;
	}
	
	@RequestMapping(value="submitForm", method=RequestMethod.POST)
	public ModelAndView submitLoginForm(Users user,ModelAndView mandv) {
		loginService.createUser(user);
		mandv.addObject("user",user);
		mandv.setViewName("login");
		return mandv;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public void register(Customer customerdetails,ModelAndView mandv) {
		customerService.registerUser(customerdetails);
	}
	
	@RequestMapping(value="getUsersByUname/{uname}", method=RequestMethod.GET)
	public void loadUserByUName(@PathVariable("uname") String uname) {
		Users user=loginService.getUserByUName(uname);
		System.out.println(user);
	}
	
	@RequestMapping(value="validateForm", method=RequestMethod.POST)
	public ModelAndView validateLoginForm(Users user,ModelAndView mandv) {
		if(loginService.checkUser(user.getUname(), user.getUpass())) {
		mandv.addObject("user",user);
		mandv.setViewName("welcome");
		}
		else {
		mandv.addObject("user",user);
		mandv.setViewName("login");
		}
		return mandv;
	}
	
	public LoginService getUserService() {
		return loginService;
	}

	public void setUserService(LoginService userService) {
		this.loginService = userService;
	}
}
