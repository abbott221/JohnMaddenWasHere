package com.ubuntuserver.frontend;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Logic.Logic_Polling;
import com.ubuntuserver.frontend.Logic.Logic_Stage;

public class MainCoreClass implements ApplicationListener {
	
	Mediator mediator;
	
	public Stage stage;
	
	public int showHeight;
	public int showWidth;
	
	
	@Override
	public void create () {
		
		stage = new Stage();
		
		mediator = new Mediator(stage);
		mediator.registerCore(this);
		
		
		Logic_Stage.constructStage(mediator);
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		//DRAW STUFF
		//Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
		mediator.widgets.drawWidgets();
		
		
		
		
		
		Logic_Polling.checkWidgetTouch(mediator);
		
		
	}
	
	
	
	//occurs once on initial display
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		//mediator.widgets.stage.setViewport(width, height, false);
		//stage.setViewport(viewport);
		
		
		
		//stage.getViewport().update(width, height, true);
		
		
		
		//====================================================
		
		//Logic_Stage.constructStage(mediator);
		
		
		showHeight = height;
		showWidth = width;
		
		mediator.displayHeight = height;
		mediator.displayWidth = width;
		
		Logic_Stage.constructStage(mediator);
		
		
		//====================================================
		
		
		//System.out.println(width);
		//System.out.println(height);
		
		
		//mediator.displayHeight = showHeight;
		//mediator.displayWidth = showWidth;
		
		
		//====================================================
		
		
		mediator.widgets.adjustBox();
		mediator.widgets2.adjustBox();
		mediator.scrollpanes.adjustBox();
		
		Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
		
		//System.out.println(mediator.displayWidth);
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
	
	
}








