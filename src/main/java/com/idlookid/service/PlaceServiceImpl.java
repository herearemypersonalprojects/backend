/**
 * 
 */
package com.idlookid.service;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
public class PlaceServiceImpl implements PlaceService {
    //private static final Logger LOGGER = LoggerFactory.getLogger(PlaceServiceImpl.class);
    private final MapRepository repository;
    
    @Autowired
    public PlaceServiceImpl(final MapRepository repository) {
        this.repository = repository;
    }    
	/* (non-Javadoc)
	 * @see com.idlookid.service.PlaceService#get(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = true)
	public Place get(@NotNull Long id) {
		return repository.getOne(id);
	}

	/* (non-Javadoc)
	 * @see com.idlookid.service.PlaceService#create(com.idlookid.domain.Place)
	 */
	@Override
	@Transactional
	public Place create(@NotNull @Valid Place place) {
		return repository.save(place);
	}

	/* (non-Javadoc)
	 * @see com.idlookid.service.PlaceService#update(java.lang.Long, com.idlookid.domain.Place)
	 */
	@Override
	@Transactional
	public Place update(@NotNull Long id, @NotNull @Valid Place place) {
		Place update = repository.getOne(id);
		update.setAddress(place.getAddress());
		update.setCity(place.getCity());
		update.setCountry(place.getCountry());
		update.setLatitude(place.getLatitude());
		update.setLongitude(place.getLongitude());
		update.setTitle(place.getTitle());
		update.setInformation(place.getInformation());
		update.setEmail(place.getEmail());
		update.setTelephone(place.getTelephone());
		update.setOpenTime(place.getOpenTime());
		update.setCloseTime(place.getCloseTime());
		repository.save(update);
		return update;
	}

	/* (non-Javadoc)
	 * @see com.idlookid.service.PlaceService#delete(java.lang.Long)
	 */
	@Override
	@Transactional
	public void delete(@NotNull Long id) {
		repository.delete(id);
	}

}
