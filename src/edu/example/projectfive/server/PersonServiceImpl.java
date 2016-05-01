package edu.example.projectfive.server;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		try {
			ResultSet set = Connector.getInstance().doQuery("select * from users");
			while(set.next()){
				boolean admin = false;
				boolean operatoer = false;
				boolean farmaceut = false;
				if(set.getString(6).equals("admin")){
					admin = true;
				}
				else if(set.getString(6).equals("operatoer")){
					operatoer = true;
				}
				else if(set.getString(6).equals("farmaceut")){
					farmaceut = true;
				}
				oprList.add(new Person(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), admin, operatoer, farmaceut));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//this.savePerson(new Person(1, "Hans", "HA", "123456-7890", "02324it!", true, false, false));
		//this .savePerson(new Person(2, "Grete", "GR", "987654-3210", "02324it!", false, true, false));
		//this.savePerson(new Person (3, "Grimm", "GI", "025814-9637", "02324it!", false, false, true));
		
		
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
		try {
			String type = "";
			if(p.isAdmin()){
				type = "admin";
			}
			else if(p.isFarmaceut()){
				type = "farmaceut";
			}
			else{
				type = "operatoer";
			}
			Connector.getInstance().doUpdate("insert into users(id, navn, ini, cpr, password, position) values("+p.getOprId()+",\""+p.getNavn()+"\",\""+p.getIni()+"\",\""+p.getCpr()+"\",\""+p.getPassword()+"\",\""+type+"\");");
			oprList.add(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePerson(Person p)  {
		// find object with id and update it
		for (int i=0; i<oprList.size();i++)
			if (oprList.get(i).getOprId() == p.getOprId())	
			{
				oprList.set(i, p);
				String type = "";
				if(p.isAdmin()){
					type = "admin";
				}
				else if(p.isFarmaceut()){
					type = "farmaceut";
				}
				else{
					type = "operatoer";
				}
				try {
					Connector.getInstance().doUpdate("update users SET  navn = \""+p.getNavn()+"\", ini = \""+p.getIni()+"\", cpr = \""+p.getCpr()+"\", password = \""+p.getPassword()+"\", position = \""+type+"\" WHERE id = "+p.getOprId()+";" );
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
				

	}

	@Override
	public void deletePerson(int id, boolean admin, boolean operatoer, boolean farmaceut) {
		// // find object with id and remove it
		for (int i=0; i<oprList.size();i++)
			if (oprList.get(i).getOprId() == id)
			{
				oprList.remove(i);
				String type = "";
				if(admin){
					type = "admin";
				}
				else if(farmaceut){
					type = "farmaceut";
				}
				else if(operatoer){
					type = "operatoer";
				}
				try {
					Connector.getInstance().doUpdate("delete from users where id = "+id+";");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
				
		
	}
}


