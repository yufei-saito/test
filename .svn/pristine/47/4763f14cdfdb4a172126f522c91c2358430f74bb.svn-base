package yufei.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import yufei.crm.dao.UserDao;
import yufei.crm.domain.User;

public class UserDaoImpl  extends BaseDaoImpl<User> implements UserDao {

	@Override
	public void regist(User u) {
		this.getHibernateTemplate().save(u);
	}

	@Override
	public User login(User u) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password=?",u.getUser_code(),u.getUser_password());
		if(list.size()==0) {
			return null;
		}else {
			return list.get(0);
		}
	}
	
}
