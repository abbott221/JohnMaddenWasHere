package com.ubuntuserver.frontend.widgets;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.ListenerEvents.Logic_EventCall;
import com.ubuntuserver.frontend.Logic.Logic_DateStrings;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Logic.Logic_Dates;
import com.ubuntuserver.frontend.Networking.Logic_JSON3;
import com.ubuntuserver.frontend.Networking.Logic_JSON3.DataSource;
import com.ubuntuserver.frontend.model.Model_WidgetSizes;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.model.Model_Portion.Results;
import com.ubuntuserver.frontend.pages.Page_NewOrActive;
import com.ubuntuserver.frontend.pages.Screen_Landing;

public class Widgets {
	
	public Mediator mediator;
	
	
	public Stage stage;
	public SpriteBatch batch;
	
	public SelectBox startDateBox;
	public SelectBox endDateBox;
	
	public SelectBox stationBox;
	public SelectBox dataModeBox;
	
	
	public Skin skin;
	public ShapeRenderer shapes;
	
	
	
	//Button buttonMulti = new TextButton("Multi\nLine\nToggle", skin, "toggle");
	public TextButton newGraph;
	public TextButton deleteGraph;
	
	public TextButton exportButton;
	public TextButton updateButton;
	
	public TextButton landingButton;
	
	
	
	public Label startDateLabel;
	public Label endDateLabel;
	public Label stationLabel;
	
	
	public Texture texture1;
	public TextureRegion image;
	public Image imageActor;
	
	
	public TextArea report;
	public ScrollPane reportPane;
	
	
	
	public Widgets(Mediator med) {
		mediator = med;
		
		shapes = new ShapeRenderer();
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		
		
		
		
		stage = mediator.stage;
		//stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		
		batch = new SpriteBatch();
		
		
		
		
		
		startDateLabel = new Label( "Start Date", skin );
		//the bounds will be changed in "adjustBox"
		startDateLabel.setBounds(100, 100, 100, 100);
		stage.addActor(startDateLabel);
		
		endDateLabel = new Label( "End Date", skin );
		//the bounds will be changed in "adjustBox"
		endDateLabel.setBounds(100, 100, 100, 100);
		stage.addActor(endDateLabel);
		
		stationLabel = new Label( "Station", skin );
		//the bounds will be changed in "adjustBox"
		stationLabel.setBounds(100, 100, 100, 100);
		stage.addActor(stationLabel);
		
		
		
		
		texture1 = new Texture(Gdx.files.internal("kitten.jpg"));
		image = new TextureRegion(texture1);
		//image.setRegion(100, 100, 100, 100);
		imageActor = new Image(image);
		imageActor.setBounds(100, 100, 100, 100);
		stage.addActor(imageActor);
		
		
		
		
		
		
		//int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9};
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
				
				Logic_EventCall.startDateEvent(mediator, startDateBox);
				
				//Logic_Dates.startDateChange(mediator, startDateBox);
				//Logic_DateStrings.startDateChange(mediator, startDateBox);
			}
		});
		
		stage.addActor(startDateBox);
		
		
		
		
		
		endDateBox = new SelectBox( skin );
		//endDateBox.setItems(1, 2, 3, 4);
		endDateBox.setItems(listEntries);
		
		endDateBox.setBounds(250, 500, 100, 20);
		
		endDateBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				Logic_EventCall.endDateEvent(mediator, endDateBox);
				
				//Logic_Dates.endDateChange(mediator, endDateBox);
				
				//Logic_DateStrings.endDateChange(mediator, endDateBox);
			}
		});
		
		stage.addActor(endDateBox);
		
		
		
		
		
		stationBox = new SelectBox( skin );
		
		
		
		String s1 = "O'shaughness Dam";
		String s2 = "Alum Creek - Africa Road";
		String s3 = "Big Walnut Creek - Sunbury";
		String s4 = "Olentangy River Delaware";
		String s5 = "Scioto River below O'shaughnessy Dam";
		String s6 = "Grigg's Dam";
		String s7 = "Hoover Dam";
		String s8 = "Big Walnut Creek - Central College";
		String s9 = "Big Walnut Creek - Rees";
		String s10 = "Olentangy River near Worthington";
		String s11 = "Scioto River near Columbus";
		String s12 = "Alum Creek Dam";
		String s13 = "Delaware Lake Dam";
		
		Object[] stationEntries = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13};
		//stationBox.setItems(1, 2, 3);
		//stationBox.setItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
		stationBox.setItems(stationEntries);
		
		
		stationBox.setBounds(400, 500, 100, 20);
		
		stationBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				Logic_EventCall.stationEvent(mediator, stationBox);
				
				//Logic_Dates.stationChange(mediator, stationBox);
				
			}
		});
		
		stage.addActor(stationBox);
		
		
		
		
		
		dataModeBox = new SelectBox( skin );
		dataModeBox.setItems("Water Level", "Forecast");
		
		dataModeBox.setBounds(550, 500, 100, 20);
		
		dataModeBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				Logic_Dates.dataModeChange(mediator, dataModeBox);
				
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
		//deleteGraph.setBounds(850, 500, 100, 20);
		deleteGraph.setBounds(880, 500, 100, 20);
		
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
		
		
		
		
		exportButton = new TextButton("Export", skin);
		exportButton.setBounds(700, 450, 100, 20);
		
		exportButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//Logic_EventCall.stationEvent(mediator, stationBox);
				Logic_EventCall.exportEvent(mediator, exportButton);
			}
		});
		
		stage.addActor(exportButton);
		
		
		
		
		updateButton = new TextButton("Update", skin);
		//updateButton.setBounds(850, 450, 100, 20);
		updateButton.setBounds(880, 450, 100, 20);
		
		updateButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//Logic_EventCall.stationEvent(mediator, stationBox);
				
				//Logic_JSON3.EntryPoint(mediator, DataSource.LOCALHOST, mediator.model.secondTable);
				Logic_JSON3.EntryPoint(mediator, DataSource.INTERNAL_IP, mediator.model.secondTable);
				
				Logic_DateStrings.determineDates(mediator);
			}
		});
		
		stage.addActor(updateButton);
		
		
		
		
		landingButton = new TextButton("Landing Page", skin);
		//updateButton.setBounds(850, 450, 100, 20);
		landingButton.setBounds(200, 25, 150, 20);
		
		landingButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				mediator.core.currentScreen = null;
				Screen_Landing  landingScreen = new Screen_Landing(mediator.core);
				
				mediator.core.resize(mediator.core.showWidth, mediator.core.showHeight);
			}
		});
		
		stage.addActor(landingButton);
		
		
		
		
		mediator.model.report = new TextArea( "Report goes here", skin );
		//report.setBounds(100, 100, 100, 100);
		//stage.addActor(report);
		
		reportPane = new ScrollPane(mediator.model.report, skin);
		reportPane.setBounds(100, 100, 100, 100);
		stage.addActor(reportPane);
		
	}
	
	
	
	public void drawWidgets() {
		
		//shapes.begin(ShapeType.Filled);
		
		int numGraphs = mediator.model.graphs.size();
		
		
		shapes.begin(ShapeType.Filled);
		
		
		
		shapes.setColor(Color.CYAN);
		
		if ( mediator.model.selectedGraph != null && mediator.model.thumbnailsView == true) {
			int x = mediator.model.selectedGraph.left - 5;
			int y = mediator.model.selectedGraph.bottom - 5;
			int w = mediator.model.selectedGraph.width + 10;
			int h = mediator.model.selectedGraph.height + 10;
			
			shapes.rect(x, y, w, h);
		}
		
		
		
		shapes.end();
		
		
		
		for (int i = 0; i < numGraphs; i++) {
			mediator.model.graphs.get(i).drawMainGraph(shapes);
		}
		
		
		
		/*
		if (mediator.model.thumbnailsView == true) {
			mediator.model.bigGraph.drawMainGraph(shapes);
		}
		/**/
		mediator.model.bigGraph.drawMainGraph(shapes);
		
		
		
		//shapes.end();
		
		
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		
		
		
		
		
		//mediator.model.selectedGraph.dataModel.drawPics(batch);
		
	}
	
	
	public void adjustBox() {
		
		//a default size for the box
		int boxBottom = 500;
		
		int h = mediator.displayHeight;
		int w = mediator.displayWidth;
		
		//if (h > 540 && w > 960) {
		if (h > 100 && w > 100) {
			
			//boxLeft = 100;
			//boxBottom = h - 40;
			boxBottom = (int) (h - mediator.model.widgetSizes.dropDown_Row1);
			
			
			
			
			
			//int buttonWidth = 100;
			
			dataModeBox.setBounds(550, boxBottom, 100, 20);
			
			
			
			
			
			
			final int buttonWidth = 120;
			
			
			
			newGraph.setBounds(700, boxBottom, buttonWidth, 20);
			
			//deleteGraph.setBounds(850, boxBottom, 100, 20);
			deleteGraph.setBounds(880, boxBottom, buttonWidth, 20);
			
			
			exportButton.setBounds(700, boxBottom - 40, buttonWidth, 20);
			
			//updateButton.setBounds(850, boxBottom - 40, 100, 20);
			updateButton.setBounds(880, boxBottom - 40, buttonWidth, 20);
			
			
			
			landingButton.setBounds(200, 25, 150, 20);
			
			
			
			/*
			float xStartDate = 100;
			float xEndDate = 250;
			float xStation = 400;
			/**/
			
			/**/
			float xStartDate = 50;
			float xEndDate = 200;
			float xStation = 350;
			/**/
			
			startDateLabel.setColor(Color.WHITE);
			endDateLabel.setColor(Color.WHITE);
			stationLabel.setColor(Color.WHITE);
			
			startDateLabel.setBounds(xStartDate, boxBottom, 100, 20);
			endDateLabel.setBounds(xEndDate, boxBottom, 100, 20);
			stationLabel.setBounds(xStation, boxBottom, 100, 20);
			
			
			//moved for more space
			
			//boxBottom -= 50;
			//boxBottom -= 30; // h - 70 total
			boxBottom = (int) (h - mediator.model.widgetSizes.dropDown_Row2);
			
			
			//startDateBox.setBounds(xStartDate, boxBottom, 100, 20);
			startDateBox.setBounds(xStartDate, boxBottom, 120, 20);
			
			//endDateBox.setBounds(xEndDate, boxBottom, 100, 20);
			endDateBox.setBounds(xEndDate, boxBottom, 120, 20);
			
			stationBox.setBounds(xStation, boxBottom, 300, 20);
			//stationBox.setBounds(xStation, boxBottom, 100, 20);
			
			
			//==================================================================
			
			Model_WidgetSizes sizing = mediator.model.widgetSizes;
			
			
			
			Results bounds = sizing.portions.get(1).getResults();
			
			imageActor.setBounds(bounds.left, bounds.bottom, bounds.width, bounds.height);
			
			
			
			bounds = sizing.portions.get(3).getResults();
			
			reportPane.setBounds(bounds.left, bounds.bottom, bounds.width, bounds.height);
			
		}
		
		
	}
	
	
}




