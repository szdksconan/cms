package com.cms.dao.wuliu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.wuliu.TestMapper;
import com.cms.model.wuliu.Test;
@Component
public class TestDaoImp implements TestDao{
	
	@Autowired
	private TestMapper testMapper;
	
	public void deleteTest(Test test){
		testMapper.deleteTest(test);
	}

}
