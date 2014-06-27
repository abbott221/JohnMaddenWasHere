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



public class Logic_JSON {
	
	
	
	
	public static void getJSONfromURL(final Mediator mediator) {
		
		//System.out.println("main");
		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		
		
		//httpGet.setUrl("http://wtfismyip.com/json"); //handled
		
		//httpGet.setUrl("http://localhost/FCEMHS/michael_recorded.php");
		
		httpGet.setUrl("http://10.119.0.52/michael/michael_recorded.php");
		
		//http://10.119.0.52/michael/michael_recorded.php
		
		
		Gdx.net.sendHttpRequest(httpGet, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {
				
				System.out.println("handler start");
				
				String text = httpResponse.getResultAsString();
				JsonValue root = new JsonReader().parse(text);
				System.out.println( root.toString() );
				
				System.out.println("handler 1");
				
				
				
				/*
				
				//true
				if (root.isArray()) {
					//System.out.println("root is array");
				}
				
				//true
				//30
				if (root.child() != null) {
					//System.out.println("root has child");
					
					//System.out.println("root child size: " + root.child.size);
				}
				
				//true
				//30
				if (root.child != null) {
					//System.out.println("root has child instance");
					
					//System.out.println("root child size: " + root.child.size);
				}
				
				//2
				//System.out.println("root size: " + root.size + "\n\n\n");
				
				
				//true
				//0
				if (root.child.child != null) {
					//System.out.println("has child");
					
					//System.out.println("child size: " + root.child.child.size);
				}
				
				/**/
				
				
				
				int recordCount = root.size;
				int columnCount = 30;
				
				if (root.child != null) {
					//System.out.println("has child");
					columnCount = root.child.size;
				}
				
				JsonValue currentRecord;
				
				/*
				for (int i = 0; i < recordCount; i++) {
					root.get(i);
				}
				/**/
				
				
				
				
				/*
				
				JsonValue record;
				JsonValue column;
				
				for (record = root.child; record != null; record = record.next) {
					//root.get(i);
					
					for (column = record.child; column != null; column = column.next) {
						
						System.out.println(column.name + " = " + column.asString());
						
					}
				}
				
				/**/
				
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
					
					/*
					for (column = record.child; column != null; column = column.next) {
						System.out.println(column.name + " = " + column.asString());
					}
					/**/
					
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





