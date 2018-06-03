package cn.itcast.tpms.dao;

import java.util.List;

import cn.itcast.tpms.domain.Manager;
import cn.itcast.tpms.pojo.ManagerVo;

public interface ManagerDao extends BaseDao<Manager, String>{
	//管理员登陆
	public List<Manager> findMannager(ManagerVo managerVo);
}
