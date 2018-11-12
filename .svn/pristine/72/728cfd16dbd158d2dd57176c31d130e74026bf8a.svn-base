package yufei.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import yufei.crm.dao.CustomerDao;
import yufei.crm.domain.Customer;
import yufei.crm.domain.Page;
import yufei.crm.service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao dao;

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Customer c) {
		dao.save(c);
	}

	@Override
	public Page<Customer> findByPage(DetachedCriteria dc, Integer pageNum, Integer everyNum) {
		Page<Customer> p = new Page<Customer>();
		p.setPageNum(pageNum);
		p.setEveryNum(everyNum);
		Integer totalCount =dao.findTotalCount(dc);;
		p.setTotalCount(totalCount);
		p.setMaxPage((int)(Math.ceil(totalCount*1.0/everyNum)));
		p.setList(dao.findByPage(dc,pageNum,everyNum));
		return p;
	}

	@Override
	public Customer getById(Long cust_id) {
		return dao.getById(cust_id);
	}

	@Override
	public void delete(Customer customer) {
		dao.delete(customer);
		
	}

	@Override
	public void update(Customer c) {
		dao.update(c);
	}

	@Override
	public List<Customer> findAll(DetachedCriteria dc) {
		return dao.findAll(dc);
	}
	
	
}
