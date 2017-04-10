package com.lj.action.userCase;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lj.constant.GeneralConstant;
import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.medicine.Medicine;
import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.user.User;
import com.lj.pojo.userCase.UserCase;
import com.lj.service.appointment.AppointmentService;
import com.lj.service.medicine.MedicineService;
import com.lj.service.user.UserService;
import com.lj.service.userCase.UserCaseService;
import com.lj.util.GeneralUtils;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 门诊收费Action
 * @author lij
 *
 *
 */
public class UserCaseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserCaseService userCaseService;

	public void setUserCaseService(UserCaseService userCaseService) {
		this.userCaseService = userCaseService;
	}
	private AppointmentService appointmentService;
	
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private MedicineService medicineService;
	


	public void setMedicineService(MedicineService medicineService) {
		this.medicineService = medicineService;
	}
	/**
	 * 预约编号  
	 */
	private String q;
	/**
	 * 医生姓名
	 */
	private String q2;
	/**
	 * 药品名称
	 */
	private String medicineName;
	/**
	 * 病例
	 */
	private UserCase userCase;
	
	/**
	 * 当前页数
	 */
	private Integer currPage = 1;
	/**
	 * 预约集合
	 */
	private List<Appointment> appointmentList;
	/**
	 * 医生集合
	 */
	private List<User> userList;
	/**
	 * 记录集合
	 */
	private List<UserCase> userCaseList;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 药品对象
	 */
	private Medicine medicine;
	/**
	 * 总页数
	 */
	private Integer totalPage;
	/**
	 * 序号查询
	 */
	private Integer serial;
	/**
	 * 预约对象
	 */
	private Appointment appointment;
	/**
	 * 快速查询
	 */
	private String userCaseSearch;
	/**
	 *药品集合 
	 */
	private List<Medicine> medicineList;
	public List<Medicine> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<Medicine> medicineList) {
		this.medicineList = medicineList;
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
		 * 查询预约列表
		 */
		public String queryAppointment(){
			try {
				if(q!=null){
					PageBean<Appointment> pageBean =appointmentService.findByAppointSerial(currPage,"0",q);	
					appointmentList= pageBean.getList();
				
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return "queryAppointment";	
		}
		/**
		 * 查看
		 * @return
		 */
		public String toDetail(){
			try {
				userCase = userCaseService.findById(serial);
				return "detail";
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}
		/**
		 * 动态查询医生
		 * @return
		 */
		public String queryUser(){
			try {
				if(q2!=null){
					PageBean<User> pageBean =userService.findByUsername(currPage,"2",q2);	
					userList= pageBean.getList();
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "queryUser";
		}
		/**
		 * 动态查询药品
		 * @return
		 */
		public String queryMedicine(){
			try {
				if(medicineName!=null){
					PageBean<Medicine> pageBean =medicineService.findBymedicine(currPage,medicineName);	
					medicineList= pageBean.getList();
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "queryMedicine";
		}
		
		/**
		 * 保存
		 * @return
		 */
		public String addSave(){
			if(userCase!=null){
				try {
					userCase.setCaseTime(getSysTime());
					medicine=medicineService.findById(userCase.getMedicineId().getSerial());
					medicine.setMedicineStore(medicine.getMedicineStore()-1);
					medicine.setMedicineSale(medicine.getMedicineSale()+1);
					medicineService.updateMedicine(medicine);
					userCaseService.saveUserCase(userCase);
					appointment=appointmentService.findById(userCase.getAppointmentId().getSerial());
					appointment.setAppointmentStatus("1");
					appointmentService.updateAppointment(appointment);
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
	  		
	  			if(userCaseSearch==null||userCaseSearch.equals("")){
	  				PageBean<UserCase> pageBean = userCaseService.findByPage(currPage); 
	  				userCaseList= pageBean.getList();
	  	  			while(userCaseList.size()<10&&userCaseList.size()!=0){
	  	  			UserCase userCase=new UserCase();
	  	  		userCase=null;
	  	  			userCaseList.add(userCase);
	  	  			}
	  	  			totalPage=pageBean.getTotalPage();
	  			}else{
	  			
	  	  		PageBean<UserCase> pageBean =userCaseService.findBySearch(currPage,userCaseSearch);	
	  	  	userCaseList= pageBean.getList();
		  			while(userCaseList.size()<10&&userCaseList.size()!=0){
		  				UserCase userCase=new UserCase();
		  				userCase=null;
		  				userCaseList.add(userCase);
		  			}
		  			totalPage=pageBean.getTotalCount();
	  			}
	  		
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "list";
		}
		
		/**
		 * 获取系统时间
		 * @return
		 */
	    private String getSysTime()
	    {
	        Date date = new Date();
	        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	        String SysTime = format.format(date);
	        return SysTime;
	    }
	
	    
		
		public String getQ() {
			return q;
		}

		public void setQ(String q) {
			this.q = q;
		}

		public Integer getCurrPage() {
			return currPage;
		}

		public void setCurrPage(Integer currPage) {
			this.currPage = currPage;
		}

		public List<Appointment> getAppointmentList() {
			return appointmentList;
		}

		public void setAppointmentList(List<Appointment> appointmentList) {
			this.appointmentList = appointmentList;
		}

		public String getQ2() {
			return q2;
		}

		public void setQ2(String q2) {
			this.q2 = q2;
		}

		public List<User> getUserList() {
			return userList;
		}

		public void setUserList(List<User> userList) {
			this.userList = userList;
		}

		public String getMedicineName() {
			return medicineName;
		}

		public void setMedicineName(String medicineName) {
			this.medicineName = medicineName;
		}

		public UserCase getUserCase() {
			return userCase;
		}

		public void setUserCase(UserCase userCase) {
			this.userCase = userCase;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Medicine getMedicine() {
			return medicine;
		}

		public void setMedicine(Medicine medicine) {
			this.medicine = medicine;
		}

		public List<UserCase> getUserCaseList() {
			return userCaseList;
		}

		public void setUserCaseList(List<UserCase> userCaseList) {
			this.userCaseList = userCaseList;
		}

		public Integer getTotalPage() {
			return totalPage;
		}

		public void setTotalPage(Integer totalPage) {
			this.totalPage = totalPage;
		}

		public Appointment getAppointment() {
			return appointment;
		}

		public void setAppointment(Appointment appointment) {
			this.appointment = appointment;
		}

		public String getUserCaseSearch() {
			return userCaseSearch;
		}

		public void setUserCaseSearch(String userCaseSearch) {
			this.userCaseSearch = userCaseSearch;
		}

		public Integer getSerial() {
			return serial;
		}

		public void setSerial(Integer serial) {
			this.serial = serial;
		}

		
		
		
}
