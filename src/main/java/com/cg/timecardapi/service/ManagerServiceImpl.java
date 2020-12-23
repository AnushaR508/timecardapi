package com.cg.timecardapi.service;
/**Author: Aswitha
Project Desc: Time Card Service
Desc: Manager Service Impl performing crud operations on Manager entity**/
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.timecardapi.exception.ResourceNotFoundException;
import com.cg.timecardapi.model.Employee;
import com.cg.timecardapi.model.Manager;
import com.cg.timecardapi.repository.ManagerRepository;



@Service
@Transactional
public class ManagerServiceImpl  implements ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	Logger log=Logger.getLogger(getClass());
	
	/**Create Manager in data base
	 * @param manager
	 */
	public Manager createManager( @RequestBody Manager manager) {
		log.info("manager details saved");
		return  managerRepository.save(manager); 
	}
	
	/**Update Manager details
	 * @param managerId
	 */
	public Manager updateManager(@PathVariable(value = "id") Integer managerId,
		 @RequestBody Manager managerDetails) throws ResourceNotFoundException {
		Manager manager = managerRepository.findById(managerId)
			.orElseThrow(() -> new ResourceNotFoundException("Company Manager not found for this id :: " + managerId));
		manager.setManagerId(managerDetails.getManagerId());
		manager.setEmps(managerDetails.getEmps());
		final Manager updatedManager = managerRepository.save(manager);
		log.info("manager details updated");
		return updatedManager; 
		
	}
	 
	/**delete manager from database
	 * @param managerId
	 */
	 public boolean deleteManager(@PathVariable(value = "id") Integer managerId)
			throws ResourceNotFoundException {
		 Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException(" Manager not found for this id :: " + managerId));
		managerRepository.delete(manager);
		log.info("manager details deleted successfully");
		return true;
	}
	
	 /**gets the list of all managers
	  */
	public List<Manager> getAllManager() {
		log.info("all manager details retrieved");
		return managerRepository.findAll();
	} 
	
	/**Get list of all employees working under a manager
	 * @param manId
	 * @return
	 */
	public Set<Employee> getEmployees(int manId){
		Manager another=managerRepository.getOne(manId);
		log.info("employee details fetched");
		return another.getEmps();
	}
	
	/**gets manager details using his/her id
	 * @param managerId
	 */
	@Override
	public Manager getManagerById(Integer managerId) {
		Manager man=managerRepository.findById(managerId).get();
		log.info("manager with id " + managerId + " retrieved");
		return man;
	}
}
