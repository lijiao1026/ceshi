package com.lj.pojo.department;
/**
 * 科室表
 * @author lij
 *
 *
 */
public class Department {
	private Integer serial;//序号
	private String departmentName;//科室名称
	private String departmentAddress;//科室地址
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}
	
}
