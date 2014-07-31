package com.ubuntuserver.frontend;

import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.ubuntuserver.frontend.model.Model_Station;

public class Report_Generator {
	
	String s1 = "O'shaughness Dam";
	String s2 = "Alum Creek - Africa Road";
	String s3 = "Big Walnut Creek - Sunbury";
	String s4 = "Olentangy River Delaware";
	String s5 = "Scioto River below O'shaughnessy Dam";
	String s6 = "Grigg's Dam";
	String s7 = "Hoover Dam";
	String s8 = "Big Walnut Creek - Central College";
	String s9 = "Big Walnut Creek - Rees";
	String s10 = "Olentangy River near Worthington";
	String s11 = "Scioto River near Columbus";
	String s12 = "Alum Creek Dam";
	String s13 = "Delaware Lake Dam";
	
	Object[] stationEntries = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13};
	
	public void updateReport(Mediator mediator, int stationIndex)
	{
		TextArea report = mediator.model.report;
		Model_Station station = mediator.model.stations.get(stationIndex);
		String update = station.records.get(station.records.size()-1).timeStamp;
		float rate = station.records.get(station.records.size()-2).waterLevel 
				- station.records.get(station.records.size()-1).waterLevel;
		
		report.setText("Station Name: " + stationEntries[stationIndex] + " \n"
				+ "Waterway: " + " \n"
				+ "Data Capturing Frequency: Every 5 minutes\n"
				+ "Most Recent Update: " + update + " \n"
				+ "Data Source: " + " \n"
				+ "Water Rising Rate (Past 2 Hours): " + String.format("%.3f", rate) + " \n");
	}
	
	
	public String updateReport(Mediator mediator, int stationIndex, boolean eventCreator)
	{
		//TextArea report = ;
		Model_Station station = mediator.model.stations.get(stationIndex);
		String update = station.records.get(station.records.size()-1).timeStamp;
		float rate = station.records.get(station.records.size()-2).waterLevel 
				- station.records.get(station.records.size()-1).waterLevel;
		
		
		String returnMe = "Station Name: " + stationEntries[stationIndex] + " \n"
				+ "Waterway: " + " \n"
				+ "Data Capturing Frequency: Every 5 minutes\n"
				+ "Most Recent Update: " + update + " \n"
				+ "Data Source: " + " \n"
				+ "Water Rising Rate (Past 2 Hours): " + String.format("%.3f", rate) + " \n";
		
		return returnMe;
	}
	
}
