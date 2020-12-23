package com.cg.timecardapi.model;



/**Author: Aswitha
 * Project Desc: Time Card Service
 * Class Desc: Manager Entity describing all attributes related to manager**/
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**creating table with name manager*/
@Entity
@Table(name="MANAGER")
public class Manager implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="MANAGER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int managerId;
	
	/**cardinality that give relationship between two entities
	 * One Manager Can Handle Many Employees
	 */
	@OneToMany(mappedBy = "manager",cascade = CascadeType.ALL)
	@JsonManagedReference
	@Column(name="EMP_ID")
	protected Set<Employee> emps;
	@Column(name="MANAGER_NAME")
	protected String managerName;
	@Column(name="MANAGER_PHNO")
	protected String managerNumber;
	@Column(name="MANAGER_EMAIL")
	protected String managerEmail;
	
	
	/**This constructor initialize data members with the values of passed arguments while object of that class created
	 * 
	 * @param managerId
	 * @param emps
	 * @param managerName
	 * @param managerNumber
	 * @param managerEmail
	 */
	
	public Manager(int managerId, Set<Employee> emps, String managerName, String managerNumber, String managerEmail) {
		super();
		this.managerId = managerId;
		this.emps = emps;
		this.managerName = managerName;
		this.managerNumber = managerNumber;
		this.managerEmail = managerEmail;
	}
	
	/**no-argument constructor
	 */
	public Manager() {
		super();
	}
	
	/**Create getters and setter methods  
	  * @return
	  */
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerNumber() {
		return managerNumber;
	}
	public void setManagerNumber(String managerNumber) {
		this.managerNumber = managerNumber;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	
	/**toString method
	 * return
	 */
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", emps=" + emps + ", managerName=" + managerName
				+ ", managerNumber=" + managerNumber + ", managerEmail=" + managerEmail + "]";
	}
	
	
}