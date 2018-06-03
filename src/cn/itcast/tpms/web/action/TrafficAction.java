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

import cn.itcast.tpms.domain.Traffic;
import cn.itcast.tpms.domain.Users;
import cn.itcast.tpms.pojo.TrafficVo;
import cn.itcast.tpms.pojo.UsersVo;
import cn.itcast.tpms.service.TrafficService;
import cn.itcast.tpms.utils.FastJsonUtil;

@Controller("trafficAction")
@Scope("prototype")
public class TrafficAction extends BaseAction<TrafficVo>{

	@Autowired
	private TrafficService trafficService;
	
	/**
	 * 查询交警信息
	 */
	public void findTraffic() {
		//获取模型对象
		TrafficVo trafficVo = this.getModel();
		//查询交警总记录数
		Long count = trafficService.findTrafficCount(trafficVo);
		//获取页码信息
		int page = trafficVo.getPage();
		int rows = trafficVo.getRows();
		int firstResult = (page - 1) * rows;
		
		//查询交警信息
		List<Traffic> list = trafficService.findTraffic(trafficVo, firstResult, rows);
		
		//将数据返回给用户
		Map<String, Object> map = new HashMap<>();
		map.put("total", count);
		map.put("rows", list);
		
		//map转json数据
		String jsonString = FastJsonUtil.toJSONString(map);
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonString);
	}
	/**
	 * 交警登录
	 */
	public String  trafficlogin() {
		//获取模型对象
		TrafficVo trafficVo = this.getModel();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Traffic> list = trafficService.loginUser(trafficVo);
		
		if(list == null || list.isEmpty()) {
			request.setAttribute("msg", "用户民或密码错误");
			
			return "login";
		}
		Traffic traffic = list.get(0);
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		session.setAttribute("traffic", traffic);
		
		return "main";
	}
	/**
	 * 交警注册
	 */
	public String regtraffic() {
		//获取模型对象
		TrafficVo trafficVo = this.getModel();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			trafficService.insertTraffic(trafficVo);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "填写数据错误，请从新检查");
			
			return "reg";
		}
		
		return "success";
	}
	/**
	 * 修改交警密码
	 */
	public void updateTrafficPassword() {
		//获取模型对象
		TrafficVo trafficVo = this.getModel();
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Traffic traffic = (Traffic) session.getAttribute("traffic");
		String pid = traffic.getPid();
		trafficService.updateTrafficPassword(trafficVo,pid);
	}
	/**
	 * 交警退出登录
	 */
	public String outTraffic() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("traffic", null);
		return "main";
	}
	
}
