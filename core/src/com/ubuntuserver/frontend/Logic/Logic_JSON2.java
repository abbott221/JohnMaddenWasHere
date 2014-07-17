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
import com.ubuntuserver.frontend.model.Model_Station;


/**
 * Logic table for handling the new server table style
 */
public class Logic_JSON2 {
	
	
	
	
	final static String dbURL = "http://localhost/FCEMHS/michael_recorded.php";
	//httpGet.setUrl("http://wtfismyip.com/json"); //handled
	//httpGet.setUrl("http://localhost/FCEMHS/michael_recorded.php");
	//httpGet.setUrl("http://10.119.0.52/michael/michael_recorded.php");
	//http://10.119.0.52/michael/michael_recorded.php
	
	
	
	
	//NOTE: the JSON response has twice as many columns as the SQL table
	//sql columns : 1 - 29
	//json children : 0 - 57, use 1 3 5
	// sql -> json : 2n - 1
	
	
	
	//new table style
	/*
	
	//whether there are multiple time stamps (a timestamp for each separate station)
	final static boolean STAMP_MULTI = true;
	
	//first column of water data -- in the table passed via JSON
	final static int STAMP_COL_FIRST = 5; //3
	
	//increment for getting next column -- in the table passed via JSON
	//ignored and only reads first if MULTI_STAMPS == false
	//final static int STAMP_COL_INCR = 4; //2
	
	
	
	
	//first column of water data -- in the table passed via JSON
	//final static int WATERLEVEL_COL_FIRST = 3; //2
	
	//increment for getting next column -- in the table passed via JSON
	//final static int WATERLEVEL_COL_INCR = 4; //2
	
	
	
	
	//position of water level data in grouping of station columns
	final static int WATERLEVEL_POS = 0;
	
	//position of timestamp data in grouping of station columns
	final static int STAMP_POS = 2;
	
	//first column of station data -- in the table passed via JSON
	final static int STATION_COL_FIRST = 3; //2
	
	//increment for getting next station -- in the table passed via JSON
	final static int STATION_COL_INCR = 4; //2
	
	//The number of stations
	final static int STATION_COUNT = 14;
	
	
	
	
	//"Column Count": number of columns in JSON
	final static int COL_COUNT = 58; //29, 0 - 57, end of for loop = 58
	
	/**/
	
	
	
	
	//old table style
	/**/
	
	//whether there are multiple time stamps (a timestamp for each separate station)
	final static boolean STAMP_MULTI = false;
	
	//first column of water data -- in the table passed via JSON
	final static int STAMP_COL_FIRST = 3; //2
	
	//increment for getting next column -- in the table passed via JSON
	//ignored and only reads first if MULTI_STAMPS == false
	//final static int STAMP_COL_INCR = -1; //Not applicable
	
	
	
	
	//first column of water data -- in the table passed via JSON
	//final static int WATERLEVEL_COL_FIRST = 5; //3
	
	//increment for getting next column -- in the table passed via JSON
	//final static int WATERLEVEL_COL_INCR = 2; //1
	
	
	
	
	//"Column Count": number of columns in JSON
	//final static int COL_COUNT = 30; //15, 0 - 29, end of for loop = 30
	
	
	//position of water level data in grouping of station columns
	final static int WATERLEVEL_POS = 0;
	
	//position of timestamp data in grouping of station columns
	final static int STAMP_POS = -1;
	
	//first column of station data -- in the table passed via JSON
	final static int STATION_COL_FIRST = 5; //2
	
	//increment for getting next station -- in the table passed via JSON
	final static int STATION_COL_INCR = 2; //2
	
	
	//The number of stations
	final static int STATION_COUNT = 13;
	
	
	
	
	//"Column Count": number of columns in JSON
	final static int COL_COUNT = 30; //15, 0 - 29, end of for loop = 30
	
	
	/**/
	
	
	
	
	
	
	public static void parseJSONfromString(final Mediator mediator, String JSONtext) {
		
		
		String text = JSONtext;
		
		
		
		
		JsonValue root = new JsonReader().parse(text);
		
		
		
		
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
		
		String tempStamp;
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
	
	
	
	
	public static void getJSONfromURL(final Mediator mediator) {
		
		//System.out.println("main");
		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		
		
		httpGet.setUrl(dbURL);
		
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





