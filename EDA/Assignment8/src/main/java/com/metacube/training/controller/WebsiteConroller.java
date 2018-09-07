package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebsiteConroller {
	
	@RequestMapping("/")
    public String home()
    {
        return "home";
    }

}
