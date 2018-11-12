package yufei.crm.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import yufei.crm.domain.User;

public class LoginInter extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation aiv) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		if(user==null) {
			ActionSupport as = (ActionSupport) aiv.getAction();
			as.addActionError("请先登录后再操作!");
			return as.LOGIN;
		}
		return aiv.invoke();
	}

}
