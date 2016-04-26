package edu.example.projectfive.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Widget;

import edu.example.projectfive.client.gui.Login;
import edu.example.projectfive.client.model.Person;

public class PersonServiceClientImpl  {
		
	public PersonServiceAsync service;
	
	public PersonServiceClientImpl(String url){
		this.service = GWT.create(PersonService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
		endpoint.setServiceEntryPoint(url);
		
		//this.maingui = new MainView(this);
	}

//	public MainView getMainGUI() {
	
	//	return this.maingui;
	//	}
	}

