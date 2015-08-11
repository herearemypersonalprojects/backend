/**
 * 
 */
package com.idlookid.service;

import java.util.List;

import com.idlookid.domain.DisplayCriterion;
import com.idlookid.domain.Place;

/**
 * @author quocanh
 *
 */
public interface MapService {
	List<String> getListCities();
	List<String> getListPlaceTypes();
    List<Place> getList();
    List<Place> getList(DisplayCriterion criterion);
}
