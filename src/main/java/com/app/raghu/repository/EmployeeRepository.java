package com.app.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
