/**
 * 
 */
package com.idlookid.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    
    /*
     * Get list of cities whose places exist on the map
     */
    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<String> listCities() {   	    	
		return mapService.getListCities();
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
    
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(
    		@RequestParam("uploadFile") MultipartFile uploadFile) {
    	try {
    		// Get the filename and build the local file path (be
    		// sure that the application have write permissions on
    		// such directory
    		String filename = uploadFile.getOriginalFilename();
    		String directory = "/home/quocanh";
    		String filepath = Paths.get(directory, filename).toString();
    		
    		// Save the file locally
    		BufferedOutputStream stream =
    				new BufferedOutputStream(new FileOutputStream(new File(filepath)));
    		stream.write(uploadFile.getBytes());
    		stream.close();
    	}
    	catch (Exception e) {
    		LOGGER.error(e.getMessage());
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	return new ResponseEntity<>(HttpStatus.OK);
    }    
}
