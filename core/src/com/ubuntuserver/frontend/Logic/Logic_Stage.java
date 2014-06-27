package com.ubuntuserver.frontend.Logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Mediator;


public class Logic_Stage {
	
	
	
	public static void constructStage(Mediator mediator) {
		
		ShapeRenderer newShapes = new ShapeRenderer();
		mediator.widgets.shapes = newShapes;
		
		SpriteBatch newBatch = new SpriteBatch();
		mediator.widgets.batch = newBatch;
		
		//=======================================================
		
		
		
		Stage newStage = new Stage();
		
		mediator.core.stage = newStage;
		mediator.stage = newStage;
		mediator.widgets.stage = newStage;
		
		
		
		//copied from Widgets Constructor
		
		Gdx.input.setInputProcessor(newStage);
		
		
		
		
		//mediator.widgets.startDateBox = new SelectBox( mediator.widgets.skin );
		
		
		
		
		newStage.addActor(mediator.widgets.startDateBox);
		newStage.addActor(mediator.widgets.endDateBox);
		
		newStage.addActor(mediator.widgets.stationBox);
		newStage.addActor(mediator.widgets.dataModeBox);
		
		newStage.addActor(mediator.widgets.newGraph);
		newStage.addActor(mediator.widgets.deleteGraph);
		
		//newStage.addActor(mediator.widgets.thumbnails);
		
		
		
		newStage.addActor(mediator.widgets2.optionsButton);
		
		
		
	}
	
	
	
	
	
	
}





