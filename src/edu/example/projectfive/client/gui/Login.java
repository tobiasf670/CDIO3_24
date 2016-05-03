package edu.example.projectfive.client.gui;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
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
		
		Image img = new Image("/images/login.jpg");
		Label un = new Label("Username : ");
		this.uname = new TextBox();
		Label pword = new Label("Password  : ");
		this.pass = new PasswordTextBox();
		final Button btn1 = new Button("Log ind");
		this.loginStatus = new Label("");
		loginStatus.setStyleName("loginError");
		btn1.addClickHandler(new BtnClickHandler());
		pass.addKeyDownHandler(new KeyDownHandler(){

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER){
				btn1.click();	
				}
				
			}
			
		});
		uname.setPixelSize(207, 24);
		this.pass.setPixelSize(207, 24);
		btn1.setPixelSize(100, 30);
		
		vPanel.add(img);
		vPanel.add(un);
		vPanel.add(this.uname);
		vPanel.add(pword);
		vPanel.add(this.pass);
		
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.add(this.loginStatus);
		vPanel.add(btn1);

	}


private class BtnClickHandler implements ClickHandler{
	private String username , password;
	@Override
	public void onClick(ClickEvent event) {
		
		username = uname.getText();
		 password = pass.getText();
		 
		 	clientImpl.service.getPersons(new AsyncCallback<List<Person>>() {

				@Override
				public void onFailure(Throwable caught) {
				}

				@Override
				public void onSuccess(List<Person> result) {
					for(int i = 0; i < result.size(); i++){
						boolean loggedIn = false;
						if(result.get(i).getNavn().equals(username)){
							if (result.get(i).getPassword().equals(password)){
								if (result.get(i).isAdmin()){
									loggedIn = true;
									loginStatus.setText("logged in as admin!");
									clientImpl.setPerson(result.get(i));
									RootPanel.get("section").clear();
									new MainView(clientImpl).run();
									break;
								
								} else if (result.get(i).isOperatoer()){
									loggedIn = true;
									loginStatus.setText("Du er en Operatoer !");
									break;
								} else if (result.get(i).isFarmaceut()){
									loggedIn = true;
									loginStatus.setText("Du er en Farmaceut !");
									break;
								} 
							}
							}
							if(!loggedIn){
								loginStatus.setText("Wrong login! Try again");
							}
						}
					}
			});
		}
	}
}