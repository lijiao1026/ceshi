package com.lj.dao.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lj.pojo.user.User;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
/**
 * 保存或者注册用户
 */
	@Override
	public void saveUser(User user) {
	
		this.getHibernateTemplate().save(user);
	}
/**
 * 查找用户名是否重复
 */
	@SuppressWarnings("unchecked")
	public User findByUsername(String user) {
	
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
/**
 * 根据用户编号查询用户
 */
	@SuppressWarnings("unchecked")
	@Override
	public User findByUid(Integer uid) {
		String hql="from User where uid= ?";
		List<User> list=this.getHibernateTemplate().find(hql, uid);
		if(list.size() > 0){
			return list.get(0);
		}else{
			
			return null;
		}
	}
	/**
	 * 根据用户类型查找出总个数
	 */
@SuppressWarnings("unchecked")
@Override
public int findCount(String string) {
	String hql="select count(*) from User where userType=?";
	List<Long> list = this.getHibernateTemplate().find(hql,string);
	if (list.size() > 0) {
		return list.get(0).intValue();
	}
	return 0;
}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByPage(int begin, int pageSize, String string) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class).add(Restrictions.like("userType",string ));
		List<User> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	@Override
	public void saveUpdateUser(User oldUser) {
		this.getHibernateTemplate().update(oldUser);
	}

}
