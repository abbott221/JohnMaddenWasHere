package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Model_Graph {
	
	Mediator mediator;
	
	
	
	
	public static enum ShowMode {
		SHOW_GAUGE, SHOW_FORECAST
	}
	public ShowMode dataMode;
	/**/
	public int[] data;
	public int dataCount;
	/**/
	
	
	public int dataClipStart;
	public int dataClipEnd;
	
	public Model_Station myStation;
	
	
	
	//Label xAxis;
	//Label yAxis;
	
	//Texture texture1;
	
	
	
	
	
	
	public Model_Graph(Mediator med, Model_General mod) {
		
		mediator = med;
		
		
		
		
		myStation = mod.stations.get(0);
		dataMode = ShowMode.SHOW_GAUGE;
		
		
		
		/*
		xAxis = new Label("Forecast", mediator.widgets.skin);
		//xAxis.setBounds(40, 40, 100, 20);
		xAxis.setPosition(50, 50);
		
		xAxis.setColor(Color.GRAY);
		
		mediator.widgets.stage.addActor(xAxis);
		
		
		
		yAxis = new Label("Rain Gauge", mediator.widgets.skin);
		yAxis.setPosition(150, 50);
		
		yAxis.setColor(Color.GRAY);
		
		mediator.widgets.stage.addActor(yAxis);
		/**/
		
		
		
		//Label tempLab = new Label("Date", mediator.widgets.skin);
		//xAxis.setBounds(40, 40, 100, 20);
		//tempLab.setPosition(300, 50);
		
		//tempLab.setColor(Color.GRAY);
		
		//mediator.widgets.stage.addActor(tempLab);
		
		
		
		//texture1 = new Texture(Gdx.files.internal("axisText.png"));
		
	}
	
	
	
	
	
	public void setData(int[] newData) {
		//x = xNew;
		data = newData;
		
		//xCount = xNew.length;
		dataCount = newData.length;
	}
	
	
	/*
	public void drawPics(SpriteBatch batch) {
		batch.begin();
		batch.draw(texture1, 100, 100);
		batch.end();
	}
	/**/
	
}
