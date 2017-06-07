package com.cms.dao.wuliu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.EmployeeMapper;
import com.cms.model.Employee;
@Component
public class EmployeeDaoImp implements EmployeeDao{
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}

	public void setEmployeeMapper(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

	public List<Employee> getAllEmployee(){
		return employeeMapper.selectAllUsers();
	}
	
	public void insertEmployee(Employee e){
		employeeMapper.insertEmployee(e);
	}

}
