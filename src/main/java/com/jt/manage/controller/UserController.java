package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.manage.pojo.User;
import com.jt.manage.service.UserService;
@Controller
public class UserController {
    @Autowired  
	private UserService userService;
    
    //返回userList页面
    @RequestMapping("/findAll")
    public String findAll(Model model) {
		
    	List<User> userList = userService.findAll(); 
    	
    	//将数据保存到域中, 四大域对象{page/request/session/context}
//    	ModelAndView andView = new ModelAndView();
//    	andView.addObject("userList",userList)
//    	andView
    	//默认存储对象为request
    	model.addAttribute("userList", userList);
    	
    	return "userList";
	}
    
    
    
	
}
