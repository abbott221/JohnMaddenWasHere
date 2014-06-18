package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

public class Widgets {
	
	Mediator mediator;
	
	
	public Stage stage;
	//SpriteBatch batch;
	
	public SelectBox startDateBox;
	public SelectBox endDateBox;
	
	public SelectBox station;
	public SelectBox dataType;
	
	
	private Skin skin;
	ShapeRenderer shapes;
	
	
	
	//Button buttonMulti = new TextButton("Multi\nLine\nToggle", skin, "toggle");
	TextButton newGraph;
	TextButton deleteGraph;
	
	
	
	public Widgets(Mediator med) {
		mediator = med;
		
		shapes = new ShapeRenderer();
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		stage = mediator.stage;
		//stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		//batch = new SpriteBatch();
		
		
		int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Object[] listEntries = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		
		
		
		
		startDateBox = new SelectBox( skin );
		//startDateBox.setItems("one", "two", "three", "four");
		//startDateBox.setItems(1, 2, 3, 4);
		//startDateBox.setItems(items);
		startDateBox.setItems(listEntries);
		//startDateBox.setI
		
		startDateBox.setBounds(100, 500, 100, 20);
		
		startDateBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				mediator.widgetChanging = true;
				
				
				//System.out.println("change occurred");
				//Logic_SelectBox.changeEvent(mediator, startDateBox);
				
				int startIndex = startDateBox.getSelectedIndex();
				mediator.model.selectedGraph.dataClipStart = startIndex;
				
				int endIndex = mediator.model.selectedGraph.dataClipEnd;
				
				int[] tempData = new int[(endIndex - startIndex) + 1];
				
				for (int i = 0; i < tempData.length; i++) {
					tempData[i] = mediator.model.waterData[i + startIndex];
				}
				mediator.model.selectedGraph.setData(tempData);
				
				
				
				
			}
		});
		
		stage.addActor(startDateBox);
		
		
		
		
		
		endDateBox = new SelectBox( skin );
		endDateBox.setItems(1, 2, 3, 4);
		endDateBox.setItems(listEntries);
		
		endDateBox.setBounds(250, 500, 100, 20);
		
		endDateBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				//System.out.println("change occurred");
				//Logic_SelectBox.changeEvent(mediator, endDateBox);
				
				int endIndex = endDateBox.getSelectedIndex();
				mediator.model.selectedGraph.dataClipEnd = endIndex;
				
				int startIndex = mediator.model.selectedGraph.dataClipStart;
				
				int[] tempData = new int[(endIndex - startIndex) + 1];
				
				for (int i = 0; i < tempData.length; i++) {
					tempData[i] = mediator.model.waterData[i + startIndex];
				}
				mediator.model.selectedGraph.setData(tempData);
				
			}
		});
		
		stage.addActor(endDateBox);
		
		
		
		
		
		station = new SelectBox( skin );
		station.setItems(1, 2, 3, 4);
		
		station.setBounds(400, 500, 100, 20);
		
		station.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				//System.out.println("change occurred");
				//Logic_SelectBox.changeEvent(mediator, endDateBox);
			}
		});
		
		stage.addActor(station);
		
		
		
		
		
		dataType = new SelectBox( skin );
		dataType.setItems(1, 2, 3, 4);
		
		dataType.setBounds(550, 500, 100, 20);
		
		dataType.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				//System.out.println("change occurred");
				//Logic_SelectBox.changeEvent(mediator, endDateBox);
			}
		});
		
		stage.addActor(dataType);
		
		
		
		
		
		newGraph = new TextButton("New Graph", skin);
		newGraph.setBounds(700, 500, 100, 20);
		
		newGraph.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				// TODO Auto-generated method stub
				//System.out.println("changed");
				
				Graph_Main tempGraph = new Graph_Main(mediator, 500, 50, 400, 400);
				tempGraph.setGridSize(300, 300);
				
				int[] x5Data = {3, 4, 6, 5, 8, 3, 3, 2};
				int[] y5Data = {5, 6, 7, 3, 4, 3, 2, 4};
				
				tempGraph.setData(x5Data, y5Data);
				
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
		
		
		
		
		
		//int boxLeft = 100;
		//int boxBottom = 500;
		
		//startDateBox.setBounds(100, 500, 100, 20);
		//firstSelectBox.setBounds(200, 1000, 200, 40);
		
		/*
		firstSelectBox.addListener(new ChangeListener() {
			public void keyTyped (TextField textField, char key) {
				if (key == '\n') textField.getOnscreenKeyboard().show(false);
			}
		});
		/**/
		
		/*
		startDateBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				System.out.println("change occurred");
			}
		});
		
		stage.addActor(startDateBox);
		//firstSelectBox.remove()
		/**/
	}
	
	
	
	public void drawWidgets() {
		
		//shapes.begin(ShapeType.Filled);
		
		int numGraphs = mediator.model.graphs.size();
		
		
		shapes.begin(ShapeType.Filled);
		shapes.setColor(Color.CYAN);
		
		if ( mediator.model.selectedGraph != null ) {
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
		
		//shapes.end();
		
		
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		
	}
	
	
	public void adjustBox() {
		
		//int boxLeft = 100;
		int boxBottom = 500;
		
		int h = mediator.displayHeight;
		int w = mediator.displayWidth;
		
		if (h > 540 && w > 960) {
			
			//boxLeft = 100;
			boxBottom = h - 40;
			
			
			
			
			startDateBox.setBounds(100, boxBottom, 100, 20);
			
			endDateBox.setBounds(250, boxBottom, 100, 20);
			
			station.setBounds(400, boxBottom, 100, 20);
			
			dataType.setBounds(550, boxBottom, 100, 20);
			
			
			
			newGraph.setBounds(700, boxBottom, 100, 20);
			
			deleteGraph.setBounds(850, boxBottom, 100, 20);
			
			
			
		}
		
		
	}
	
	
}




