package com.lj.dao.userCase;

import java.util.List;

import com.lj.pojo.userCase.UserCase;

public interface UserCaseDao {
	/**
	 * 保存病例记录
	 * @param userCase
	 */
	void saveUserCase(UserCase userCase);
	/**
	 * 无条件查询
	 * @return
	 */
	int findCount();
	/**
	 * 分页查询
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	List<UserCase> findByPage(int begin, int pageSize);
	/**
	 * 按照条件查询总数
	 * @param userCaseSearch
	 * @return
	 */
	int findCountByName(String userCaseSearch);
	/**
	 * 按照条件分页查询
	 * @param begin
	 * @param pageSize
	 * @param userCaseSearch
	 * @return
	 */
	List<UserCase> findByPageBySearch(int begin, int pageSize, String userCaseSearch);
	/**
	 * 根据序号查询
	 * @param serial
	 * @return
	 */
	UserCase findById(Integer serial);

}
