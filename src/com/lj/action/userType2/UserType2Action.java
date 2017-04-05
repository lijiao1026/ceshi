package com.lj.action.userType2;

import java.util.List;

import com.lj.pojo.department.Department;
import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.user.User;
import com.lj.service.department.DepartmentService;
import com.lj.service.user.UserService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 医生用户Action类
 * @author lij
 *
 *
 */
public class UserType2Action extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService;	
	
    public void setUserService(UserService userService) {
		this.userService = userService;
	}
    private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	} 
    
    
    
    /**
     * 当前页数
     */
    private Integer currPage = 1;
    /**
     * 用户集合
     */
	private List<User> userList;
	/**
	 * 总页数
	 */
    private Integer totalPage;
    /**
     * 用户姓名查询
     */
    private String searchUserName;
    /**
     * 科室集合
     */
	private List<Department> departmentList;
  
	public String getSearchUserName() {
		return searchUserName;
	}

	public void setSearchUserName(String searchUserName) {
		this.searchUserName = searchUserName;
	}

	private User user;
	private String message;
	private Integer uid;








	/**
	 * 查询
	 * @return
	 */
	public String queryList(){
  		try {
  			//因为用户类型为1的是用户 所以这里传入1
  			if(searchUserName==null||searchUserName.equals("")){
  				PageBean<User> pageBean = userService.findByPage(currPage,"2"); 
  				userList= pageBean.getList();
  	  			while(userList.size()<10&&userList.size()!=0){
  	  				User user=new User();
  	  				user=null;
  	  				userList.add(user);
  	  			}
  	  			totalPage=pageBean.getTotalPage();
  			}else{
  			
  	  		PageBean<User> pageBean =userService.findByUsername(currPage,"2",searchUserName);	
				userList= pageBean.getList();
	  			while(userList.size()<10&&userList.size()!=0){
	  				User user=new User();
	  				user=null;
	  				userList.add(user);
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
  		departmentList=departmentService.findAll();
  		return "toAdd";
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
  		
  	}
  	
	public String addSave(){
		if(user!=null){
			try {
				userService.saveUser(user);
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
			user = userService.findByUid(uid);
			return "detail";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String toEdit(){
		try {
			departmentList=departmentService.findAll();
			user = userService.findByUid(uid);
			return "edit";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 删除用户
	 * @return
	 */
  	public String delate(){
  		try {
  			user = userService.findByUid(uid);
  			userService.delate(user);
  			message="1";
  			return "delate";
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
  	}
  	
  	public String editSave(){
  		if(user!=null){
			try {
				userService.saveUpdateUser(user);
				message="1";
			} catch (Exception e) {
				 e.printStackTrace();
			
			}
		}
		return "editSuccess";
  	}
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
  		this.currPage = currPage;
  	}
  	

	public Integer getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}








	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
}
