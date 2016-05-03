package edu.example.projectfive.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;



public class MenuView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();

	public MenuView(final MainView mainView) {
		initWidget(this.vPanel);
		
		Anchor showPersons = new Anchor("Vis personer");
		vPanel.add(showPersons);
		showPersons.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){	
			
				mainView.showPersons();
			}
		});
	
		// use unicode escape sequence \u00F8 for 'ø'
		Anchor add = new Anchor("Tilf\u00F8j person");
		vPanel.add(add);
		add.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
				mainView.addPerson();
			}
		});
		
		Anchor edit = new Anchor("Ret person");
		vPanel.add(edit);
		edit.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
			mainView.editPersons();
			}
		});
		
		Anchor delete = new Anchor("Slet person");
		delete.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
			mainView.deletePersons();
			}
		});
		vPanel.add(delete);
	
	
	Anchor logOut = new Anchor("Log Ud");
	vPanel.add(logOut);
	
	logOut.addClickHandler(new ClickHandler(){
		public void onClick(ClickEvent event){	
		mainView.logOut();
		}
	});
	
	
}
	public VerticalPanel getVpanel(){
		return vPanel;
	}
}