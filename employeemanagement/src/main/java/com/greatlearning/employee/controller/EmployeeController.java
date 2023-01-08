package com.greatlearning.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import javax.websocket.server.PathParam;

import com.greatlearning.employee.Service.EmployeeService;
import com.greatlearning.employee.model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/employees")
	public String getAllEmployees(Model model) {
		List<Employee> result= service.getAllEmployee();
		model.addAttribute("employees",result);
		return "employees";
		
	}
	@GetMapping("/employees/new")
	public String addNewEmployee(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		return "create_employee";
		
		
	}
	@GetMapping("/employees/edit/{id}")
	public String updateEmployee(Model model,@PathVariable("id") int id) {
		Employee emp = service.getEmployeeById(id);
		model.addAttribute("employee",emp);
		return "edit_employee";
		
		
	}
	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		
		service.deleteEmployeeById(id);
		return "redirect:/employees";
		
		
	}
	@PostMapping("/employees")
	public String addEmployee(@ModelAttribute(name="employee") Employee emp) {
		service.saveOrUpdate(emp);
		return "redirect:/employees";
		
	}
	@PostMapping("/employees/{id}")
	public String updateEmployee(@ModelAttribute(name="employee") Employee emp,@PathVariable("id") int id) {
		Employee existingemp= service.getEmployeeById(id);
		if(existingemp.getId()== emp.getId()) {
			existingemp.setFirstName(emp.getFirstName());
			existingemp.setLastName(emp.getLastName());
			existingemp.setEmail(emp.getEmail());
			
		}
		service.saveOrUpdate(existingemp);
		return "redirect:/employees";
		
	}
	
	
	
	
	
	
	
	
	

}
