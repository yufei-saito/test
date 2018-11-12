package yufei.crm.dao;

import java.util.List;

import yufei.crm.domain.BaseDict;

public interface BaseDictDao {

	List<BaseDict> findByType(String dict_type_code);

}
