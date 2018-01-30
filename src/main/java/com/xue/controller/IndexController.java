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
	
	@Value(value="${xue.secret}")
	private String secret;
	@Value(value="${xue.number}")
	private Integer number;
	@Value(value="${xue.bignumber}")
	private String bignumber;
	@Value(value="${xue.number.less.than.ten}")
	private Integer less;
	@Value(value="${xue.number.in.range}")
	private String range;
	@Value(value="${xue.helloworld}")
	private String hello;
	@Value(value="${xue.user}")
	private String user;
	@RequestMapping
	public String index() {
		return "hello world";
	}

	@RequestMapping(value="/get")
	public Map<String,Object> getMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "hello");
		map.put("secret",secret);
		map.put("number", number);
		map.put("bignumber", bignumber);
		map.put("less", less);
		map.put("range", range);
		map.put("hello", hello);
		map.put("user", user);
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
