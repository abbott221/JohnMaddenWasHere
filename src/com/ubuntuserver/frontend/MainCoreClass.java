package com.ubuntuserver.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class MainCoreClass implements ApplicationListener {
	
	public Stage stage;
	
	SpriteBatch batch;
	//Texture img;
	
	private SelectBox firstSelectBox;
	
	private Skin skin;
	
	
	//OrthographicCamera camera;
	ShapeRenderer shapes;
	
	
	
	Model_Main mainModel;
	
	Graph_Main drawMe;
	
	
	@Override
	public void create () {
		//camera = new OrthographicCamera();
		//camera.setToOrtho(false, 960, 540);
		
		shapes = new ShapeRenderer();
		
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		
		
		
		
		firstSelectBox = new SelectBox( skin );
		firstSelectBox.setItems("one", "two", "three", "four");
		firstSelectBox.setBounds(100, 500, 100, 20);
		
		
		stage.addActor(firstSelectBox);
		
		mainModel = new Model_Main();
		
		
		
		drawMe = new Graph_Main(mainModel, 50, 50, 600, 400);
		drawMe.setGridSize(500, 300);
		
		int[] xData = {3, 4, 6};
		int[] yData = {5, 6, 7};
		
		drawMe.setData(xData, yData);
		
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//camera.update();
		
		
		
		batch.begin();
		//batch.draw(img, 0, 0);
		batch.end();
		
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		
		
		
		shapes.begin(ShapeType.Filled);
		
		drawMe.drawMainGraph(shapes);
		
		shapes.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	private class ItemSelectionListener implements SelectionListener
	{
		//
	}
	/**/
	
}








