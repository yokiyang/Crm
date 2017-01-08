package com.tz.test;


import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.tz.entity.User;
import com.tz.user.dao.IUserDao;
import com.tz.user.service.IUserService;
import com.tz.util.BeanFactory;

public class TestUserDaoImpl {
	IUserDao userDao=(IUserDao) BeanFactory.getBean("userDao");
	IUserService userService=(IUserService) BeanFactory.getBean("userService");
	@Test
	public void testDDL(){
		Configuration cfg=new Configuration().configure();
		SchemaExport export=new SchemaExport(cfg);
		export.create(true,true);
	}
	
	@Test
	public void testSelectUser(){
		User user=userDao.selectUser("jack", "123456");
		System.out.println(user);
	}
	
	@Test
	public void testLogin(){
		User user=userService.login("jack", "123456");
		System.out.println(user);
	}
	
}
