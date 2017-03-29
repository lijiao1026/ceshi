package com.lj.service.user;

import java.util.List;

import com.lj.dao.user.UserDao;
import com.lj.pojo.pageBean.PageBean;
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

	@Override
	public User login(User user) {
		User existUser=userDao.findByUsernameAndPassword(user);
		return existUser;
	}

	@Override
	public User findByUid(Integer uid) {
	try {
		User user=userDao.findByUid(uid);
		return user;
	} catch (Exception e) {
		e.printStackTrace();
	}
		return null;
	}

	@Override
	public PageBean<User> findByPage(Integer currPage, String string) {
		PageBean<User> pageBean=new PageBean<User>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = userDao.findCount(string);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<User> list = userDao.findByPage(begin,pageSize,string);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 更新用户
	 */
	@Override
	public void updateUser(User oldUser) {
		userDao.saveUpdateUser(oldUser);
	}

}
