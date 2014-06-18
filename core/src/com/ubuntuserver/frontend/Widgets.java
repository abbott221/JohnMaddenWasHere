package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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
		
		
		
		
		
		startDateBox = new SelectBox( skin );
		//startDateBox.setItems("one", "two", "three", "four");
		startDateBox.setItems(1, 2, 3, 4);
		
		startDateBox.setBounds(100, 500, 100, 20);
		
		startDateBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				//System.out.println("change occurred");
				Logic_SelectBox.changeEvent(mediator, startDateBox);
			}
		});
		
		stage.addActor(startDateBox);
		
		
		
		
		
		endDateBox = new SelectBox( skin );
		endDateBox.setItems(1, 2, 3, 4);
		
		endDateBox.setBounds(300, 500, 100, 20);
		
		endDateBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				//System.out.println("change occurred");
				Logic_SelectBox.changeEvent(mediator, endDateBox);
			}
		});
		
		stage.addActor(endDateBox);
		
		
		
		
		newGraph = new TextButton("New Graph", skin);
		newGraph.setBounds(500, 500, 100, 20);
		/*
		newGraph.addListener(new InputListener() {
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				//process up event
				//System.out.println("up");
				
				//return true;
			}
		});
		/**/
		newGraph.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				// TODO Auto-generated method stub
				System.out.println("changed");
			}
			
		});
		
		stage.addActor(newGraph);
		
		
		
		
		deleteGraph = new TextButton("Delete Graph", skin);
		deleteGraph.setBounds(700, 500, 100, 20);
		/*
		deleteGraph.addListener(new InputListener() {
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				if (mediator.model.selectedGraph != null) {
					
					//System.out.println("Delete");
					//mediator.model.selectedGraph.
					//mediator.model.graphs.remove(mediator.model.selectedGraph);
				}
			}
		});
		/**/
		deleteGraph.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				// TODO Auto-generated method stub
				//System.out.println("changed");
				
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
			
			
			endDateBox.setBounds(300, boxBottom, 100, 20);
			
			
			
			newGraph.setBounds(500, boxBottom, 100, 20);
			
			deleteGraph.setBounds(700, boxBottom, 100, 20);
		}
		
		
	}
	
	
}




