package com.ubuntuserver.frontend.Logic;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.model.Model_WidgetSizes;
import com.ubuntuserver.frontend.model.Model_Portion.Results;

public class Logic_GraphSizing {
	
	
	
	
	public static void setSizeByCount(Mediator med, ArrayList<Graph_Main> graphL) {
		
		ArrayList<Graph_Main> graphList = graphL;
		
		int graphCount = graphList.size();
		
		
		
		
		
		Model_WidgetSizes sizing = med.model.widgetSizes;
		
		
		
		//spaceHeight and spaceWidth are what's left
		//when the dropdown space and margins are removed
		//wait, no?
		
		
		int spaceHeight = (int) (med.displayHeight - sizing.dropDown_Space);
		
		//System.out.println("graph width reading" + med.displayWidth);
		
		int spaceWidth = med.displayWidth - (2 * 25);
		//40 + 25 * 2 = 90
		
		
		float graphHeight;
		float graphWidth;
		
		
		
		
		
		
		//==================================================================
		
		Results bounds = sizing.portions.get(0).getResults();
		
		//==================================================================
		
		
		
		med.model.bigGraph = new Graph_Main(med, med.model);
		
		med.model.bigGraph.dataModel = med.model.selectedGraph.dataModel;
		
		
		Graph_Main bigTemp = med.model.bigGraph;
		
		
		//Results bounds = sizing.portions.get(0).getResults();
		
		
		//bigTemp.setGraphLocation(partitionLeft, partitionBottom);
		bigTemp.setGraphLocation(bounds.left, bounds.bottom);
		
		//bigTemp.setGraphSize((int) (partitionWidth), (int) (partitionHeight));
		bigTemp.setGraphSize((int) (bounds.width), (int) (bounds.height));
		
		
		/**/
		bigTemp.setGridSize(bigTemp.width - 100, bigTemp.height - 100);
		bigTemp.setGridLocRelToGraph(80, 80);
		/**/
		
		
		
		
		
		//==================================================================
		
		
		
		
		//System.out.println("THUMBNAILS VIEW = TRUE?");
		
		
		
		
		//System.out.println("BLAH");
		
		//graphList.get(0).setGraphLocation(25, 25);
		//graphList.get(0).setGraphSize(spaceWidth, spaceHeight);
		
		
		
		bounds = sizing.portions.get(4).getResults();
		
		
		
		
		
		
		//graphWidth = (spaceWidth - 25 * 2) / 3;
		float sideWidth = (spaceWidth - 25 * 2) / 3; //thirds
		//int sideWidth = (spaceWidth - 25 * 3) / 4; //fourths
		float sideHeight = spaceHeight;
		
		
		sideWidth = bounds.width;
		sideHeight = bounds.height;
		
		
		graphWidth = (int) ((sideWidth - 10) / 2);
		graphHeight = (spaceHeight - 4 * 10) / 5;
		
		
		graphHeight = sideHeight;
		graphWidth = (sideWidth - 20) / 3;
		
		
		
		
		
		
		//something with graphCount
		
		float xLeft = (int) (2 * sideWidth + 3 * 25); //thirds
		float yTop = (int) (25 + sideHeight - graphHeight);
		float x = xLeft;
		float y = yTop;
		
		xLeft = bounds.left;
		yTop = bounds.bottom + bounds.height;
		
		for (int i = 0; i < graphCount; i ++) {
			
			//int x = 0;
			//int y = 0;
			
			//thirds
			//x = 2 * sideWidth + 3 * 25;
			
			
			if (i % 3 == 0) //if even, starting at 0
			{
				x = xLeft;
				//y = yTop - ( ((i+1)/2) * (10+graphHeight) ); //move out
				//y = yTop - ( (i/2) * (10+graphHeight) ); //move out
				
				y = bounds.bottom;
				
				graphList.get(i).setGraphLocation(x, y); //move out
				graphList.get(i).setGraphSize( (int) graphWidth, (int) graphHeight);
			}
			else if (i % 3 == 1)
			{
				x = xLeft + graphWidth + 10;
				//y = yTop - ( ((i+1)/2) * (10+graphHeight) ); //move out
				//y = yTop - ( (i/2) * (10+graphHeight) ); //move out
				
				y = bounds.bottom;
				
				graphList.get(i).setGraphLocation(x, y); //move out
				graphList.get(i).setGraphSize( (int) graphWidth, (int) graphHeight);
			}
			
			else {
				x = xLeft + (2 * (graphWidth + 10));
				//y = yTop - ( ((i+1)/2) * (10+graphHeight) ); //move out
				//y = yTop - ( (i/2) * (10+graphHeight) ); //move out
				
				y = bounds.bottom;
				
				graphList.get(i).setGraphLocation(x, y); //move out
				graphList.get(i).setGraphSize( (int) graphWidth, (int) graphHeight);
			}
			
		}
		
		
		
		
		
	}
	
	
	
	
}
