package yufei.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import yufei.crm.dao.BaseDictDao;
import yufei.crm.domain.BaseDict;
import yufei.crm.service.BaseDictService;

@Transactional
public class BaseDictServiceImpl implements BaseDictService {
	private BaseDictDao dao;

	public void setDao(BaseDictDao dao) {
		this.dao = dao;
	}

	@Override
	public List<BaseDict> findByType(String dict_type_code) {
		return dao.findByType(dict_type_code);
	}
	
}
