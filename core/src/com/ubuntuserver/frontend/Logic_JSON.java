package com.ubuntuserver.frontend;

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



public class Logic_JSON {
	
	
	
	
	/*
	public static JSONArray getJSONfromURL(String url) {
    	
    	String result = "";
    	
	    InputStream is = null;
	    //JSONObject jArray = null;
	    JSONArray jArray = null;

	    
	    
	    // Download JSON data from URL
	    //http post
	    try {
	        //System.out.println("MRA 1");
	    	HttpClient httpclient = new DefaultHttpClient();
	    	//System.out.println("MRA 2");
	    	HttpPost httppost = new HttpPost(url);
	    	//System.out.println("MRA 3");
	        
	        //this fucker is the problem.
	        HttpResponse response = httpclient.execute(httppost);
	        
	        //System.out.println("MRA 4");
	        
	        //GET ENTITY
	        HttpEntity entity = response.getEntity();
	        
	        //System.out.println("MRA 5");
	        
	        is = entity.getContent();

	    } catch (Exception e) {
	        Log.e("log_tag", "lol1 Error in http connection " + e.toString());
	    }

	    
	    
	    
	    
	    
	    // Convert response to string
	    try {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
	        StringBuilder sb = new StringBuilder();
	        
	        
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	        is.close();
	        
	        result = sb.toString();
	        
	    } catch (Exception e) {
	        Log.e("log_tag", "lol2 Error converting result " + e.toString());
	    }

	    try {

	        //jArray = new JSONObject(result);
	        jArray = new JSONArray(result);
	        
	        
	    } catch (JSONException e) {
	        
	    	
	    	
	    	//PROBLEM IS HERE
	    	
	    	Log.e("log_tag", "lol3 Error parsing data " + e.toString());
	        
	    } catch (Exception e) {
	        Log.e("log_tag", "toplel Error parsing data " + e.toString());
	    }

	    return jArray;
	    
    }
	/**/
	
	
	
	public static void getJSONfromURL2(String url) {
		
		
		//Map<String, String> parameters = new HashMap<String, String>();
		//parameters.put("user", "myuser");
		
		HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
		//httpGet.setUrl("http://somewhere.net");
		httpGet.setUrl(url);
		//httpGet.setContent(HttpParametersUtils.convertHttpParameters(parameters));
		
		
		Gdx.net.sendHttpRequest(httpGet, new HttpResponseListener() {

			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {
				// TODO Auto-generated method stub
				
				
				
				
				
				Json json = new Json();
				
				//String text = json.toJson(person, Object.class);
				//String text = json.toJson(httpResponse, Object.class);
				
				//httpResponse.getResultAsStream();
				
				//THIS!!!
				String text = httpResponse.getResultAsString();
				
				//json VALUE = a JSON object, array, string, float, long, boolean, or null
				JsonValue root = new JsonReader().parse(text);
				//root.
				
				
			}

			@Override
			public void failed(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void cancelled() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		//send an HttpRequest
		//Gdx.net.sendHttpRequest(HttpRequest httpRequest, HttpResponseListener httpResponseListener);
		
		//Gdx.net.
		
	}
	
	
	
	
	
	
}





