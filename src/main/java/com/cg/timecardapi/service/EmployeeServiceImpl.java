package com.cg.timecardapi.service;

/**Author: Aswitha
Project Desc: Employee Service Implementation
Desc: Employee service Impl performing crud operations on Employee entity*/
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.timecardapi.exception.ResourceNotFoundException;
import com.cg.timecardapi.model.Employee;
import com.cg.timecardapi.model.Manager;
import com.cg.timecardapi.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	Logger log = Logger.getLogger(getClass());

	@Autowired
	private ManagerService manService;

	/**
	 * Create Employee under a Manager
	 * 
	 * @param ManagerId
	 *//*
		 * public Employee createEmployee(Employee employee) throws
		 * ResourceNotFoundException { Manager
		 * manager=manService.getManagerById(employee.getManager().getManagerId());
		 * manager.getEmps().add(employee);
		 * manService.updateManager(manager.getManagerId(),manager);
		 * log.info("employee with id "+employee.getEmployeeId()+" created"); return
		 * employeeRepository.save(employee); }
		 */
	/**
	 * Update an employee
	 * 
	 * @param EmployeeId
	 */
	public Employee updateEmployee(Integer employeeId, Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				"Updation not possible as employee not found for this id :: " + employeeId));
		employee.setEmployeeName(employeeDetails.getEmployeeName());
		employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
		employee.setPhoneNumber(employeeDetails.getPhoneNumber());
		final Employee updatedEmployee = employeeRepository.save(employee);
		log.info("employee id " + updatedEmployee.getEmployeeId() + " updated");
		return updatedEmployee;
	}

	/**
	 * delete employee from database
	 * 
	 * @param employeeId
	 */
	public boolean deleteEmployeeById(Integer employeeId) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		log.info("employee removed");
		return true;
	}

	/**
	 * Gives List of all employees
	 * 
	 */
	public List<Employee> getAllEmployee() {
		log.info("list of employees fetched");
		return employeeRepository.findAll();
	}

	/**
	 * Finds employee using employee ID
	 * 
	 * @param employeeId
	 */
	@Override
	public Employee getEmpById(int empId) throws ResourceNotFoundException {
		Employee emp = employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));
		log.info("employee fetched by Id " + empId);
		return emp;
	}

}
