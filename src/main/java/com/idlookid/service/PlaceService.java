/**
 * 
 */
package com.idlookid.service;

import com.idlookid.domain.Place;

/**
 * @author quocanh
 *
 */
public interface PlaceService {
	Place get(Long id);
	Place create(Place place);
	Place update(Long id, Place place);
	void delete(Long id);
}
