package com.lj.service.department;

import java.util.List;

import com.lj.dao.department.DepartmentDao;
import com.lj.dao.user.UserDao;
import com.lj.pojo.department.Department;
import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.sysNotice.SysNotice;

/**
 * 科室service类
 * @author lij
 *
 *
 */
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean=new PageBean<Department>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Department> findBydepartment(Integer currPage, String searchDepartmentName) {
		PageBean<Department> pageBean=new PageBean<Department>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCountByDepartmentName(searchDepartmentName);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPageBySysNoticeByDepartmentName(begin,pageSize,searchDepartmentName);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void saveDepartment(Department department) {
		try {
			departmentDao.saveDepartment(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Department findById(Integer serial) {
		try {
			Department department=departmentDao.findById(serial);
			return department;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;
	}

	@Override
	public void saveUpdate(Department department) {
		try {
			departmentDao.saveUpdate(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Department department) {
		try {
			departmentDao.delete(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	
}
