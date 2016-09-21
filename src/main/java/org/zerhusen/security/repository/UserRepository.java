package org.zerhusen.security.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zerhusen.config.ConfigUsers;
import org.zerhusen.model.security.User;

/**
 * Created by stephan on 20.03.16.
 */
@Component
public class UserRepository {
	
	@Autowired
	ConfigUsers cfg;
	
	public User findByUsername(String username) {
		User user = new User();
		
		User foundUser = cfg.getUsers().stream()
	    	.filter(x -> x.getUsername().equals(username))
	    	.findFirst().get();
	    	
		if (foundUser!=null) {
			user.setAuthorities(foundUser.getAuthorities());
			user.setId(1L);
			user.setEnabled(true);
			user.setUsername(username);
			user.setPassword(foundUser.getPassword());
		}
		return user;
	}
}
