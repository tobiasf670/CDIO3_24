package edu.example.projectfive.client.gui;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.projectfive.client.service.PersonServiceClientImpl;
import edu.example.projectfive.client.model.*;



public class BrowseView extends Composite {
	VerticalPanel browsePanel;

	// reference to data layer
	// IPersonDAO iPersonDAO;

	public BrowseView(PersonServiceClientImpl clientImpl) {
		//	this.iPersonDAO = iPersonDAO;

		browsePanel = new VerticalPanel();
		initWidget(this.browsePanel);
		Label l1 = new Label("Personer i Systemet");
		l1.setStyleName("label");
		browsePanel.add(l1);

		final FlexTable t = new FlexTable();
		t.getFlexCellFormatter().setWidth(0, 0, "50px");
		t.getFlexCellFormatter().setWidth(0, 1, "200px");
		t.getFlexCellFormatter().setWidth(0, 2, "50px");
	
	

		t.addStyleName("FlexTable");
		t.getRowFormatter().addStyleName(0,"FlexTable-Header");
		
		// set headers in flextable
		t.setText(0, 0, "Id");
		t.setText(0, 1, "Navn");
		t.setText(0, 2, "password");

		// V.1
		//List<PersonDTO> personer = iPersonDAO.getPersons();

		// V.2
		clientImpl.service.getPersons(new AsyncCallback<List<Person>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Server fejl!" + caught.getMessage());
			}

			@Override
			public void onSuccess(List<Person> result) {
				for (int i=0; i < result.size(); i++) {
					t.setText(i+1, 0, "" + result.get(i).getOprId());
					t.setText(i+1, 1, result.get(i).getNavn());
					t.setText(i+1, 2, "" + result.get(i).getPassword());
				}

			}

		});

		browsePanel.add(t);
	}
}
