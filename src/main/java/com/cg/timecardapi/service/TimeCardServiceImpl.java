package com.cg.timecardapi.service;

/**Author: Theja Nadhella
Project Desc: Time Card Service
Desc: Time card Implementation performing crud operations on Time card Entity**/
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.timecardapi.exception.ResourceNotFoundException;
import com.cg.timecardapi.model.TimeCard;
import com.cg.timecardapi.repository.TimeCardRepository;



@Service
public class TimeCardServiceImpl implements TimeCardService {
	
	@Autowired
	TimeCardRepository daoCaller;
	
	/**Implementation of Loggers
	 */
	Logger log=Logger.getLogger(getClass());
	
	/**Adds Time card entry in data base
	 * @param timeCard
	 */
	@Override
	public TimeCard saveTimeEntry(TimeCard timeCard) {
		log.info("added timecard entry");
		return daoCaller.save(timeCard);  
	}
	
	/**Removes time card entry from data base
	 * @param timeCardId
	 */
	@Override
	public boolean removeEntry(int timeCardId) throws ResourceNotFoundException {
		boolean check=false;
		TimeCard toDelete= daoCaller.findById(timeCardId).orElseThrow(() -> new ResourceNotFoundException("TimeCard not found for this id :: " + timeCardId));
		check=(toDelete!=null);
		daoCaller.deleteId(timeCardId);
		log.info("deleted entry");
		return check;
	}
	
	/**Update Time card entries
	 * 
	 */
	@Override
	public int updateEntries(int id,TimeCard tcard ) throws ResourceNotFoundException {
		
		TimeCard timecard=daoCaller.findById(id).orElseThrow(() -> new ResourceNotFoundException(" TimeCard not found for this id :: " + id));
		timecard.setDate(tcard.getDate());
		daoCaller.save(timecard);
		log.info("update entry");
		return timecard.getTimeCardId();
	}
	
	/**Display time card entries of an employee
	 * @param empId
	 */
	@Override
	public List<TimeCard> displayEntries(int empId) {
		log.info("entries by employee id");
		return daoCaller.findByEmpId(empId);
		
	}
	
	/**Display all time card entries in data base
	 * 
	 */
	@Override
	public List<TimeCard> displayAll() {
		log.info("all entries");
		return daoCaller.findAll();
	}
	
	/**Get time card details using time card id
	 * @param tcId
	 */
	@Override
	public TimeCard getTimeCard(Integer tcId) {
		TimeCard opt=null;
		if(daoCaller.findById(tcId).isPresent()) {
			opt=daoCaller.findById(tcId).get();
		}
		return opt;
	}
}
