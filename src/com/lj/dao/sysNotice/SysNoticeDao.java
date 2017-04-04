package com.lj.dao.sysNotice;

import java.util.List;

import com.lj.pojo.sysNotice.SysNotice;

/**
 * 公共Dao类
 * @author lij
 *
 *
 */
public interface SysNoticeDao {
	/**
	 * 查询总记录数量
	 * @return
	 */
	int findCount();
	/**
	 * 分页查询
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	List<SysNotice> findByPage(int begin, int pageSize);
	/**
	 * 查询符合条件的记录数量
	 * @param searchNoticeTitle
	 * @return
	 */
	int findCountBySysNotice(String searchNoticeTitle);
	/**
	 * 分页查询符合条件的记录
	 * @param begin
	 * @param pageSize
	 * @param searchNoticeTitle
	 * @return
	 */
	List<SysNotice> findByPageBySysNotice(int begin, int pageSize, String searchNoticeTitle);
	/**
	 * 保存
	 * @param sysNotice
	 */
	void saveSysNotice(SysNotice sysNotice);
	/**
	 * 根据序号查询
	 * @param serial
	 * @return
	 */
	SysNotice findByUid(Integer serial);
	/**
	 * 保存修改
	 * @param sysNotice
	 */
	void saveUpdate(SysNotice sysNotice);
	/**
	 * 删除公告
	 * @param sysNotice
	 */
	void delate(SysNotice sysNotice);

}
