package com.xtensus.ged;

import java.util.HashMap;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;

public class AlfrescoFileHelper {
	public static Session CreateAlfrescoSession(Map<String, String> parameters) {
		SessionFactory factory = SessionFactoryImpl.newInstance();
		Session session = factory.getRepositories(parameters).get(0).createSession();
		return session;
	}

	public static Map<String, String> CreateAlfrescoParameters(String user, String password, String url,
			String bindingType) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(SessionParameter.USER, user);
		parameters.put(SessionParameter.PASSWORD, password);
		parameters.put(SessionParameter.ATOMPUB_URL, url);
		parameters.put(SessionParameter.BINDING_TYPE, bindingType);

		return parameters;
	}

}
