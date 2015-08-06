/**
 * 
 */
package com.idlookid.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author quocanh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TestFileService {
	@Test
	public void test() {
		String name = "/apps/frontend/images/place1/1.jpg";
		
		System.out.println(name.substring(name.indexOf("/images/")));
	}
}
