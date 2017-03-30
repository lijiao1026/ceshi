package com.lj.action.userType1;


import java.util.ArrayList;
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
  
  
	public String getSearchUserName() {
		return searchUserName;
	}








	public void setSearchUserName(String searchUserName) {
		this.searchUserName = searchUserName;
	}








	public String queryList(){
  		try {
  			//因为用户类型为1的是用户 所以这里传入1
  			if(searchUserName==null||searchUserName==""){
  				PageBean<User> pageBean = userService.findByPage(currPage,"1"); 
  				userList= pageBean.getList();
  	  			while(userList.size()<10&&userList.size()!=0){
  	  				User user=new User();
  	  				user=null;
  	  				userList.add(user);
  	  			}
  	  			totalPage=pageBean.getTotalCount();
  			}else{
  			
  	  		PageBean<User> pageBean =userService.findByUsername(currPage,"1",searchUserName);	
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


	

}
