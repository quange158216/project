package cn.itcast.tpms.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.tpms.domain.Notice;
import cn.itcast.tpms.domain.Users;
import cn.itcast.tpms.pojo.NoticeVo;
import cn.itcast.tpms.pojo.UsersVo;
import cn.itcast.tpms.service.NoticeService;
import cn.itcast.tpms.service.UsersService;
import cn.itcast.tpms.utils.FastJsonUtil;

@Controller("usersAction")
@Scope("prototype")
public class UsersAction extends BaseAction<UsersVo>{

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private NoticeService noticeService;
	
	
	/**
	 * 管理员查询用户信息
	 */
	public void findUsers() {
		//获取模型对象
		UsersVo usersVo = this.getModel();
		//查询用户总记录数
		Long count = usersService.findUsersCount(usersVo);
		//获取页码信息
		int page = usersVo.getPage();
		int rows = usersVo.getRows();
		int firstResult = (page - 1) * rows;
		
		//查询用户信息
		List<Users> list = usersService.findUsers(usersVo, firstResult, rows);
		
		//将数据返回给用户
		Map<String, Object> map = new HashMap<>();
		map.put("total", count);
		map.put("rows", list);
		
		//map转json数据
		String jsonString = FastJsonUtil.toJSONString(map);
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonString);
	}
	
	public String userLogin() {
		
		//获取模型对象
		UsersVo usersVo = this.getModel();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Users> list = usersService.loginUser(usersVo);
		
		if(list == null || list.isEmpty()) {
			request.setAttribute("msg", "用户民或密码错误");
			
			return "login";
		}
		Users user = list.get(0);
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		session.setAttribute("user", user);
		
		return "index";
	}
	/**
	 * 用户注册
	 */
	public String  reguser() {
		//获取模型对象
		UsersVo usersVo = this.getModel();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			usersService.insertuser(usersVo);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "填写数据错误，请从新检查");
			
			return "reg";
		}
		
		return "success";
	}
	/**
	 * 修改密码
	 */
	public void updateUserPassword() {
		//获取模型对象
		UsersVo usersVo = this.getModel();
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users users = (Users) session.getAttribute("user");
		String uid = users.getUid();
		usersService.updateUserPasswor(usersVo,uid);
				
	}
	/**
	 * 用户退出
	 */
	public String outUser() {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", null);
		return "index";
	}
	
}
