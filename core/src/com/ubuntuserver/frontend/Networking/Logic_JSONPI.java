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
import com.ubuntuserver.frontend.pages.Screen_Landing;


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
		
		
		System.out.println("credentials id 3: StartLine" + core.modelCore.id + "EndLine");
		
		
		
		
		
		
		
		
		if ( (core.modelCore.id > 0) ) {
			//if true conditions, successful login?
			
			//actor.getParent().remove();
			
			//core.logInSuccess();
			
			System.out.println("Landing Screen has been made 1");
			
			core.currentScreen.thisRemoveScreen();
			core.currentScreen = null;
			Screen_Landing  landingScreen = new Screen_Landing(core);
			
			System.out.println("Landing Screen has been made 2");
			
			//core.currentScreen = landingScreen;
		}
		else {
			//core.loggedIn = false;
			
			Dialog dialog = new Dialog("Improper login michael", core.currentScreen.skin, "dialog") {
				protected void result (Object object) {
					System.out.println("Improper login michael");
				}
			}.text("If this problem remains then please contact your IT department")
				.button("Cancel", true)
				.key(Keys.ENTER, true).show(core.currentScreen.stage);
		}
	}
	
	
	
	
	public static boolean getJSONfromURL(final MainCoreClass core, String url) {

		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		
		httpGet.setUrl(url);
		
		
		Gdx.net.sendHttpRequest(httpGet, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {

				
				String text = httpResponse.getResultAsString();
				JsonValue root = new JsonReader().parse(text);
				
				
				System.out.println("PI Checkpoint 1");
				parseJSONfromString(core, text);
				System.out.println("PI Checkpoint 2");
				
			}
			
			@Override
			public void failed(Throwable t) {
				System.out.println("http failed - JSON PI");
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
