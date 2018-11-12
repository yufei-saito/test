package yufei.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import yufei.crm.domain.Customer;
import yufei.crm.domain.Page;

public interface CustomerService {

	void save(Customer c);

	Page<Customer> findByPage(DetachedCriteria dc, Integer pageNum, Integer everyNum);

	Customer getById(Long cust_id);

	void delete(Customer customer);

	void update(Customer c);
	
	List<Customer> findAll(DetachedCriteria dc);

	

}
