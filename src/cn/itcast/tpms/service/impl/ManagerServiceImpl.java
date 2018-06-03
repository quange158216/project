package cn.itcast.tpms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.tpms.dao.ManagerDao;
import cn.itcast.tpms.domain.Manager;
import cn.itcast.tpms.pojo.ManagerVo;
import cn.itcast.tpms.service.ManagerService;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDao managerDao;
	/**
	 * 管理员登陆
	 */
	@Override
	public List<Manager> managerlogin(ManagerVo managerVo) {
		return managerDao.findMannager(managerVo);
	}
	@Override
	public void updateManagerPassword(ManagerVo managerVo, String mid) {
		Manager manager = managerDao.findById(mid);
		
		String mpassword = managerVo.getMpassword();
		
		manager.setMpassword(mpassword);
		
		
	}

}
