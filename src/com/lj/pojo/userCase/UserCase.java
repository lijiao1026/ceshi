package com.lj.pojo.userCase;

import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.medicine.Medicine;
import com.lj.pojo.user.User;

/**
 * 门诊收费表也是病例表
 * @author lij
 *
 *
 */
public class UserCase {
	private Integer serial;//序号
	private Appointment appointmentId;//预约号
	private User userId;//就诊医生
	private String caseTime;//就诊时间
	private Medicine MedicineId;//所开药品
	private Medicine MedicineId2;//所开药品
	private Medicine MedicineId3;//所开药品
	private Medicine MedicineId1;//所开药品
	private String caseFree;//就诊费用
	private String zhuSu;//主诉
	private String nowBingShi;//现病史
	private String personBingShi;//个人史
	private String famailyBingShi;//家族史
	
	
	
	
	
	
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	public Appointment getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Appointment appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public String getCaseTime() {
		return caseTime;
	}
	public void setCaseTime(String caseTime) {
		this.caseTime = caseTime;
	}
	public Medicine getMedicineId() {
		return MedicineId;
	}
	public void setMedicineId(Medicine medicineId) {
		MedicineId = medicineId;
	}

	
	public String getCaseFree() {
		return caseFree;
	}
	public void setCaseFree(String caseFree) {
		this.caseFree = caseFree;
	}
	public String getZhuSu() {
		return zhuSu;
	}
	public void setZhuSu(String zhuSu) {
		this.zhuSu = zhuSu;
	}
	public String getNowBingShi() {
		return nowBingShi;
	}
	public void setNowBingShi(String nowBingShi) {
		this.nowBingShi = nowBingShi;
	}
	public String getPersonBingShi() {
		return personBingShi;
	}
	public void setPersonBingShi(String personBingShi) {
		this.personBingShi = personBingShi;
	}
	public String getFamailyBingShi() {
		return famailyBingShi;
	}
	public void setFamailyBingShi(String famailyBingShi) {
		this.famailyBingShi = famailyBingShi;
	}
	public Medicine getMedicineId2() {
		return MedicineId2;
	}
	public void setMedicineId2(Medicine medicineId2) {
		MedicineId2 = medicineId2;
	}
	public Medicine getMedicineId3() {
		return MedicineId3;
	}
	public void setMedicineId3(Medicine medicineId3) {
		MedicineId3 = medicineId3;
	}
	public Medicine getMedicineId1() {
		return MedicineId1;
	}
	public void setMedicineId1(Medicine medicineId1) {
		MedicineId1 = medicineId1;
	}
	
}
