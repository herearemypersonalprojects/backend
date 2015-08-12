/**
 * 
 */
package com.idlookid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idlookid.domain.Country;

/**
 * @author quocanh
 *
 */
public interface CountryRepository extends JpaRepository<Country, String> {

}
