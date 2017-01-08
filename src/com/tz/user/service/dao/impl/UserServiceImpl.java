package com.tz.user.service.dao.impl;


import com.tz.entity.User;
import com.tz.user.dao.IUserDao;
import com.tz.user.service.IUserService;
import com.tz.util.BeanFactory;

public class UserServiceImpl implements IUserService {

	IUserDao userDao = (IUserDao) BeanFactory.getBean("userDao");

	@Override
	public User login(String username, String password) {
		User user=userDao.selectUser(username, password);
		if(user!=null){
			return userDao.selectUser(username, password);
		}else{
			return null;
		}
	}
}
