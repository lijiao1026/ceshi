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
	private String departmentType;//0为内科，1为外科，2为妇产科，
	//3为生殖中心，4为儿科，5为骨外科，6为眼科，7为口腔科，8为耳鼻咽喉头颈科，9为肿瘤科
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
	public String getDepartmentType() {
		return departmentType;
	}
	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}
	
}
