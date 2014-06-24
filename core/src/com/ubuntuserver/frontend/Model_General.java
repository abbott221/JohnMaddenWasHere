package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Model_General {
	
	Mediator mediator;
	
	
	
	
	ArrayList<Graph_Main> graphs;
	
	Graph_Main selectedGraph;
	
	Graph_Main bigGraph;
	
	
	
	
	//Graph_Main firstGraph;
	//Graph_Main secondGraph;
	
	
	
	
	//public int[] waterData;
	//int waterDataSize;
	
	
	ArrayList<Model_Station> stations;
	
	//Model_Station firstStation;
	
	
	
	public Model_General(Mediator med) {
		
		mediator = med;
		
		
		//int[] temp = {5, 6, 7, 3, 4, 3, 2, 4};
		int[] temp = {5, 6, 7, 5, 6, 3, 4, 2, 6, 5, 7, 3};
		
		
		//waterData = temp;
		//waterDataSize = waterData.length;
		
		
		
		
		stations = new ArrayList<Model_Station>();
		
		
		
		int[] tempGauge = {2, 3, 4, 5, 4, 5, 6, 7, 6, 7, 8, 9};
		int[] tempForecast = {2, 3, 4, 3, 4, 5, 4, 5, 6, 5, 6, 7};
		
		Model_Station tempStation = new Model_Station(mediator);
		tempStation.setGauge(tempGauge);
		tempStation.setForecast(tempForecast);
		
		stations.add(tempStation);
		
		
		
		int[] tempGauge2 = {9, 8, 7, 6, 7, 6, 5, 4, 5, 4, 3, 2};
		int[] tempForecast2 = {7, 6, 5, 6, 5, 4, 5, 4, 3, 4, 3, 2};
		
		Model_Station tempStation2 = new Model_Station(mediator);
		tempStation2.setGauge(tempGauge2);
		tempStation2.setForecast(tempForecast2);
		
		stations.add(tempStation2);
		
		/*
		System.out.println("Value: " + tempStation2.gauge[3]);
		/**/
		
		
		int[] tempGauge3 = {3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6};
		int[] tempForecast3 = {3, 4, 5, 3, 4, 5, 3, 4, 5, 3, 4, 5};
		
		Model_Station tempStation3 = new Model_Station(mediator);
		tempStation3.setGauge(tempGauge3);
		tempStation3.setForecast(tempForecast3);
		
		stations.add(tempStation3);
		
		
		//System.out.println(stations.size());
		
		
		
		
		graphs = new ArrayList<Graph_Main>();
		
		
		
		
		/*
		//600, 400 graph size
		//500, 300 grid size
		//firstGraph = new Graph_Main(med, 50, 50, 400, 400);
		firstGraph = new Graph_Main(med, 25, 25, 400, 400);
		firstGraph.setGridSize(300, 300);
		
		int[] xData = {3, 4, 6, 5, 8};
		int[] yData = {5, 6, 7, 3, 4};
		
		firstGraph.setData(xData, yData);
		
		graphs.add(firstGraph);
		/**/
		
		//====================================================
		
		
		
		Graph_Main tempGraph1 = new Graph_Main(med, this);
		
		graphs.add(tempGraph1);
		
		
		
		
		Graph_Main tempGraph2 = new Graph_Main(med, this);
		
		graphs.add(tempGraph2);
		//tempGraph2.dataModel.myStation = stations.get(1);
		//tempGraph2.dataModel.dataMode = ShowMode.SHOW_FORECAST;
		
		
		
		
		
		
		
		//System.out.println( graphs.size() );
		Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
		selectedGraph = tempGraph1;
		
		bigGraph = tempGraph1;
		
	}
	
	
}
