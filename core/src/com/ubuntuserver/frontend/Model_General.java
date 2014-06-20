package com.ubuntuserver.frontend;

import java.util.ArrayList;

public class Model_General {
	
	Mediator mediator;
	
	
	
	ArrayList<Graph_Main> graphs;
	
	Graph_Main selectedGraph;
	
	Graph_Main bigGraph;
	
	
	Graph_Main firstGraph;
	Graph_Main secondGraph;
	
	public int[] waterData;
	int waterDataSize;
	
	
	
	public Model_General(Mediator med) {
		
		mediator = med;
		
		
		//int[] temp = {5, 6, 7, 3, 4, 3, 2, 4};
		int[] temp = {5, 6, 7, 5, 6, 3, 4, 2, 6, 5, 7, 3};
		waterData = temp;
		waterDataSize = waterData.length;
		
		
		
		
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
		
		firstGraph = new Graph_Main(med, this);
		
		graphs.add(firstGraph);
		
		
		
		
		
		
		
		
		
		//System.out.println( graphs.size() );
		Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
		selectedGraph = firstGraph;
		
		bigGraph = firstGraph;
		
	}
	
	
}
