package com.cg.timecardapi.repository;

/**Author: Theja Nadhella
Project Desc: Time Card Service
Desc: Time card Repository Interface performing crud operations on Time card**/
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.timecardapi.model.Employee;
import com.cg.timecardapi.model.TimeCard;



@Repository
public interface TimeCardRepository extends JpaRepository<TimeCard, Integer>{
	
	/**Query to Find Time card details 
	 * @param emp
	 * @return
	 */
	@Query("select tc from TimeCard tc where tc.employee=:emp")
    List<TimeCard> findByEmp(Employee emp);
	
	/**Query to Find time card details using employee ID
	 * @param empId
	 * @return
	 */
	@Query("select tc from TimeCard tc where tc.employee=(select emp from Employee emp where emp.employeeId=:empId)")
	List<TimeCard> findByEmpId(int empId);
	
	/**Query to Delete time card details using time card ID
	 * @param id
	 */
	@Transactional
	@Modifying
	@Query("delete from TimeCard tt where tt.timeCardId=:id")
	void deleteId(int id);
}
