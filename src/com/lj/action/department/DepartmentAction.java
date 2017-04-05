package com.lj.action.department;

import java.util.List;

import com.lj.pojo.department.Department;
import com.lj.pojo.pageBean.PageBean;

import com.lj.service.department.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 科室Action类
 * @author lij
 *
 *
 */
public class DepartmentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	/**
	 * 科室对象
	 */
	private Department department;
	 /**
     * 当前页数
     */
    private Integer currPage = 1;
    /**
     * 科室集合
     */
	private List<Department> departmentList;
	/**
	 * 总页数
	 */
    private Integer totalPage;
    /**
     * 科室名字查询
     */
    private String searchDepartmentName;
    /**
     * 提示消息
     */
	private String message;
	/**
	 * 科室序号
	 */
	private Integer serial;
	

	/**
	 * 查询
	 * @return
	 */
	public String queryList(){
  		try {
  			//因为用户类型为1的是用户 所以这里传入1
  			if(searchDepartmentName==null||searchDepartmentName.equals("")){
  				PageBean<Department> pageBean = departmentService.findByPage(currPage); 
  				departmentList= pageBean.getList();
  	  			while(departmentList.size()<10&&departmentList.size()!=0){
  	  				Department department=new Department();
  	  				department=null;
  	  				departmentList.add(department);
  	  			}
  	  			totalPage=pageBean.getTotalPage();
  			}else{
  			
  	  		PageBean<Department> pageBean =departmentService.findBydepartment(currPage,searchDepartmentName);	
				departmentList= pageBean.getList();
	  			while(departmentList.size()<10&&departmentList.size()!=0){
	  				Department department=new Department();
	  				department=null;
	  				departmentList.add(department);
	  			}
	  			totalPage=pageBean.getTotalCount();
  			}
  		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "list";
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
  	public String toAdd(){
  		try {
  			return "toAdd";
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
  		
  	}
  	
  	/**
	 * 保存
	 * @return
	 */
	public String addSave(){
		if(department!=null){
			try {
				departmentService.saveDepartment(department);
				
				message="1";
			} catch (Exception e) {
				 e.printStackTrace();
			
			}
		}
		return "addSuccess";
	}
	/**
	 * 查看
	 * @return
	 */
	public String toDetail(){
		try {
			department = departmentService.findById(serial);
			return "detail";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String toEdit(){
		try {
			department = departmentService.findById(serial);
			return "edit";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/**
  	 * 保存更新
  	 * @return
  	 */
  	public String editSave(){
  		if(department!=null){
			try {
			
				departmentService.saveUpdate(department);
				message="1";
			} catch (Exception e) {
				 e.printStackTrace();
			
			}
		}
		return "editSuccess";
  	}
	/**
	 * 删除公告
	 * @return
	 */
  	public String delete(){
  		try {
  			department = departmentService.findById(serial);
  			departmentService.delete(department);
  			message="1";
  			return "delete";
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
  	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public String getSearchDepartmentName() {
		return searchDepartmentName;
	}
	public void setSearchDepartmentName(String searchDepartmentName) {
		this.searchDepartmentName = searchDepartmentName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}

}
