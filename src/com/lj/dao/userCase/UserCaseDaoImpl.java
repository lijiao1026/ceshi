package com.lj.dao.userCase;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.userCase.UserCase;

public class UserCaseDaoImpl  extends HibernateDaoSupport implements UserCaseDao {

	@Override
	public void saveUserCase(UserCase userCase) {
		this.getHibernateTemplate().save(userCase);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		String hql="select count(*) from UserCase";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserCase> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserCase.class);
		List<UserCase> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public int findCountByName(String userCaseSearch) {
		String hql="select count(*) from UserCase  where appointmentId.userId.name=?";
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql,"%"+userCaseSearch+"%");
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserCase> findByPageBySearch(int begin, int pageSize, String userCaseSearch) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserCase.class).createAlias("appointmentId", "appointmentId").createAlias("appointmentId.userId", "appointmentuserId").add(Restrictions.like("appointmentuserId.name", "%"+userCaseSearch+"%"));
		List<UserCase> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserCase findById(Integer serial) {
		String hql="from UserCase where serial= ?";
		List<UserCase> list=this.getHibernateTemplate().find(hql, serial);
		if(list.size() > 0){
			return list.get(0);
		}else{
			
			return null;
		}
	}

}
