package com.lj.action.appointment;

import java.util.List;

import com.lj.constant.GeneralConstant;
import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.department.Department;
import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.sysNotice.SysNotice;
import com.lj.pojo.user.User;
import com.lj.service.appointment.AppointmentService;
import com.lj.service.department.DepartmentService;
import com.lj.service.user.UserService;
import com.lj.util.GeneralUtils;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 预约Action
 * @author lij
 *
 *
 */
public class AppointmentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AppointmentService appointmentService;
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
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
     * 科室集合
     */
	private List<Department> departmentList;
	 /**
     * 预约集合
     */
	private List<Appointment> appointmentList;
	 /**
     * 用户姓名查询
     */
    private String q;
    /**
     * 预约对象
     */
    private Appointment appointment;
    /**
     * 科室名称查询
     */
    private String q2;
    /**
	 * 总页数
	 */
    private Integer totalPage;
    /**
     * 消息传递
     */
    private String message;
    /**
     * 查询患者姓名
     */
    private String searchName;
    /**
	 * 预约序号
	 */
	private Integer serial;
    
    
	/**
	 * 跳转到预约页面
	 * @return
	 */
	public String toAppointment(){
		try {
			return "toAppointment";
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
	}
	/**
	 * 动态查询患者
	 * @return
	 */
	public String queryUser(){
		try {
			if(q!=null){
				PageBean<User> pageBean =userService.findByUsername(currPage,"1",q);	
				userList= pageBean.getList();
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "querySuccess";
	}
	
	/**
	 * 动态查询科室
	 * @return
	 */
	public String queryDepartment(){
		try {
			if(q2!=null){
				/*PageBean<Department> pageBean =departmentService.findBydepartment(currPage,q2);	*/
				departmentList= departmentService.findAllByName(q2);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "queryDepartmentSuccess";
	}
	/**
	 * 保存
	 * @return
	 */
	public String addSave(){
		if(appointment!=null){
			try {
				String appointmentTrueTime=GeneralUtils.date2String(GeneralUtils.string2Date(appointment.getAppointmentTime(),GeneralConstant.DATETIME_10), GeneralConstant.DATETIME_8);
				appointment.setAppointmentTime(appointmentTrueTime);
				appointment.setAppointmentStatus("0");
				appointment.setAppointmentSerial(appointment.getUserId().getUid()+appointmentTrueTime);
				appointmentService.saveAppointment(appointment);
				message="1";
			} catch (Exception e) {
				 e.printStackTrace();
			
			}
		}
		return "addSuccess";
	}
	/**
	 * 查询
	 * @return
	 */
	public String queryList(){
  		try {
  			//因为用户类型为1的是用户 所以这里传入1
  			if(searchName==null||searchName.equals("")){
  				PageBean<Appointment> pageBean = appointmentService.findByPage(currPage); 
  				appointmentList= pageBean.getList();
  	  			while(appointmentList.size()<10&&appointmentList.size()!=0){
  	  				Appointment appointment=new Appointment();
  	  				appointment=null;
  	  				appointmentList.add(appointment);
  	  			}
  	  			totalPage=pageBean.getTotalPage();
  			}else{
  			
  	  		PageBean<Appointment> pageBean =appointmentService.findByappointment(currPage,searchName);	
				appointmentList= pageBean.getList();
	  			while(appointmentList.size()<10&&appointmentList.size()!=0){
	  				Appointment appointment=new Appointment();
	  				appointment=null;
	  				appointmentList.add(appointment);
	  			}
	  			totalPage=pageBean.getTotalCount();
  			}
  		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "list";
	}
	
	/**
	 * 查看
	 * @return
	 */
	public String toDetail(){
		try {
			appointment = appointmentService.findById(serial);
			return "detail";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 删除预约
	 * @return
	 */
  	public String delete(){
  		try {
			appointment = appointmentService.findById(serial);
			appointmentService.delete(appointment);
  			message="1";
  			return "delete";
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
  	}
	
	
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
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
	public String getQ2() {
		return q2;
	}
	public void setQ2(String q2) {
		this.q2 = q2;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	
}
