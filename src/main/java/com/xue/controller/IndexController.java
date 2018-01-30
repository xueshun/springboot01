package com.xue.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xue.bean.User;

@RequestMapping(value="/index")
@RestController
public class IndexController {
	
	@RequestMapping
	public String index() {
		return "hello world";
	}

	@RequestMapping(value="/get")
	public Map<String,Object> getMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "hello");
		return map;
	}
	
	// @PathVariable 获得请求url中的动态参数
	@RequestMapping(value = "/get/{id}/{name}")
	public User getBean(@PathVariable Integer id, @PathVariable String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
}
