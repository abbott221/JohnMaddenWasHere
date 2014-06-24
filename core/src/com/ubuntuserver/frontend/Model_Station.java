package com.ubuntuserver.frontend;

import java.util.ArrayList;

public class Model_Station {
	
	Mediator mediator;
	
	public int[] gauge;
	public int[] forecast;
	
	
	public int gaugeCount;
	public int forecastCount;
	
	
	
	public Model_Station(Mediator med) {
		
		mediator = med;
		
		
	}
	
	
	
	public void setGauge(int[] newData) {
		gauge = newData;
		gaugeCount = newData.length;
	}
	
	
	
	public void setForecast(int[] newData) {
		forecast = newData;
		forecastCount = newData.length;
	}
	
	
}



