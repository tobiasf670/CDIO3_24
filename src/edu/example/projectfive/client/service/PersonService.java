package edu.example.projectfive.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


import edu.example.projectfive.client.model.Person;

@RemoteServiceRelativePath("personservice")
public interface PersonService extends RemoteService {
	public Person getOperatoer (int id);
	public Person[] getOperatoers ();
}
