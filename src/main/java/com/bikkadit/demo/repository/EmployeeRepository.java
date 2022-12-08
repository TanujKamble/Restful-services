package com.bikkadit.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadit.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
