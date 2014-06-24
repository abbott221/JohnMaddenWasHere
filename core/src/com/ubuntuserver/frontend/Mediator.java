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
	
	
	
	
	public Mediator(Stage newStage) {
		
		stage = newStage;
		
		model = new Model_General(this);
		
		//graphs = new ArrayList<Graph_Main>();
		
		
		
		/*
		
		drawMe = new Graph_Main(this, 50, 50, 600, 400);
		drawMe.setGridSize(500, 300);
		
		int[] xData = {3, 4, 6, 5, 8};
		int[] yData = {5, 6, 7, 3, 4};
		
		drawMe.setData(xData, yData);
		
		model.graphs.add(drawMe);
		//graphs.add(drawMe);
		
		/**/
		
		
		
		
		widgets = new Widgets(this);
		
		
		
		
		
		model.fillModel();
		
	}
	
	
}
