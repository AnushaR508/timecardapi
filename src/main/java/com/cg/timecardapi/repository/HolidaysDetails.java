package com.cg.timecardapi.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.timecardapi.model.HolidaysEntity;


/**
 * @author anusha
 * This class extends crud repository to manage crud operations
 * 
 */
@Repository
public interface HolidaysDetails extends CrudRepository<HolidaysEntity, Integer> {
	List<HolidaysEntity> findByYear(int year);
}
