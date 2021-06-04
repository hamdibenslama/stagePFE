package com.xtensus.spring.service.impl;

import java.util.List;

import com.xtensus.hibernate.model.UserDetails;
import com.xtensus.spring.dao.UserDetailsDao;
import com.xtensus.spring.service.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserDetailsDao userDetailsDao;
  
	@Override
    public UserDetails getuserDetails(int id) {
        return userDetailsDao.getuserDetails(id);
    }
    @Override
    public List<UserDetails> getAllUserDetails() {
        return userDetailsDao.getAllUserDetails();
    }
    public UserDetailsDao getUserDetailsDao() {
        return userDetailsDao;
    }
}
