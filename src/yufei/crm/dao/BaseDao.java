package yufei.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T>{
	void save(T t);
	void delete(T t);
	void update(T t);
	T getById(Long id);
	Integer findTotalCount(DetachedCriteria dc);
	List<T> findByPage(DetachedCriteria dc,Integer pageNum, Integer everyNum);
	List<T> findAll(DetachedCriteria dc);
	
}
