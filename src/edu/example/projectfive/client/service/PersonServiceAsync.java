package edu.example.projectfive.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;


import edu.example.projectfive.client.model.Person;



public interface PersonServiceAsync {
	void getOperatoer(int id, AsyncCallback<Person> callback);
	void getOperatoers(AsyncCallback<Person[]> callback);
	void getPersons(AsyncCallback<List<Person>> callback);
	void savePerson(Person p, AsyncCallback<Void> callback);
	void updatePerson(Person person, AsyncCallback<Void> asyncCallback);
	
}
