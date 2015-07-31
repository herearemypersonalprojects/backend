/**
 * 
 */
package com.idlookid.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

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
}
