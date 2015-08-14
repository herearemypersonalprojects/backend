/**
 * 
 */
package com.idlookid.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idlookid.domain.DisplayCriterion;
import com.idlookid.domain.Place;
import com.idlookid.service.MapService;

/**
 * @author quocanh
 *
 */
@RestController
public class MapController {
	private static final Logger LOGGER = Logger.getLogger(MapController.class);
    private final MapService mapService;

    @Autowired
    public MapController(final MapService mapService) {
        this.mapService = mapService;
    }	

    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public List<Place> listPlaces() {
        LOGGER.debug("Received request to list all places");
        return mapService.getList();
    }
    
    @RequestMapping(value = "/getPlaces", 
    		method = RequestMethod.POST)
    public List<Place> getListPlaces(@ModelAttribute @Valid final DisplayCriterion criterion) {
    	LOGGER.info("Received request to list places for conditions: ");
    	
    	return mapService.getList(criterion);
    }
    
    /*
     * Get list of cities whose places exist on the map
     */
    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<String> listCities() {   	    	
		return mapService.getListCities();
    }
    
    /*
     * Get list of available place types    
     */
    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public List<String> listTypes() {   	    	
		return mapService.getListPlaceTypes();
    }
    
    /*
     * Get list of place types whose places exist on the map
     */
    @RequestMapping(value = "/placeTypes", method = RequestMethod.GET)
    public List<String> listPlaceTypes() {   	    	
		return mapService.getListPlaceTypes();
    }
    
    @RequestMapping(value = "/getIp", method = RequestMethod.GET)
    public String getUserIp(HttpServletRequest request) {
    	return request.getRemoteAddr();
    }
}
