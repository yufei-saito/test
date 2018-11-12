package yufei.crm.domain;

import java.util.HashSet;
import java.util.Set;

/*
 *`cust_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
  `cust_name` VARCHAR(32) NOT NULL COMMENT '客户名称(公司名称)',
  `cust_source` VARCHAR(32) DEFAULT NULL COMMENT '客户信息来源',
  `cust_industry` VARCHAR(32) DEFAULT NULL COMMENT '客户所属行业',
  `cust_level` VARCHAR(32) DEFAULT NULL COMMENT '客户级别',
  `cust_phone` VARCHAR(64) DEFAULT NULL COMMENT '固定电话',
  `cust_mobile` VARCHAR(16) DEFAULT NULL COMMENT '移动电话',
  PRIMARY KEY (`cust_id`),
  FOREIGN KEY (`cust_source`) REFERENCES  `base_dict`(`dict_id`),
  FOREIGN KEY (`cust_industry`) REFERENCES  `base_dict`(`dict_id`),
  FOREIGN KEY (`cust_level`) REFERENCES  `base_dict`(`dict_id`)
 * */



public class Customer {
	private Long cust_id;
	private String cust_name;
	private String cust_phone;
	private String cust_mobile;
	private BaseDict bd_source;
	private BaseDict bd_industry;
	private BaseDict bd_level;
	private String cust_image;
	private Set<LinkMan> linkMans =  new HashSet<LinkMan>();
	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}
	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}
	public String getCust_image() {
		return cust_image;
	}
	public void setCust_image(String cust_image) {
		this.cust_image = cust_image;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public BaseDict getBd_source() {
		return bd_source;
	}
	public void setBd_source(BaseDict bd_source) {
		this.bd_source = bd_source;
	}
	public BaseDict getBd_industry() {
		return bd_industry;
	}
	public void setBd_industry(BaseDict bd_industry) {
		this.bd_industry = bd_industry;
	}
	public BaseDict getBd_level() {
		return bd_level;
	}
	public void setBd_level(BaseDict bd_level) {
		this.bd_level = bd_level;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_phone=" + cust_phone
				+ ", cust_mobile=" + cust_mobile + ", bd_source=" + bd_source + ", bd_industry=" + bd_industry
				+ ", bd_level=" + bd_level + ", cust_image=" + cust_image + "]";
	}
	
}
