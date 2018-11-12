package yufei.crm.web.action;



import java.io.File;
import java.io.IOException;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import yufei.crm.domain.Customer;
import yufei.crm.domain.Page;
import yufei.crm.service.CustomerService;
import yufei.crm.utils.UploadUtils;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer c = new Customer();
	private CustomerService cs ;
	private Integer pageNum = 1;
	private Integer everyNum = 3;
	private String uploadFileName;
	private File upload;
	private String uploadContentType;
	
	
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
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
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}
	@Override
	public Customer getModel() {
		return c;
	}
	
	public String saveUI() {
		
		return "saveUI";
	}
	
	
	public String save() throws IOException {
		if(upload!=null) {
			String fileName = UploadUtils.getUUIDName(uploadFileName);
			String index = UploadUtils.getPath();
			File path = new File("E:/upload",index);
			if(!path.exists()) {
				path.mkdirs();
			}
			String cust_image = "E://upload"+index+fileName;
			File file = new File(path,fileName);
			FileUtils.copyFile(upload, file);
			c.setCust_image(cust_image);
		}
		cs.save(c);
		return SUCCESS;
	}
	
	public String findByPage() {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//System.out.println(c);
		if(c.getCust_name()!=null&&!"".equals(c.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+c.getCust_name()+"%"));
			//System.out.println("c1");
		}
		if(c.getBd_source()!=null&&c.getBd_source().getDict_id()!=null&&!"".equals(c.getBd_source().getDict_id())) {
			dc.add(Restrictions.eq("bd_source.dict_id", c.getBd_source().getDict_id()));
			//System.out.println("c2");
		}
		if(c.getBd_level()!=null&&c.getBd_level().getDict_id()!=null&&!"".equals(c.getBd_level().getDict_id())) {
			dc.add(Restrictions.eq("bd_level.dict_id", c.getBd_level().getDict_id()));
			//System.out.println("c3");
		}
		if(c.getBd_industry()!=null&&c.getBd_industry().getDict_id()!=null&&!"".equals(c.getBd_industry().getDict_id())) {
			dc.add(Restrictions.eq("bd_industry.dict_id", c.getBd_industry().getDict_id()));
			//System.out.println("c4");
		}
		
		Page<Customer> p =cs.findByPage(dc,pageNum,everyNum);
		//System.out.println(p);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(p);
		return "list";
	}
	
	public String updateUI() {
		Customer customer =cs.getById(c.getCust_id());
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(customer);
		return "update";
	}
	
	public String delete() {
		Customer customer = cs.getById(c.getCust_id());
		if(customer!=null) {
			String cust_image = customer.getCust_image();
			if(cust_image!=null||!"".equals(cust_image)) {
				File file = new File(cust_image);
				if(file.exists()) {
					file.delete();
				}
			}
			cs.delete(customer);
		}
		return SUCCESS;
	}
	
	public String update() throws IOException {
		if(upload!=null) {
			String o_cust_image = c.getCust_image();
			File oldf = new File(o_cust_image);
			if(oldf.exists()) {
				oldf.delete();
			}
			String fileName = UploadUtils.getUUIDName(uploadFileName);
			String index = UploadUtils.getPath();
			File path = new File("E:/upload",index);
			if(!path.exists()) {
				path.mkdirs();
			}
			String cust_image = "E://upload"+index+fileName;
			File file = new File(path,fileName);
			FileUtils.copyFile(upload, file);
			c.setCust_image(cust_image);
		}
		cs.update(c);
		return SUCCESS;
	}
}
