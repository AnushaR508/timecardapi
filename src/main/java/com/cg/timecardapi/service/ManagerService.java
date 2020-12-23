package com.cg.timecardapi.service;
/**Author: Aswitha
Project Desc: Manager Service
Desc: Manager Interface performing crud operations on Manager class**/
import java.util.List;

import com.cg.timecardapi.exception.ResourceNotFoundException;
import com.cg.timecardapi.model.Manager;


public interface ManagerService {
	
	/**Create a manager
	 * @param manager
	 * @return
	 */
	Manager createManager(Manager manager);
	
	/**Update manager details
	 * @param managerId
	 * @param managerDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	Manager updateManager(Integer managerId, Manager managerDetails) throws ResourceNotFoundException;
	
	/**delete Manager from data base 
	 * @param managerId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	boolean deleteManager(Integer managerId) throws ResourceNotFoundException;
	
	/**Lists all managers available
	 * @return
	 */
	List<Manager> getAllManager();
	
	/**finds manager by his/her ID
	 * @param managerId
	 * @return
	 */
	Manager getManagerById(Integer managerId);
	 
}
