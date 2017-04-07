package com.lj.service.medicine;

import com.lj.pojo.medicine.Medicine;
import com.lj.pojo.pageBean.PageBean;
/**
 * 药品service
 * @author lij
 *
 *
 */
public interface MedicineService {
	/**
	 * 保存入库
	 * @param medicine
	 */
	void saveMedicine(Medicine medicine);
	/**
	 * 无条件分页查询
	 * @param currPage
	 * @return
	 */
	PageBean<Medicine> findByPage(Integer currPage);
	/**
	 * 根据药品名称分页查询
	 * @param currPage
	 * @param searchMedicineName
	 * @return
	 */
	PageBean<Medicine> findBymedicine(Integer currPage, String searchMedicineName);
	/**
	 * 根据序号查询Id
	 * @param serial
	 * @return
	 */
	Medicine findById(Integer serial);

}
