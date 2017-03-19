package com.lj.dao.user;

import com.lj.pojo.user.User;
/**
 * 用户Dao
 * @author lij
 *
 *
 */
public interface UserDao {
	/**
	 * 用户增加或者注册
	 * @param user
	 */
	void saveUser(User user);

	User findByUsername(String user);

}
