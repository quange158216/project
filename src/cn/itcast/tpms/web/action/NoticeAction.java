package cn.itcast.tpms.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.tpms.domain.Notice;
import cn.itcast.tpms.pojo.NoticeVo;
import cn.itcast.tpms.pojo.UsersVo;
import cn.itcast.tpms.service.NoticeService;

@Controller("noticeAction")
@Scope("prototype")
public class NoticeAction extends BaseAction<NoticeVo>{

	@Autowired
	private NoticeService noticeService;
	
	/**
	 * 普通用户首页跳转
	 */
	public String list() {
		NoticeVo noticeVo = this.getModel();
	
		int ut = noticeVo.getUt();
		int pageCode = noticeVo.getPc();
		int manager = noticeVo.getManager();
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
		List<Notice> list = noticeService.findNotice(firstResult, maxResults);
		
		noticeVo.setNoticesList(list);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		session.setAttribute("notice", noticeVo);
		if(ut ==1) {
			return "showUserMain";
		}else if(ut == 2){
			return "showTrafficMain";
		}else if(manager == 1){
			return "adminNotice";
		}else {
			return "notice";
		}
		
	}
	/**
	 * 查询公告详情
	 * @return
	 */
	public String  findNoticeById() {
		NoticeVo noticeVo = this.getModel();
	
		String nid = noticeVo.getNid();
		
		
		Notice notice = noticeService.findNoticeById(nid);
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("noticeone", notice);
		
		return "detialNotice";
		
	}
	/**
	 * 添加公告
	 */
	public String addNotice() {
		NoticeVo noticeVo = this.getModel();
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			noticeService.insertNotice(noticeVo);
			
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
			List<Notice> list = noticeService.findNotice(firstResult, maxResults);
			
			noticeVo.setNoticesList(list);
			
			HttpSession session = ServletActionContext.getRequest().getSession();
			
			session.setAttribute("notice", noticeVo);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "添加公告失败");
			return "addResult";
		}
		request.setAttribute("msg", "添加公告成功");
		return "addResult";
	}
	/**
	 * 删除公告
	 */
	public String deleteNotice() {
		NoticeVo noticeVo = this.getModel();
		
		String nid = noticeVo.getNid();
		
		noticeService.deleteNotice(nid);
		
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
		List<Notice> list = noticeService.findNotice(firstResult, maxResults);
		
		noticeVo.setNoticesList(list);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		session.setAttribute("notice", noticeVo);
		
		return "adminNotice";
	}
}
