package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Logic.Logic_JSON;
import com.ubuntuserver.frontend.Logic.Logic_JSON2;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Model_General {
	
	public Mediator mediator;
	
	
	
	
	public ArrayList<Graph_Main> graphs;
	
	public Graph_Main selectedGraph;
	
	public Graph_Main bigGraph;
	
	
	
	
	
	public ArrayList<Model_Station> stations;
	
	
	
	public boolean thumbnailsView = true;
	public boolean scrollpanesView = false;
	public boolean dataTableView = true;
	
	
	
	
	public String bigJSON;
	
	
	public ArrayList<String> gaugeTimes;
	
	
	
	
	public Model_JSONread firstTable;
	public Model_JSONread secondTable;
	
	
	
	
	
	public Model_General(Mediator med) {
		
		mediator = med;
		
		
		
		
		gaugeTimes = new ArrayList<String>();
		
		
		
		
		//FileHandle file = Gdx.files.internal("waterlevel.json");
		FileHandle file = Gdx.files.internal("waterlevelSys.json");
		this.bigJSON = file.readString();
		//System.out.println(this.bigJSON);
		
		
		
		
		//int[] temp = {5, 6, 7, 3, 4, 3, 2, 4};
		//int[] temp = {5, 6, 7, 5, 6, 3, 4, 2, 6, 5, 7, 3};
		
		
		//waterData = temp;
		//waterDataSize = waterData.length;
		
		
		
		
		stations = new ArrayList<Model_Station>();
		
		
		
		
		graphs = new ArrayList<Graph_Main>();
		
		
		
		
		selectedGraph = null;
		bigGraph = null;
		
	}
	
	
	
	public void fillModel() {
		
		
		//run the Logic_JSON script here but with the other text
		//Logic_JSON.getJSONfromURL(mediator);
		
		//Logic_JSON.parseJSONfromString(mediator, this.bigJSON);
		
		
		/*
		
		float[] tempGauge1 = {2, 3, 4, 5,   4, 5, 6, 7,   6, 7, 8, 9};
		float[] tempForecast1 = {2, 3, 4,   3, 4, 5,   4, 5, 6,   5, 6, 7};
		
		Model_Station tempStation1 = new Model_Station(mediator);
		tempStation1.setGauge(tempGauge1);
		tempStation1.setForecast(tempForecast1);
		
		//tempStation1.addAlertLine(Color.RED, "warning", 848.5f);
		//tempStation1.addAlertLine(Color.GREEN, "standard", 600);
		
		//tempStation1.setYScale(847.0f, 852.0f);
		
		stations.add(tempStation1);
		
		/*
		
		float[] tempGauge2 = {9, 8, 7, 6, 7, 6, 5, 4, 5, 4, 3, 2};
		float[] tempForecast2 = {7, 6, 5, 6, 5, 4, 5, 4, 3, 4, 3, 2};
		
		Model_Station tempStation2 = new Model_Station(mediator);
		tempStation2.setGauge(tempGauge2);
		tempStation2.setForecast(tempForecast2);
		
		tempStation2.addAlertLine(Color.RED, "warning", 5.2f);
		//tempStation2.addAlertLine(Color.GREEN, "standard", 3);
		
		stations.add(tempStation2);
		
		
		
		float[] tempGauge3 = {3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6};
		float[] tempForecast3 = {3, 4, 5, 3, 4, 5, 3, 4, 5, 3, 4, 5};
		
		Model_Station tempStation3 = new Model_Station(mediator);
		tempStation3.setGauge(tempGauge3);
		tempStation3.setForecast(tempForecast3);
		
		tempStation3.addAlertLine(Color.RED, "warning", 10.05f);
		//tempStation3.addAlertLine(Color.GREEN, "standard", 3);
		
		stations.add(tempStation3);
		
		
		/**/
		
		
		
		/**
		 * The next line of code adds old data to hold in all stations
		 */
		
		
		//Logic_JSON.parseJSONfromString(mediator, this.bigJSON);
		Logic_JSON2.parseJSONfromString(mediator, this.bigJSON);
		
		
		
		//O'Shaughness Dam
		this.stations.get(0).setYScale(847.0f, 852.0f);
		this.stations.get(0).addAlertLine(Color.RED, "warning", 848.5f);
		
		//Alum Creek - Africa Road
		this.stations.get(1).setYScale(0.0f, 6.0f);
		this.stations.get(1).addAlertLine(Color.RED, "warning", 5.2f);
		
		//Big Walnut Creek - Sunbury
		this.stations.get(2).setYScale(0.0f, 13.0f);
		this.stations.get(2).addAlertLine(Color.RED, "warning", 10.05f);
		
		//Olentangy River Delaware
		this.stations.get(3).addAlertLine(Color.RED, "warning", 9.00f);
		this.stations.get(3).setYScale(0.0f, 10.0f);
		
		//Scioto River below O'shaughnessy Dam
		this.stations.get(4).addAlertLine(Color.RED, "warning", 12.00f);
		this.stations.get(4).setYScale(0.0f, 14.0f);
		
		//Grigg's Dam
		this.stations.get(5).addAlertLine(Color.RED, "warning", 756.18f);
		this.stations.get(5).setYScale(750.0f, 762.0f);
		
		//Hoover Dam
		this.stations.get(6).addAlertLine(Color.RED, "warning", 905.0f);
		this.stations.get(6).setYScale(888.0f, 908.0f);
		
		//Big Walnut Creek at Central College
		this.stations.get(7).addAlertLine(Color.RED, "warning", 11.0f);
		
		//Big Walnut Creek at Rees
		this.stations.get(8).addAlertLine(Color.RED, "warning", 12.0f);
		
		//Olentangy River near Worthington
		this.stations.get(9).addAlertLine(Color.RED, "warning", 7.8f);
		
		//Scioto River near Columbus
		this.stations.get(10).addAlertLine(Color.RED, "warning", 24.0f);
		this.stations.get(10).setYScale(0.0f, 26.0f);
		
		//Alum Creek Dam
		this.stations.get(11).addAlertLine(Color.RED, "alert pool", 892.0f);
		this.stations.get(11).setYScale(884.0f, 895.0f);
		
		//Delaware Lake Dam
		this.stations.get(12).addAlertLine(Color.RED, "alert pool", 935.0f);
		this.stations.get(12).setYScale(910.0f, 960.0f);
		
		
		
		
		
		
		
		
		Graph_Main tempGraph1 = new Graph_Main(mediator, this);
		graphs.add(tempGraph1);
		
		
		//Graph_Main tempGraph2 = new Graph_Main(mediator, this);
		//graphs.add(tempGraph2);
		
		
		
		//if thumbnails is checked, selectedGraph can't be null
		//Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
		
		
		selectedGraph = tempGraph1;
		
		bigGraph = tempGraph1;
		
		
		
		
		//Logic_JSON.parseJSONfromString(mediator, this.bigJSON);
		
		
		
		
		Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
		
		
		
		firstTable = new Model_JSONread(mediator);
		secondTable = new Model_JSONread(mediator);
		
		
		
		firstTable.stampMulti = false;
		firstTable.stampColFirst = 3;
		
		firstTable.waterlevelPos = 0;
		firstTable.stampPos = -1;
		
		firstTable.stationColFirst = 5;
		firstTable.stationColIncr = 2;
		firstTable.stationCount = 13;
		
		firstTable.colCount = 30;
		
		
		
		
		secondTable.stampMulti = true;
		secondTable.stampColFirst = 5; //-1
		
		secondTable.waterlevelPos = 0;
		secondTable.stampPos = 2;
		
		secondTable.stationColFirst = 3;
		secondTable.stationColIncr = 4;
		secondTable.stationCount = 14;
		
		secondTable.colCount = 58;
		
		
	}
	
	
	
	
	
}
