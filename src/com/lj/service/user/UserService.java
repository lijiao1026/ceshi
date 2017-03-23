package com.lj.service.user;

import com.lj.pojo.user.User;

/**
 * 用户Service 
 * @author lij
 *
 *
 */
public interface UserService {
	/**
	 * 
	 * @param 注册或者增加用户
	 */
	 void saveUser(User user);
/**
 * 
 * @param userName
 * @return
 */
	User findByUsername(String userName);
	/**
	 * 登录方法
	 * @param user
	 * @return
	 */
     User login(User user);

}
