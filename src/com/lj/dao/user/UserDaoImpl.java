package com.lj.dao.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lj.pojo.user.User;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
/**
 * 保存或者注册用户
 */
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}
/**
 * 查找用户名是否重复
 */
	@SuppressWarnings("unchecked")
	public User findByUsername(String user) {
		// TODO Auto-generated method stub
		String hql="from User where username= ?";
		List<User> list=this.getHibernateTemplate().find(hql, user);
		if(list.size() > 0){
			return list.get(0);
		}else{
			
			return null;
		}
	}
	/**
	 * 登录
	 */
@SuppressWarnings("unchecked")
@Override
public User findByUsernameAndPassword(User user) {
	String hql="from User where username= ? and password= ?";
	List<User> list =this.getHibernateTemplate().find(hql,user.getUserName(),user.getPassword());
	if(list.size() > 0){
		return list.get(0);
	}else{
		
		return null;
	}
}

}
