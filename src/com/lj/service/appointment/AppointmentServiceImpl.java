package com.lj.service.appointment;

import java.util.List;

import com.lj.dao.appointment.AppointmentDao;
import com.lj.dao.department.DepartmentDao;
import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.department.Department;
import com.lj.pojo.pageBean.PageBean;

/**
 * 预约Service类
 * @author lij
 *
 *
 */
public class AppointmentServiceImpl implements AppointmentService {
	private AppointmentDao appointmentDao;

	public void setAppointmentDao(AppointmentDao appointmentDao) {
		this.appointmentDao = appointmentDao;
	}

	@Override
	public void saveAppointment(Appointment appointment) {
		try {
			appointmentDao.saveAppointment(appointment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public PageBean<Appointment> findByPage(Integer currPage) {
		PageBean<Appointment> pageBean=new PageBean<Appointment>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = appointmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Appointment> list = appointmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Appointment> findByappointment(Integer currPage, String searchName) {
		PageBean<Appointment> pageBean=new PageBean<Appointment>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = appointmentDao.findCountByName(searchName);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Appointment> list = appointmentDao.findByPageByName(begin,pageSize,searchName);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Appointment findById(Integer serial) {
		try {
			Appointment appointment=appointmentDao.findById(serial);
			return appointment;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;
	}

	@Override
	public void delete(Appointment appointment) {
		try {
			appointmentDao.delete(appointment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
