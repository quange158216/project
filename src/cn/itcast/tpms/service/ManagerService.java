package cn.itcast.tpms.service;

import java.util.List;

import cn.itcast.tpms.domain.Manager;
import cn.itcast.tpms.pojo.ManagerVo;

public interface ManagerService {
	//管理员登陆
	public List<Manager> managerlogin(ManagerVo managerVo);
	//修改用户密码
	public void updateManagerPassword(ManagerVo managerVo, String mid);
}
