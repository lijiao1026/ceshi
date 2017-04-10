package com.lj.service.medicine;


import java.util.List;

import com.lj.dao.medicine.MedicineDao;
import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.medicine.Medicine;
import com.lj.pojo.pageBean.PageBean;
/**
 * 药品service类
 * @author lij
 *
 *
 */
public class MedicineServiceImpl implements MedicineService {
	private MedicineDao medicineDao;

	public void setMedicineDao(MedicineDao medicineDao) {
		this.medicineDao = medicineDao;
	}

	@Override
	public void saveMedicine(Medicine medicine) {
		try {
			medicineDao.saveMedicine(medicine);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public PageBean<Medicine> findByPage(Integer currPage) {
		PageBean<Medicine> pageBean=new PageBean<Medicine>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = medicineDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Medicine> list = medicineDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Medicine> findBymedicine(Integer currPage, String searchMedicineName) {
		PageBean<Medicine> pageBean=new PageBean<Medicine>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = medicineDao.findCountByName(searchMedicineName);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Medicine> list = medicineDao.findByPageByName(begin,pageSize,searchMedicineName);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Medicine findById(Integer serial) {
		try {
			Medicine medicine=medicineDao.findById(serial);
			return medicine;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;
	}

	@Override
	public void updateMedicine(Medicine medicine) {
		try {
			medicineDao.updateMedicine(medicine);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
