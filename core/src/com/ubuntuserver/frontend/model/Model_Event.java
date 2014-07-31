package com.ubuntuserver.frontend.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.ubuntuserver.frontend.Mediator;

public class Model_Event {
	
	
	
	
	
	public String eventName;
	public String description;
	public String date;
	
	public boolean active = false;
	
	
	//change to a EventStep object? or unnecessary?
	//public int currentStep = 0;
	
	
	
	
	
	
	public ArrayList<EventStep> steps;
	
	
	public Model_Event() {
		steps = new ArrayList<EventStep>();
		
		EventStep step1 = new SummaryStep();
		steps.add(step1);
		
		
		
		
		
		for (int i = 0; i < 10; i++) {
			//EventStep temp = new SelectBoxStep();
			SelectBoxStep temp = new SelectBoxStep();
			temp.selection = 0;
			steps.add(temp);
		}
		
		
		//System.out.println( "step count: " + steps.size() );
	}
	
	
	
	/*
	public void addStep() {
		//
	}
	/**/
	
	
	
	
	//public class action {
	public class EventStep {
		public String author;
		
		//change to a time object or something like that?
		public String lastChange;
		
		
		
		public boolean completed = false;
		//int selection;
	}
	
	
	
	
	public class SummaryStep extends EventStep {
		public String summary;
	}
	
	public class SelectBoxStep extends EventStep {
		/**
		 * 0 = nothing selected; shouldn't I remove "boolean completed"?
		 * 1 = first option
		 * 2 = second option
		 */
		public int selection = 0;
	}
	
	
	
	
}








