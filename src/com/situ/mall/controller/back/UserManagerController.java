package com.situ.mall.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/user")
public class UserManagerController {
	
	@RequestMapping(value="/getLoginPage")
	public String getLoginPage() {
		return "login";
	}
}
