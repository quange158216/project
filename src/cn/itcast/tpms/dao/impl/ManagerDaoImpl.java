package cn.itcast.tpms.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.itcast.tpms.dao.ManagerDao;
import cn.itcast.tpms.domain.Manager;
import cn.itcast.tpms.pojo.ManagerVo;
import cn.itcast.tpms.pojo.UsersVo;

@Repository("managerDao")
public class ManagerDaoImpl extends BaseDaoImpl<Manager, String> implements ManagerDao{

	

	/**
	 * 拼装条件
	 */
	private DetachedCriteria setDetachesCriteria(ManagerVo managerVo,DetachedCriteria detachedCriteria) {
		
		detachedCriteria.add(Restrictions.eq("mname", managerVo.getMname()));
		detachedCriteria.add(Restrictions.eq("mpassword", managerVo.getMpassword()));
		
		return detachedCriteria;
	}
	/**
	 * 管理员登陆
	 */
	@Override
	public List<Manager> findMannager(ManagerVo managerVo) {
		//获取拼装条件对象
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		//拼装条件
		this.setDetachesCriteria(managerVo, detachedCriteria);
		//查询
		List<Manager> list = (List<Manager>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		return list;
	}

}
