package edu.example.projectfive.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.example.projectfive.client.gui.MainView;
import edu.example.projectfive.client.model.Person;
import edu.example.projectfive.client.service.PersonService;

public class PersonServiceImpl extends RemoteServiceServlet implements PersonService {

	private List<Person> oprList;
	private int oprID;
	private MainView mw;
	
	public PersonServiceImpl(){
		oprList = new ArrayList<Person>();
		this.setup();
	}
	
	private void setup(){
		
		Person p1 = new Person(1, "Hans", "HA", "123456-7890", "02324it!", true, false, false);
		Person p2 = new Person(2, "Grete", "GR", "987654-3210", "02324it!", false, true, false);
		Person p3 = new Person(3, "Grimm", "GI", "025814-9637", "02324it!", false, false, true);
		oprList.add(p1);
		oprList.add(p2);
		oprList.add(p3);
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
}


