package cn.itcast.tpms.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import cn.itcast.tpms.dao.UsersDao;
import cn.itcast.tpms.domain.Users;
import cn.itcast.tpms.pojo.UsersVo;

@Repository("usersDao")
public class UsersDaoImpl extends BaseDaoImpl<Users, String> implements UsersDao{

	
	/**
	 * 拼装条件
	 */
	private DetachedCriteria setDetachesCriteria(UsersVo usersVo,DetachedCriteria detachedCriteria) {
		if(usersVo != null) {
			if(StringUtils.isNotEmpty(usersVo.getUname()) && StringUtils.isNotEmpty(usersVo.getUpassword())) {
				detachedCriteria.add(Restrictions.eq("uname", usersVo.getUname()));
				detachedCriteria.add(Restrictions.eq("upassword", usersVo.getUpassword()));
			}
		}
		return detachedCriteria;
	}
	
	/**
	 * 查询用户总数
	 */
	@Override
	public Long findUsersCount(UsersVo usersVo) {
		//获取拼装条件对象
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		//拼装条件
		this.setDetachesCriteria(usersVo, detachedCriteria);
		//设置投影列
		detachedCriteria.setProjection(Projections.rowCount());
		//查询
		List<?> list = this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long count = (Long) list.get(0);
		return count;
	}

	/**
	 * 查询用户详细信息
	 */
	@Override
	public List<Users> findUsers(UsersVo usersVo, int firstResult, int maxResults) {
		//获取拼装条件对象
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		//拼装条件
		this.setDetachesCriteria(usersVo, detachedCriteria);
		//查询
		return (List<Users>) this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
	}

	/**
	 * 用户登录
	 */
	
	@Override
	public List<Users> findUser(UsersVo usersVo) {
		//获取拼装条件对象
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		//拼装条件
		this.setDetachesCriteria(usersVo, detachedCriteria);
		//查询
		
		List<Users> list = (List<Users>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		
		return list;
	}

}
