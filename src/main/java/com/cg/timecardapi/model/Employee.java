package com.cg.timecardapi.model;



/**Author: Aswitha
 * Project Desc: Time Card Service
 * Class Desc: Employee Entity describing all attributes related to employee**/

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.catalina.Manager;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**creating table with name employees*/
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="EMP_ID")	
	protected int employeeId;
	@Column(name="EMP_NAME")
	protected String employeeName;
	@Column(name="EMP_ROLE")
	protected String employeeRole;
	@Column(name="EMP_PHNO")
	protected String phoneNumber;
	@Column(name="EMP_EMAIL")
	protected String employeeEmail;
	
	/**cardinality that give relationship between two entities
	 * One Manager Can Handle Many Employees
	 */
	@ManyToOne
	@JoinColumn(name="MANAGER_ID")
	@JsonBackReference
	protected Manager manager;
	
	/**This constructor initialize data members with the values of passed arguments while object of that class created
	 * 
	 * @param employeeId
	 * @param employeeName
	 * @param phoneNumber
	 * @param employeeEmail
	 * @param manager
	 */
	public Employee(int employeeId, String employeeName, String phoneNumber, String employeeEmail, Manager manager) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
		this.employeeEmail = employeeEmail;
		this.manager = manager;
	}
	
	/**no-argument constructor
	 */
	public Employee() {
		super();
	}
	
	/**Create getters and setter methods  
	  * @return
	  */
	public int getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return this.employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeRole() {
		return this.employeeRole;
	}
	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
		public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	
	public Manager getManager() {
		return manager; 
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	/**toString Method
	 * return
	 */
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeRole="
				+ employeeRole + ", phoneNumber=" + phoneNumber + ", employeeEmail=" + employeeEmail + "]";
	}
	
	
	
}
