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
import com.ubuntuserver.frontend.Networking.Logic_JSON3.DataSource;
import com.ubuntuserver.frontend.model.Model_JSONread;
import com.ubuntuserver.frontend.model.Model_Station;


public class Logic_JSON {
	
	static JsonValue root;
	
	/**
	 * 
	 * @param mediator
	 * @param url
	 * @return a JsonValue object that is the root of the JSON tree
	 * 
	 */
	public static JsonValue getJSONfromURL(final Mediator mediator, String url) {
		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		
		httpGet.setUrl(url);
		
		JsonValue methodRoot = null;
		
		
		Gdx.net.sendHttpRequest(httpGet, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {
				
				//System.out.println("handler start");
				
				String text = httpResponse.getResultAsString();
				JsonValue holdRoot = new JsonReader().parse(text);
				
				//methodRoot = new JsonReader().parse(text);
				
				setRoot(holdRoot);
				
				
				//System.out.println("handler 1");
				
				
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
		
		
		return root;
	}
	
	
	/**
	 * "Cannot refer to a non-final variable 'methodRoot' inside
	 * an inner class defined in a different method"
	 */
	public static void setRoot(JsonValue storeMe) {
		root = storeMe;
	}
	
	
}





