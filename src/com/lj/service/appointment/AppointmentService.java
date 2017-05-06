package com.lj.service.appointment;

import java.util.List;

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
	/**
	 * 根据序号查询
	 * @param serial
	 * @return
	 */
	Appointment findById(Integer serial);
	/**
	 * 删除预约
	 * @param appointment
	 */
	void delete(Appointment appointment);
	/**
	 * 根据预约编号查询
	 * @param currPage
	 * @param string
	 * @param q
	 * @return
	 */
	PageBean<Appointment> findByAppointSerial(Integer currPage, String string, String q);
	/**
	 * 更新预约
	 * @param appointment
	 */
	void updateAppointment(Appointment appointment);
	/**
	 * 首页查询
	 * @param currPage
	 * @param string
	 * @return
	 */
	PageBean<Appointment> findByPageAndStatus(Integer currPage, String string);
	/**
	 * 按照sql语句查询
	 * @param sql
	 * @return
	 */
	List<Object[]> findBySql(String sql);

}
