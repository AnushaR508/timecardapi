package com.cg.timecardapi.controller;
/**Author: Aswitha
Project Desc: Time Card Service
Desc: Manager Controller responsible for accessing data from data base**/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.cg.timecardapi.model.Manager;
import com.cg.timecardapi.service.ManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(value = "ManagerControllerClass")
@RestController
@RequestMapping("/api/v2/Manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	/**Adds Manager details in Data Base using POST method
	 * @param manager
	 * @return
	 */
	@ApiOperation(value = "create manager", response = Manager.class, tags = "ManagerControllerClass")
	@PostMapping("/CreateManager")
	public Manager createCompanyManger( @RequestBody Manager manager) {
		return managerService.createManager(manager);  
	}
	
	/**Edits manager details using PUt method
	 * @param managerId
	 * @param managerDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@ApiOperation(value = "edit manager", response = Manager.class, tags = "ManagerControllerClass")
	@PutMapping("/editManager/{id}")
	public ResponseEntity<Manager> updateManager(@PathVariable(value = "id") Integer managerId,
			 @RequestBody Manager managerDetails) throws ResourceNotFoundException {
		Manager manager = managerService.updateManager(managerId, managerDetails);
		return  ResponseEntity.ok(manager); 
	}

	/**Deletes manager from data base using DELETE Method
	 * @param managerId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@ApiOperation(value = "delete manager", response = Boolean.class, tags = "ManagerControllerClass")
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteManager(@PathVariable(value = "id") Integer managerId) throws ResourceNotFoundException	{
		
		boolean manager = managerService.deleteManager(managerId);
		return  ResponseEntity.ok(manager);
	}
	
	/**Displays details of all managers using GET method
	 * @return
	 */
	@ApiOperation(value = "get all manager", response = Iterable.class, tags = "ManagerControllerClass")
	@GetMapping("/all")
	public List<Manager> getAllManager() {
		return managerService.getAllManager();
	} 
	/**display employee details by GET method
	 * @param empId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/getById/{id}")
	@ApiOperation(value = "fetch manager by id", response = Manager.class, tags = "ManagerControllerClass")
	public Manager getManagerById(@PathVariable(value="id") int managerId) {
		
		return managerService.getManagerById(managerId);
	}
	
}
