package com.ubuntuserver.frontend;

import java.util.ArrayList;

public class Model_Station {
	
	Mediator mediator;
	
	public float[] gauge;
	public float[] forecast;
	
	
	public int gaugeCount;
	public int forecastCount;
	
	
	
	public Model_Station(Mediator med) {
		
		mediator = med;
		
		
	}
	
	
	
	public void setGauge(float[] newData) {
		gauge = newData;
		gaugeCount = newData.length;
	}
	
	
	
	public void setForecast(float[] newData) {
		forecast = newData;
		forecastCount = newData.length;
	}
	
	
}



