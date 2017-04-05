package com.lj.pojo.user;

import com.lj.pojo.department.Department;

/**
 *用户类
 * @author lij
 *
 *
 */
public class User {
	 private Integer uid;//用户编号
	 private String userName;//用户名
	 private String name;//姓名
	 private String password;//密码
	 private String sex;//性别 0为男性 1为女性
     private String age;//年龄
     private String telPhone;//电话号码
     private String address;//家庭住址
     private String userType;//用户类型 0为超级管理员 1为患者 2为医生
     private Department department;
     
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
     
     
	 
}
