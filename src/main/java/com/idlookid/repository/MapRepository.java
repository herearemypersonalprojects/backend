/**
 * 
 */
package com.idlookid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idlookid.domain.Place;

/**
 * @author quocanh
 *
 */
public interface MapRepository  extends JpaRepository<Place, Long> {
	@Query(value="select distinct CONCAT(city, ', ', country) as city from place", nativeQuery = true)
	List<String> findAllCities();
	
	@Query(value="select distinct place_type from place", nativeQuery = true)
	List<String> getListPlaceTypes();
	
	List<Place> findByCity(@Param("city") String city);
	
	//List<Place> findByTypeIn(List<String> types);
	
	@Query(value="select * from place where latitude > :swLat and latitude < :neLat and longitude > :swLng and longitude < :neLng", nativeQuery = true)
	List<Place> findByCurrentView(
			@Param("swLat") Double swLat, 
			@Param("swLng") Double swLng, 
			@Param("neLat") Double neLat, 
			@Param("neLng") Double neLng);
}
