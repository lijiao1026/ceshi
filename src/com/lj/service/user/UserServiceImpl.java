package com.lj.service.user;

import com.lj.dao.user.UserDao;
import com.lj.pojo.user.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void saveUser(User user) {
	try {
		userDao.saveUser(user);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}

	@Override
	public User findByUsername(String user) {
		try {
			User userExist=userDao.findByUsername(user);
			return userExist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
