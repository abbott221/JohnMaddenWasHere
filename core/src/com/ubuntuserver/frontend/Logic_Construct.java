package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Logic_Construct {
	
	
	
	public static void construct(MainCoreClass core) {
		
		Mediator mediatorL = new Mediator();
		
		
		//Stage stageL = new Stage();
		
		
		mediatorL.model = new Model_General();
		mediatorL.widgets = new Widgets();
		//Model_General model_generalL = new Model_General();
		//Widgets widgetsL = new Widgets();
		
		//Stage stageL = new Stage();
		//mediatorL.widgets.stage = new Stage();
		
		mediatorL.model.mediator = mediatorL;
		mediatorL.widgets.mediator = mediatorL;
		
		
		mediatorL.widgets.stage = new Stage();
		
		
		
		constructModel(mediatorL);
		constructWidgets(mediatorL);
		
		
		//activate to test
		core.registerMediator(mediatorL);
	}
	
	
	
	public static void fill(MainCoreClass core) {
		//
		fillModel(core.mediator);
	}
	
	
	public static void constructModel(Mediator mediator) {
		
		
		
		mediator.model.stations = new ArrayList<Model_Station>();
		
		
		
		mediator.model.graphs = new ArrayList<Graph_Main>();
		
		
		//Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
		mediator.model.selectedGraph = null;
		
		mediator.model.bigGraph = null;
		
	}
	
	
	
	
	public static void constructWidgets(Mediator mediator) {
		
		
		//mediator = med;
		
		shapes = new ShapeRenderer();
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		
		
		
		
		
		
		stage = mediator.stage;
		//stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		//batch = new SpriteBatch();
		
		
		int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Object[] listEntries = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		
		
		
		
		
		startDateBox = new SelectBox( skin );
		//startDateBox.setItems("one", "two", "three", "four");
		//startDateBox.setItems(1, 2, 3, 4);
		//startDateBox.setItems(items);
		startDateBox.setItems(listEntries);
		//startDateBox.setI
		
		startDateBox.setBounds(100, 500, 100, 20);
		
		startDateBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				Logic_SelectBox.startDateChange(mediator, startDateBox);
				
			}
		});
		
		stage.addActor(startDateBox);
		
		
		
		
		
		endDateBox = new SelectBox( skin );
		endDateBox.setItems(1, 2, 3, 4);
		endDateBox.setItems(listEntries);
		
		endDateBox.setBounds(250, 500, 100, 20);
		
		endDateBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				Logic_SelectBox.endDateChange(mediator, endDateBox);
				
			}
		});
		
		stage.addActor(endDateBox);
		
		
		
		
		
		stationBox = new SelectBox( skin );
		stationBox.setItems(1, 2, 3);
		
		stationBox.setBounds(400, 500, 100, 20);
		
		stationBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				Logic_SelectBox.stationChange(mediator, stationBox);
				
			}
		});
		
		stage.addActor(stationBox);
		
		
		
		
		
		dataModeBox = new SelectBox( skin );
		dataModeBox.setItems("1 RG", "2 FC");
		
		dataModeBox.setBounds(550, 500, 100, 20);
		
		dataModeBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				Logic_SelectBox.dataModeChange(mediator, dataModeBox);
				
			}
		});
		
		stage.addActor(dataModeBox);
		
		
		
		
		
		newGraph = new TextButton("New Graph", skin);
		newGraph.setBounds(700, 500, 100, 20);
		
		newGraph.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				Graph_Main tempGraph = new Graph_Main(mediator, mediator.model);
				mediator.model.graphs.add(tempGraph);
				
				Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
				
			}
		});
		
		stage.addActor(newGraph);
		
		
		
		
		deleteGraph = new TextButton("Delete Graph", skin);
		deleteGraph.setBounds(850, 500, 100, 20);
		
		deleteGraph.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				if (mediator.model.selectedGraph != null) {
					mediator.model.graphs.remove(mediator.model.selectedGraph);
					
					mediator.model.selectedGraph = mediator.model.graphs.get(0);
					
					//readjust sizes because a graph was just removed
					Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
					
				}
				
			}
		});
		
		stage.addActor(deleteGraph);
		
		
		
		
		thumbnails = new CheckBox("Thumbnails", skin);
		thumbnails.setBounds(1000, 500, 100, 20);
		
		thumbnails.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
			}
		});
		
		//thumbnails.isChecked()
		//Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
		
		stage.addActor(thumbnails);
		
	}
	
	
	
	
	public static void constructStage(Mediator mediator) {
		
		
		
		mediator.model.stations = new ArrayList<Model_Station>();
		
		
		
		mediator.model.graphs = new ArrayList<Graph_Main>();
		
		
		//Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
		mediator.model.selectedGraph = null;
		
		mediator.model.bigGraph = null;
		
	}
	
	
	
	
	
	public static void fillModel(Mediator mediator) {
		
		
		
		
		/**/
		int[] tempGauge = {2, 3, 4, 5,   4, 5, 6, 7,   6, 7, 8, 9};
		int[] tempForecast = {2, 3, 4,   3, 4, 5,   4, 5, 6,   5, 6, 7};
		
		Model_Station tempStation = new Model_Station(mediator);
		tempStation.setGauge(tempGauge);
		tempStation.setForecast(tempForecast);
		
		mediator.model.stations.add(tempStation);
		
		
		
		int[] tempGauge2 = {9, 8, 7, 6, 7, 6, 5, 4, 5, 4, 3, 2};
		int[] tempForecast2 = {7, 6, 5, 6, 5, 4, 5, 4, 3, 4, 3, 2};
		
		Model_Station tempStation2 = new Model_Station(mediator);
		tempStation2.setGauge(tempGauge2);
		tempStation2.setForecast(tempForecast2);
		
		mediator.model.stations.add(tempStation2);
		
		
		
		int[] tempGauge3 = {3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6};
		int[] tempForecast3 = {3, 4, 5, 3, 4, 5, 3, 4, 5, 3, 4, 5};
		
		Model_Station tempStation3 = new Model_Station(mediator);
		tempStation3.setGauge(tempGauge3);
		tempStation3.setForecast(tempForecast3);
		
		mediator.model.stations.add(tempStation3);
		/**/
		
		
		
		
		
		
		/**/
		Graph_Main tempGraph1 = new Graph_Main(mediator, mediator.model);
		
		mediator.model.graphs.add(tempGraph1);
		
		
		
		Graph_Main tempGraph2 = new Graph_Main(mediator, mediator.model);
		
		mediator.model.graphs.add(tempGraph2);
		/**/
		
		
		
		
		
		//save this for rendering
		//Logic_GraphSizing.setSizeByCount(mediator, graphs);
		
		mediator.model.selectedGraph = tempGraph1;
		
		mediator.model.bigGraph = tempGraph1;
		
		
	}
	
	
	
	
	
}





