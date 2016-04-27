package edu.example.projectfive.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import edu.example.projectfive.client.service.PersonServiceClientImpl;


public class MainView  {
	
	// reference to ContentView
	private ContentView contentView;
	private MenuView m;
	
	// V.1
	// reference to data layer
	// private IPersonDAO iPersonDAO;
	
	// V.2
	// reference to remote data layer
	
	
	
	public MainView(PersonServiceClientImpl clientImpl) {
		
		// V.1
		// add implementation of data layer
		// iPersonDAO = new PersonDAO();
		
		// V.2
		// add server side implementation of data layer
		clientImpl = new PersonServiceClientImpl(GWT.getModuleBaseURL() + "personservice");
		
		// wrap menuView
		 m = new MenuView(this);
		RootPanel.get("nav").add(m);
		
		// wrap contentView
		contentView = new ContentView(clientImpl);
		RootPanel.get("section").add(contentView);	
	}
	
	public void run() {
		// show welcome panel
		contentView.openBrowseView();
	}
	
	
	// Call back handlers
	public void addPerson() {
		contentView.openAddView();
	}
	
	public void showPersons() {
		contentView.openBrowseView();
	}
	
	public void editPersons() {
		contentView.openEditView();
	}
	
	public void deletePersons() {
		contentView.openDeleteView();
	}
	
	public void logOut(){
		m.getVpanel().clear();
		contentView.openLogOutView();
	}
	
}
