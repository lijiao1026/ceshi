package com.lj.action;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lj.constant.GeneralConstant;
import com.lj.pojo.user.User;
import com.lj.service.user.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
/**
 * 用户Action
 * @author lij
 *
 *
 */
public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;//User对象
	
	private UserService userService;	
	
    public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
    private String userName;
    private String message;
    
    
    
	public String toRegister(){		
		return "toRegister";		
	}
	
	public String  registerSave(){
		
		if(user!=null){
			try {
				user.setUserType("1");
				userService.saveUser(user);
			} catch (Exception e) {
				 e.printStackTrace();
			
			}
		}
		return "toLogin";
		
	}
	public String checkUserName(){
		
		try {
			
			User searchUserUsername = userService.findByUsername(userName);
			if(searchUserUsername!=null){
				message="1";
			}else{
				message="0";	
			}
			
		} catch (Exception e) {
			
		}
		 return "checkSuccess";
	}
	public String login(){
		User existUser = userService.login(user);
		if(existUser==null){
			this.addActionError("用户名或者密码错误!");
			return INPUT;
		}else{
			user=existUser;
			ActionContext.getContext().getSession().put(GeneralConstant.SESSION_USER, existUser);
			return "loginSuccess";
		}
	}
	
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	 
}
