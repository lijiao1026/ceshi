package com.lj.dao.department;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lj.pojo.department.Department;
import com.lj.pojo.sysNotice.SysNotice;
/**
 * 科室的Dao类
 * @author lij
 *
 *
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		String hql="select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findCountByDepartmentName(String searchDepartmentName) {
		String hql="select count(*) from Department where departmentName=?";
		List<Long> list = this.getHibernateTemplate().find(hql,"%"+searchDepartmentName+"%");
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findByPageBySysNoticeByDepartmentName(int begin, int pageSize,
			String searchDepartmentName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class).add(Restrictions.like("departmentName", "%"+searchDepartmentName+"%"));
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void saveDepartment(Department department) {
		this.getHibernateTemplate().save(department);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Department findById(Integer serial) {
		String hql="from Department where serial= ?";
		List<Department> list=this.getHibernateTemplate().find(hql, serial);
		if(list.size() > 0){
			return list.get(0);
		}else{
			
			return null;
		}
	}

	@Override
	public void saveUpdate(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("from Department");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAllByName(String q2) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class).add(Restrictions.like("departmentName", "%"+q2+"%"));
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

}
