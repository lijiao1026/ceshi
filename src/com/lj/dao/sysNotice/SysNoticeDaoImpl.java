package com.lj.dao.sysNotice;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lj.pojo.sysNotice.SysNotice;
import com.lj.pojo.user.User;

/**
 * 公告Dao类
 * @author lij
 *
 *
 */
public class SysNoticeDaoImpl extends HibernateDaoSupport implements SysNoticeDao {

	/**
	 * 查询总记录数量
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		String hql="select count(*) from SysNotice";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SysNotice> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SysNotice.class);
		List<SysNotice> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	/**
	 * 查询符合条件的总记录数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int findCountBySysNotice(String searchNoticeTitle) {
		String hql="select count(*) from SysNotice where noticeTitle=?";
		List<Long> list = this.getHibernateTemplate().find(hql,"%"+searchNoticeTitle+"%");
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SysNotice> findByPageBySysNotice(int begin, int pageSize, String searchNoticeTitle) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SysNotice.class).add(Restrictions.like("noticeTitle", "%"+searchNoticeTitle+"%"));
		List<SysNotice> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	/**
	 * 保存
	 */
	@Override
	public void saveSysNotice(SysNotice sysNotice) {
		this.getHibernateTemplate().save(sysNotice);
	}

	@SuppressWarnings("unchecked")
	@Override
	public SysNotice findByUid(Integer serial) {
		String hql="from SysNotice where serial= ?";
		List<SysNotice> list=this.getHibernateTemplate().find(hql, serial);
		if(list.size() > 0){
			return list.get(0);
		}else{
			
			return null;
		}
	}

	@Override
	public void saveUpdate(SysNotice sysNotice) {
		this.getHibernateTemplate().update(sysNotice);
	}

	@Override
	public void delate(SysNotice sysNotice) {
		this.getHibernateTemplate().delete(sysNotice);
	}

}
