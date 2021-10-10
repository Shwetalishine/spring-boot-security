package com.telusko.secureapp.service;

import com.telusko.secureapp.model.User;
import com.telusko.secureapp.UserDetailsImpl;
import com.telusko.secureapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepostitory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepostitory.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User 404");
		return new UserDetailsImpl(user);
	}

}
