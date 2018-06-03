package cn.itcast.tpms.dao;

import java.util.List;

import cn.itcast.tpms.domain.Ticket;
import cn.itcast.tpms.pojo.TicketVo;

public interface TicketDao extends BaseDao<Ticket, String>{
	
	//查询订单总记录数
	public Long findTicketCount(TicketVo ticketVo);
	//根据车牌查询违章订单
	public List<Ticket> findTicketBydlicensePlateNumber(TicketVo ticketVo,int firstResult,int maxResults);
	
}
