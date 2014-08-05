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
import com.ubuntuserver.frontend.pageAbstraction.Abstract_StepPage;


/**
 * Logic table for handling the new server table style
 */
public class Logic_PHP {
	
	
	
	//start here
	public static void getResponseFromURL(final MainCoreClass core, String url) {

		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		
		httpGet.setUrl(url);
		
		
		Gdx.net.sendHttpRequest(httpGet, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {

				
				String text = httpResponse.getResultAsString();
				//JsonValue root = new JsonReader().parse(text);
				
				
				System.out.println("Response: " + text);
				
				
				Abstract_StepPage currentPage = (Abstract_StepPage) core.currentScreen;
				
				
				
				currentPage.responseText = text;
				currentPage.networkResponse = true;
				
				
				
				//parseJSONfromString(core, text);
				
				/*
				if ( text.contains("true") ) {
					//
					//core.currentScreen
				}
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
		
		//return core.id != null;
	}
	
	
	
	
	
	
}
