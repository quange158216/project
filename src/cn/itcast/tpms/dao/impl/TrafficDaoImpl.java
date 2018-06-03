package cn.itcast.tpms.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.itcast.tpms.dao.TrafficDao;
import cn.itcast.tpms.domain.Traffic;
import cn.itcast.tpms.pojo.TrafficVo;

@Repository("trafficDao")
public class TrafficDaoImpl extends BaseDaoImpl<Traffic, String> implements TrafficDao{

	

	/**
	 * 拼装条件
	 */
	private DetachedCriteria setDetachesCriteria(TrafficVo trafficVo,DetachedCriteria detachedCriteria) {
		if(trafficVo != null) {
			if(StringUtils.isNotEmpty(trafficVo.getPname()) && StringUtils.isNotEmpty(trafficVo.getPpassword())) {
				detachedCriteria.add(Restrictions.eq("pname", trafficVo.getPname()));
				detachedCriteria.add(Restrictions.eq("ppassword", trafficVo.getPpassword()));
			}
		}
		return detachedCriteria;
	}
	
	/**
	 * 查询交警总数
	 */
	@Override
	public Long findTrafficCount(TrafficVo trafficVo) {
		//获取拼装条件对象
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		//拼装条件
		this.setDetachesCriteria(trafficVo, detachedCriteria);
		//设置投影列
		detachedCriteria.setProjection(Projections.rowCount());
		//查询
		List<?> list = this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long count = (Long) list.get(0);
		return count;
	}

	/**
	 * 查询交警详细信息
	 */
	@Override
	public List<Traffic> findTraffic(TrafficVo trafficVo, int firstResult, int maxResults) {
		//获取拼装条件对象
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		//拼装条件
		this.setDetachesCriteria(trafficVo, detachedCriteria);
		//查询
		return  (List<Traffic>) this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
	}

	/**
	 * 交警登录界面
	 */
	@Override
	public List<Traffic> findTraffic(TrafficVo trafficVo) {
		//获取拼装条件对象
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		//拼装条件
		this.setDetachesCriteria(trafficVo, detachedCriteria);
		//查询
		return (List<Traffic>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

}
