package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController
{
	@RequestMapping(value="/")
	public String navigatePage()
	{
		return "index";
	}
	@RequestMapping(value="/home")
	public String homePage()
	{
		return "home";
	}
	@RequestMapping(value="/aboutus")
	public String aboutusPage()
	{
		return "aboutus";
	}
	@RequestMapping(value="/contactus")
	public String contactPage()
	{
		return "contactus";
	}

	
}
