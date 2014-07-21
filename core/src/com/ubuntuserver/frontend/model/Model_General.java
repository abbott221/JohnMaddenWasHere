package com.ubuntuserver.frontend.model;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter.OutputType;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Logic.Logic_JSON;
import com.ubuntuserver.frontend.Logic.Logic_JSON2;
import com.ubuntuserver.frontend.Logic.Logic_JSON3;
import com.ubuntuserver.frontend.Logic.Logic_JSON3.DataSource;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;

public class Model_General {
	
	public Mediator mediator;
	
	
	
	
	public ArrayList<Graph_Main> graphs;
	
	public Graph_Main selectedGraph;
	
	public Graph_Main bigGraph;
	
	
	
	
	
	public ArrayList<Model_Station> stations;
	
	
	
	public boolean thumbnailsView = true;
	public boolean scrollpanesView = false;
	public boolean dataTableView = true;
	
	public boolean multiStamps = true;
	
	
	
	
	public String bigJSON;
	
	
	public ArrayList<String> gaugeTimes;
	
	
	
	
	public Model_JSONread firstTable;
	public Model_JSONread secondTable;
	
	
	
	public Model_WidgetSizes widgetSizes;
	
	
	
	public Model_Maps mapsModel;
	
	
	
	
	public Model_General(Mediator med) {
		
		mediator = med;
		
		
		
		widgetSizes = new Model_WidgetSizes(mediator);
		
		this.mapsModel = new Model_Maps(mediator);
		
		
		
		
		gaugeTimes = new ArrayList<String>();
		
		
		
		
		//Logic_JSON.getJSONfromURL(mediator);
		
		/*
		//FileHandle file = Gdx.files.internal("waterlevel.json");
		//FileHandle file = Gdx.files.internal("waterlevelSys.json");
		FileHandle file = Gdx.files.internal("waterlevels_messy2.json");
		this.bigJSON = file.readString();
		JsonValue root = new JsonReader().parse(this.bigJSON);
		//System.out.println(this.bigJSON);
		//System.out.println( root.toString() );
		//root.prettyPrint(OutputType.minimal)
		System.out.println( root.prettyPrint(OutputType.minimal, 0) );
		/**/
		
		/*
		FileHandle file = Gdx.files.internal("waterlevels_messy.json");
		Json json = new Json();
		json.setOutputType(OutputType.minimal);
		//String text = json.toJson(person, Object.class);
		String text = file.readString();
		System.out.println(json.prettyPrint(text));
		//Object person2 = json.fromJson(Object.class, text);
		/**/
		
		
		
		
		
		
		
		
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
		
		
		
		//=================================================================
		
		
		firstTable = new Model_JSONread(mediator);
		secondTable = new Model_JSONread(mediator);
		
		
		//old
		firstTable.stampMulti = false;
		firstTable.stampColFirst = 3;
		
		firstTable.waterlevelPos = 0;
		firstTable.stampPos = -1;
		
		firstTable.stationColFirst = 5;
		firstTable.stationColIncr = 2;
		firstTable.stationCount = 13;
		
		firstTable.colCount = 30;
		
		
		
		//new
		secondTable.stampMulti = true;
		secondTable.stampColFirst = 5; //-1
		
		secondTable.waterlevelPos = 0;
		secondTable.stampPos = 2;
		
		secondTable.stationColFirst = 3;
		secondTable.stationColIncr = 4;
		secondTable.stationCount = 14;
		
		secondTable.colCount = 58;
		
		
		//=================================================================
		
		/**
		 * The next line of code adds old data to hold in all stations
		 */
		
		
		
		//Logic_JSON.parseJSONfromString(mediator, this.bigJSON);
		//Logic_JSON2.parseJSONfromString(mediator, this.bigJSON);
		//Logic_JSON3.EntryPoint(mediator, source, table);
		
		
		Logic_JSON3.EntryPoint(mediator, DataSource.FILE_2, firstTable);
		
		//Logic_JSON3.EntryPoint(mediator, DataSource.FILE_3, secondTable);
		//Logic_JSON3.EntryPoint(mediator, DataSource.LOCALHOST, secondTable);
		
		
		
		
		
		
		
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
		
		
		
		
		
		
		//Logic_JSON2.parseJSONfromString(mediator, this.bigJSON);
		//Logic_JSON3.EntryPoint(mediator, DataSource.FILE_2, firstTable);
		
	}
	
	
	
	
	
}
