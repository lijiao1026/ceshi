package com.lj.dao.medicine;

import java.util.List;

import com.lj.pojo.medicine.Medicine;
/**
 * 药品dao
 * @author lij
 *
 *
 */
public interface MedicineDao {
	/**
	 * 入库
	 * @param medicine
	 */
	void saveMedicine(Medicine medicine);
	/**
	 * 查询无条件记录总数
	 * @return
	 */
	int findCount();
	/**
	 * 分页封装记录
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	List<Medicine> findByPage(int begin, int pageSize);
	/**
	 * 根据条件能查询记录总数
	 * @param searchMedicineName
	 * @return
	 */
	int findCountByName(String searchMedicineName);
	/**
	 * 根据条件查询分页封装
	 * @param begin
	 * @param pageSize
	 * @param searchMedicineName
	 * @return
	 */
	List<Medicine> findByPageByName(int begin, int pageSize, String searchMedicineName);
	/**
	 * 根据序号查询药品
	 * @param serial
	 * @return
	 */
	Medicine findById(Integer serial);
	/**
	 * 更新药品
	 * @param medicine
	 */
	void updateMedicine(Medicine medicine);

}
