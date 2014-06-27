package com.ubuntuserver.frontend;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
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
		
		
		
		boolean isTouched = Gdx.input.isTouched();
		boolean justTouched = Gdx.input.justTouched();
		//boolean isCaught = Gdx.input.isCursorCatched();
		//Gdx.input.getCurrentEventTime();
		//Gdx.input.isTouched();
		boolean boxClicked = false;
		boolean graphClicked = false;
		
		Graph_Main potentialGraph = mediator.model.selectedGraph;
		
		//=======================================================
		
		
		
		if (isTouched) {
			
			int firstX = Gdx.input.getX();
			int firstY = showHeight - Gdx.input.getY();
			
			SelectBox tempWidget;
			
			tempWidget = mediator.widgets.startDateBox;
			if (firstX > tempWidget.getX() && firstX < tempWidget.getRight() ) {
				if (firstY > tempWidget.getY() && firstY < tempWidget.getTop() ) {
					//mediator.model.selectedGraph = tempGraph;
					boxClicked = true;
				}
			}
			
			tempWidget = mediator.widgets.endDateBox;
			if (firstX > tempWidget.getX() && firstX < tempWidget.getRight() ) {
				if (firstY > tempWidget.getY() && firstY < tempWidget.getTop() ) {
					boxClicked = true;
				}
			}
			
			tempWidget = mediator.widgets.stationBox;
			if (firstX > tempWidget.getX() && firstX < tempWidget.getRight() ) {
				if (firstY > tempWidget.getY() && firstY < tempWidget.getTop() ) {
					boxClicked = true;
				}
			}
			
			tempWidget = mediator.widgets.dataModeBox;
			if (firstX > tempWidget.getX() && firstX < tempWidget.getRight() ) {
				if (firstY > tempWidget.getY() && firstY < tempWidget.getTop() ) {
					boxClicked = true;
				}
			}
			
			Graph_Main tempGraph;
			int count = mediator.model.graphs.size();
			
			for (int i = 0; i < count; i++) {
				tempGraph = mediator.model.graphs.get(i);
				
				if (firstX > tempGraph.left && firstX < (tempGraph.left + tempGraph.width) ) {
					if (firstY > tempGraph.bottom && firstY < (tempGraph.bottom + tempGraph.height) ) {
						//mediator.model.selectedGraph = tempGraph;
						potentialGraph = tempGraph;
						graphClicked = true;
					}
				}
			}
			
			
			
		}
		
		
		if (justTouched && mediator.boxActivity == true) {
			mediator.boxActivity = false;
		}
		//"else" otherwise the above change goes directly into another change
		else if (justTouched && mediator.boxActivity == false) {
			if (boxClicked) {
				mediator.boxActivity = true;
			}
			else if (graphClicked) {
				mediator.model.selectedGraph = potentialGraph;
				
				
				//is a check for null necessary?
				/*
				if (mediator.widgets.thumbnails.isChecked() == true)
				{
					mediator.model.bigGraph.dataModel = potentialGraph.dataModel;
				}
				/**/
				if (mediator.model.thumbnailsView == true)
				{
					mediator.model.bigGraph.dataModel = potentialGraph.dataModel;
				}
				
				
				
			}
		}
		
		
		
		
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








