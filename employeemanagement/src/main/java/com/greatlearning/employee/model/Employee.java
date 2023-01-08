package com.greatlearning.employee.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id; 
import javax.persistence.Column; 
import javax.persistence.Table;
import lombok.Data;


import lombok.AccessLevel;
import lombok.Setter;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="employees")
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int id;
	
	@Column(name="emp_first_name")
	private String firstName;
	
	@Column(name="emp_last_name")
	private String lastName;
	
	@Column(name="emp_email")
	private String email;
	
	
	

}
