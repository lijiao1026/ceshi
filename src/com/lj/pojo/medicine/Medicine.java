package com.lj.pojo.medicine;

import com.lj.pojo.user.User;

public class Medicine {
	private Integer serial;//序号
	private String medicineType;//药品分类编号
	private String productionDate;//药品生产日期
	private String expireDate;//有效日期
	private String medicineName;//药品名称
	private Integer medicineStore;//库存量
	private Integer medicineSupply;//供应量
	private String medicineSuppier;//供应商
	private String SuppierPhone;//供应商电话
	private Integer unitPrice;//单价
	private User userId;//入库人
	private String inTime;//入库时间
	private Integer medicineSale;//销售量
	private String remark;//备注
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	public String getMedicineType() {
		return medicineType;
	}
	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}
	public String getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public Integer getMedicineStore() {
		return medicineStore;
	}
	public void setMedicineStore(Integer medicineStore) {
		this.medicineStore = medicineStore;
	}
	public Integer getMedicineSupply() {
		return medicineSupply;
	}
	public void setMedicineSupply(Integer medicineSupply) {
		this.medicineSupply = medicineSupply;
	}
	public String getMedicineSuppier() {
		return medicineSuppier;
	}
	public void setMedicineSuppier(String medicineSuppier) {
		this.medicineSuppier = medicineSuppier;
	}
	public String getSuppierPhone() {
		return SuppierPhone;
	}
	public void setSuppierPhone(String suppierPhone) {
		SuppierPhone = suppierPhone;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getMedicineSale() {
		return medicineSale;
	}
	public void setMedicineSale(Integer medicineSale) {
		this.medicineSale = medicineSale;
	}
	
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
