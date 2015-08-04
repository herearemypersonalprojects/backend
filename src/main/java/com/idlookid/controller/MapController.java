/**
 * 
 */
package com.idlookid.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idlookid.domain.Place;
import com.idlookid.service.MapService;

/**
 * @author quocanh
 *
 */
@RestController
public class MapController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MapController.class);
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
    
    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<String> listCities() {   	    	
		return mapService.getListCities();
    }
    
    @RequestMapping(value = "/placeTypes", method = RequestMethod.GET)
    public List<String> listPlaceTypes() {   	    	
		return mapService.getListPlaceTypes();
    }
    
    @RequestMapping(value = "/getIp", method = RequestMethod.GET)
    public String getUserIp(HttpServletRequest request) {
    	return request.getRemoteAddr();
    }
}
