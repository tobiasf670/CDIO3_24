package edu.example.projectfive.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import edu.example.projectfive.client.model.Person;

public class PersonServiceClientImpl  {
		
	public PersonServiceAsync service;
	private Person loggedIn;
	
	public PersonServiceClientImpl(String url){
		this.service = GWT.create(PersonService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
		endpoint.setServiceEntryPoint(url);
	}
	
	public void setPerson(Person p){
		this.loggedIn = p;
	}
	
	public Person getLoggedUser(){
		return loggedIn;
	}
}