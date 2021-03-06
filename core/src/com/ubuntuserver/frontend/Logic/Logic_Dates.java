package com.ubuntuserver.frontend.Logic;

import java.awt.TextArea;
import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.Report_Generator;

public class Logic_Dates {
	
	static Report_Generator report = new Report_Generator();
	
	/*
	public static void changeEvent(Mediator med, SelectBox changedBox) {
		changedBox.getSelected();
		changedBox.getSelectedIndex();
		changedBox.getSelection();
		
		//if (changedBox == med.widgets.startDateBox)
	}
	/**/
	
	
	
	public static void startDateChange(Mediator mediator, SelectBox startDateBox) {
		
		Graph_Main activeGraph = mediator.model.selectedGraph;
		
		activeGraph.dataModel.dataClipStart = startDateBox.getSelectedIndex();
		
		setDisplayData(activeGraph);
	}
	
	
	public static void endDateChange(Mediator mediator, SelectBox endDateBox) {
		
		Graph_Main activeGraph = mediator.model.selectedGraph;
		
		//activeGraph.dataModel.dataClipEnd = endDateBox.getSelectedIndex();
		activeGraph.dataModel.setClipEnd( endDateBox.getSelectedIndex() );
		
		setDisplayData(activeGraph);
	}
	
	
	
	public static void startDateChange(Mediator mediator, List startDateList) {
		
		Graph_Main activeGraph = mediator.model.selectedGraph;
		
		activeGraph.dataModel.dataClipStart = startDateList.getSelectedIndex();
		
		setDisplayData(activeGraph);
	}
	
	
	public static void endDateChange(Mediator mediator, List endDateList) {
		
		Graph_Main activeGraph = mediator.model.selectedGraph;
		
		//activeGraph.dataModel.dataClipEnd = endDateList.getSelectedIndex();
		activeGraph.dataModel.setClipEnd( endDateList.getSelectedIndex() );
		
		setDisplayData(activeGraph);
	}
	
	
	
	public static void stationChange(Mediator mediator, SelectBox stationBox) {
		
		
		Graph_Main activeGraph = mediator.model.selectedGraph;
		
		//====================== Reused code ======================
		
		int stationIndex = stationBox.getSelectedIndex();
		
		
		//Model_Station newStation = mediator.model.stations.get(stationIndex);
		//activeGraph.dataModel.myStation = newStation;
		activeGraph.dataModel.myStation = mediator.model.stations.get(stationIndex);
		
		//====================== Reused code ======================
		
		
		setDisplayData(activeGraph);
		report.updateReport(mediator, stationIndex);
		
		
		
		
		
		
		mediator.model.mapsModel.setMap(stationIndex);
		
	}
	
	
	
	public static void dataModeChange(Mediator mediator, SelectBox dataModeBox) {
		
		
		//store the affected graph
		Graph_Main activeGraph = mediator.model.selectedGraph;
		
		
		//====================== Reused code ======================
		
		//UNIQUE PART
		
		//store the selected DataMode
		int dataModeIndex = dataModeBox.getSelectedIndex();
		
		//set the selected DataMode
		if (dataModeIndex == 0) {
			activeGraph.dataModel.dataMode = ShowMode.SHOW_GAUGE;
		}
		else if (dataModeIndex == 1) {
			activeGraph.dataModel.dataMode = ShowMode.SHOW_FORECAST;
		}
		
		
		
		//====================== Reused code ======================
		
		
		
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
				if (activeGraph.dataModel.myStation.records.size() == 0) {
					
					//tempData[i] = activeGraph.dataModel.myStation.gauge[i + startIndex];
					tempData[i] = activeGraph.dataModel.myStation.records.get(i + startIndex).waterLevel;
					
				}
				else {
					try {
						tempData[i] = activeGraph.dataModel.myStation.records.get(i + startIndex).waterLevel;
					} catch (Exception e) {
						tempData[i] = 0;
					}
				}
				//tempData[i] = activeGraph.dataModel.myStation.gauge[i + startIndex];
				//tempData[i] = activeGraph.dataModel.myStation.records.get(i + startIndex).waterLevel;
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





