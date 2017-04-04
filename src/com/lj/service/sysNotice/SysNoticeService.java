package com.lj.service.sysNotice;

import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.sysNotice.SysNotice;

/**
 * 公告Service类
 * @author lij
 *
 *
 */
public interface SysNoticeService {
	/**
	 * 查询类
	 * @param currPage
	 * @return
	 */
	PageBean<SysNotice> findByPage(Integer currPage);
	/**
	 * 按公告标题查询
	 * @param currPage
	 * @param searchNoticeTitle
	 * @return
	 */
	PageBean<SysNotice> findBySysNotice(Integer currPage, String searchNoticeTitle);
	/**
	 * 保存
	 * @param sysNotice
	 */
	void saveSysNotice(SysNotice sysNotice);
	/**
	 * 根据序号查询单个
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
	void delete(SysNotice sysNotice);

}
