package edu.example.projectfive.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


import edu.example.projectfive.client.model.Person;

@RemoteServiceRelativePath("personservice")
public interface PersonService extends RemoteService {
	public Person getOperatoer (int id);
	public Person[] getOperatoers ();
	public List <Person> getPersons();
	public void savePerson(Person p);
	void updatePerson(Person person);
}
