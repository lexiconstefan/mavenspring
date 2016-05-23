package com.websystique.springmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websystique.springmvc.bo.UserBo;
import com.websystique.springmvc.model.User;

@Controller
@RequestMapping("/")
public class HelloWorldController {
	UserBo userBO;
	public HelloWorldController() {
		// TODO Auto-generated constructor stub
		if(userBO == null){
			userBO= new UserBo();
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}


	@ResponseBody
	@RequestMapping(value="/getuser", method = RequestMethod.GET)
	public List<User> sayHelloAgain() {
		return userBO.getUsers();
	}
	
	@ResponseBody
	@RequestMapping(value="/insertuser", method = RequestMethod.POST)
	public User insertUser(@RequestBody User user) {
		System.out.println(user.toString());
		
		
		return userBO.insertUser(user);
	}

}
