/**
 * 
 */
package com.idlookid.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.idlookid.domain.DisplayCriterion;
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
	
	@Override
	@Transactional(readOnly = true)
    public List<Place> getList(DisplayCriterion criterion) {
		if (criterion.getType() != null) {
			return repository.findByType(criterion.getType());
		} else
		if (criterion.getCity() != null) {
			return repository.findByCity(criterion.getCity());
		} else
		if (criterion.getSwLat() != null && 
			criterion.getSwLng() != null && 
			criterion.getNeLat() != null && 
			criterion.getNeLng() != null) {
			List<Place> lst = repository.findByCurrentView(criterion.getSwLat(), 
					criterion.getSwLng(), 
					criterion.getNeLat(), 
					criterion.getNeLng());
			// TODO: This can be improved later
			List<Place> newLst = new ArrayList<Place>();
			int citiesNumber = 0;
			Set<String> setCities = new HashSet<String>();
			for (Place place : lst) {
				if (!setCities.contains(place.getCity())) {
					citiesNumber++;
					setCities.add(place.getCity());
					newLst.add(place);
				}
			}
			if (citiesNumber > 3) {
				return newLst;
			}
			return lst;
		} else {
			return new ArrayList<Place>();
		}
	}
}
