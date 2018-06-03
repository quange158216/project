package cn.itcast.tpms.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.itcast.tpms.dao.TicketDao;
import cn.itcast.tpms.domain.Ticket;
import cn.itcast.tpms.pojo.TicketVo;

@Repository("ticketDao")
public class TicketDaoImpl extends BaseDaoImpl<Ticket, String> implements TicketDao{

	
	
	//条件拼装
	private DetachedCriteria setDetachedCriteria(DetachedCriteria detachedCriteria,TicketVo ticketVo) {
		if(ticketVo!=null) {
			if(ticketVo.getDlicensePlateNumbers()!=null && ticketVo.getDlicensePlateNumbers()[0] != null) {
				detachedCriteria.add(Restrictions.in("detialCat.dlicensePlateNumber",ticketVo.getDlicensePlateNumbers()));
			}
			if(ticketVo.getTraffic()!=null) {
				if(StringUtils.isNotEmpty(ticketVo.getTraffic().getPid())) {
					detachedCriteria.add(Restrictions.eq("traffic.pid", ticketVo.getTraffic().getPid()));
				}
			}
		}
		return detachedCriteria;
	}
	/**
	 * 订单总记录数
	 */
	@Override
	public Long findTicketCount(TicketVo ticketVo) {
		//获取拼装查询条件对象
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		//拚条件
		this.setDetachedCriteria(detachedCriteria, ticketVo);
		//设置投影列
		detachedCriteria.setProjection(Projections.rowCount());
		//查询
		List<?> list = this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long count = (Long) list.get(0);
		return count;
	}
	/**
	 * 根据车牌号查询订单
	 */
	@Override
	public List<Ticket> findTicketBydlicensePlateNumber(TicketVo ticketVo,int firstResult,int maxResults) {
		//获取拼装查询条件对象
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		//拚条件
		this.setDetachedCriteria(detachedCriteria, ticketVo);
		//查询
		List<Ticket> list = (List<Ticket>) this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		return list;
	}
	

}
