package com.ubuntuserver.frontend.Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.net.HttpParametersUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.Model_JSONread;
import com.ubuntuserver.frontend.Model_Station;


public class Logic_JSON3 {
	
	
	
	public static enum DataSource {
		TEST, FILE_1, FILE_2, LOCALHOST, INTERNAL_IP, FILE_3
	}
	
	
	
	
	
	
	static boolean STAMP_MULTI = false;
	static int STAMP_COL_FIRST = 3;
	static int WATERLEVEL_POS = 0;
	static int STAMP_POS = -1;
	static int STATION_COL_FIRST = 5;
	static int STATION_COL_INCR = 2;
	static int STATION_COUNT = 13;
	static int COL_COUNT = 30;
	
	
	
	
	
	
	public static void EntryPoint(final Mediator mediator, DataSource source, Model_JSONread table) {
		
		String bigJSON = "";
		FileHandle file;
		
		String url;
		
		
		
		
		
		STAMP_MULTI = table.stampMulti;
		STAMP_COL_FIRST = table.stampColFirst;
		WATERLEVEL_POS = table.waterlevelPos;
		STAMP_POS = table.stampPos;
		STATION_COL_FIRST = table.stationColFirst;
		STATION_COL_INCR = table.stationColIncr;
		STATION_COUNT = table.stationCount;
		COL_COUNT = table.colCount;
		
		mediator.model.multiStamps = STAMP_MULTI;
		
		
		
		if (source == DataSource.TEST) {
			//
		}
		
		else if (source == DataSource.FILE_1) {
			file = Gdx.files.internal("waterlevel_1.json");
			bigJSON = file.readString();
			parseJSONfromString(mediator, bigJSON);
		}
		
		else if (source == DataSource.FILE_2) {
			file = Gdx.files.internal("waterlevel_2.json");
			bigJSON = file.readString();
			parseJSONfromString(mediator, bigJSON);
		}
		
		else if (source == DataSource.LOCALHOST) {
			
			//System.out.println("local host case");
			
			url = "http://localhost/FCEMHS/michael_recorded.php";
			getJSONfromURL(mediator, url);
		}
		
		else if (source == DataSource.INTERNAL_IP) {
			url = "http://10.119.0.52/michael/michael_recorded.php";
			getJSONfromURL(mediator, url);
		}
		
		
		else if (source == DataSource.FILE_3) {
			file = Gdx.files.internal("waterlevels_messy2.json");
			bigJSON = file.readString();
			parseJSONfromString(mediator, bigJSON);
		}
		
		
		
	}
	
	
	
	
	
	public static void parseJSONfromString(final Mediator mediator, String JSONtext) {
		
		mediator.model.multiStamps = STAMP_MULTI;
		
		String text = JSONtext;
		
		
		
		JsonValue root = null;
		
		root = new JsonReader().parse(text);
		/*
		try {
			root = new JsonReader().parse(text);
		} catch (Exception e) {
			//
		}
		/**/
		
		
		int recordCount = root.size; //number of records isn't constant
		//int columnCount = 30;
		int columnCount = COL_COUNT;
		
		
		
		
		
		
		//int stationCount = (columnCount / 2) - 2;
		//int stationCount = ( (COL_COUNT - WATERLEVEL_COL_FIRST + 1) / WATERLEVEL_COL_INCR);
		int stationCount = STATION_COUNT;
		
		ArrayList<Model_Station> stations = mediator.model.stations;
		
		int extraStations = stationCount - stations.size();
		
		
		float[] tempGauge = {1, 2, 3};
		float[] tempForecast = {1, 2, 3};
		
		//make enough stations for the data coming in
		for (int i = 0; i < extraStations; i++) {
			Model_Station tempStation = new Model_Station(mediator);
			
			//This may crash the application
			//tempStation.setGauge(tempGauge);
			
			tempStation.setForecast(tempForecast);
			
			stations.add(tempStation);
		}
		
		
		
		
		
		JsonValue record;
		JsonValue column;
		//JsonValue column;
		int a;
		
		
		//Model_Station.GaugeRecord tempRecord;
		
		//String tempStamp;
		String tempStamp = "invalid"; //placeholder value
		float tempFloat;
		
		
		//loops through records
		for (record = root.child, a = 0; record != null; record = record.next, a++) {
			
			//tempRecord = new Model_Station.GaugeRecord();
			
			
			
			
			
			//Time stamp via old method
			if (STAMP_MULTI == false) {
				column = record.get(STAMP_COL_FIRST);
				tempStamp = column.asString();
				
				//mediator.model.gaugeTimes.add( column.asString() );
				mediator.model.gaugeTimes.add( column.asString() );
			}
			//column = record.get(STAMP_COL_FIRST);
			//mediator.model.gaugeTimes.add( column.asString() );
			
			
			
			//i points to the index of the current station's starting column
			for (int i = STATION_COL_FIRST, j = 0; i < columnCount; i += STATION_COL_INCR, j++) {
				
				column = record.get(i + WATERLEVEL_POS);
				tempFloat = column.asFloat();
				//column.asFloat();
				
				
				//data.get(j)[a] = column.asFloat();
				
				
				if (STAMP_MULTI == true) {
					column = record.get(i + STAMP_POS);
					tempStamp = column.asString();
					//mediator.model.gaugeTimes.add( column.asString() );
				}
				
				
				//only add the record if the float value is greater than -0.5
				if (tempFloat > -0.5f) {
					mediator.model.stations.get(j).addRecord(tempStamp, tempFloat);
				}
				
				//tempRecord.timeStamp;
				//System.out.println(column.name + " = " + column.asString());
			}
			
		}
		
		
		
		int clipSize = 2;
		
		Graph_Main tempGraph;
		
		for (int i = 0; i < mediator.model.graphs.size(); i++) {
			
			tempGraph = mediator.model.graphs.get(i);
			
			clipSize = tempGraph.dataModel.getClipEnd();
			
			
			
			if (clipSize > (tempGraph.dataModel.myStation.records.size() - 1) ) {
				
				tempGraph.dataModel.setClipEnd( tempGraph.dataModel.myStation.records.size() - 1 );
				
				tempGraph.dataModel.dataClipStart = 0;
			}
			
			
		}
		
		
		//System.out.println("handler 4");
		
		
		mediator.model.stations = stations;
		
		//Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
		
		
		
		//System.out.println("handler end");
		
	}
	
	
	
	
	public static void getJSONfromURL(final Mediator mediator, String url) {
		
		//System.out.println("main");
		
		//System.out.println("checkpoint 1");
		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		
		//System.out.println(url);
		
		httpGet.setUrl(url);
		
		//System.out.println("checkpoint 2");
		
		
		
		
		//httpGet.setUrl("http://wtfismyip.com/json"); //handled
		
		//httpGet.setUrl("http://localhost/FCEMHS/michael_recorded.php");
		
		//httpGet.setUrl("http://10.119.0.52/michael/michael_recorded.php");
		
		//http://10.119.0.52/michael/michael_recorded.php
		
		
		Gdx.net.sendHttpRequest(httpGet, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {
				
				System.out.println("handler start");
				
				String text = httpResponse.getResultAsString();
				JsonValue root = new JsonReader().parse(text);
				//System.out.println( root.toString() );
				
				System.out.println("handler 1");
				
				
				
				
				
				
				
				parseJSONfromString(mediator, text);
				
				
			}
			
			@Override
			public void failed(Throwable t) {
				System.out.println("http failed");
			}
			
			@Override
			public void cancelled() {
				System.out.println("cancelled");
			}
			
		});
		
	}
	
	
	
	
	
	
}





