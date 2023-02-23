package com.app.raghu;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;

import com.app.raghu.entity.Employee;

//@Component
//public class EmployeeUtil{
public interface EmployeeUtil 
{
	public static void commonCal(Employee e)
	{
		double hra=e.getEmpSal()*(12.0/100);
		double ta=e.getEmpSal()*(4.0/100);
		e.setEmpHra(hra);
		e.setEmpTa(ta);
	}
	
	public static void createDeptList(Model model) {
		List<String> list = Arrays.asList("DEV","QA","BA","ADMIN","IT");
		model.addAttribute("deptList", list);
	}
	
}
