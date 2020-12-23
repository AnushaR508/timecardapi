package com.cg.timecardapi.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.timecardapi.model.EmployeeLeaveDetailsEntity;

/**
 * @author anusha
 * This class extends crud repository to manage crud operations performed with database
 * 
 */
@Repository
public interface EmployeeLeaveDetailsRepository extends CrudRepository<EmployeeLeaveDetailsEntity,Long> {
	 @Query(value = "SELECT distinct leave_type FROM employee_leave_details_entity", nativeQuery = true)
	    public List<String> getLeaveType();
     EmployeeLeaveDetailsEntity findByEmpId(long empId);
     EmployeeLeaveDetailsEntity findByEmpName(String empName);
     
}
