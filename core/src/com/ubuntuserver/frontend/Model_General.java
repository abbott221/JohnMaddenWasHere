package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Logic.Logic_JSON;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Model_General {
	
	public Mediator mediator;
	
	
	
	
	public ArrayList<Graph_Main> graphs;
	
	public Graph_Main selectedGraph;
	
	public Graph_Main bigGraph;
	
	
	
	
	
	public ArrayList<Model_Station> stations;
	
	
	
	public boolean thumbnailsView = true;
	public boolean scrollpanesView = false;
	
	
	
	
	public String bigJSON;
	
	
	
	
	public Model_General(Mediator med) {
		
		mediator = med;
		
		
		
		//FileHandle file = Gdx.files.internal("waterlevel.json");
		FileHandle file = Gdx.files.internal("waterlevelSys.json");
		this.bigJSON = file.readString();
		System.out.println(this.bigJSON);
		
		
		
		
		//int[] temp = {5, 6, 7, 3, 4, 3, 2, 4};
		//int[] temp = {5, 6, 7, 5, 6, 3, 4, 2, 6, 5, 7, 3};
		
		
		//waterData = temp;
		//waterDataSize = waterData.length;
		
		
		
		
		stations = new ArrayList<Model_Station>();
		
		
		
		
		graphs = new ArrayList<Graph_Main>();
		
		
		
		
		selectedGraph = null;
		bigGraph = null;
		
	}
	
	
	
	public void fillModel() {
		
		
		//run the Logic_JSON script here but with the other text
		//Logic_JSON.getJSONfromURL(mediator);
		
		//Logic_JSON.parseJSONfromString(mediator, this.bigJSON);
		
		
		
		
		float[] tempGauge1 = {2, 3, 4, 5,   4, 5, 6, 7,   6, 7, 8, 9};
		float[] tempForecast1 = {2, 3, 4,   3, 4, 5,   4, 5, 6,   5, 6, 7};
		
		Model_Station tempStation1 = new Model_Station(mediator);
		tempStation1.setGauge(tempGauge1);
		tempStation1.setForecast(tempForecast1);
		
		tempStation1.addAlertLine(Color.RED, "warning", 848.5f);
		tempStation1.addAlertLine(Color.GREEN, "standard", 600);
		
		tempStation1.setYScale(845.0f, 855.0f);
		
		stations.add(tempStation1);
		
		
		
		float[] tempGauge2 = {9, 8, 7, 6, 7, 6, 5, 4, 5, 4, 3, 2};
		float[] tempForecast2 = {7, 6, 5, 6, 5, 4, 5, 4, 3, 4, 3, 2};
		
		Model_Station tempStation2 = new Model_Station(mediator);
		tempStation2.setGauge(tempGauge2);
		tempStation2.setForecast(tempForecast2);
		
		tempStation2.addAlertLine(Color.RED, "warning", 4);
		tempStation2.addAlertLine(Color.GREEN, "standard", 3);
		
		stations.add(tempStation2);
		
		
		
		float[] tempGauge3 = {3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6};
		float[] tempForecast3 = {3, 4, 5, 3, 4, 5, 3, 4, 5, 3, 4, 5};
		
		Model_Station tempStation3 = new Model_Station(mediator);
		tempStation3.setGauge(tempGauge3);
		tempStation3.setForecast(tempForecast3);
		
		tempStation3.addAlertLine(Color.RED, "warning", 4);
		tempStation3.addAlertLine(Color.GREEN, "standard", 3);
		
		stations.add(tempStation3);
		
		
		
		
		
		Graph_Main tempGraph1 = new Graph_Main(mediator, this);
		graphs.add(tempGraph1);
		
		
		Graph_Main tempGraph2 = new Graph_Main(mediator, this);
		graphs.add(tempGraph2);
		
		
		
		//if thumbnails is checked, selectedGraph can't be null
		//Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
		
		
		selectedGraph = tempGraph1;
		
		bigGraph = tempGraph1;
		
		
		
		
		Logic_JSON.parseJSONfromString(mediator, this.bigJSON);
		
		
		
		
		Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
	}
	
	
	
	
	
}
