package com.cms.dao.wuliu;

import java.util.List;

import com.cms.model.Employee;

public interface EmployeeDao {
  public List<Employee> getAllEmployee();
  public void insertEmployee(Employee e);
}
