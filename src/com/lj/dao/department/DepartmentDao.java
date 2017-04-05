package com.lj.dao.department;

import java.util.List;

import com.lj.pojo.department.Department;

/**
 * 科室Dao类
 * @author lij
 *
 *
 */
public interface DepartmentDao {
	/**
	 * 查询总数
	 * @return
	 */
	int findCount();
	/**
	 * 分页查询
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	List<Department> findByPage(int begin, int pageSize);
	/**
	 * 查询分页的总数
	 * @param searchDepartmentName
	 * @return
	 */
	int findCountByDepartmentName(String searchDepartmentName);
	/**
	 * 查询科室名字的分页
	 * @param begin
	 * @param pageSize
	 * @param searchDepartmentName
	 * @return
	 */
	List<Department> findByPageBySysNoticeByDepartmentName(int begin, int pageSize, String searchDepartmentName);
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
	 * 查询出所有的科室
	 * @return
	 */
	List<Department> findAll();

}
