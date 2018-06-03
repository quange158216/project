package cn.itcast.tpms.dao;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T,PK> {
	//创建封装条件对象
	public DetachedCriteria getDetachedCriteria();
	//根据id查询
	public T findById(PK i);
	//添加
	public void insert(T entity);
	//更新
	public void update(T entity);
	//删除
	public void delete(T entity);
	//根据主键删除
	public void deleteById(PK id);
}
