package com.lj.dao.medicine;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.medicine.Medicine;
/**
 * 药品Dao类
 * @author lij
 *
 *
 */
public class MedicineDaoImpl extends HibernateDaoSupport implements MedicineDao {

	@Override
	public void saveMedicine(Medicine medicine) {
		this.getHibernateTemplate().save(medicine);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		String hql="select count(*) from Medicine";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Medicine.class);
		List<Medicine> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findCountByName(String searchMedicineName) {
		String hql="select count(*) from Medicine  where medicineName=?";
		List<Long> list = this.getHibernateTemplate().find(hql,"%"+searchMedicineName+"%");
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> findByPageByName(int begin, int pageSize, String searchMedicineName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Medicine.class).add(Restrictions.like("medicineName", "%"+searchMedicineName+"%"));
		List<Medicine> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Medicine findById(Integer serial) {
		String hql="from Medicine where serial= ?";
		List<Medicine> list=this.getHibernateTemplate().find(hql, serial);
		if(list.size() > 0){
			return list.get(0);
		}else{
			
			return null;
		}
	}

	@Override
	public void updateMedicine(Medicine medicine) {
		this.getHibernateTemplate().update(medicine);
	}

}
