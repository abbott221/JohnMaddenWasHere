package com.ubuntuserver.frontend;

import java.util.ArrayList;

public class Mediator {
	
	//will be moved to a model if one is created in the future
	ArrayList<Graph_Main> graphs;
	
	Graph_Main drawMe;
	
	
	
	Widgets widgets;
	
	
	public Mediator() {
		
		
		drawMe = new Graph_Main(this, 50, 50, 600, 400);
		drawMe.setGridSize(500, 300);
		
		int[] xData = {3, 4, 6};
		int[] yData = {5, 6, 7};
		
		drawMe.setData(xData, yData);
		
		
		graphs = new ArrayList<Graph_Main>();
		graphs.add(drawMe);
		
		
		widgets = new Widgets(this);
	}
	
	
}
