/**
 * 
 */
package com.idlookid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idlookid.domain.Place;

/**
 * @author quocanh
 *
 */
public interface MapRepository  extends JpaRepository<Place, Long> {

}
