package com.cms.service.wuliu;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.cms.dao.wuliu.EmployeeDao;
import com.cms.iservice.wuliu.WuliuTest;
import com.cms.model.Employee;



public class WuliuTestImp implements WuliuTest{
	
	private static Logger logger = LoggerFactory.getLogger(WuliuTestImp.class);
	
	@Autowired
	private EmployeeDao employeeDao;
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	public Employee sayHello(String name){
		List<Employee> l=employeeDao.getAllEmployee();
		logger.info("the get dao name------");
		for(Employee e:l){
			//System.out.println("the get dao name------"+e.getName());
			logger.info("the get dao name------{}",e.getName());
		}
		
		Employee u=new Employee();
		Long id=1200L;
		u.setId(id);
		u.setName(name);
		u.setSharding_id(id);
		return u;
	}
	
	public void insertEmployee(Employee e){
		employeeDao.insertEmployee(e);
	}

}
