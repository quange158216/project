package cn.itcast.tpms.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.tpms.dao.BaseDao;

public class BaseDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport implements BaseDao<T, PK>{
	
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		//获取父类类型
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		//判断父类是否有泛型
		if(genericSuperclass instanceof ParameterizedType) {
			//将父类类型转为泛型（参数化类型）
			ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
			//获取参数
			Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
			Type type = actualTypeArguments[0];
			entityClass = (Class<T>) type;
		}
	}
	//将hibernateTemplate注入给父类setHibernatetemplate方法
	@Autowired
	public void setHt(HibernateTemplate hibernateTemplate){
		this.setHibernateTemplate(hibernateTemplate);
	}

	@Override
	public T findById(PK id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public void insert(T entity) {
		this.getHibernateTemplate().save(entity);
		
	}
	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
		
	}
	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
		
	}
	@Override
	public void deleteById(PK id) {

		T entity = findById(id);
		if(entity!=null) {
			this.getHibernateTemplate().delete(entity);
		}
		
	}
	@Override
	public DetachedCriteria getDetachedCriteria() {
		return DetachedCriteria.forClass(entityClass);
	}

}
