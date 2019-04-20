package com.bobo.springcloud.feign.feigneurekamanyparamsproducer.controller;

import com.bobo.springcloud.feign.feigneurekamanyparamsproducer.model.User;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
public class UserController {

	private Logger logger =LoggerFactory.getLogger(UserController.class);


	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(User user , HttpServletRequest request){
		logger.info("user:{}",user.toString());
		return "hello,"+user.getName();

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser( @RequestBody User user){
		return "hello,"+user.getName();
	}
}
