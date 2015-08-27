/**
 * 
 */
package com.idlookid.service;

import java.util.Iterator;
import java.util.Map;
import java.util.TimerTask;

import com.idlookid.domain.User;

/**
 * @author quocanh
 *
 */
public class CheckOnlineUsers extends TimerTask{

	/**
	 * Remove user if the server has not yet received his signal in 60 s
	 */
	@Override
	public void run() {
	    for(Iterator<Map.Entry<Long, User>> it = UserServiceImpl.listOnlineUsers.entrySet().iterator(); it.hasNext(); ) {
	        Map.Entry<Long, User> entry = it.next();
	        if(System.currentTimeMillis() - entry.getValue().getLastActiveTime() > 60000) {
	          it.remove();
	        }
	      }
	}

}
