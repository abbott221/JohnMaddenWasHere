package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.ubuntuserver.frontend.Logic.Logic_Dates;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Widgets_ScrollTable {
	
	Mediator mediator;
	
	
	
	public List dateList;
	public List waterList;
	public List dateWaterList;
	
	
	
	public ScrollPane tablePane;
	Table table;
	
	//ArrayList<Label> recordsC1;
	//ArrayList<Label> recordsC2;
	
	
	public Widgets_ScrollTable(Mediator med) {
		
		mediator = med;
		
		
		
		
		table = new Table();
		//table.setFillParent(true);
		//table.set
		
		
		
		
		
		
		
		tablePane = new ScrollPane(table, med.widgets.skin);
		
		
		
		tablePane.setBounds(100, 100, 300, 300);
		
		
		//table.setWidth(300);
		
		//mediator.widgets.stage.addActor(tablePane);
		
		
		
		
		dateList = new List( med.widgets.skin );
		waterList = new List( med.widgets.skin );
		dateWaterList = new List( med.widgets.skin );
		
		
		//recordsC1 = new ArrayList<Label>();
		//recordsC2 = new ArrayList<Label>();
		
		
	}
	
	
	
	public void fillTable() {
		
		/*
		Label textLabel = new Label("First Label", mediator.widgets.skin);
		table.add(textLabel);
		
		table.row();
		
		Label textLabel2 = new Label("Second Label", mediator.widgets.skin);
		table.add(textLabel2);
		/**/
		
		
		Graph_Main theGraph = mediator.model.bigGraph;
		Model_Station theStation = theGraph.dataModel.myStation;
		
		int arraySize = theGraph.dataModel.dataClipEnd - theGraph.dataModel.dataClipStart;
		
		
		
		
		Label temp = new Label("Water Level Data", mediator.widgets.skin);
		table.add(temp).expandX().fillX().colspan(2);
		table.row();
		
		
		/*
		for (int i = 0; i < arraySize; i++) {
			
			String dateStamp = mediator.model.gaugeTimes.get(theGraph.dataModel.dataClipStart + i);
			Label tempLabel2 = new Label(dateStamp, mediator.widgets.skin);
			//table.add(tempLabel2);
			
			
			float data = theStation.gauge[theGraph.dataModel.dataClipStart + i];
			Label tempLabel = new Label(Float.toString(data), mediator.widgets.skin);
			//table.add(tempLabel);
			
			
			//table.row();
		}
		/**/
		
		
		//Object[] dateEntries = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		Object[] dateEntries = new Object[arraySize];
		Object[] waterEntries = new Object[arraySize];
		Object[] dateWaterEntries = new Object[arraySize];
		
		
		
		for (int i = 0; i < arraySize; i++) {
			
			String dateStamp = mediator.model.gaugeTimes.get(theGraph.dataModel.dataClipStart + i);
			dateEntries[i] = dateStamp;
			
			float data = theStation.gauge[theGraph.dataModel.dataClipStart + i];
			waterEntries[i] = Float.toString(data);
			
			
			String dateWaterStr = dateStamp + "      " + Float.toString(data);
			dateWaterEntries[i] = dateWaterStr;
			
			/*
			String dateStamp = mediator.model.gaugeTimes.get(theGraph.dataModel.dataClipStart + i);
			Label tempLabel2 = new Label(dateStamp, mediator.widgets.skin);
			table.add(tempLabel2);
			
			
			float data = theStation.gauge[theGraph.dataModel.dataClipStart + i];
			Label tempLabel = new Label(Float.toString(data), mediator.widgets.skin);
			table.add(tempLabel);
			
			
			table.row();
			/**/
		}
		
		dateList.setItems(dateEntries);
		dateList.getSelection().setMultiple(true);
		dateList.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				//startDateBox.getSelectedIndex();
				
				System.out.println( dateList.getSelectedIndex() );
				//System.out.println( dateList.getSelection().set(item); );
				
				waterList.setSelectedIndex( dateList.getSelectedIndex() );
				//waterList.getSelection().set(waterList.setSelectedIndex(index));
				
				//Logic_Dates.endDateChange(mediator, endDateList);
			}
		});
		
		
		
		waterList.setItems(waterEntries);
		waterList.getSelection().setMultiple(true);
		waterList.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				//Logic_Dates.endDateChange(mediator, endDateList);
			}
		});
		
		
		
		dateWaterList.setItems(dateWaterEntries);
		dateWaterList.getSelection().setMultiple(true);
		dateWaterList.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				//Logic_Dates.endDateChange(mediator, endDateList);
			}
		});
		
		
		table.add(dateList);
		table.add(waterList);
		//table.add(dateWaterList).colspan(2);
		
		
		//table.setWidth(300);
		
		//mediator.model.bigGraph.dataModel.dataClipStart
		
		
	}
	
	
	
	public void adjustBox() {
		
		//int boxLeft = 100;
		//int boxBottom = 500;
		
		int h = mediator.displayHeight;
		int w = mediator.displayWidth;
		
		if (h > 540 && w > 960) {
			
			int spaceWidth = mediator.displayWidth - 50;
			
			int spaceHeight = mediator.displayHeight - 90; //40 + 25 * 2 = 90
			if (mediator.model.scrollpanesView == true) {
				spaceHeight -= 145;
			}
			//temporary space for station names
			else {
				spaceHeight -= 65;
			}
			
			
			int sideWidth = (spaceWidth - 25 * 2) / 3; //thirds
			
			int graphWidth = (sideWidth - 10) / 2;
			
			int graphW = 2*sideWidth + 25; //thirds
			int graphH = spaceHeight; //thirds
			
			
			//tablePane.setBounds(25, 25, graphW, graphH);
			
			tablePane.setBounds(25, 25, sideWidth, graphH);
			
			//tablePane.setBounds(25, 25, 300, graphH);
		}
		
		
	}
	
	
}




