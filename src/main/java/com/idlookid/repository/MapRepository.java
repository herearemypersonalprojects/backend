/**
 * 
 */
package com.idlookid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idlookid.domain.Place;

/**
 * @author quocanh
 *
 */
public interface MapRepository  extends JpaRepository<Place, Long> {
	@Query(value="select distinct city from place", nativeQuery = true)
	List<String> findAllCities();
	
	@Query(value="select distinct place_type from place", nativeQuery = true)
	List<String> getListPlaceTypes();
}
