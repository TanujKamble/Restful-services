package com.bikkadit.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.demo.entity.Employee;
import com.bikkadit.demo.service.EmployeeServiceI;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	@PostMapping(value = "/saveEmployee", consumes = {"application/xml","application/json"},produces = {"application/xml","application/json"})
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		Employee employee = employeeServiceI.saveEmployee(emp);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);		
	}	
		

	@GetMapping(value = "/getAllEmployee", produces = { "application/json", "application/xml" })	
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> allEmployee = employeeServiceI.getAllEmployee();

		return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
	}
	
	@PostMapping(value="/saveAllEmployee",consumes = {"application/xml","application/json"},produces = {"application/xml","application/json"} )
	public ResponseEntity<List<Employee>> saveAllEmployee(@RequestBody List<Employee> list){
		List<Employee> saveAllEmployee = employeeServiceI.saveAllEmployee(list);
		return new ResponseEntity<List<Employee>>(saveAllEmployee,HttpStatus.OK);
		
	}
	@GetMapping(value = "/EmployeeById/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Employee> EmployeeByIdPathParam(@PathVariable int id){
		Employee employeeByIdPathParam = employeeServiceI.EmployeeByIdPathParam(id);
		return new ResponseEntity<Employee>(employeeByIdPathParam,HttpStatus.OK);}
	
	
	@GetMapping(value="/getEmployeeIdRequestBody",produces = {"application/json"})
	public ResponseEntity<Employee>  getEmployeeIdRequestBody(@RequestBody Employee emp){
		
		System.out.println(emp);
		Employee employee = employeeServiceI.getEmployeeRequestBody(emp);
		
		return new  ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
	

}
