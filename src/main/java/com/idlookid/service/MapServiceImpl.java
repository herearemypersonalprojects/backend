/**
 * 
 */
package com.idlookid.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.idlookid.domain.Place;
import com.idlookid.repository.MapRepository;
import com.idlookid.repository.UserRepository;

/**
 * @author quocanh
 *
 */
@Service
@Validated
public class MapServiceImpl implements MapService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapServiceImpl.class);
    private final MapRepository repository;
    
    @Inject
    public MapServiceImpl(final MapRepository repository) {
        this.repository = repository;
    }
	/* (non-Javadoc)
	 * @see com.idlookid.service.MapService#save(com.idlookid.domain.Place)
	 */
	@Override
	public Place save(Place place) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.idlookid.service.MapService#getList()
	 */
	@Override
	public List<Place> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
