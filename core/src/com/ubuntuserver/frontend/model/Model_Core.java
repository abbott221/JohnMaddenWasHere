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
	
	
	
	
	public String forecastLine = "";
	
	
	//public String targetURL = "http://10.119.0.52/michael/michael_recorded.php";
	//public String targetURL = "http://localhost/FCEMHS/michael/michael_recorded.php";
	
	//public String targetURL = "http://localhost/FCEMHS/";
	public String targetURL = "http://10.119.0.52/";
	
	
	
	
	
	//public int networkResponse = 0;
	public boolean buttonWaiting = false;
	public boolean networkResponse = false;
	
	
	
	
	/**
	 * true = circumvent networking
	 * false = publish
	 */
	public final boolean offlineMode = true;
	//public final boolean offlineMode = false;
	
	
	public ArrayList<Model_Event> events;
	//public int selectedEvent;
	public Model_Event selectedEvent;
	
	
	
	
	
	
	public int pageOnePosition = 0;
	public String pageOneString = "Gage site name\nWater level\nLast reading time\n"
				+ "Increase rate in the last 4 hours\nActual precipitation\nForecast\n"
				+ "Flood warning issued: (all alert records in alert table"
				+ " for the last 3 hours)";
	
	
	
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



