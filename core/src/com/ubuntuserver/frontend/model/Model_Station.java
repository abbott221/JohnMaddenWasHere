package com.ubuntuserver.frontend.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.ubuntuserver.frontend.Mediator;

public class Model_Station {
	
	Mediator mediator;
	
	//public float[] gauge;
	public float[] forecast;
	
	
	//public int gaugeCount;
	public int forecastCount;
	
	
	
	public ArrayList<GaugeRecord> records;
	
	//====================================================
	
	public ArrayList<AlertLevel> alerts;
	
	//check if less than 0 for displaying stuff on graph
	public float yBottom = -1;
	public float yTop = -1;
	
	
	
	
	public class AlertLevel {
		public Color lineColor;
		
		//alert, warning, name, seasonal level, standard level, etc.
		//display this string in a label next to the line?
		public String purpose;
		
		public float waterLevel;
	}
	
	
	public class GaugeRecord {
		public String timeStamp;
		
		public float waterLevel;
	}
	
	
	
	public Model_Station(Mediator med) {
		
		mediator = med;
		
		records = new ArrayList<GaugeRecord>();
		
		alerts = new ArrayList<AlertLevel>();
	}
	
	
	
	
	public void addAlertLine(Color newColor, String name, float level) {
		AlertLevel temp = new AlertLevel();
		
		temp.lineColor = newColor;
		temp.purpose = name;
		temp.waterLevel = level;
		
		alerts.add(temp);
	}
	
	
	public void addRecord(String stamp, float level) {
		GaugeRecord temp = new GaugeRecord();
		
		temp.timeStamp = stamp;
		temp.waterLevel = level;
		
		records.add(temp);
	}
	
	
	
	
	
	
	public void setYScale(float yBottomIn, float yTopIn) {
		this.yBottom = yBottomIn;
		this.yTop = yTopIn;
	}
	
	
	
	/*
	public void setGauge(float[] newData) {
		gauge = newData;
		gaugeCount = newData.length;
	}
	/**/
	
	
	public void setForecast(float[] newData) {
		forecast = newData;
		forecastCount = newData.length;
	}
	
	
}



