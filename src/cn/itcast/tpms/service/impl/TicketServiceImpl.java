package cn.itcast.tpms.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.tpms.dao.TicketDao;
import cn.itcast.tpms.domain.Ticket;
import cn.itcast.tpms.domain.Traffic;
import cn.itcast.tpms.pojo.TicketVo;
import cn.itcast.tpms.service.TicketService;
import cn.itcast.tpms.utils.IDUtils;

@Service("ticketService")
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketDao ticketDao;
	/**
	 * 查询订单总数
	 */
	@Override
	public Long findTicketCount(TicketVo ticketVo) {
		return ticketDao.findTicketCount(ticketVo);
	}

	/**
	 * 查询订单数据
	 */
	@Override
	public List<Ticket> findTicketBydlicensePlateNumber(TicketVo ticketVo, int firstResult, int maxResults) {
		List<Ticket> list = ticketDao.findTicketBydlicensePlateNumber(ticketVo, firstResult, maxResults);
		return list;
	
	}

	/**
	 * 添加订单数据
	 */
	@Override
	public void insertTicket(TicketVo ticketVo) {
		
		Ticket ticket = new Ticket();
		
		if(ticketVo==null) {
			throw new RuntimeException("数据异常");
		}
		BeanUtils.copyProperties(ticketVo, ticket);
		//设置订单id
		ticket.setTid(IDUtils.genItemId()+"");
		//设置初始化订单
		ticket.setTstate("1");
		//对交警和汽车进行数据处理
		if(ticket.getTraffic() != null) {
			if(StringUtils.isEmpty(ticket.getTraffic().getPid())) {
				ticket.setTraffic(null);
			}
		}
		if(ticket.getDetialCat() != null) {
			if(StringUtils.isEmpty(ticket.getDetialCat().getDlicensePlateNumber())) {
				ticket.setDetialCat(null);
			}
		}
		
		ticketDao.insert(ticket);
	}

	/**
	 * 查询订单信息
	 */
	@Override
	public Ticket findTicketByTid(String tid) {
		return ticketDao.findById(tid);
	}

	/**
	 * 更新订单信息
	 *
	 */
	@Override
	public void updateTicket(TicketVo ticketVo) {
		
		
		if(ticketVo == null) {
			throw new RuntimeException("参数异常");
		}
		
		Ticket ticket = ticketDao.findById(ticketVo.getTid());
		
		if(ticket==null) {
			throw new RuntimeException("用户不存在");
		}
		//对交警和汽车进行数据处理
		if(ticket.getTraffic() != null) {
			if(StringUtils.isEmpty(ticket.getTraffic().getPid())) {
				ticket.setTraffic(null);
			}
		}
		if(ticket.getDetialCat() != null) {
			if(StringUtils.isEmpty(ticket.getDetialCat().getDlicensePlateNumber())) {
				ticket.setDetialCat(null);
			}
		}
		ticket.setTsite(ticketVo.getTsite());
		ticket.setTunlawfulAct(ticketVo.getTunlawfulAct());
		ticket.setTscore(ticketVo.getTscore());
		ticket.setTfine(ticketVo.getTfine());
	}

	/**
	 * 删除订单信息
	 */
	@Override
	public void deleteTicket(String tid) {
		
		ticketDao.deleteById(tid);
		
	}

}
