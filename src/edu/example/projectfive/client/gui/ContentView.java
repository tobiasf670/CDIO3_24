package edu.example.projectfive.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.projectfive.client.service.PersonServiceClientImpl;



public class ContentView extends Composite {

	private PersonServiceClientImpl clientImpl;

	VerticalPanel contentPanel;

	public ContentView() {
	}

	public ContentView(PersonServiceClientImpl clientImpl) {
		this.clientImpl = clientImpl;
		contentPanel = new VerticalPanel();
		initWidget(this.contentPanel);
	}	

	// Sub views
	public void openUserView() {
		contentPanel.clear();
		UserView welcomeView = new UserView(clientImpl);
		contentPanel.add(welcomeView);
		contentPanel.setStyleName("style");
	}

	public void openAddView() {
		contentPanel.clear();
		AddView AV = new AddView (clientImpl);
		contentPanel.add(AV);
		contentPanel.setStyleName("style");
	}

	public void openBrowseView() {
		contentPanel.clear();
		BrowseView BV = new BrowseView(clientImpl);
		contentPanel.add(BV);
		contentPanel.setStyleName("style");
		
	}

	public void openEditView() {
		contentPanel.clear();
		EditView EV = new EditView(clientImpl);
		contentPanel.add(EV);
		contentPanel.setStyleName("style");
	}

	public void openDeleteView() {
		contentPanel.clear();
		DeleteView DV = new DeleteView(clientImpl);
		contentPanel.add(DV);
		contentPanel.setStyleName("style");
		
	}
	
	public void openLogOutView(){
		contentPanel.clear();
		Login LI = new Login(clientImpl);
		contentPanel.add(LI);
		contentPanel.setStyleName("style");
	}
}
