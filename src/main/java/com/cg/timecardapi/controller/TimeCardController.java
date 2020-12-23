package com.cg.timecardapi.controller;

/**Author: Theja Nadhella
Project Desc: Time Card Service
Desc: Time Card Controller responsible for accessing data from data base**/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cg.timecardapi.model.TimeCard;
import com.cg.timecardapi.service.EmployeeService;
import com.cg.timecardapi.service.TimeCardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(value = "TimeCardControllerClass")
@RestController 
@RequestMapping("/api/v2/timecard")
public class TimeCardController {

	@Autowired
	private TimeCardService tcs;
	
	@Autowired
	private EmployeeService empSer;
	
	/**Display entries of time card of one employee using GET method
	 * @param employeeId
	 * @return
	 */
	@ApiOperation(value = "get timecards by employee id", response = Iterable.class, tags = "TimeCardControllerClass")
	@GetMapping("/employee/{id}")
	public List<TimeCard> getEmployeeById(@PathVariable(value = "id") Integer employeeId){
		return tcs.displayEntries(employeeId);
	}
	
	/**Display entries of time card using GET method
	 * @param tcId
	 * @return
	 */
	@ApiOperation(value = "get timecards by employee id", response = Iterable.class, tags = "TimeCardControllerClass")
	@GetMapping("/getTimeCard/{id}")
	public TimeCard getTimeCardById(@PathVariable(value = "id") Integer tcId){
		return tcs.getTimeCard(tcId);
	}
	
	/**Adds time card details in data base using POST method
	 * @param tca
	 * @param empId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@ApiOperation(value = "enter timecard entry", response = TimeCard.class, tags = "TimeCardControllerClass")
	@PostMapping("/timecardEntry/{emp_id}")
	public TimeCard createTimeCard( @RequestBody TimeCard tca, @PathVariable(value = "emp_id") Integer empId ) throws ResourceNotFoundException {
		Employee employee=empSer.getEmpById(empId);
		if(employee!=null)
			tca.setEmployee(employee);
		tca.setStatus("Pending");
		return tcs.saveTimeEntry(tca); 
	}
	
	/**Edits time card details using PUT method
	 * @param id
	 * @param tcard
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@ApiOperation(value = "edit timecard entry", response = Integer.class, tags = "TimeCardControllerClass")
	@PutMapping("/timeCardEdit/{tc_id}")
	public Integer editTimeCard(@PathVariable("tc_id") Integer id,@RequestBody TimeCard tcard) throws ResourceNotFoundException{
		
		return tcs.updateEntries(id, tcard);
	}
	
	/**Delete Time card Entries using DELETE method
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@ApiOperation(value = "delete timecard entry", response = Boolean.class, tags = "TimeCardControllerClass")
	@DeleteMapping("/timecardDelete/{id}")
	public Boolean deleteTimeCard(@PathVariable("id") Integer id ) throws ResourceNotFoundException{
		return tcs.removeEntry(id);
	}
	
	/**displays all time card entries using GET method
	 * @return
	 */
	@ApiOperation(value = "get all timecards", response = Iterable.class, tags = "TimeCardControllerClass")
	@GetMapping("/timecards")
	public List<TimeCard> getAllEntries(){
		return tcs.displayAll();
		 
	}
	
}
