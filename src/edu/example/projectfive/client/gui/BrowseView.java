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
		
	
	

		t.addStyleName("FlexTable");
		t.getRowFormatter().addStyleName(0,"FlexTable-Header");
		
		// set headers in flextable
		t.setText(0, 0, "Id");
		t.setText(0, 1, "Navn");
		t.setText(0, 2, "Ini");
		t.setText(0, 3, "Cpr");
		t.setText(0, 4, "password");
		t.setText(0, 5, "Admin");
		t.setText(0, 6, "Operatoer");
		t.setText(0, 7, "Farmaceut");

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
					t.setText(i+1, 1, "" + result.get(i).getNavn());
					t.setText(i+1, 2, "" + result.get(i).getIni());
					t.setText(i+1, 3, "" + result.get(i).getCpr());
					t.setText(i+1, 4, "" + result.get(i).getPassword());
					t.setText(i+1, 5, "" + result.get(i).isAdmin());
					t.setText(i+1, 6, "" + result.get(i).isOperatoer());
					t.setText(i+1, 7, "" + result.get(i).isFarmaceut());
				}

			}

		});

		browsePanel.add(t);
	}
}
