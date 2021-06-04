package com.xtensus.ged;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.xtensus.hibernate.model.UserDetails;
import com.xtensus.spring.service.IGenericManager;
import com.xtensus.spring.service.UserDetailsService;
import com.xtensus.spring.service.impl.AbstractGenericManager;
import com.xtensus.spring.service.impl.ApplicationManager;

@ManagedBean
@RequestScoped
public class UserDetailsMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	// inject spring bean via ID
	@ManagedProperty("#{userDetailsService}")
	private UserDetailsService userDetailsService;

	private UserDetails userDetails;
	private List<UserDetails> userDetailsList;
	// inject spring bean via ID
	@ManagedProperty("#{iGenericManager}")
	private IGenericManager iGenericManager;

	public UserDetails getUserDetails() {
		int idUser = 7;
		List<UserDetails> listeUser = iGenericManager.listeUtilisateurParId(idUser);
		if (listeUser != null && listeUser.size() > 0) {
			userDetails = listeUser.get(0);
			System.out.println(userDetails);
		}
//		if (userDetails == null) {
//			int id = 7;// should come from UI
//			userDetails = userDetailsService.getuserDetails(id);
//		}
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public List<UserDetails> getUserDetailsList() {
		// Récupérer la liste des Users

		if (userDetailsList == null) {
			try {
				userDetailsList = iGenericManager.getList(UserDetails.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		getUserDetails();

		/*
		 * 
		 * if (userDetailsList == null) { userDetailsList =
		 * userDetailsService.getAllUserDetails(); }
		 */
		return userDetailsList;
	}

	public void setUserDetailsList(List<UserDetails> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public void setiGenericManager(IGenericManager iGenericManager) {
		this.iGenericManager = iGenericManager;
	}

}
