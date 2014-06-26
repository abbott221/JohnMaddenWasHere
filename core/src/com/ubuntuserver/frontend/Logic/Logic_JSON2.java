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



public class Logic_JSON2 {
	
	
	
	
	public static void getJSONfromURL3() {
		
		//System.out.println("JSON 2-3");
		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		
		
		httpGet.setUrl("http://wtfismyip.com/json"); //handled
		
		
		
		Gdx.net.sendHttpRequest(httpGet, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {
				// TODO Auto-generated method stub
				
				//System.out.println("handled");
				
				
				//don't use this
				//System.out.println( httpResponse.toString() );
				//use this one
				//System.out.println( httpResponse.getResultAsString() );
				
				
				
				String text = httpResponse.getResultAsString();
				
				JsonValue root = new JsonReader().parse(text);
				
				//root is an object
				//root.toString();
				System.out.println( root.toString() );
				
				
				String guess = "something";
				
				if (root.has(guess)) {
					System.out.println(guess);
				} else {
					System.out.println("NOT " + guess);
				}
				
				guess = "YourFuckingIPAddress";
				
				if (root.has(guess)) {
					System.out.println(guess);
				} else {
					System.out.println("NOT " + guess);
				}
				
				guess = "YourFuckingLocation";
				
				if (root.has(guess)) {
					System.out.println(guess);
				} else {
					System.out.println("NOT " + guess);
				}
				
			}
			
			@Override
			public void failed(Throwable t) {
				// TODO Auto-generated method stub
				
				System.out.println("failed");
				
			}
			
			@Override
			public void cancelled() {
				// TODO Auto-generated method stub
				
				System.out.println("cancelled");
				
			}
			
		});
		
		
		
	}
	
	
	
	
	public static void getJSONfromURL4() {
		
		//System.out.println("JSON 2-3");
		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		
		
		//httpGet.setUrl("http://wtfismyip.com/json"); //handled
		httpGet.setUrl("http://localhost/FCEMHS/michael_recorded.php");
		
		
		
		Gdx.net.sendHttpRequest(httpGet, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {
				
				System.out.println("handler start");
				
				String text = httpResponse.getResultAsString();
				JsonValue root = new JsonReader().parse(text);
				System.out.println( root.toString() );
				
				System.out.println("handler 1");
				
				//yes
				if (root.isArray()) {
					System.out.println("root is array");
				}
				
				
				/*
				String guess = "YourFuckingIPAddress";
				
				if (root.has(guess)) {
					System.out.println(guess);
					
				} else {
					System.out.println("NOT " + guess);
				}
				
				
				System.out.println("root name: " + root.name);
				
				if (root.child != null) {
					System.out.println("child name: " + root.child.name);
				}
				/**/
				
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





