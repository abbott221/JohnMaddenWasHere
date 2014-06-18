package com.ubuntuserver.frontend;

import java.util.ArrayList;

public class Model_General {
	
	Mediator mediator;
	
	
	
	ArrayList<Graph_Main> graphs;
	
	Graph_Main selectedGraph;
	
	
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
		//firstGraph.setGridSize(300, 300);
		//setSizeByCount at end of initializing some graphs
		
		//int[] xData = {3, 4, 6, 5, 8};
		//int[] yData = {5, 6, 7, 3, 4};
		
		//data is set to waterData in the constructor
		//firstGraph.setData(xData, yData);
		
		graphs.add(firstGraph);
		
		
		
		

		
		
		
		/**/
		secondGraph = new Graph_Main(med, 500, 50, 400, 400);
		secondGraph.setGridSize(300, 300);
		
		int[] x2Data = {3, 4, 6, 5, 8, 3, 3, 2};
		int[] y2Data = {5, 6, 7, 3, 4, 3, 2, 4};
		
		secondGraph.setData(x2Data, y2Data);
		
		graphs.add(secondGraph);
		/**/
		
		Graph_Main thirdGraph = new Graph_Main(med, 500, 50, 400, 400);
		thirdGraph.setGridSize(300, 300);
		
		int[] x3Data = {3, 4, 6, 5, 8, 3, 3, 2};
		int[] y3Data = {5, 6, 7, 3, 4, 3, 2, 4};
		
		thirdGraph.setData(x3Data, y3Data);
		
		graphs.add(thirdGraph);
		
		
		Graph_Main fourthGraph = new Graph_Main(med, 500, 50, 400, 400);
		fourthGraph.setGridSize(300, 300);
		
		int[] x4Data = {3, 4, 6, 5, 8, 3, 3, 2};
		int[] y4Data = {5, 6, 7, 3, 4, 3, 2, 4};
		
		fourthGraph.setData(x4Data, y4Data);
		
		graphs.add(fourthGraph);
		
		
		Graph_Main fifthGraph = new Graph_Main(med, 500, 50, 400, 400);
		fifthGraph.setGridSize(300, 300);
		
		int[] x5Data = {3, 4, 6, 5, 8, 3, 3, 2};
		int[] y5Data = {5, 6, 7, 3, 4, 3, 2, 4};
		
		fifthGraph.setData(x5Data, y5Data);
		
		graphs.add(fifthGraph);
		
		
		
		
		//System.out.println( graphs.size() );
		Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
		selectedGraph = firstGraph;
		
	}
	
	
}
