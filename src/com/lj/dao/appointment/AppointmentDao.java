package com.lj.dao.appointment;

import java.util.List;

import com.lj.pojo.appointment.Appointment;

public interface AppointmentDao {
	/**
	 * 新增预约
	 * @param appointment
	 */
	void saveAppointment(Appointment appointment);
	/**
	 * 查询无条件的总数
	 * @return
	 */
	int findCount();
	/**
	 * 分页查询
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	List<Appointment> findByPage(int begin, int pageSize);
	/**
	 * 查询符合条件的总数
	 * @param searchName
	 * @return
	 */
	int findCountByName(String searchName);
	/**
	 * 符合条件的分页
	 * @param begin
	 * @param pageSize
	 * @param searchName
	 * @return
	 */
	List<Appointment> findByPageByName(int begin, int pageSize, String searchName);
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
	 * 根据编号
	 * 查询记录总数
	 * @param q
	 * @param string 
	 * @return
	 */
	int findCountByAppointmentSerial(String q, String string);
	/**
	 * 根据编号分页查询
	 * @param begin
	 * @param pageSize
	 * @param q
	 * @param string 
	 * @return
	 */
	List<Appointment> findByPageByAppointmentSerial(int begin, int pageSize, String q, String string);
	/**
	 * 更新预约
	 * @param appointment
	 */
	void updateAppointment(Appointment appointment);
	/**
	 * 首页查询记录数量
	 * @param string
	 * @return
	 */
	int findCountByStatus(String string);
	/**
	 * 主页查询记录数
	 * @param begin
	 * @param pageSize
	 * @param string
	 * @return
	 */
	List<Appointment> findByPageByStatus(int begin, int pageSize, String string);

}
