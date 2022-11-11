package com.system.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.system.api.model.Client;
import com.system.api.repository.ClientRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	ClientRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email_id) throws UsernameNotFoundException {

		Client user = userRepository.findByEmail(email_id)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email_id));
		System.out.println("UserDetailsServiceImpl user login successful with email: " + user.getEmail_id());

		return UserDetailsImpl.build(user);
	}

}