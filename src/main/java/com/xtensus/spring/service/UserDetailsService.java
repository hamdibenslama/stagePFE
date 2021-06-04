package com.xtensus.spring.service;

import java.util.List;

import com.xtensus.hibernate.model.UserDetails;

public interface UserDetailsService {
	public UserDetails getuserDetails(int id);

	public List<UserDetails> getAllUserDetails();
}
