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
public class Logic_getForecast {
	
	
	
	
	public static void setInModelCore(final MainCoreClass core) {
		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		
		String url = core.modelCore.targetURL + "flood/weathertext.php";
		httpGet.setUrl(url);
		
		
		Gdx.net.sendHttpRequest(httpGet, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {

				
				String reply = httpResponse.getResultAsString();
				//JsonValue root = new JsonReader().parse(text);
				
				
				
				System.out.println("Response: " + reply);
				
				
				//String prefix = core.mediator.widgets.report.getText();
				//String both = prefix + suffix;
				
				//core.mediator.widgets.report.setText(both);
				//core.mediator.model.report.setText(both);
				
				core.modelCore.forecastLine = reply;
				
				
				//Abstract_StepPage currentPage = (Abstract_StepPage) core.currentScreen;
				
				
				
				//currentPage.responseText = text;
				//currentPage.networkResponse = true;
				
				
				
			}
			
			@Override
			public void failed(Throwable t) {
				System.out.println("getForecast http failed");
			}
			
			@Override
			public void cancelled() {
				System.out.println("cancelled");
			}
			
		});
		
		//return core.id != null;
	}
	
	
	
	
}
