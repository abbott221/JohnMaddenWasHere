package com.ubuntuserver.frontend.Logic;

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
import com.badlogic.gdx.net.HttpParametersUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.Model_Station;


/**
 * Logic table for handling the new server table style
 */
public class Logic_JSON {
	
	
	
	
	
	//NOTE: the JSON response has twice as many columns as the SQL table
	//sql columns : 1 - 29
	//json children : 0 - 57, use 1 3 5
	// sql -> json : 2n - 1
	
	
	
	//new table style
	/*
	
	//whether there are multiple time stamps (a timestamp for each separate station)
	final static boolean MULTI_STAMPS = true;
	
	//first column of water data -- in the table passed via JSON
	final static int STAMP_COL_FIRST = 5; //3
	
	//increment for getting next column -- in the table passed via JSON
	//ignored and only reads first if MULTI_STAMPS == false
	final static int STAMP_COL_INCR = 4; //2
	
	
	
	
	//first column of water data -- in the table passed via JSON
	final static int WATERLEVEL_COL_FIRST = 3; //2
	
	//increment for getting next column -- in the table passed via JSON
	final static int WATERLEVEL_COL_INCR = 4; //2
	
	
	
	
	//"Column Count": number of columns in JSON
	final static int COL_COUNT = 58; //29, 0 - 57, end of for loop = 58
	
	//The number of stations
	final static int STATION_COUNT = 13;
	
	/**/
	
	
	
	
	//old table style
	/**/
	
	//whether there are multiple time stamps (a timestamp for each separate station)
	final static boolean STAMP_MULTI = false;
	
	//first column of water data -- in the table passed via JSON
	final static int STAMP_COL_FIRST = 3; //2
	
	//increment for getting next column -- in the table passed via JSON
	//ignored and only reads first if MULTI_STAMPS == false
	final static int STAMP_COL_INCR = -1; //Not applicable
	
	
	
	
	//first column of water data -- in the table passed via JSON
	final static int WATERLEVEL_COL_FIRST = 5; //3
	
	//increment for getting next column -- in the table passed via JSON
	final static int WATERLEVEL_COL_INCR = 2; //1
	
	
	
	
	//"Column Count": number of columns in JSON
	final static int COL_COUNT = 30; //15, 0 - 29, end of for loop = 30
	
	//The number of stations
	final static int STATION_COUNT = 13;
	
	/**/
	
	
	
	
	
	
	public static void parseJSONfromString(final Mediator mediator, String JSONtext) {
		
		
		String text = JSONtext;
		
		
		
		
		JsonValue root = new JsonReader().parse(text);
		
		
		
		
		int recordCount = root.size; //number of records isn't constant
		//int columnCount = 30;
		int columnCount = COL_COUNT;
		
		
		
		/*
		if (root.child != null) {
			//System.out.println("has child");
			columnCount = root.child.size;
		}
		/**/
		
		
		
		//JsonValue currentRecord;
		
		
		
		
		
		
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
		
		//System.out.println("Size: " + mediator.model.stations.size());
		//=================================================================
		
		//System.out.println("handler 2");
		
		//arraylist of the water level data
		ArrayList<float[]> data = new ArrayList<float[]>();
		
		//construct/allocate space for each array in this arraylist
		for (int i = 0; i < stationCount; i++) {
			float[] recordSize = new float[recordCount];
			data.add(recordSize);
		}
		
		
		JsonValue record;
		JsonValue column;
		int a;
		
		//loops through records
		for (record = root.child, a = 0; record != null; record = record.next, a++) {
			//root.get(i);
			
			/*
			for (column = record.child; column != null; column = column.next) {
				System.out.println(column.name + " = " + column.asString());
			}
			/**/
			
			//Time stamp via old method
			column = record.get(STAMP_COL_FIRST);
			mediator.model.gaugeTimes.add( column.asString() );
			
			
			//loop through the columns in each record, collecting the waterlevel data
			//for (int i = 5, j = 0; i < columnCount; i += 2, j++) {
			for (int i = WATERLEVEL_COL_FIRST, j = 0; i < columnCount; i += WATERLEVEL_COL_INCR, j++) {
				column = record.get(i);
				
				column.asFloat();
				
				data.get(j)[a] = column.asFloat();
				
				//System.out.println(column.name + " = " + column.asString());
			}
		}
		
		
		//set the data for each rain gauge
		for (int i = 0; i < stationCount; i++) {
			
			//This may/will crash the application
			//However, Logic_JSON2 is used instead now
			//stations.get(i).setGauge(data.get(i));
			
		}
		
		//stations.get(0).setForecast(newData);
		
		
		//System.out.println("handler 3");
		
		int clipSize = 2;
		
		Graph_Main tempGraph;
		
		//for (int i = 0; i < stationCount; i++) {
		for (int i = 0; i < mediator.model.graphs.size(); i++) {
			
			tempGraph = mediator.model.graphs.get(i);
			
			//mediator.model.graphs.get(i).dataModel.dataClipEnd;
			//clipSize = tempGraph.dataModel.dataClipEnd;
			clipSize = tempGraph.dataModel.getClipEnd();
			
			if (clipSize > (data.get(i).length - 1) ) {
				
				//tempGraph.dataModel.dataClipEnd = data.get(i).length - 1;
				tempGraph.dataModel.setClipEnd( data.get(i).length - 1 );
			}
		}
		
		
		//System.out.println("handler 4");
		
		
		mediator.model.stations = stations;
		
		//Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
		
		
		
		
		
		
		//System.out.println("handler end");
		
	}
	
	
	
	
	
	
	
	public static void getJSONfromURL(final Mediator mediator) {
		
		//System.out.println("main");
		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		
		
		//httpGet.setUrl("http://wtfismyip.com/json"); //handled
		
		httpGet.setUrl("http://localhost/FCEMHS/michael_recorded.php");
		
		//httpGet.setUrl("http://10.119.0.52/michael/michael_recorded.php");
		
		//http://10.119.0.52/michael/michael_recorded.php
		
		
		Gdx.net.sendHttpRequest(httpGet, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {
				
				System.out.println("handler start");
				
				String text = httpResponse.getResultAsString();
				JsonValue root = new JsonReader().parse(text);
				System.out.println( root.toString() );
				
				System.out.println("handler 1");
				
				
				
				
				
				
				
				parseJSONfromString(mediator, text);
				
				/*
				
				
				int recordCount = root.size;
				int columnCount = 30;
				
				if (root.child != null) {
					//System.out.println("has child");
					columnCount = root.child.size;
				}
				
				JsonValue currentRecord;
				
				
				//=================================================================
				
				//ArrayList<Model_Station> stations = new ArrayList<Model_Station>();
				
				int stationCount = (columnCount / 2) - 2;
				
				ArrayList<Model_Station> stations = mediator.model.stations;
				
				int extraStations = stationCount - stations.size();
				
				
				float[] tempGauge = {1, 2, 3};
				float[] tempForecast = {1, 2, 3};
				
				for (int i = 0; i < extraStations; i++) {
					Model_Station tempStation = new Model_Station(mediator);
					tempStation.setGauge(tempGauge);
					tempStation.setForecast(tempForecast);
					
					stations.add(tempStation);
				}
				
				//System.out.println("Size: " + mediator.model.stations.size());
				//=================================================================
				
				System.out.println("handler 2");
				
				ArrayList<float[]> data = new ArrayList<float[]>();
				
				for (int i = 0; i < stationCount; i++) {
					float[] recordSize = new float[recordCount];
					data.add(recordSize);
				}
				
				
				JsonValue record;
				JsonValue column;
				int a;
				
				for (record = root.child, a = 0; record != null; record = record.next, a++) {
					//root.get(i);
					
					
					for (int i = 5, j = 0; i < columnCount; i += 2, j++) {
						column = record.get(i);
						
						column.asFloat();
						
						data.get(j)[a] = column.asFloat();
						
						//System.out.println(column.name + " = " + column.asString());
					}
				}
				
				
				//set the data for each rain gauge
				for (int i = 0; i < stationCount; i++) {
					stations.get(i).setGauge(data.get(i));
				}
				
				//stations.get(0).setForecast(newData);
				
				
				System.out.println("handler 3");
				
				int clipSize = 2;
				
				Graph_Main tempGraph;
				
				//for (int i = 0; i < stationCount; i++) {
				for (int i = 0; i < mediator.model.graphs.size(); i++) {
					
					tempGraph = mediator.model.graphs.get(i);
					
					//mediator.model.graphs.get(i).dataModel.dataClipEnd;
					clipSize = tempGraph.dataModel.dataClipEnd;
					
					if (clipSize > (data.get(i).length - 1) ) {
						tempGraph.dataModel.dataClipEnd = data.get(i).length - 1;
					}
				}
				
				
				System.out.println("handler 4");
				
				
				mediator.model.stations = stations;
				
				Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
				
				
				
				
				
				
				System.out.println("handler end");
				
				/**/
				
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





