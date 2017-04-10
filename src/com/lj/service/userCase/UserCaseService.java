package com.lj.service.userCase;

import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.userCase.UserCase;

public interface UserCaseService {
	/**
	 * 保存病例记录
	 * @param userCase
	 */
	void saveUserCase(UserCase userCase);
	/**
	 * 分页查询记录数
	 * @param currPage
	 * @return
	 */
	PageBean<UserCase> findByPage(Integer currPage);
	/**
	 * 按照条件分页查询
	 * @param currPage
	 * @param userCaseSearch
	 * @return
	 */
	PageBean<UserCase> findBySearch(Integer currPage, String userCaseSearch);

}
