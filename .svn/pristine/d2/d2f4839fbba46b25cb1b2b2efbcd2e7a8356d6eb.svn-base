package yufei.crm.web.action;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import yufei.crm.domain.BaseDict;
import yufei.crm.service.BaseDictService;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict>{
	private BaseDict bd =new BaseDict();
	private BaseDictService bs;
	
	public void setBs(BaseDictService bs) {
		this.bs = bs;
	}

	@Override
	public BaseDict getModel() {
		
		return bd;
	}
	
	public String findByType() throws IOException {
		List<BaseDict> list =bs.findByType(bd.getDict_type_code());
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(json.toString());
		return NONE;
	}

}
