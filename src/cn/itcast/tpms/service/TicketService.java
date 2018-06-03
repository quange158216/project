package cn.itcast.tpms.service;

import java.util.List;

import cn.itcast.tpms.domain.Ticket;
import cn.itcast.tpms.pojo.TicketVo;

public interface TicketService {
	//查询订单总记录数
	public Long findTicketCount(TicketVo ticketVo);
	//查询订单总数
	public List<Ticket> findTicketBydlicensePlateNumber(TicketVo ticketVo,int firstResult,int maxResults);
	//添加订单信息
	public void insertTicket(TicketVo ticketVo);
	//根据tid查询订单信息
	public Ticket findTicketByTid(String tid);
	//更新订单信息
	public void updateTicket(TicketVo ticketVo);
	//删除订单信息
	public void deleteTicket(String tid);
}
