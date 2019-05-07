package com.ecomm.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.User;

@Controller

public class UserController 
{

	@RequestMapping(value="/login",method=RequestMethod.GET)
	
	public String loginPage()
	{
		
		return "login";
	}
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/saveuser")
	public String saveUser(@RequestParam("username") String name, @RequestParam("passwd") String passwd, @RequestParam("mobno") String mob,
			@RequestParam("email") String mail,Model m)
	{
		User user=new User();
		user.setEmail(mail);
		user.setMobileNo(mob);
		user.setUsername(name);
		user.setPassword(passwd);
		
		userDAO.addUser(user);
		List<User> userlist=userDAO.getUser();
		m.addAttribute("usrlist", userlist);
		
		return "login";
	}

	@RequestMapping("/login_failure")
	public String invalid(HttpSession Session)
	{
		Session.setAttribute("ErrorMessage","Invalid Credentials");
		return "index";
	}
	

	
	@RequestMapping("/login_success")
	public String showMessage(@RequestParam(value="username")String name,@RequestParam(value="password")String password, 
			HttpSession session,Model model) 
	{
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String page="";
		
		String role="ROLE_USER";
		for (GrantedAuthority authority:authorities) 
		{
		 System.out.println(authority.getAuthority());
		
		 if (authority.getAuthority().equals(role)) 
	     {
	    	 session.setAttribute("username",username);
			 session.setAttribute("SuccessMessage","Login Successful");
	    	 page="DisplayProduct";	    	
	     }
	     else 
	     {
	  
	    page="DisplayProduct";
	    session.setAttribute("username", "Admin");
	    session.setAttribute("SuccessMessage","Login Successful");
	    	 break;
	    }
		}
		 return page;
		}
	@RequestMapping("/perform_login")
	public ModelAndView showMessage(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		System.out.println("in controller");

		String message;
		ModelAndView mv ;
		if (userDAO.isValidUser(username,password)) 
		{
			message = "Successfully Logged in";
			 mv = new ModelAndView("product");
		} else{
			message="Please enter a valid username and password";
			mv=new ModelAndView("Success");
		}
	
		mv.addObject("message", message);
		mv.addObject("username", username);
		return mv;
	}
	
	@RequestMapping("/perform_logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session)
	{
		ModelAndView mv=new ModelAndView("login");
		session.invalidate();
		session=request.getSession(true);
		mv.addObject("logoutMessage","you are successfully logged out");
		mv.addObject("loggedOut","true");
		return mv;
	}
		
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	
	public String registerPage()
	{
		return "RegForm";
	}
	
}
