package com.lj.service.sysNotice;

import java.util.List;

import com.lj.dao.sysNotice.SysNoticeDao;
import com.lj.pojo.pageBean.PageBean;
import com.lj.pojo.sysNotice.SysNotice;
import com.lj.pojo.user.User;


/**
 * 公告实现类
 * @author lij
 *
 *
 */
public class SysNoticeServiceImpl implements SysNoticeService {
	private SysNoticeDao sysNoticeDao;

	public void setSysNoticeDao(SysNoticeDao sysNoticeDao) {
		this.sysNoticeDao = sysNoticeDao;
	}

	@Override
	public PageBean<SysNotice> findByPage(Integer currPage) {
		PageBean<SysNotice> pageBean=new PageBean<SysNotice>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = sysNoticeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<SysNotice> list = sysNoticeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<SysNotice> findBySysNotice(Integer currPage, String searchNoticeTitle) {
		PageBean<SysNotice> pageBean=new PageBean<SysNotice>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = sysNoticeDao.findCountBySysNotice(searchNoticeTitle);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<SysNotice> list = sysNoticeDao.findByPageBySysNotice(begin,pageSize,searchNoticeTitle);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void saveSysNotice(SysNotice sysNotice) {
		try {
			sysNoticeDao.saveSysNotice(sysNotice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public SysNotice findByUid(Integer serial) {
		try {
			SysNotice sysNotice=sysNoticeDao.findByUid(serial);
			return sysNotice;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;
	}

	@Override
	public void saveUpdate(SysNotice sysNotice) {
		sysNoticeDao.saveUpdate(sysNotice);
	}

	@Override
	public void delete(SysNotice sysNotice) {
		sysNoticeDao.delate(sysNotice);
	}

	
	
}
