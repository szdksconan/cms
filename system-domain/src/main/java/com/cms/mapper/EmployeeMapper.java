package com.cms.mapper;

import java.util.List;

import com.cms.model.Employee;

public interface EmployeeMapper {
	
	public List<Employee> selectAllUsers();
	public void insertEmployee(Employee e);
}
