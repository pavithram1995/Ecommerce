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

}
