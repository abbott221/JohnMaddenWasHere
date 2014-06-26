package com.ubuntuserver.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;


public class Logic_Stage {
	
	
	
	public static void constructStage(Mediator mediator) {
		
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
		
		newStage.addActor(mediator.widgets.thumbnails);
		
		
		
		newStage.addActor(mediator.widgets2.optionsButton);
		
		
		
	}
	
	
	
	
	
	
}





