package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Mediator {
	
	//will be moved to a model if one is created in the future
	//ArrayList<Graph_Main> graphs;
	
	//Graph_Main drawMe;
	
	public MainCoreClass core;
	
	
	
	
	public Model_General model;
	
	
	
	public Widgets widgets;
	public Widgets2 widgets2;
	public Widgets_Scrollpanes scrollpanes;
	
	
	
	public Stage stage;
	
	public int displayHeight;
	public int displayWidth;
	
	
	
	public boolean boxActivity = false;
	
	
	
	
	public Mediator(Stage newStage) {
		
		stage = newStage;
		
		model = new Model_General(this);
		
		
		
		widgets = new Widgets(this);
		widgets2 = new Widgets2(this);
		scrollpanes = new Widgets_Scrollpanes(this);
		
		
		model.fillModel();
		
	}
	
	
	public void registerCore(MainCoreClass newObject) {
		core = newObject;
	}
	
	
	
}





