package com.lj.dao.appointment;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.department.Department;

/**
 * 预约Dao类
 * @author lij
 *
 *
 */
public class AppointmentDaoImpl extends HibernateDaoSupport implements AppointmentDao {

	@Override
	public void saveAppointment(Appointment appointment) {
		this.getHibernateTemplate().save(appointment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		String hql="select count(*) from Appointment";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Appointment.class).addOrder(Order.desc("appointmentTime"));
		List<Appointment> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findCountByName(String searchName) {
		String hql="select count(*) from Appointment  where userId.name=?";
		List<Long> list = this.getHibernateTemplate().find(hql,"%"+searchName+"%");
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> findByPageByName(int begin, int pageSize, String searchName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Appointment.class).createAlias("userId", "userId").add(Restrictions.like("userId.name", "%"+searchName+"%")).addOrder(Order.desc("appointmentTime"));
		List<Appointment> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Appointment findById(Integer serial) {
		String hql="from Appointment where serial= ?";
		List<Appointment> list=this.getHibernateTemplate().find(hql, serial);
		if(list.size() > 0){
			return list.get(0);
		}else{
			
			return null;
		}
	}

	@Override
	public void delete(Appointment appointment) {
		this.getHibernateTemplate().delete(appointment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findCountByAppointmentSerial(String q,String string) {
		String hql="select count(*) from Appointment  where appointmentSerial=? and appointmentStatus=?";
		List<Long> list = this.getHibernateTemplate().find(hql,"%"+q+"%",string);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> findByPageByAppointmentSerial(int begin, int pageSize, String q,String string) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Appointment.class).add(Restrictions.like("appointmentStatus", string)).add(Restrictions.like("appointmentSerial", "%"+q+"%")).addOrder(Order.desc("appointmentTime"));
		List<Appointment> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void updateAppointment(Appointment appointment) {
		this.getHibernateTemplate().update(appointment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findCountByStatus(String string) {
		String hql="select count(*) from Appointment  where  appointmentStatus=?";
		List<Long> list = this.getHibernateTemplate().find(hql,string);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> findByPageByStatus(int begin, int pageSize, String string) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Appointment.class).add(Restrictions.like("appointmentStatus", string)).addOrder(Order.desc("appointmentTime"));
		List<Appointment> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

}
