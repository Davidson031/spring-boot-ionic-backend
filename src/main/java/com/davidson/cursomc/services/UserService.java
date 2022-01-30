package com.davidson.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.davidson.cursomc.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		
		try {
			
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
			
			
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch(Exception e) {
			return null;
		}
	}

}
