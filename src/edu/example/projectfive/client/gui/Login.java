package edu.example.projectfive.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


import edu.example.projectfive.client.model.Person;
import edu.example.projectfive.client.service.PersonServiceClientImpl;
import edu.example.projectfive.server.PersonServiceImpl;



public class Login extends Composite {
	private PersonServiceClientImpl clientImpl ;
	
	
	private VerticalPanel vPanel = new VerticalPanel ();
	private TextBox uname;
	private PasswordTextBox pass;
	private Label loginStatus;
	
	
	public Login(PersonServiceClientImpl clientImpl ){

		this.clientImpl = clientImpl;
		HTML label1 = new HTML(new SafeHtmlBuilder().appendEscapedLines("\n  ").toSafeHtml());
		this.vPanel.add(label1);
		initWidget(this.vPanel);
		
		vPanel.setStyleName("style");
		
		// create all components used on the page
		Image img = new Image("/images/login.jpg");
		Label un = new Label("Username : ");
		this.uname = new TextBox();
		Label pword = new Label("Password  : ");
		this.pass = new PasswordTextBox();
		HTML label = new HTML(new SafeHtmlBuilder().appendEscapedLines("\n").toSafeHtml());
		Button btn1 = new Button("Log ind");
		this.loginStatus = new Label("Test");
		btn1.addClickHandler(new BtnClickHandler());
		   
		
		//sets the size of the elements
		uname.setPixelSize(207, 24);
		this.pass.setPixelSize(207, 24);
		btn1.setPixelSize(100, 30);
		
		// insert the different things on the website
		vPanel.add(img);
		vPanel.add(un);
		vPanel.add(this.uname);
		vPanel.add(pword);
		vPanel.add(this.pass);
		vPanel.add(label);	
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.add(btn1);
		vPanel.add(this.loginStatus);
		
		//btn1.addClickHandler(new BtnClickHandler());

	}


private class BtnClickHandler implements ClickHandler{
	private String username , password;
	private int id ;
	@Override
	public void onClick(ClickEvent event) {
		
		username = uname.getText();
		 password = pass.getText();
		 
		
			 id = Integer.parseInt(username);
			 loginStatus.setText(id+"");
			clientImpl.service.getOperatoer(id, new AsyncCallback<Person>(){
				
			
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					loginStatus.setText("FEJL! " + caught.getMessage());
					
				}

				@Override
				public void onSuccess(Person result) {
					// TODO Auto-generated method stub
					loginStatus.setText("Morten din noob");
					if (result.getOprId() == id){
						if (result.getPassword().equals(password)){
							loginStatus.setText("LOGGED IN PROPERLY!");
							RootPanel.get("section").clear();
							new MainView(clientImpl).run();
							
						}
					}
					
				}

				
		
	});
	
}
	

}

}
	



