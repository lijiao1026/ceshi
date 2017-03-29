package com.lj.service.user;

import com.lj.pojo.pageBean.PageBean;
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
     /**
      * 根据用户编号查询
      * @param uid
      * @return
      */
	User findByUid(Integer uid);
	/**
	 * 按类型查找所有符合的用户
	 * @param currPage
	 * @param string 0为超级管理员1为患者2为医生
	 * @return
	 */
	PageBean<User> findByPage(Integer currPage, String string);
	/**
	 * 更新用户
	 * @param oldUser
	 */
	void updateUser(User oldUser);

}
