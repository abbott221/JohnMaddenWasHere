package com.ubuntuserver.frontend;

import java.util.ArrayList;

public class Model_General {
	
	Mediator mediator;
	
	
	
	ArrayList<Graph_Main> graphs;
	
	Graph_Main selectedGraph;
	
	
	Graph_Main firstGraph;
	Graph_Main secondGraph;
	
	
	public Model_General(Mediator med) {
		mediator = med;
		
		graphs = new ArrayList<Graph_Main>();
		
		
		
		
		//600, 400 graph size
		//500, 300 grid size
		firstGraph = new Graph_Main(med, 50, 50, 400, 400);
		firstGraph.setGridSize(300, 300);
		
		int[] xData = {3, 4, 6, 5, 8};
		int[] yData = {5, 6, 7, 3, 4};
		
		firstGraph.setData(xData, yData);
		
		graphs.add(firstGraph);

		
		
		
		/**/
		secondGraph = new Graph_Main(med, 500, 50, 400, 400);
		secondGraph.setGridSize(300, 300);
		
		int[] x2Data = {3, 4, 6, 5, 8, 3, 3, 2};
		int[] y2Data = {5, 6, 7, 3, 4, 3, 2, 4};
		
		secondGraph.setData(x2Data, y2Data);
		
		graphs.add(secondGraph);
		/**/
		
	}
	
	
}
