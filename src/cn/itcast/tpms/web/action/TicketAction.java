package cn.itcast.tpms.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.tpms.domain.DetialCat;
import cn.itcast.tpms.domain.Ticket;
import cn.itcast.tpms.domain.Traffic;
import cn.itcast.tpms.domain.Users;
import cn.itcast.tpms.pojo.DetialCatVo;
import cn.itcast.tpms.pojo.TicketVo;
import cn.itcast.tpms.service.DetialCatService;
import cn.itcast.tpms.service.TicketService;
import cn.itcast.tpms.utils.FastJsonUtil;

@Controller("ticketAction")
@Scope("prototype")
public class TicketAction extends BaseAction<TicketVo>{

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private DetialCatService detialCatService;
	/**
	 * 用户查询订单信息     车牌号查询
	 */
	public void userslist() {
		
		//获取模型对象
		TicketVo ticketVo = this.getModel();
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users users = (Users) session.getAttribute("user");
		
		
		DetialCatVo detialCatVo = new DetialCatVo();
	    detialCatVo.setUsers(users);
	    
	    //获取车牌信息
	    List<DetialCat> lists = detialCatService.findDetialCatByUid(detialCatVo, 0, 10);
	    
	    String[] dlicensePlateNumbers = new String[lists.size()];
	    int i = 0;
	    for (DetialCat detialCat : lists) {
			String dlicensePlateNumber = detialCat.getDlicensePlateNumber();
			
			dlicensePlateNumbers[i] = dlicensePlateNumber;
			
			i++;
		}
	    
	    ticketVo.setDlicensePlateNumbers(dlicensePlateNumbers);
	    //总违章记录数
	    Long count = ticketService.findTicketCount(ticketVo);
	    
	    //获取页码数据
	    int page = ticketVo.getPage();
	    int rows = ticketVo.getRows();
	    
	    int firstResult = (page - 1)*rows;
	    
	    List<Ticket> ticketList = ticketService.findTicketBydlicensePlateNumber(ticketVo, firstResult, rows);
	    
	  //封装数据
  		Map<String, Object> map = new HashMap<String,Object>();
  		map.put("total", count);
  		map.put("rows", ticketList);
  		//map对象转json对象
  		String jsonString = FastJsonUtil.toJSONString(map);
  		HttpServletResponse response = ServletActionContext.getResponse();
  		//回写客户端
  		FastJsonUtil.write_json(response, jsonString);
	    
	}
	/**
	 * 交警查询订单信息
	 */
	public void trafficlist() {
		
		//获取模型对象
		TicketVo ticketVo = this.getModel();
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Traffic traffic = (Traffic) session.getAttribute("traffic");
		ticketVo.setTraffic(traffic);
	   
	    
	    //总违章记录数
	    Long count = ticketService.findTicketCount(ticketVo);
	    
	    //获取页码数据
	    int page = ticketVo.getPage();
	    int rows = ticketVo.getRows();
	    
	    int firstResult = (page - 1)*rows;
	    
	    List<Ticket> ticketList = ticketService.findTicketBydlicensePlateNumber(ticketVo, firstResult, rows);
	    
	  //封装数据
  		Map<String, Object> map = new HashMap<String,Object>();
  		map.put("total", count);
  		map.put("rows", ticketList);
  		//map对象转json对象
  		String jsonString = FastJsonUtil.toJSONString(map);
  		HttpServletResponse response = ServletActionContext.getResponse();
  		//回写客户端
  		FastJsonUtil.write_json(response, jsonString);
	    
	}
	/**
	 * 管理员查询订单信息
	 */
	public void list() {
		
		//获取模型对象
		TicketVo ticketVo = this.getModel();
		
	    //总违章记录数
	    Long count = ticketService.findTicketCount(ticketVo);
	    
	    //获取页码数据
	    int page = ticketVo.getPage();
	    int rows = ticketVo.getRows();
	    
	    int firstResult = (page - 1)*rows;
	    
	    List<Ticket> ticketList = ticketService.findTicketBydlicensePlateNumber(ticketVo, firstResult, rows);
	    
	  //封装数据
  		Map<String, Object> map = new HashMap<String,Object>();
  		map.put("total", count);
  		map.put("rows", ticketList);
  		//map对象转json对象
  		String jsonString = FastJsonUtil.toJSONString(map);
  		HttpServletResponse response = ServletActionContext.getResponse();
  		//回写客户端
  		FastJsonUtil.write_json(response, jsonString);
	    
	}
	/**
	 * 添加订单信息
	 */
	public void insertTicket() {
		//获取模型对象
		TicketVo ticketVo = this.getModel();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Traffic traffic = (Traffic) session.getAttribute("traffic");
		
		ticketVo.setTraffic(traffic);
		try {
			ticketService.insertTicket(ticketVo);
			
		} catch (Exception e) {
			e.printStackTrace();
			//添加失败
			String ajaxResult = FastJsonUtil.ajaxResult(false, "添加违章信息失败");
			FastJsonUtil.write_json(response, ajaxResult);
			return ;
		}
		//添加成功
		String ajaxResult = FastJsonUtil.ajaxResult(true, "添加违章信息成功");
		FastJsonUtil.write_json(response, ajaxResult);
	}
	
	/**
	 * 交警根据主键查询订单信息
	 */
	public void findTicketByTid() {
		TicketVo ticketVo = this.getModel();
		HttpServletResponse response = ServletActionContext.getResponse();
		//获取用户id
		String tid = ticketVo.getTid();
		//查询用户
		Ticket ticket = ticketService.findTicketByTid(tid);
		
		ticket.setTtime(null);
		//对象转json
		String jsonString = FastJsonUtil.toJSONString(ticket);
		//使json对象中嵌套json转为不嵌套json对象
		jsonString = FastJsonUtil.JsonFormatterAddPrefix(jsonString, "", null);
		FastJsonUtil.write_json(response, jsonString);
	}
	/**
	 * 更新订单信息
	 */
	public void updateTicket() {
		//获取模型对象
		TicketVo ticketVo = this.getModel();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			ticketService.updateTicket(ticketVo);
			
		} catch (Exception e) {
			e.printStackTrace();
			//修改失败
			String ajaxResult = FastJsonUtil.ajaxResult(false, "修改罚单失败");
			FastJsonUtil.write_json(response, ajaxResult);
			return ;
		}
		//修改成功
		String ajaxResult = FastJsonUtil.ajaxResult(true, "修改罚单成功");
		FastJsonUtil.write_json(response, ajaxResult);
	}
	/**
	 * 删除订单信息
	 */
	public void deleteTicket() {
		//获取模型对象
		TicketVo ticketVo = this.getModel();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		try {
			
			String tid = ticketVo.getTid();
			
			ticketService.deleteTicket(tid);
		} catch (Exception e) {
			e.printStackTrace();
			//删除失败
			String ajaxResult = FastJsonUtil.ajaxResult(false, "删除罚单失败");
			FastJsonUtil.write_json(response, ajaxResult);
			return ;
		}
		//删除成功
		String ajaxResult = FastJsonUtil.ajaxResult(true, "删除罚单成功");
		FastJsonUtil.write_json(response, ajaxResult);
	}
}










