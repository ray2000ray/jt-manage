package com.jt.manage.controller.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.po.User;



@Controller
public class JSONPController {

	//1.使用传统ajax形式回传数据,手动拼接写入response
//	@RequestMapping("/web/testJSONP")
	public void testJSONP(String callback, HttpServletResponse response) throws IOException {
		String json = "{\"id\":\"1000\", \"name\":\"tomcat\"";
		
		String result = callback +"("+json+")";
		
		response.setContentType("text/html,charset=utf-8");
		response.getWriter().write(result);
	}
	
	//2.使用工具API形式回传数据
	@RequestMapping("/web/testJSONP")
	@ResponseBody
	public MappingJacksonValue testJP(String callback) {
		User user = new User();
		user.setId(2000L);
		user.setUsername("jack");
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(user);
		jacksonValue.setJsonpFunction(callback);
		
		return jacksonValue;
	}
}
