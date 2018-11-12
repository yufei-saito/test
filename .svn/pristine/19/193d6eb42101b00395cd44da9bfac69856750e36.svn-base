package yufei.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import yufei.crm.dao.UserDao;
import yufei.crm.domain.User;
import yufei.crm.service.UserService;
import yufei.crm.utils.MD5Utils;

@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
	private UserDao dao;

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public void regist(User u) {
		u.setUser_state("1");
		u.setUser_password(MD5Utils.md5(u.getUser_password()));
		dao.regist(u);
	}

	@Override
	public User login(User u) {
		u.setUser_password(MD5Utils.md5(u.getUser_password()));
		User user = dao.login(u);
		return user;
	}
	
}
