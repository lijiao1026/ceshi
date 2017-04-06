package com.lj.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lj.constant.GeneralConstant;
import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.sysNotice.SysNotice;
import com.lj.pojo.user.User;
import com.lj.service.sysNotice.SysNoticeService;
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
    private SysNoticeService sysNoticeService;
	
	public void setSysNoticeService(SysNoticeService sysNoticeService) {
		this.sysNoticeService = sysNoticeService;
	}
    private String userName;
    private String message;
    private Integer uid;
    private String newPassword;
    private String newPasswordTwo;
    private String oldPassword;
    /**
     * 当前页数
     */
    private Integer currPage = 1;
    /**
     * 公告集合
     */
	private List<SysNotice> sysNoticeList;
    /**
     * 跳转到注册页面
     * @return
     */
	public String toRegister(){		
		return "toRegister";		
	}
	/**
	 * 注册保存
	 * @return
	 */
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
	/**
	 * 验证用户名是否重复
	 * @return
	 */
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
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		try {
			if(user!=null)
			{
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
			else{
				User userSession=(User) ActionContext.getContext().getSession().get(GeneralConstant.SESSION_USER);
				if(userSession==null){
					return INPUT;
				}else{
					user=userSession;
					return "loginSuccess";
				}
			}
		} catch (Exception e) {
			
		}
		return null;
		
	}
	/**
	 *系统首页跳转
	 * @return
	 */
	public String toIndex(){
		try {
			PageBean<SysNotice> pageBean = sysNoticeService.findByPage(currPage); 
			List<SysNotice> sysNoticeListFirst=new ArrayList<SysNotice>();	
			sysNoticeListFirst=null;
			sysNoticeListFirst= pageBean.getList();
	  			while(sysNoticeListFirst.size()<3&&sysNoticeListFirst.size()!=0){
	  				SysNotice sysNotice=new SysNotice();
	  				sysNotice=null;
	  				sysNoticeListFirst.add(sysNotice);
	  			}
	  			if(sysNoticeListFirst.size()>=4){
	  				sysNoticeList=sysNoticeListFirst.subList(0, 3);
	  			}else{
	  				sysNoticeList=sysNoticeListFirst;
	  			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	/**
	 * 改变密码
	 * @return
	 */
	public String changePassWord(){
		try {
		user=userService.findByUid(uid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "changePassword";
	}
	/**
	 * 保存修改密码
	 * @return
	 */
	public String saveNewPassword(){
		try {
		User oldUser=userService.findByUid(user.getUid());	
		if(oldUser.getPassword().equals(oldPassword)){
			oldUser.setPassword(newPassword);
			userService.updateUser(oldUser);	
			message="1";
		}else{
			message="2";
		}
		} catch (Exception e) {
			message="0";
		}
		return "saveNewPassword";
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

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewPasswordTwo() {
		return newPasswordTwo;
	}
	public void setNewPasswordTwo(String newPasswordTwo) {
		this.newPasswordTwo = newPasswordTwo;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public List<SysNotice> getSysNoticeList() {
		return sysNoticeList;
	}
	public void setSysNoticeList(List<SysNotice> sysNoticeList) {
		this.sysNoticeList = sysNoticeList;
	}

	
	
	 
}
