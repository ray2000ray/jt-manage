package com.jt.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.manage.mapper.UserMapper;
import com.jt.manage.pojo.User;
import com.jt.manage.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Transactional(readOnly=true) //查询必须加上
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}
	/**
	 * 1.通过type类型确定用户校验的字段
	 */
	@Override
	public Boolean findCheckUser(String param, Integer type) {
		String column=null;
		
		switch(type) {
		case 1:
			column = "username"; break;
		
		case 2:
			column = "phone"; break;
			
		case 3:
			column = "email"; break;
		}
		
		int count = userMapper.findCheckUser(param, column);

		//
		return count==0?false:true;
	}

}
