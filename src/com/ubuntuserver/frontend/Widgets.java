package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Widgets {
	
	Mediator mediator;
	
	
	public Stage stage;
	SpriteBatch batch;
	private SelectBox firstSelectBox;
	private Skin skin;
	ShapeRenderer shapes;
	
	
	public Widgets(Mediator med) {
		mediator = med;
		
		shapes = new ShapeRenderer();
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		batch = new SpriteBatch();
		
		
		
		firstSelectBox = new SelectBox( skin );
		firstSelectBox.setItems("one", "two", "three", "four");
		firstSelectBox.setBounds(100, 500, 100, 20);
		
		stage.addActor(firstSelectBox);
	}
	
	
	
	public void drawWidgets() {
		//background
		
		shapes.begin(ShapeType.Filled);
		
		//drawMe.drawMainGraph(shapes);
		
		int numGraphs = mediator.graphs.size();
		
		for (int i = 0; i < numGraphs; i++) {
			mediator.graphs.get(i).drawMainGraph(shapes);
		}
		
		shapes.end();
		
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		
	}
	
	/*
	public void drawWidgets(ShapeRenderer paint) {
		//background
		
		shapes.begin(ShapeType.Filled);
		
		drawMe.drawMainGraph(shapes);
		
		shapes.end();
		
	}
	/**/
	
}




