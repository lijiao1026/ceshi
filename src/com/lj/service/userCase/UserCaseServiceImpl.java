package com.lj.service.userCase;

import java.util.List;

import com.lj.dao.userCase.UserCaseDao;
import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.userCase.UserCase;

public class UserCaseServiceImpl implements UserCaseService{
	private UserCaseDao userCaseDao;

	public void setUserCaseDao(UserCaseDao userCaseDao) {
		this.userCaseDao = userCaseDao;
	}

	@Override
	public void saveUserCase(UserCase userCase) {
		try {
			userCaseDao.saveUserCase(userCase);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public PageBean<UserCase> findByPage(Integer currPage) {
		PageBean<UserCase> pageBean=new PageBean<UserCase>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = userCaseDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<UserCase> list = userCaseDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<UserCase> findBySearch(Integer currPage, String userCaseSearch) {
		PageBean<UserCase> pageBean=new PageBean<UserCase>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = userCaseDao.findCountByName(userCaseSearch);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<UserCase> list = userCaseDao.findByPageBySearch(begin,pageSize,userCaseSearch);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public UserCase findById(Integer serial) {
		try {
			UserCase userCase=userCaseDao.findById(serial);
			return userCase;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;
	}

	
	
}
