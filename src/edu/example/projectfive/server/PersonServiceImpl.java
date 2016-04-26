package edu.example.projectfive.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.example.projectfive.client.gui.Login;
import edu.example.projectfive.client.model.Person;
import edu.example.projectfive.client.service.PersonService;

public class PersonServiceImpl extends RemoteServiceServlet implements PersonService {

	private List<Person> oprList;
	private int oprID;
	private Login mw;
	
	public PersonServiceImpl(){
		oprList = new ArrayList<Person>();
		this.setup();
	}
	
	private void setup(){
		
		Person p1 = new Person(1, "Hans", "HA", "123456-7890", "02324it!", true, false, false);
		Person p2 = new Person(2, "Grete", "GR", "987654-3210", "02324it!", false, true, false);
		Person p3 = new Person(3, "Grimm", "GI", "025814-9637", "02324it!", false, false, true);
		Person p4 = new Person(4, "John", "JO", "0223814-9637", "02324it!", false, false, true);
		Person p5 = new Person(5, "Grimm2", "GI", "025814-9637", "02324it!", false, false, true);
		Person p6 = new Person(6, "Grimm3", "GI", "025814-9637", "02324it!", false, false, true);
		Person p7 = new Person(7, "Grimm4", "GI", "025814-9637", "02324it!", false, false, true);
		Person p8 = new Person(8, "Grimm5", "GI", "025814-9637", "02324it!", false, false, true);
		Person p9 = new Person(9, "Grimm6", "GI", "025814-9637", "02324it!", false, false, true);
		oprList.add(p1);
		oprList.add(p2);
		oprList.add(p3);
		oprList.add(p4);
		oprList.add(p5);
		oprList.add(p6);
		oprList.add(p7);
		oprList.add(p8);
		oprList.add(p9);
		
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
}


