package net.javaguides.ems.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//Build Add Employee REST API 
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeDto) {
		EmployeeDto savedEmployee = employeeService.createEmployee(employeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	//Build Get Employee REST API 
	@GetMapping("{id}")	
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")Long employeId){
		EmployeeDto employeeDto =  employeeService.getEMployeeById(employeId);
		
		return ResponseEntity.ok(employeeDto);
	}

	//Build Get All Employees REST API 
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	//Build Update Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId ,@RequestBody EmployeeDto updateEMployee){
		EmployeeDto employeeDto = employeeService.updaEmployee(employeeId, updateEMployee);
		return ResponseEntity.ok(employeeDto);
	}

	//Build Delete Employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee delete successfully! ");
	}
}
