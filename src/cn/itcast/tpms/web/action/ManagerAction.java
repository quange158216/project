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

import cn.itcast.tpms.domain.Manager;
import cn.itcast.tpms.domain.Notice;
import cn.itcast.tpms.domain.Users;
import cn.itcast.tpms.pojo.ManagerVo;
import cn.itcast.tpms.pojo.NoticeVo;
import cn.itcast.tpms.pojo.UsersVo;
import cn.itcast.tpms.service.ManagerService;
import cn.itcast.tpms.service.NoticeService;
import cn.itcast.tpms.service.UsersService;
import cn.itcast.tpms.utils.FastJsonUtil;

@Controller("managerAction")
@Scope("prototype")
public class ManagerAction extends BaseAction<ManagerVo>{

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private NoticeService noticeService;
	/**
	 * 管理员登陆
	 */
	public String managerlogin() {
		//获取模型对象
		ManagerVo managerVo = this.getModel();
		
		NoticeVo noticeVo = new NoticeVo();
		int ut = noticeVo.getUt();
		int pageCode = noticeVo.getPc();
		
		if(pageCode == 0) {
			pageCode = 1;
		}
		
		Long noticeCount = noticeService.findNoticeCount();
		//当前页码
		noticeVo.setPageCode(pageCode);
		//每页显示记录数
		noticeVo.setPageSize(10);
		//总记录数
		noticeVo.setTotalCount(noticeCount);
		
		int firstResult = (pageCode - 1)*noticeVo.getPageSize();
		int maxResults = noticeVo.getPageSize();
		List<Notice> noticelist = noticeService.findNotice(firstResult, maxResults);
		
		noticeVo.setNoticesList(noticelist);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		session.setAttribute("notice", noticeVo);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		List<Manager> list = managerService.managerlogin(managerVo);
		
		if(list == null || list.isEmpty()) {
			request.setAttribute("msg", "用户民或密码错误");
			
			return "login";
		}
		Manager manager = list.get(0);
//		HttpSession session = ServletActionContext.getRequest().getSession();
		
		session.setAttribute("manager", manager);
		
		return "index";
	}
	
	/**
	 * 修改密码
	 */
	public void updateManagerPassword() {
		//获取模型对象
		ManagerVo managerVo = this.getModel();
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Manager manager = (Manager) session.getAttribute("manager");
		String mid = manager.getMid();
		managerService.updateManagerPassword(managerVo,mid);
	}
	/**
	 * 管理员退出
	 */
	public String outManager() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("manager", null);
		return "login";
	}
}
