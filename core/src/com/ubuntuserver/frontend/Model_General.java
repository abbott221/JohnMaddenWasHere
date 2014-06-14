package com.ubuntuserver.frontend;

import java.util.ArrayList;

public class Model_General {
	
	Mediator mediator;
	
	ArrayList<Graph_Main> graphs;
	
	
	
	
	
	public Model_General(Mediator med) {
		mediator = med;
		
		graphs = new ArrayList<Graph_Main>();
	}
	
	
}
