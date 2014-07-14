package com.ubuntuserver.frontend.ListenerEvents;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.Logic.Logic_DateStrings;
import com.ubuntuserver.frontend.Logic.Logic_Dates;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Logic_EventCall {
	
	
	/*
	 * Call the scripts that you want to run on each Widget change event from
	 * within the functions below.
	 */
	
	
	
	public static void startDateEvent(Mediator mediator, SelectBox startDateBox) {
		System.out.println("Start Date Change");
		
		Logic_DateStrings.startDateChange(mediator, startDateBox);
		
	}
	
	
	
	public static void endDateEvent(Mediator mediator, SelectBox endDateBox) {
		System.out.println("End Date Change");
		
		Logic_DateStrings.endDateChange(mediator, endDateBox);
		
	}
	
	
	
	public static void stationEvent(Mediator mediator, SelectBox stationBox) {
		System.out.println("Station Change");
		
		Logic_Dates.stationChange(mediator, stationBox);
		
	}
	
	
}





