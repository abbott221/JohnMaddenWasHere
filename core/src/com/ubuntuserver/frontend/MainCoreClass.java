package com.ubuntuserver.frontend;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MainCoreClass implements ApplicationListener {
	
	Mediator mediator;
	
	public Stage stage;
	
	public int showHeight;
	public int showWidth;
	
	
	@Override
	public void create () {
		
		stage = new Stage();
		
		mediator = new Mediator(stage);
		
		
		
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		mediator.widgets.drawWidgets();
		
		
		boolean isTouched = Gdx.input.isTouched();
		if (isTouched) {
			int firstX = Gdx.input.getX();
			int firstY = showHeight - Gdx.input.getY();
			
			int count = mediator.model.graphs.size();
			Graph_Main tempGraph;
			
			for (int i = 0; i < count; i++) {
				tempGraph = mediator.model.graphs.get(i);
				
				if (firstX > tempGraph.left && firstX < (tempGraph.left + tempGraph.width) ) {
					if (firstY > tempGraph.bottom && firstY < (tempGraph.bottom + tempGraph.height) ) {
						mediator.model.selectedGraph = tempGraph;
					}
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
		
		stage.getViewport().update(width, height, true);
		
		//System.out.println(width);
		//System.out.println(height);
		
		
		mediator.displayHeight = showHeight;
		mediator.displayWidth = showWidth;
		mediator.widgets.adjustBox();
		
		Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
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








