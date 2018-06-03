package cn.itcast.tpms.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import cn.itcast.tpms.utils.FastJsonUtil;

@Controller("detialCatAction")
@Scope("prototype")
public class DetialCatAction extends BaseAction<DetialCatVo>{

	private static final long serialVersionUID = 1L;

	@Autowired
	private DetialCatService detialCatService;
	/**
	 * 根据用户uid查询车辆信息
	 */
	public void list() {
		//获取模型对象
		DetialCatVo detialCatVo = this.getModel();
		
		//模拟用户
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users users = (Users) session.getAttribute("user");
		
		detialCatVo.setUsers(users);
		
		//车辆总记录数
		Long count = detialCatService.findDetialCatCount(detialCatVo);
		//获取页码相关信息
		int page = detialCatVo.getPage();
		int rows = detialCatVo.getRows();
		
		int firstResult = (page-1)*rows;
		
		
		
		//调用业务层
		List<DetialCat> lists = detialCatService.findDetialCatByUid(detialCatVo, firstResult, rows);
		
		//封装数据
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("total", count);
		map.put("rows", lists);
		//map对象转json对象
		String jsonString = FastJsonUtil.toJSONString(map);
		HttpServletResponse response = ServletActionContext.getResponse();
		//回写客户端
		FastJsonUtil.write_json(response, jsonString);
	}
	
	/**
	 * 根据车牌号查询汽车信息
	 */
	public String detialCat() {
		//获取模型对象
		DetialCatVo detialCatVo = this.getModel();
		//获取车牌号
		String dlicensePlateNumber = detialCatVo.getDlicensePlateNumber();
		
		DetialCat detialCat = detialCatService.findDetialCat(dlicensePlateNumber);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("detialCat", detialCat);
		request.setAttribute("load", "second");
		return "success";
	}
	
	/**
	 * 
	 * 添加汽车信息
	 */
	public void insertCat() {
		//获取模型对象
		DetialCatVo detialCatVo = this.getModel();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users users = (Users) session.getAttribute("user");
		
		detialCatVo.setUsers(users);
		try {
			detialCatService.insertCat(detialCatVo);
			
		} catch (Exception e) {
			e.printStackTrace();
			//添加失败
			String ajaxResult = FastJsonUtil.ajaxResult(false, "添加信息失败");
			FastJsonUtil.write_json(response, ajaxResult);
			return ;
		}
		//添加成功
		String ajaxResult = FastJsonUtil.ajaxResult(true, "添加信息成功");
		FastJsonUtil.write_json(response, ajaxResult);
	}
}
