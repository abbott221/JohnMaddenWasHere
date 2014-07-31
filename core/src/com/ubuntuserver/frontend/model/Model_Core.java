package com.ubuntuserver.frontend.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.Mediator;

/**
 * Put more stuff in here.
 * 
 * Model_General only exists for "Data Reporter."
 * This will kind of serve as a mediator for everything
 * not related to "Data Reporter" in order to keep
 * MainCoreClass from getting cluttered.
 * 
 * 
 * @author michael
 *
 */
public class Model_Core {
	
	public MainCoreClass core;
	
	
	/**
	 * true = circumvent networking
	 * false = publish
	 */
	public final boolean offlineMode = true;
	
	
	public ArrayList<Model_Event> events;
	//public int selectedEvent;
	public Model_Event selectedEvent;
	
	
	
	//SB_General thisShouldNotBeHere;
	
	
	
	
	public String username;
	public String firstname;
	public String lastname;
	public int id = 0;
	public String email;
	public String rights;
	
	
	
	
	//create new instances here
	public Model_Core(MainCoreClass c) {
		
		//System.out.println("Model_Core constructed");
		
		core = c;
		
		
		
		events = new ArrayList<Model_Event>();
		//Model_Event example = new Model_Event();
		
		
		//thisShouldNotBeHere = new SB_General();
		
	}
	
	
	
	//give possibly dependent meaning of those new instances here
	public void fillModel() {
		Model_Event example = new Model_Event();
		example.eventName = "Example Fake Event 1";
		example.date = "7/29/14";
		example.active = true;
		
		events.add(example);
		
		
		Model_Event example2 = new Model_Event();
		example2.eventName = "Example Fake Event 2";
		example2.date = "7/30/14";
		example2.active = true;
		
		events.add(example2);
	}
	
	
	
	
	public void userlogin(String[] credentials)
	{
		//loggedIn = true;
		id = Integer.parseInt(credentials[0]);
		username = credentials[1];
		lastname = credentials[2];
		firstname = credentials[3];
		email = credentials[4];
		rights = credentials[5];
	}
	
}



