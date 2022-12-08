package com.bikkadit.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bikkadit.demo.entity.Employee;
import com.bikkadit.demo.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeServiceI  {

	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
    public Employee saveEmployee(Employee emp) {
	Employee save = employeeRepository.save(emp);
	return save;
}


	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();
		return findAll;
	}


	@Override
	public List<Employee> saveAllEmployee(List<Employee> list) {
		List<Employee> saveAll = employeeRepository.saveAll(list);
		return saveAll;
	}


	@Override
	public Employee EmployeeByIdPathParam(int empId) {
		Employee findById = employeeRepository.findById(empId).get();
		return findById;
	}


	@Override
	public Employee getEmployeeRequestBody(Employee emp) {
		int empId = emp.getEmpId();
		
		Employee emp1 = employeeRepository.findById(empId).get();
		return emp1;
	}

}
