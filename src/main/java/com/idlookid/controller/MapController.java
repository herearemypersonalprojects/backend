/**
 * 
 */
package com.idlookid.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idlookid.domain.Place;
import com.idlookid.domain.User;
import com.idlookid.service.MapService;

/**
 * @author quocanh
 *
 */
@RestController
public class MapController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MapController.class);
    private final MapService mapService;

    @Inject
    public MapController(final MapService mapService) {
        this.mapService = mapService;
    }	
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Place createPlace(@RequestBody @Valid final Place place) {
        LOGGER.debug("Received request to create the {}", place);
        return mapService.save(place);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<Place> listUsers() {
        LOGGER.debug("Received request to list all users");
        return mapService.getList();
    }
}
