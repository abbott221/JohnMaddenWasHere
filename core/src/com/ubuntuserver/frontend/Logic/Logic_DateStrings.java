package com.ubuntuserver.frontend.Logic;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.Model_Station;

public class Logic_DateStrings {
	
	
	
	public static ArrayList<String> determineDates(Mediator mediator) {
		
		Model_Station theStation = mediator.model.selectedGraph.dataModel.myStation;
		
		//ORIGINAL
		Object[] listEntries = mediator.tablepane.dateList.getItems().toArray();
		
		
		
		//Object[] listEntries = mediator.model.selectedGraph.dataModel.myStation.records;
		
		if (theStation.records.size() > 0) {
			
			listEntries = new Object[theStation.records.size()];
			
			for (int i = 0; i < theStation.records.size(); i++) {
				listEntries[i] = theStation.records.get(i).timeStamp;
			}
			
		}
		
		//===========================================================
		
		
		
		ArrayList<String> dates = new ArrayList<String>();
		
		//String uniqueValue = (String) listEntries[0];
		String uniqueValue = dateWithoutTime(listEntries[0]);
		dates.add(uniqueValue);
		
		String newestValue;
		
		for (int i = 1; i < listEntries.length; i++) {
			
			//newestValue = (String) listEntries[i];
			newestValue = dateWithoutTime(listEntries[i]);
			
			if (uniqueValue.equals(newestValue) == false) {
				dates.add(newestValue);
				uniqueValue = newestValue;
			}
		}
		
		
		/*
		for (int i = 0; i < dates.size(); i++) {
			System.out.println( dates.get(i) );
		}
		/**/
		
		while (dates.contains("0000-00-00")) {
			dates.remove("0000-00-00");
		}
		
		/*
		for (int i = 0; i < dates.size(); i++) {
			System.out.println( dates.get(i) );
		}
		/**/
		
		Object[] newEntries = new Object[dates.size()];
		
		
		for (int i = 0; i < dates.size(); i++) {
			newEntries[i] = dates.get(i);
		}
		
		
		//mediator.widgets.startDateBox.setItems(dates);
		mediator.widgets.startDateBox.setItems(newEntries);
		mediator.widgets.endDateBox.setItems(newEntries);
		
		
		return dates;
	}
	
	
	public static String dateWithoutTime(Object entry) {
		String date = (String) entry;
		
		date = date.substring(0, 10);
		
		return date;
	}
	
	public static String dateWithoutTime(String entry) {
		String date = entry;
		
		date = date.substring(0, 10);
		
		return date;
	}
	
	
	
	
	public static void startDateChange(Mediator mediator, SelectBox startDateBox) {
		
		Graph_Main activeGraph = mediator.model.selectedGraph;
		
		
		String newStartDate = (String) startDateBox.getSelected();
		
		
		
		mediator.model.gaugeTimes.get(0);
		
		System.out.println( mediator.model.gaugeTimes.get(0) );
		
		String current;
		boolean leaveLoop = false;
		
		for (int i = 0; i < mediator.model.gaugeTimes.size() && !leaveLoop; i++) {
			current = mediator.model.gaugeTimes.get(i);
			current = dateWithoutTime(current);
			
			if (current.equals(newStartDate) == true) {
				activeGraph.dataModel.dataClipStart = i;
				leaveLoop = true;
			}
		}
		
		
		
		
		
		//activeGraph.dataModel.dataClipStart = startDateBox.getSelectedIndex();
		
		setDisplayData(activeGraph);
	}
	
	
	
	public static void endDateChange(Mediator mediator, SelectBox startDateBox) {
		
		Graph_Main activeGraph = mediator.model.selectedGraph;
		
		
		String newStartDate = (String) startDateBox.getSelected();
		
		
		
		mediator.model.gaugeTimes.get(0);
		
		System.out.println( mediator.model.gaugeTimes.get(0) );
		
		String current;
		boolean leaveLoop = false;
		
		for (int i = 0; i < mediator.model.gaugeTimes.size(); i++) {
			current = mediator.model.gaugeTimes.get(i);
			current = dateWithoutTime(current);
			
			if (current.equals(newStartDate) == true) {
				
				//activeGraph.dataModel.dataClipEnd = i;
				activeGraph.dataModel.setClipEnd(i);
				
				//leaveLoop = true;
			}
		}
		
		
		
		
		
		//activeGraph.dataModel.dataClipStart = startDateBox.getSelectedIndex();
		
		setDisplayData(activeGraph);
	}
	
	
	
	public static void setDisplayData(Graph_Main activeGraph) {
		
		//store the start and end indexes
		//int endIndex = activeGraph.dataModel.dataClipEnd;
		int endIndex = activeGraph.dataModel.getClipEnd();
		
		int startIndex = activeGraph.dataModel.dataClipStart;
		
		//allocate space for the data that will be displayed
		//float[] tempData = new float[(endIndex - startIndex) + 1];
		float[] tempData = new float[(endIndex - startIndex) + 0];
		
		
		
		
		//Fill tempData
		if (activeGraph.dataModel.dataMode == ShowMode.SHOW_GAUGE)
		{
			for (int i = 0; i < tempData.length; i++) {
				
				//tempData[i] = activeGraph.dataModel.myStation.gauge[i + startIndex];
				tempData[i] = activeGraph.dataModel.myStation.records.get(i + startIndex).waterLevel;
				
			}
		}
		else //ShowMode.SHOW_FORECAST
		{
			for (int i = 0; i < tempData.length; i++) {
				tempData[i] = activeGraph.dataModel.myStation.forecast[i + startIndex];
			}
		}
		
		//set the affected graph's data to tempData
		activeGraph.setData(tempData);
		
		
		
	}
	
}





