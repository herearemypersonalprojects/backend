/**
 * 
 */
package com.idlookid.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.idlookid.domain.Place;
import com.idlookid.repository.MapRepository;

/**
 * @author quocanh
 *
 */
@Service
@Validated
public class MapServiceImpl implements MapService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapServiceImpl.class);
    private final MapRepository repository;
    
    @Autowired
    public MapServiceImpl(final MapRepository repository) {
        this.repository = repository;
    }

	/* (non-Javadoc)
	 * @see com.idlookid.service.MapService#getList()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Place> getList() {
        LOGGER.debug("Retrieving the list of all places");
        return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true) 
	public List<String> getListCities() {
		return repository.findAllCities();
	}

	@Override
	@Transactional(readOnly = true) 
	public List<String> getListPlaceTypes() {
		return repository.getListPlaceTypes();
	}	
	
}
