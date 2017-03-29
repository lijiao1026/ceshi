package com.lj.action.userType1;


import java.util.List;

import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.user.User;
import com.lj.service.user.UserService;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 患者管理Action
 * @author lij
 *
 *
 */
public class UserType1Action extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService;	
	
    public void setUserService(UserService userService) {
		this.userService = userService;
	}
    
    private Integer currPage = 1;
	private List<User> userList;
    
  	public void setCurrPage(Integer currPage) {
  		this.currPage = currPage;
  	}
  	
  
	public String queryList(){
  		try {
  			PageBean<User> pageBean = userService.findByPage(currPage,"1"); 
  			userList= pageBean.getList();
  			while(userList.size()<10){
  				User user=new User();
  				user=null;
  				userList.add(user);
  			}
  		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "list";
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
	

}
