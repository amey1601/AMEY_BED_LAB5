package com.greatlearning.employee.Service;

import java.util.List;
import com.greatlearning.employee.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	public void saveOrUpdate(Employee emp);
	public void deleteEmployeeById(int id);
	public Employee getEmployeeById(int id);
	
}
