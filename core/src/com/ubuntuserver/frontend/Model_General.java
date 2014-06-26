package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Model_General {
	
	public Mediator mediator;
	
	
	
	
	public ArrayList<Graph_Main> graphs;
	
	public Graph_Main selectedGraph;
	
	public Graph_Main bigGraph;
	
	
	
	
	
	public ArrayList<Model_Station> stations;
	
	
	
	public boolean thumbnailsView = true;
	boolean scrollpanesView = false;
	
	
	
	public Model_General(Mediator med) {
		
		mediator = med;
		
		
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
		
		float[] tempGauge = {2, 3, 4, 5,   4, 5, 6, 7,   6, 7, 8, 9};
		float[] tempForecast = {2, 3, 4,   3, 4, 5,   4, 5, 6,   5, 6, 7};
		
		Model_Station tempStation = new Model_Station(mediator);
		tempStation.setGauge(tempGauge);
		tempStation.setForecast(tempForecast);
		
		stations.add(tempStation);
		
		
		
		float[] tempGauge2 = {9, 8, 7, 6, 7, 6, 5, 4, 5, 4, 3, 2};
		float[] tempForecast2 = {7, 6, 5, 6, 5, 4, 5, 4, 3, 4, 3, 2};
		
		Model_Station tempStation2 = new Model_Station(mediator);
		tempStation2.setGauge(tempGauge2);
		tempStation2.setForecast(tempForecast2);
		
		stations.add(tempStation2);
		
		
		
		float[] tempGauge3 = {3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6};
		float[] tempForecast3 = {3, 4, 5, 3, 4, 5, 3, 4, 5, 3, 4, 5};
		
		Model_Station tempStation3 = new Model_Station(mediator);
		tempStation3.setGauge(tempGauge3);
		tempStation3.setForecast(tempForecast3);
		
		stations.add(tempStation3);
		
		
		
		
		
		Graph_Main tempGraph1 = new Graph_Main(mediator, this);
		graphs.add(tempGraph1);
		
		
		Graph_Main tempGraph2 = new Graph_Main(mediator, this);
		graphs.add(tempGraph2);
		
		
		
		//if thumbnails is checked, selectedGraph can't be null
		//Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
		
		
		selectedGraph = tempGraph1;
		
		bigGraph = tempGraph1;
		
		
		Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
	}
	
	
	
	
	
}
