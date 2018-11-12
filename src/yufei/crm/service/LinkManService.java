package yufei.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import yufei.crm.domain.LinkMan;
import yufei.crm.domain.Page;

public interface LinkManService {

	Page<LinkMan> findByPage(DetachedCriteria dc, Integer pageNum, Integer everyNum);
	void save(LinkMan l);
	LinkMan getById(Long id);
	void update(LinkMan l);
	void delete(LinkMan l);

}
