package com.lj.action.medicine;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lj.constant.GeneralConstant;
import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.medicine.Medicine;
import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.user.User;
import com.lj.service.medicine.MedicineService;
import com.lj.util.GeneralUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MedicineAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MedicineService medicineService;
	public void setMedicineService(MedicineService medicineService) {
		this.medicineService = medicineService;
	}
	
	/**
	 * 药品
	 */
	private Medicine medicine;
	private String message;
	
	private String searchMedicineName;
	private List<Medicine> medicineList;
	 /**
     * 当前页数
     */
    private Integer currPage = 1;
    /**
   	 * 总页数
   	 */
    private Integer totalPage;
    /**
     * 药品序号
     */
    private Integer serial;   
    
	/**
	 * 跳转到预约页面
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
	 * 保存
	 * @return
	 */
	public String addSave(){
		if(medicine!=null){
			try {
				String medicineProductionDate=GeneralUtils.date2String(GeneralUtils.string2Date(medicine.getProductionDate(),GeneralConstant.DATETIME_10), GeneralConstant.DATETIME_8);
				String medicineExpireDate=GeneralUtils.date2String(GeneralUtils.string2Date(medicine.getExpireDate(),GeneralConstant.DATETIME_10), GeneralConstant.DATETIME_8);
				medicine.setExpireDate(medicineExpireDate);
				medicine.setProductionDate(medicineProductionDate);
				medicine.setMedicineStore(medicine.getMedicineSupply());
				medicine.setInTime(getSysTime());
				User userSession=(User) ActionContext.getContext().getSession().get(GeneralConstant.SESSION_USER);
				medicine.setUserId(userSession);
				medicine.setMedicineSale(0);
				medicineService.saveMedicine(medicine);
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
  			if(searchMedicineName==null||searchMedicineName.equals("")){
  				PageBean<Medicine> pageBean = medicineService.findByPage(currPage); 
  				medicineList= pageBean.getList();
  	  			while(medicineList.size()<10&&medicineList.size()!=0){
  	  				Medicine medicine=new Medicine();
  	  				medicine=null;
  	  				medicineList.add(medicine);
  	  			}
  	  			totalPage=pageBean.getTotalPage();
  			}else{
  			
  	  		PageBean<Medicine> pageBean =medicineService.findBymedicine(currPage,searchMedicineName);	
				medicineList= pageBean.getList();
	  			while(medicineList.size()<10&&medicineList.size()!=0){
	  				Medicine medicine=new Medicine();
	  				medicine=null;
	  				medicineList.add(medicine);
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
			medicine = medicineService.findById(serial);
			return "detail";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
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
	public String getSearchMedicineName() {
		return searchMedicineName;
	}
	public void setSearchMedicineName(String searchMedicineName) {
		this.searchMedicineName = searchMedicineName;
	}
	public List<Medicine> getMedicineList() {
		return medicineList;
	}
	public void setMedicineList(List<Medicine> medicineList) {
		this.medicineList = medicineList;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	
	
}
