package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;

public class Model_Station {
	
	Mediator mediator;
	
	public float[] gauge;
	public float[] forecast;
	
	
	public int gaugeCount;
	public int forecastCount;
	
	
	//====================================================
	
	ArrayList<AlertLevel> alerts;
	
	//check if less than 0 for displaying stuff on graph
	float yBottom = -1;
	float yTop = -1;
	
	
	
	
	class AlertLevel {
		Color lineColor;
		
		//alert, warning, name, seasonal level, standard level, etc.
		//display this string in a label next to the line?
		String purpose;
		
		float waterLevel;
	}
	
	
	
	
	
	public Model_Station(Mediator med) {
		
		mediator = med;
		
		alerts = new ArrayList<AlertLevel>();
	}
	
	
	
	
	public void addAlertLine(Color newColor, String name, float level) {
		AlertLevel temp = new AlertLevel();
		
		temp.lineColor = newColor;
		temp.purpose = name;
		temp.waterLevel = level;
		
		alerts.add(temp);
	}
	
	public void setYScale(float yBottomIn, float yTopIn) {
		this.yBottom = yBottomIn;
		this.yTop = yTopIn;
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



