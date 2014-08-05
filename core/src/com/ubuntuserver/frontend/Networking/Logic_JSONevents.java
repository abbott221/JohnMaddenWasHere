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
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.net.HttpParametersUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.model.Model_Event;
import com.ubuntuserver.frontend.pages.Screen_Landing;


/**
 * Logic table for handling the new server table style
 */
public class Logic_JSONevents {
	
	
	MainCoreClass core;
	
	public static boolean EntryPoint(final MainCoreClass core, String url) {
		
			getJSONfromURL(core, url);
			return true;
	}
	
	
	
	
	
	public static void parseJSONfromString(MainCoreClass core, String JSONtext) {

		
		String text = JSONtext;
		
		
		
		JsonValue root = null;
		
		root = new JsonReader().parse(text);
		System.out.println(root);
		
		
		core.modelCore.events = new ArrayList<Model_Event>();
		
		
		
		
		int recordCount = root.size;
		
		JsonValue record;
		JsonValue column;
		
		Model_Event temp;
		
		int a;
		
		//loop through the records
		for (record = root.child, a = 0; record != null; record = record.next, a++) {
			
			temp = new Model_Event();
			
			temp.eventName = record.get(3).asString();
			temp.date = "1/2/3";
			temp.active = true;
			
			core.modelCore.events.add(temp);
			
			//temp.date = record.
		}
		
		
		
		
		
		
		String[] credentials = new String[6];
		for(int i=0; i<6; i++)
		{
			credentials[i] = root.get(i).asString();
			System.out.println(credentials[i]);
		}
		
		core.modelCore.userlogin(credentials);
		
		
		
		
	}
	
	
	
	
	public static boolean getJSONfromURL(final MainCoreClass core, String url) {

		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		
		httpGet.setUrl(url);
		
		
		Gdx.net.sendHttpRequest(httpGet, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {

				
				String text = httpResponse.getResultAsString();
				JsonValue root = new JsonReader().parse(text);
				
				parseJSONfromString(core, text);
				
				
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
		
		//return core.id != null;
		return true;
	}
	

	
}
