package edu.example.projectfive.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


import edu.example.projectfive.client.model.Person;
import edu.example.projectfive.client.service.PersonService;

public class PersonServiceImpl extends RemoteServiceServlet implements PersonService {

	private List<Person> oprList;
	
	
	public PersonServiceImpl(){
		oprList = new ArrayList<Person>();
		this.setup();
	}
	
	private void setup(){
		
		this.savePerson(new Person(1, "Hans", "HA", "123456-7890", "02324it!", true, false, false));
		this .savePerson(new Person(2, "Grete", "GR", "987654-3210", "02324it!", false, true, false));
		this.savePerson(new Person (3, "Grimm", "GI", "025814-9637", "02324it!", false, false, true));
		
		
	}
	
	@Override
	public Person getOperatoer(int id) {
		for (Person opr : oprList){
			if(opr.getOprId() == id){
				return opr;
			}
		}
		return null;
	}

	@Override
	public Person[] getOperatoers() {
		Person[] oprs = new Person[oprList.size()];
		oprList.toArray(oprs);
		return oprs;
	}

	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return oprList;
	}

	@Override
	public void savePerson(Person p) {
		// TODO Auto-generated method stub
		oprList.add(p);
	}

	@Override
	public void updatePerson(Person p)  {
		// find object with id and update it
		for (int i=0; i<oprList.size();i++)
			if (oprList.get(i).getOprId() == p.getOprId())	
				oprList.set(i, p);

	}
}


