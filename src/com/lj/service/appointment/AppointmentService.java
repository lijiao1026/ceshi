package com.lj.service.appointment;

import com.lj.pojo.appointment.Appointment;
import com.lj.pojo.pageBean.PageBean;

public interface AppointmentService {
	/**
	 * 新增预约
	 * @param appointment
	 */
	void saveAppointment(Appointment appointment);
	/**
	 * 无条件分页
	 * @param currPage
	 * @return
	 */
	PageBean<Appointment> findByPage(Integer currPage);
	/**
	 * 根据患者姓名查询
	 * @param currPage
	 * @param searchName
	 * @return
	 */
	PageBean<Appointment> findByappointment(Integer currPage, String searchName);

}
