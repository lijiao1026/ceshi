package com.lj.service.department;

import java.util.List;

import com.lj.pojo.department.Department;
import com.lj.pojo.pageBean.PageBean;

/**
 * 科室Service类
 * @author lij
 *
 *
 */
public interface DepartmentService {
	/**
	 * 分页查询
	 * @param currPage
	 * @return
	 */
	PageBean<Department> findByPage(Integer currPage);
	/**
	 * 根据科室名字分页查询
	 * @param currPage
	 * @param searchDepartmentName
	 * @return
	 */
	PageBean<Department> findBydepartment(Integer currPage, String searchDepartmentName);
	/**
	 * 新增保存
	 * @param department
	 */
	void saveDepartment(Department department);
	/**
	 * 根据序号查询
	 * @param serial
	 * @return
	 */
	Department findById(Integer serial);
	/**
	 * 保存修改
	 * @param department
	 */
	void saveUpdate(Department department);
	/**
	 * 删除科室
	 * @param department
	 */
	void delete(Department department);
	/**
	 * 查询出所有的科室集合
	 * @return
	 */
	List<Department> findAll();
	

}
