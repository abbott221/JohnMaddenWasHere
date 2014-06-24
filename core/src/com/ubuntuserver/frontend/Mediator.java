package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Mediator {
	
	//will be moved to a model if one is created in the future
	//ArrayList<Graph_Main> graphs;
	
	//Graph_Main drawMe;
	
	Model_General model;
	
	Widgets widgets;
	
	Stage stage;
	
	public int displayHeight;
	public int displayWidth;
	
	
	
	
	//old system
	//public boolean widgetChanging = false;
	
	//new system
	public boolean boxActivity = false;
	
	
	

	//Logic_Construction
	public Mediator() {
		//
	}
	
	
	
	public Mediator(Stage newStage) {
		
		stage = newStage;
		
		model = new Model_General(this);
		
		//graphs = new ArrayList<Graph_Main>();
		
		
		
		
		widgets = new Widgets(this);
	}
	
	
	
	
	
}
