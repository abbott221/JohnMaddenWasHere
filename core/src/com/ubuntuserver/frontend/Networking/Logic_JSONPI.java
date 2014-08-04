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
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.Mediator;


/**
 * Logic table for handling the new server table style
 */
public class Logic_JSONPI {
	
	
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
		/*
		try {
			root = new JsonReader().parse(text);
		} catch (Exception e) {
			//
		}
		/**/
		
		String[] credentials = new String[6];
		for(int i=0; i<6; i++)
		{
			credentials[i] = root.get(i).asString();
			System.out.println(credentials[i]);
		}
		
		core.modelCore.userlogin(credentials);
		
		
		
		
		
		//move Widget_Login's if-else statement here
		
		
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
