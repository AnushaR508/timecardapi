package com.cg.timecardapi.model;

/**Author:  Theja Nadhella
 * Project Desc: Time Card Service
 *Class Desc: Time card Entity describing all attributes related to Timecard**/
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**creating table with name timecard*/
@Entity
@Table(name="TIMECARD")
public class TimeCard implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="TIME_CARDID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int timeCardId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="EMP_ID")
	protected Employee employee;
	@Column(name="ENTRY_DATE")
	protected LocalDate date;
	@Column(name="PROJECT_ID")
	protected int projectId;
	@Column(name="PROJECT_NAME")
	protected String projectName;
	@Column(name="HOURS")
	protected int hours;
	@Column(name="STATUS")
	protected String status;
	
	/**no-argument constructor
	 */
	public TimeCard() {
		super();
	}

	/**This constructor initialize data members with the values of passed arguments while object of that class created
	 * 
	 * @param timeCardId
	 * @param employee
	 * @param date
	 * @param projectId
	 * @param projectName
	 * @param hours
	 * @param status
	 */
	 
	public TimeCard(int timeCardId, Employee employee, LocalDate date, int projectId, String projectName, int hours,
			String status) {
		super();
		this.timeCardId = timeCardId;
		this.employee = employee;
		this.date = date;
		this.projectId = projectId;
		this.projectName = projectName;
		this.hours = hours;
		this.status = status;
	}

	/**Create getters and setter methods  
	  * @return
	  */
	public int getTimeCardId() {
		return timeCardId;
	}


	public void setTimeCardId(int timeCardId) {
		this.timeCardId = timeCardId;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public int getHours() {
		return hours;
	}


	public void setHours(int hours) {
		this.hours = hours;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TimeCard [timeCardId=" + timeCardId + ", employee=" + employee + ", date=" + date + ", projectId="
				+ projectId + ", projectName=" + projectName + ", hours=" + hours + ", status=" + status + "]";
	}
	
	
	
	
}
