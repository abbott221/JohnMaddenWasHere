package com.ubuntuserver.frontend.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.ubuntuserver.frontend.Mediator;

public class Model_Event {
	
	
	
	
	
	String eventName;
	String description;
	
	boolean active;
	
	
	int currentStep;
	
	
	
	
	
	
	ArrayList<EventStep> steps;
	
	
	public Model_Event() {
		steps = new ArrayList<EventStep>();
		
		EventStep step1 = new SummaryStep();
		steps.add(step1);
		
		
		
		
		
		for (int i = 0; i < 10; i++) {
			EventStep temp = new SelectBoxStep();
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
		String author;
		
		//change to a time object or something like that?
		String lastChange;
		
		boolean completed;
		//int selection;
	}
	
	
	
	
	public class SummaryStep extends EventStep {
		String summary;
	}
	
	public class SelectBoxStep extends EventStep {
		/**
		 * 0 = nothing selected; shouldn't I remove "boolean completed"?
		 * 1 = first option
		 * 2 = second option
		 */
		int selection;
	}
	
	
	
	
}








