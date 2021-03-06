package com.ubuntuserver.frontend.widgets;

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
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.Logic.Logic_Dates;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.model.Model_Station;
import com.ubuntuserver.frontend.model.Model_WidgetSizes;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.model.Model_Portion.Results;

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
		
		
		//System.out.println("End: " + theGraph.dataModel.dataClipEnd);
		//System.out.println( "End: " + theGraph.dataModel.getClipEnd() );
		//System.out.println("Start: " + theGraph.dataModel.dataClipStart);
		
		
		//int arraySize = theGraph.dataModel.dataClipEnd - theGraph.dataModel.dataClipStart;
		int arraySize = theGraph.dataModel.getClipEnd() - theGraph.dataModel.dataClipStart;
		
		
		
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
			
			String dateStamp = "";
			
			
			if (mediator.model.multiStamps = false) {
				dateStamp = mediator.model.gaugeTimes.get(theGraph.dataModel.dataClipStart + i);
			}
			else {
				//Model_Station theStation = mediator.model.selectedGraph.dataModel.myStation;
				//dateStamp = mediator.model.selectedGraph.dataModel.myStation.records.get(i);
				dateStamp = theStation.records.get(theGraph.dataModel.dataClipStart + i).timeStamp;
			}
			
			
			//String dateStamp = mediator.model.gaugeTimes.get(theGraph.dataModel.dataClipStart + i);
			dateEntries[i] = dateStamp;
			
			//float data = theStation.gauge[theGraph.dataModel.dataClipStart + i];
			float data = theStation.records.get(i).waterLevel;
			
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
				
				//System.out.println( dateList.getSelectedIndex() );
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
		
		//if (h > 540 && w > 960) {
		if (h > 100 && w > 100) {
			
			
			
			
			//==================================================================
			
			
			Model_WidgetSizes sizing = mediator.model.widgetSizes;
			
			
			Results bounds = sizing.portions.get(2).getResults();
			
			//==================================================================
			
			//tablePane.setBounds(partitionLeft, partitionBottom, partitionWidth, partitionHeight);
			tablePane.setBounds(bounds.left, bounds.bottom, bounds.width, bounds.height);
			
			
			
		}
		
		
	}
	
	
	
	
	public void updateTable() {
		
		table.remove();
		
		table = new Table();
		
		//mediator.widgets.imageActor.setBounds(100, 100, 100, 100);
		//mediator.widgets.stage.addActor(mediator.widgets.imageActor);
		
		tablePane = new ScrollPane(table, mediator.widgets.skin);
		tablePane.setBounds(100, 100, 300, 300);
		
		dateList = new List( mediator.widgets.skin );
		waterList = new List( mediator.widgets.skin );
		dateWaterList = new List( mediator.widgets.skin );
		
		
		
		
		Graph_Main theGraph = mediator.model.bigGraph;
		Model_Station theStation = theGraph.dataModel.myStation;
		
		theGraph = mediator.model.selectedGraph;
		theStation = theGraph.dataModel.myStation;
		
		
		
		
		int arraySize = theGraph.dataModel.getClipEnd() - theGraph.dataModel.dataClipStart;
		
		
		
		
		Label temp = new Label("Water Level Data", mediator.widgets.skin);
		table.add(temp).expandX().fillX().colspan(2);
		table.row();
		
		
		Label temp1 = new Label("Date/time", mediator.widgets.skin);
		table.add(temp1).expandX().fillX().colspan(1);
		Label temp2 = new Label("Feet", mediator.widgets.skin);
		table.add(temp2).expandX().fillX().colspan(1);
		table.row();
		
		
		
		
		Object[] dateEntries = new Object[arraySize];
		Object[] waterEntries = new Object[arraySize];
		Object[] dateWaterEntries = new Object[arraySize];
		
		
		for (int i = 0; i < arraySize; i++) {
			
			String dateStamp = "";
			
			
			if (mediator.model.multiStamps = false) {
				dateStamp = mediator.model.gaugeTimes.get(theGraph.dataModel.dataClipStart + i);
			}
			else {
				//dateStamp = theStation.records.get(theGraph.dataModel.dataClipStart + i).timeStamp;
				
				try {
					dateStamp = theStation.records.get(theGraph.dataModel.dataClipStart + i).timeStamp;
				} catch (Exception e) {
					dateStamp = "0000-00-00";
				}
			}
			
			dateEntries[i] = dateStamp;
			
			
			
			//float data = theStation.records.get(i).waterLevel;
			//float data = theStation.records.get(theGraph.dataModel.dataClipStart + i).waterLevel;
			float data = 0.0f;
			
			try {
				data = theStation.records.get(theGraph.dataModel.dataClipStart + i).waterLevel;
			} catch (Exception e) {
				//dateStamp = "0000-00-00";
			}
			
			
			//does previous line need if-else statement for multiStamps?
			
			waterEntries[i] = Float.toString(data);
			//waterEntries[i] = Float.toString(theGraph.dataModel.dataClipStart + data);
			
			
			
			String dateWaterStr = dateStamp + "      " + Float.toString(data);
			dateWaterEntries[i] = dateWaterStr;
			
		}
		
		
		
		
		
		dateList.setItems(dateEntries);
		dateList.getSelection().setMultiple(true);
		dateList.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				waterList.setSelectedIndex( dateList.getSelectedIndex() );
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
		
		
		
		dateList.getItems().reverse();
		waterList.getItems().reverse();
		
		
		table.add(dateList);
		table.add(waterList);
		
		
		
		mediator.core.resize(mediator.core.showWidth, mediator.core.showHeight);
	}
	
	
	
	
}




