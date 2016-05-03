package edu.example.projectfive.client.gui;

import com.google.gwt.user.client.ui.RootPanel;

import edu.example.projectfive.client.service.PersonServiceClientImpl;


public class MainView  {
	
	private ContentView contentView;
	private MenuView m;
	
	public MainView(PersonServiceClientImpl clientImpl) {
		m = new MenuView(this);
		RootPanel.get("nav").add(m);
		
		contentView = new ContentView(clientImpl);
		RootPanel.get("section").add(contentView);	
	}
	
	public void run() {
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
