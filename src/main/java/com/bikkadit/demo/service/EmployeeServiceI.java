package com.bikkadit.demo.service;

import java.util.List;

import com.bikkadit.demo.entity.Employee;


public interface EmployeeServiceI {
	public Employee saveEmployee(Employee emp);
	
	public List<Employee> getAllEmployee();
	
	public List<Employee> saveAllEmployee(List<Employee> list);
	
	public Employee EmployeeByIdPathParam(int empId);
	
	public Employee getEmployeeRequestBody(Employee emp);

}
