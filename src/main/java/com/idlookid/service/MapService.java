/**
 * 
 */
package com.idlookid.service;

import java.util.List;

import com.idlookid.domain.Place;

/**
 * @author quocanh
 *
 */
public interface MapService {
    Place save(Place place);

    List<Place> getList();
}
