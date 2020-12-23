package com.cg.timecardapi.controller;

/**Author: Aswitha
Project Desc: Time Card Service
Desc: Employee Controller responsible for accessing data from data base**/
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.cg.timecardapi.exception.ResourceNotFoundException;
import com.cg.timecardapi.model.Employee;
import com.cg.timecardapi.model.Manager;
import com.cg.timecardapi.service.EmployeeService;
import com.cg.timecardapi.service.ManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(value = "EmployeeControllerClass")
@RestController
@RequestMapping("/api/v2/employees")
public class EmployeeController {

	Logger log = Logger.getLogger(getClass());

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ManagerService manServ;

	/**
	 * Display list of employees using GET method
	 * 
	 * @return
	 */
	@GetMapping("/all")
	@ApiOperation(value = "get all employees ", response = Iterable.class, tags = "EmployeeControllerClass")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	/**
	 * Insert details of employee using POST method
	 * 
	 * @param employee
	 * @param managerId
	 * @return
	 * @throws ResourceNotFoundException
	 *//*
		 * @PostMapping("/CreateEmployee/{manager_id}")
		 * 
		 * @ApiOperation(value = "save employee ", response = Employee.class, tags =
		 * "EmployeeControllerClass") public ResponseEntity<Employee>
		 * createEmployee( @RequestBody Employee employee,@PathVariable("manager_id")
		 * Integer managerId) throws ResourceNotFoundException { Manager
		 * man=manServ.getManagerById(managerId); if(man!=null)
		 * employee.setManager(man); else { log.warn(man+" is null"); }
		 * log.info("created employee"); return
		 * ResponseEntity.ok(employeeService.createEmployee(employee)); }
		 */

	/**
	 * Update employee details using PUT method
	 * 
	 * @param employeeId
	 * @param employeeDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/{id}")
	@ApiOperation(value = "update employee details ", response = Employee.class, tags = "EmployeeControllerClass")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
			@RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeService.updateEmployee(employeeId, employeeDetails);
		log.info("updated employee");
		return ResponseEntity.ok(employee);
	}

	/**
	 * Delete employee details using DELETE method
	 * 
	 * @param employeeId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/deleteEmployee/{id}")
	@ApiOperation(value = "update employee details", response = Employee.class, tags = "EmployeeControllerClass")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(value = "id") Integer employeeId)
			throws ResourceNotFoundException {
		log.info("deleted employee");
		return ResponseEntity.ok(employeeService.deleteEmployeeById(employeeId));
	}

	/**
	 * display employee details by GET method
	 * 
	 * @param empId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/getById/{id}")
	@ApiOperation(value = "fetch employee by id", response = Employee.class, tags = "EmployeeControllerClass")
	public Employee getEmployeeById(@PathVariable(value = "id") String empId) throws ResourceNotFoundException {
		log.info("fetched employee with id " + empId);
		return employeeService.getEmpById(Integer.parseInt(empId));
	}
}
