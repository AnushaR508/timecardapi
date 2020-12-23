package com.cg.timecardapi.service;

/**Author: Theja Nadhella
Project Desc: Time Card Service
Desc: Time card Interface performing crud operations on Time card class**/
import java.util.List;

import com.cg.timecardapi.exception.ResourceNotFoundException;
import com.cg.timecardapi.model.TimeCard;



public interface TimeCardService {
	
	/**Saves the entries of time card 
	 * @param man
	 * @return
	 */
	TimeCard saveTimeEntry(TimeCard man);
	
	/**delete time card entries 
	 * @param timeCardId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	boolean removeEntry(int timeCardId) throws ResourceNotFoundException;
	
	/**Update time card entry
	 * @param id
	 * @param tcard
	 * @return
	 * @throws ResourceNotFoundException
	 */
	int updateEntries(int id,TimeCard tcard) throws ResourceNotFoundException;
	
	/**Display all the time card entries of one employee
	 * @param employeeId
	 * @return
	 */
	List<TimeCard> displayEntries(int employeeId);
	
	/**display entries of all time cards 
	 * 
	 * @return
	 */
	List<TimeCard> displayAll();
	
	/**get timecard details using time card ID
	 * 
	 * @param tcId
	 * @return
	 */
	TimeCard getTimeCard(Integer tcId);
	
}
