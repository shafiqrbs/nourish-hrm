package com.erp.hrm.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/home")
public class HomeApi {
	
	@GetMapping(value= "/login")		
	public String getLoginForm(Model model) {
		
		return "login";
	}

}
