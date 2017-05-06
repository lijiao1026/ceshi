package com.lj.action.userType0;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lj.constant.GeneralConstant;
import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.user.User;
import com.lj.service.user.UserService;
import com.lj.util.GeneralUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理员用户的action类
 * @author lij
 *
 *
 */
public class UserType0Action extends ActionSupport{

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

	private User user;
	private String message;
	private Integer uid;




	public void setSearchUserName(String searchUserName) {
		this.searchUserName = searchUserName;
	}







	/**
	 * 查询
	 * @return
	 */
	public String queryList(){
  		try {
  			//因为用户类型为1的是用户 所以这里传入1
  			if(searchUserName==null||searchUserName.equals("")){
  				PageBean<User> pageBean = userService.findByPage(currPage,"0"); 
  				userList= pageBean.getList();
  	  			while(userList.size()<10&&userList.size()!=0){
  	  				User user=new User();
  	  				user=null;
  	  				userList.add(user);
  	  			}
  	  			totalPage=pageBean.getTotalPage();
  			}else{
  			
  	  		PageBean<User> pageBean =userService.findByUsername(currPage,"0",searchUserName);	
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
  			return "toAdd";
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
  		
  	}
  	
	public String addSave(){
		if(user!=null){
			try {
				String birthDay=GeneralUtils.date2String(GeneralUtils.string2Date(user.getBirthDay(),GeneralConstant.DATETIME_10),
						GeneralConstant.DATETIME_8);
				user.setBirthDay(birthDay);
				String nowDay=getSysTime();
				Integer age=Integer.parseInt(nowDay.substring(0, 4))-Integer.parseInt(birthDay.substring(0, 4));
				user.setAge(age.toString());
				userService.saveUser(user);
				message="1";
			} catch (Exception e) {
				 e.printStackTrace();
			
			}
		}
		return "addSuccess";
	}
	/**
	 * 获取系统时间
	 * @return
	 */
    private String getSysTime()
    {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String SysTime = format.format(date);
        return SysTime;
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
  	/**
  	 * 保存更新
  	 * @return
  	 */
  	public String editSave(){
  		if(user!=null){
			try {
				String birthDay=GeneralUtils.date2String(GeneralUtils.string2Date(user.getBirthDay(),GeneralConstant.DATETIME_10),
						GeneralConstant.DATETIME_8);
				user.setBirthDay(birthDay);
				String nowDay=getSysTime();
				Integer age=Integer.parseInt(nowDay.substring(0, 4))-Integer.parseInt(birthDay.substring(0, 4));
				user.setAge(age.toString());
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
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}



}
