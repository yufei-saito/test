package yufei.crm.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import yufei.crm.domain.User;
import yufei.crm.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User u = new User();
	private UserService us;
	
	public void setUs(UserService us) {
		this.us = us;
	}
	@Override
	public User getModel() {
		
		return u;
	}
	
	public String regist() {
		us.regist(u);
		return "login";
	}
	
	public String login() {
		User user = us.login(u);
		
		if(user==null) {
			this.addActionError("你输入的用户名或密码有误");
			return "login";
		}else {
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "main";
		}
		
	}
	
	

}
