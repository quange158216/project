package cn.itcast.tpms.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.itcast.tpms.dao.DetialCatDao;
import cn.itcast.tpms.domain.DetialCat;
import cn.itcast.tpms.pojo.DetialCatVo;

@Repository("detialCatDao")
public class DetialCatDaoImpl extends BaseDaoImpl<DetialCat, String> implements DetialCatDao{

	//条件拼装
	private DetachedCriteria setDetachedCriteria(DetachedCriteria detachedCriteria,DetialCatVo detialCatVo) {
		if(detialCatVo !=null) {
			if(detialCatVo.getUsers()!=null) {
				if(StringUtils.isNotEmpty(detialCatVo.getUsers().getUid())) {
					detachedCriteria.add(Restrictions.eq("users.uid", detialCatVo.getUsers().getUid()));
					//detachedCriteria.add(Restrictions.eq("dcolor", "白色"));
//					String[] pai = new String[] {"白色","红色"};
//					detachedCriteria.add(Restrictions.in("dcolor", pai));
					
				}
			}
		}
		return detachedCriteria;
	}
	
	//查询车辆总记录数
	@Override
	public Long findDetialCatCount(DetialCatVo detialCatVo) {
		//获取拼装查询条件对象
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		//拚条件
		this.setDetachedCriteria(detachedCriteria, detialCatVo);
		//设置投影列
		detachedCriteria.setProjection(Projections.rowCount());
		
/*		DetialCat example = new DetialCat();
		example.setDlicensePlateNumber("皖A-88888");
		List<DetialCat> list2 = this.getHibernateTemplate().findByExample(example);
		
		System.out.println(list2);*/
		DetialCat detialCat = this.getHibernateTemplate().get(DetialCat.class, "皖A-88888");
		//查询
		List<?> list = this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long count = (Long) list.get(0);
		return count;
	}

	
	//查询车辆全部信息
	@Override
	public List<DetialCat> findDetialCatByUid(DetialCatVo detialCatVo, int firstResult, int maxResults) {
		//获取拼装查询条件对象
		DetachedCriteria detachedCriteria = this.getDetachedCriteria();
		//拚条件
		this.setDetachedCriteria(detachedCriteria, detialCatVo);
		//查询
		List<DetialCat> list = (List<DetialCat>) this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		return list;
	}


}
