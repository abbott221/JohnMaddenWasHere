package com.ubuntuserver.frontend;

import java.util.ArrayList;

public class Model_Graph {
	
	Mediator mediator;
	
	
	
	
	public static enum ShowMode {
		SHOW_GAUGE, SHOW_FORECAST
	}
	public ShowMode dataMode;
	/**/
	public int[] data;
	public int dataCount;
	/**/
	
	
	public int dataClipStart;
	public int dataClipEnd;
	
	public Model_Station myStation;
	
	
	public Model_Graph(Mediator med, Model_General mod) {
		
		mediator = med;
		
		
		
		
		myStation = mod.stations.get(0);
		dataMode = ShowMode.SHOW_GAUGE;
	}
	
	
	
	/*
	public void setDefault() {
		//x = xNew;
	}
	/**/
	
	
	
	public void setData(int[] newData) {
		//x = xNew;
		data = newData;
		
		//xCount = xNew.length;
		dataCount = newData.length;
	}
	
	
	
}
