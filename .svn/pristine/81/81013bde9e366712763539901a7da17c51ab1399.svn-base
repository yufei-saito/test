package yufei.crm.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


import yufei.crm.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;
	
	public BaseDaoImpl() {
		Class  c = this.getClass();
		ParameterizedType pt =(ParameterizedType) c.getGenericSuperclass();
		Type[] types = pt.getActualTypeArguments();
		this.clazz = (Class) types[0];
	};
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
		
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
		
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
		
	}

	@Override
	public T getById(Long id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer findTotalCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		if(list.size()>0) {
			return list.get(0).intValue();
		}
		return null;
	}

	@Override
	public List<T> findByPage(DetachedCriteria dc, Integer pageNum, Integer everyNum) {
		dc.setProjection(null);
		List<T> list = (List<T>) this.getHibernateTemplate().findByCriteria(dc, (pageNum-1)*everyNum, everyNum);
		return list;
	}
	@Override
	public List<T> findAll(DetachedCriteria dc) {
		dc.setProjection(null);
		return (List<T>) this.getHibernateTemplate().findByCriteria(dc);
		
		
	}

}
