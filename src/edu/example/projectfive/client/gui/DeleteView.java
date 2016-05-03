package edu.example.projectfive.client.gui;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.projectfive.client.model.Person;
import edu.example.projectfive.client.service.PersonServiceClientImpl;


public class DeleteView extends Composite {
	VerticalPanel deletePanel;
	FlexTable t;
	PersonServiceClientImpl clientImpl;
	Anchor previousCancel = null;

	public DeleteView(final PersonServiceClientImpl clientImpl) {
		this.clientImpl = clientImpl;
		deletePanel = new VerticalPanel();
		initWidget(this.deletePanel);

		t = new FlexTable();
		t.addStyleName("FlexTable");
		t.getRowFormatter().addStyleName(0,"FlexTable-Header");

		t.setText(0, 0, "Id");
		t.setText(0, 1, "Navn");
		t.setText(0, 2, "Cpr");
		t.setText(0, 3, "password");
		t.setText(0, 4, "Admin");
		t.setText(0, 5, "Operatoer");
		t.setText(0, 6, "Farmaceut");

		clientImpl.service.getPersons(new AsyncCallback<List<Person>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Server fejl!");
			}

			@Override
			public void onSuccess(List<Person> result) {
				// populate table and add delete anchor to each row
				for (int i=0; i < result.size(); i++) {
					if(result.get(i).getOprId() != clientImpl.getLoggedUser().getOprId()){
						t.setText(i+1, 0, "" + result.get(i).getOprId());
						t.setText(i+1, 1, "" + result.get(i).getNavn());
						t.setText(i+1, 2, "" + result.get(i).getCpr());
						t.setText(i+1, 3, "" + result.get(i).getPassword());
						t.setText(i+1, 4, "" + result.get(i).isAdmin());
						t.setText(i+1, 5, "" + result.get(i).isOperatoer());
						t.setText(i+1, 6, "" + result.get(i).isFarmaceut());
						Anchor delete = new Anchor("delete");
						t.setWidget(i+1, 7, delete);
						delete.addClickHandler(new DeleteHandler());
					}
				}

			}

		});

		deletePanel.add(t);
	}

	private class DeleteHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			if (previousCancel != null)
				previousCancel.fireEvent(new ClickEvent(){});

			final int eventRowIndex = t.getCellForEvent(event).getRowIndex();

			final Anchor delete =  (Anchor) event.getSource();

			Anchor ok = new Anchor("ok");
			ok.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {				
					clientImpl.service.deletePerson(Integer.parseInt(t.getText(eventRowIndex, 0)), Boolean.parseBoolean(t.getText(eventRowIndex, 4)), Boolean.parseBoolean(t.getText(eventRowIndex, 5)), Boolean.parseBoolean(t.getText(eventRowIndex, 6)), new AsyncCallback<Void>() {

						@Override
						public void onSuccess(Void result) {
							deletePanel.clear();
							DeleteView DV = new DeleteView(clientImpl);
							deletePanel.add(DV);
						}

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Server fejl!" + caught.getMessage());
						}

					});
					t.removeRow(eventRowIndex);
				}
			});

			Anchor cancel = new Anchor("cancel");
			previousCancel = cancel;
			cancel.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					t.setWidget(eventRowIndex, 7, delete);
					t.clearCell(eventRowIndex, 8);
				}

			});
			t.setWidget(eventRowIndex, 7 , ok);
			t.setWidget(eventRowIndex, 8 , cancel);
		}
	}
}


