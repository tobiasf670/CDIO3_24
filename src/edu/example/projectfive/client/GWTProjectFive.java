package edu.example.projectfive.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import edu.example.projectfive.client.gui.MainView;
import edu.example.projectfive.client.service.PersonServiceClientImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTProjectFive implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		PersonServiceClientImpl clientImpl = new PersonServiceClientImpl(GWT.getModuleBaseURL() + "personservice");
		RootPanel.get().add(new MainView(clientImpl));
	}
}
