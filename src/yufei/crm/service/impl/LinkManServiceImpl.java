package yufei.crm.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import yufei.crm.dao.LinkManDao;
import yufei.crm.domain.LinkMan;
import yufei.crm.domain.Page;
import yufei.crm.service.LinkManService;
@Transactional
public class LinkManServiceImpl implements LinkManService {
	private LinkManDao dao;

	public void setDao(LinkManDao dao) {
		this.dao = dao;
	}

	@Override
	public Page<LinkMan> findByPage(DetachedCriteria dc, Integer pageNum, Integer everyNum) {
		Page<LinkMan> p = new Page<LinkMan>();
		p.setPageNum(pageNum);
		p.setEveryNum(everyNum);
		Integer totalCount =dao.findTotalCount(dc);
		p.setTotalCount(totalCount);
		p.setMaxPage((int)Math.ceil(totalCount*1.0/everyNum));
		p.setList(dao.findByPage(dc,pageNum,everyNum));
		
		return p;
	}

	@Override
	public void save(LinkMan l) {
		dao.save(l);
	}

	@Override
	public LinkMan getById(Long id) {
		LinkMan lk = dao.getById(id);
		return lk;
	}

	@Override
	public void update(LinkMan l) {
		dao.update(l);
	}

	@Override
	public void delete(LinkMan l) {
		dao.delete(l);
	}
	
}
