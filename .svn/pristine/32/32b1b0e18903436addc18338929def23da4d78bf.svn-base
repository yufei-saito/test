package yufei.crm.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import yufei.crm.domain.Customer;
import yufei.crm.domain.LinkMan;
import yufei.crm.domain.Page;
import yufei.crm.service.CustomerService;
import yufei.crm.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkMan lk = new LinkMan();
	private LinkManService ls;
	private CustomerService cs;
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	private Integer pageNum =1;
	private Integer everyNum =3;
	
	
	public void setPageNum(Integer pageNum) {
		if(pageNum!=null) {
		this.pageNum = pageNum;
		}
	}

	public void setEveryNum(Integer everyNum) {
		if(everyNum!=null) {
		this.everyNum = everyNum;
		}
	}

	public void setLs(LinkManService ls) {
		this.ls = ls;
	}

	@Override
	public LinkMan getModel() {
		return lk;
	}
	
	
	public String saveUI() {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = cs.findAll(dc);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("list", list);
		return "saveUI";
	}
	
	public String findByPage() {
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		DetachedCriteria dc2 = DetachedCriteria.forClass(Customer.class);
		List<Customer> custs = cs.findAll(dc2);
		if(lk.getLkm_name()!=null&&!"".equals(lk.getLkm_name())) {
			dc.add(Restrictions.like("lkm_name", "%"+lk.getLkm_name()+"%"));
		}
		if(lk.getLkm_gender()!=null&&!"".equals(lk.getLkm_gender())) {
			dc.add(Restrictions.eq("lkm_gender", lk.getLkm_gender()));
		}
		if(lk.getC()!=null&&lk.getC().getCust_id()!=null&&!"".equals(lk.getC().getCust_id()+"")) {
			dc.add(Restrictions.eq("c.cust_id", lk.getC().getCust_id()));
		}
		Page<LinkMan> p = ls.findByPage(dc,pageNum,everyNum);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("custs", custs);
		vs.push(p);
		
		return "list";
	}
	
	public String save() {
		ls.save(lk);
		return SUCCESS;
	}
	
	public String updateUI() {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = cs.findAll(dc);
		LinkMan lkm = ls.getById(lk.getLkm_id());
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(lkm);
		vs.set("list", list);
		return "update";
	}
	
	public String update() {
		ls.update(lk);
		return SUCCESS;
	}
	
	public String delete() {
		LinkMan lkm = ls.getById(lk.getLkm_id());
		ls.delete(lkm);
		return SUCCESS;
	}
}
