package com.xtensus.spring.dao;

import java.util.List;

import com.xtensus.hibernate.model.UserDetails;

public interface UserDetailsDao {
	 public UserDetails getuserDetails(int id);
	    public List<UserDetails> getAllUserDetails();
}
