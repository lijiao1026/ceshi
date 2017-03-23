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
	/**
	 * 用户名验证
	 * @param user
	 * @return
	 */
	User findByUsername(String user);
	/**
	 * 通过用户名和密码实现登录
	 * @param user
	 * @return
	 */
	User findByUsernameAndPassword(User user);

}
