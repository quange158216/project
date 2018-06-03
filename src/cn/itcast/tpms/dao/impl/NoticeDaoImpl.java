package cn.itcast.tpms.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.junit.Test;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.itcast.tpms.dao.NoticeDao;
import cn.itcast.tpms.domain.Notice;

@Repository("noticeDao")
public class NoticeDaoImpl extends BaseDaoImpl<Notice, String> implements NoticeDao{

	/**
	 * 查询公告总记录数
	 */
	@Override
	public Long findNoticeCount() {
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		
		detachedCriteria.setProjection(Projections.rowCount());
		
		List<?> list = this.getHibernateTemplate().findByCriteria(detachedCriteria);
		
		Long  count = (Long) list.get(0);
		return count;
	}

	/**
	 * 查询公告信息
	 */
	@Override
	public List<Notice> findNotice(int firstResult, int maxResults) {
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		
		List<Notice> list = (List<Notice>) this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		return list;
	}

	
}
