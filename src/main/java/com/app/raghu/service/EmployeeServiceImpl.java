package com.app.raghu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.raghu.EmployeeUtil;
import com.app.raghu.entity.Employee;
import com.app.raghu.exception.EmployeeNotFoundException;
import com.app.raghu.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService 
{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//@Autowired
	//private EmployeeUtil util;
	
	@Override
	public Integer saveEmployee(Employee e) 
	{
		//util.commonCal();
		EmployeeUtil.commonCal(e);
		e=employeeRepository.save(e);
		return e.getEmpId();
	}

	@Override
	public void updateEmployee(Employee e) 
	{
		//util.commonCal();
		EmployeeUtil.commonCal(e);
		employeeRepository.save(e);
	}

	@Override
	public void deleteEmployee(Integer id) 
	{
		//employeeRepository.deleteById(id);
		
		/*
		Optional<Employee> opt = employeeRepository.findById(id);
		if(opt.isPresent())
		{
			employeeRepository.delete(opt.get());
		}
		else
		{
			throw new EmployeeNotFoundException("EMPLOYEE '"+id+"' NOT FOUND");
		}
		*/
		
		employeeRepository.delete(
				employeeRepository.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException("EMPLOYEE '"+id+"' NOT FOUND"))
				);
	}

	@Override
	public Employee getOneEmployee(Integer id) 
	{
		/*Optional<Employee> employee = employeeRepository.findById(id);
		return employee.get();*/
		return employeeRepository.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException("EMPLOYEE '"+id+"' NOT FOUND"));
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		List<Employee> list = employeeRepository.findAll();
		return list;
	}

	//get all employees using pagination
	@Override
	public Page<Employee> getAllEmployees(Pageable pageable) 
	{
		Page<Employee> pages = employeeRepository.findAll(pageable);
		return pages;
	}
}
