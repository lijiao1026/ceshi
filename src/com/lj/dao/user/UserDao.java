package com.lj.dao.user;

import java.util.List;

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
	/**
	 * 根据用户编号查询用户
	 * @param uid
	 * @return
	 */
	User findByUid(Integer uid);
	/**
	 * 根据类型查找出用户总个数
	 * @param string
	 * @return
	 */
	int findCount(String string);
	/**
	 * 根据类型分页查找用户
	 * @param begin
	 * @param pageSize
	 * @param string
	 * @return
	 */
	List<User> findByPage(int begin, int pageSize, String string);
	/**
	 * 更新用户
	 * @param oldUser
	 */
	void saveUpdateUser(User oldUser);
	/**
	 * 分页按照姓名查询用户
	 * @param begin
	 * @param pageSize
	 * @param string
	 * @param searchUserName
	 * @return
	 */
	List<User> findByPageByName(int begin, int pageSize, String string, String searchUserName);
	/**
	 * 按照姓名查询总记录数
	 * @param string
	 * @param searchUserName
	 * @return
	 */
	int findCountByName(String string, String searchUserName);

}
