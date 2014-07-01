package com.ubuntuserver.frontend.Logic;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Logic_Polling {
	
	
	
	public static void checkWidgetTouch(Mediator mediator) {
		
		
		
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
			int firstY = mediator.core.showHeight - Gdx.input.getY();
			
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
	
	
	public static void startDateChange(Mediator mediator, SelectBox startDateBox) {
		
		Graph_Main activeGraph = mediator.model.selectedGraph;
		
		activeGraph.dataModel.dataClipStart = startDateBox.getSelectedIndex();
		
		//setDisplayData(activeGraph);
	}
	
	
}





