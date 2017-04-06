package com.lj.pojo.appointment;

import com.lj.pojo.department.Department;
import com.lj.pojo.user.User;

/**
 * 预约表
 * @author lij
 *
 *
 */
public class Appointment {
	private Integer serial;//序号
	private User userId;//患者
	private Department departmentId;//科室
	private String appointmentTime;//预约时间
	private String remark;//备注
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Department getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
	
