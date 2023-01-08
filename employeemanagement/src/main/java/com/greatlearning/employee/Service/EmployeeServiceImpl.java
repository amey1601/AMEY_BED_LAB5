package com.greatlearning.employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.model.Employee;
import com.greatlearning.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repository;
	

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void saveOrUpdate(Employee emp) {
		// TODO Auto-generated method stub
		repository.save(emp);
		
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee emp=getEmployeeById(id);
		repository.delete(emp);;
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

}
