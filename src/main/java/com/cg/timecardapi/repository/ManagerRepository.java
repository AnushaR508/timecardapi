package com.cg.timecardapi.repository;

/**Author: Aswitha
Project Desc: Time Card Service
Desc: ManagerRepository Interface performing crud operations on Manager**/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.timecardapi.model.Manager;



@Repository
public interface ManagerRepository extends  JpaRepository<Manager, Integer>  {

}
