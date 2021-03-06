package com.lj.action;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lj.constant.GeneralConstant;
import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.sysNotice.SysNotice;
import com.lj.pojo.user.User;
import com.lj.service.appointment.AppointmentService;
import com.lj.service.sysNotice.SysNoticeService;
import com.lj.service.user.UserService;
import com.lj.util.GeneralUtils;
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
	private AppointmentService appointmentService;
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
    private String userName;
    private String message;
    private Integer uid;
    private String newPassword;
    private String newPasswordTwo;
    private String oldPassword;
    /**
     * 预约集合
     */
	private List<Appointment> appointmentList;
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
				String birthDay=GeneralUtils.date2String(GeneralUtils.string2Date(user.getBirthDay(),GeneralConstant.DATETIME_10),
						GeneralConstant.DATETIME_8);
				user.setBirthDay(birthDay);
				String nowDay=getSysTime();
				Integer age=Integer.parseInt(nowDay.substring(0, 4))-Integer.parseInt(birthDay.substring(0, 4));
				user.setAge(age.toString());
				userService.saveUser(user);
			} catch (Exception e) {
				 e.printStackTrace();
			
			}
		}
		return "toLogin";
		
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
			//公告栏
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
			//预约栏
	  			
	  			String sql="SELECT m.departmentName,count(t.serial) sumAppointment FROM appointment t,department m where t.departmentId=m.serial and t.appointmentTime='"
	  			+getSysTime()+"' group by t.departmentId order by sumAppointment;";
	  			List<Object[]> tmpObjList = appointmentService.findBySql(sql);
	  			List<Appointment> appointmentListFirst=new ArrayList<Appointment>();
	  			
	  			/*List<Appointment> appointmentListFirst=new ArrayList<Appointment>();	
	  			appointmentListFirst=null;*/
	  			if(tmpObjList!=null){
	  				if(tmpObjList.size()<3&&tmpObjList.size()!=0){
		  				int i;
		  				for(i=0;i<tmpObjList.size();i++){
		  					Appointment appointment=new Appointment();
		  					appointment.setAppointmentSerial(tmpObjList.get(i)[0].toString());
		  					appointment.setAppointmentTime(tmpObjList.get(i)[1].toString());
		  					appointmentListFirst.add(appointment);
		  				}
		  				while(i<=2){
		  					Appointment appointment=new Appointment();
		  	  				appointment=null;
		  	  				i++;
		  	  			appointmentListFirst.add(appointment);
		  				}
		  			}else{
		  				int i;
		  				for(i=0;i<3;i++){
		  					Appointment appointment=new Appointment();
		  					appointment.setAppointmentSerial(tmpObjList.get(i)[0].toString());
		  					appointment.setAppointmentTime(tmpObjList.get(i)[1].toString());
		  					appointmentListFirst.add(appointment);
		  				}
		  			}
		  			appointmentList=appointmentListFirst;	
	  			}
	  		
	  		/*	PageBean<Appointment> pageBean2 = appointmentService.findByPageAndStatus(currPage,"0");
	  			List<Appointment> appointmentListFirst=new ArrayList<Appointment>();
	  			appointmentListFirst=null;
	  			appointmentListFirst= pageBean2.getList();
  	  			while(appointmentListFirst.size()<2&&appointmentListFirst.size()!=0){
  	  				Appointment appointment=new Appointment();
  	  				appointment=null;
  	  			appointmentListFirst.add(appointment);
  	  			}	
  	  		if(appointmentListFirst.size()>=4){
  				appointmentList=appointmentListFirst.subList(0, 3);
  			}else{
  				appointmentList=appointmentListFirst;
  			}*/
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
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	
	
	 
}
