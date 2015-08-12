/**
 * 
 */
package com.idlookid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.idlookid.domain.Country;
import com.idlookid.repository.CountryRepository;

/**
 * @author quocanh
 *
 */
@Service
@Validated
public class AppService {
	
	private final CountryRepository repository;
    
    @Autowired
    public AppService(final CountryRepository repository) {
        this.repository = repository;
    }
    
	public List<Country> getListALlCountries() {
		return repository.findAll();
	}
}
