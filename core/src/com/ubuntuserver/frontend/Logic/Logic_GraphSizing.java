package com.ubuntuserver.frontend.Logic;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.Model_WidgetSizes;

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
		
		
		int graphHeight;
		int graphWidth;
		
		
		
		
		
		
		//section = available absolute space from resizing
		float sectionHeight = med.displayHeight - sizing.dropDown_Space;
		//sectionHeight -= (sizing.PARS_COLS + 1) * sizing.PARS_MARGNS;
		sectionHeight -= sizing.PAR1_ABS_TTL_BOTTOM;
		
		float sectionWidth = med.displayWidth;
		sectionWidth -= sizing.PAR1_ABS_TTL_LEFT;
		
		
		
		float partitionLeft = sizing.PAR1_ABS_USE_LEFT;
		float partitionBottom = sizing.PAR1_ABS_USE_BOTTOM;
		
		float partitionWidth = med.displayWidth;
		partitionWidth -= (sizing.PARS_COLS + 1) * sizing.PARS_MARGNS;
		//partitionWidth *= sizing.PAR_1_WIDTH;
		
		float partitionHeight = med.displayHeight - sizing.dropDown_Space;
		partitionWidth -= 2 * sizing.PARS_MARGNS; //there is only one partition row
		//height fraction/portion is 1.0
		
		//float partitionLeft = sizing.PAR1_ABS_USE_LEFT;
		//float partitionBottom = sizing.PAR1_ABS_USE_BOTTOM;
		
		
		
		float lol;
		lol = sectionHeight;
		lol = sectionWidth;
		lol = partitionLeft;
		lol = partitionBottom;
		lol = partitionWidth;
		lol = partitionHeight;
		
		//==================================================================
		
		
		
		System.out.println("THUMBNAILS VIEW = TRUE?");
		
		
		//System.out.println("BLAH");
		
		//graphList.get(0).setGraphLocation(25, 25);
		//graphList.get(0).setGraphSize(spaceWidth, spaceHeight);
		
		
		
		
		
		
		//graphWidth = (spaceWidth - 25 * 2) / 3;
		int sideWidth = (spaceWidth - 25 * 2) / 3; //thirds
		//int sideWidth = (spaceWidth - 25 * 3) / 4; //fourths
		int sideHeight = spaceHeight;
		
		graphWidth = (sideWidth - 10) / 2;
		graphHeight = (spaceHeight - 4 * 10) / 5;
		
		
		
		
		
		//something with graphCount
		
		int xLeft = 2 * sideWidth + 3 * 25; //thirds
		int yTop = 25 + sideHeight - graphHeight;
		int x = xLeft;
		int y = yTop;
		
		for (int i = 0; i < graphCount; i ++) {
			
			//int x = 0;
			//int y = 0;
			
			//thirds
			//x = 2 * sideWidth + 3 * 25;
			
			
			if (i % 2 == 0) //if even, starting at 0
			{
				x = xLeft;
				//y = yTop - ( ((i+1)/2) * (10+graphHeight) ); //move out
				y = yTop - ( (i/2) * (10+graphHeight) ); //move out
				
				graphList.get(i).setGraphLocation(x, y); //move out
				graphList.get(i).setGraphSize(graphWidth, graphHeight);
			}
			else
			{
				x = xLeft + graphWidth + 10;
				//y = yTop - ( ((i+1)/2) * (10+graphHeight) ); //move out
				y = yTop - ( (i/2) * (10+graphHeight) ); //move out
				
				graphList.get(i).setGraphLocation(x, y); //move out
				graphList.get(i).setGraphSize(graphWidth, graphHeight);
			}
			
		}
		
		
		
		
		
		/*
		
		graphList.get(0).setGraphLocation(25, 25); //25
		graphList.get(0).setGraphSize(graphWidth, spaceHeight);
		
		graphList.get(1).setGraphLocation(graphWidth + 50, 25); //25 + width + 25
		graphList.get(1).setGraphSize(graphWidth, spaceHeight);
		
		graphList.get(2).setGraphLocation(graphWidth * 2 + 75, 25); //25 + width + 25 + width + 25
		graphList.get(2).setGraphSize(graphWidth, spaceHeight);
		
		/**/
		
		
		
		med.model.bigGraph = new Graph_Main(med, med.model);
		
		med.model.bigGraph.dataModel = med.model.selectedGraph.dataModel;
		
		
		
		
		Graph_Main bigTemp = med.model.bigGraph;
		bigTemp.setGraphLocation(25, 25);
		
		
		
		int graphW = 2*sideWidth + 25; //thirds
		int graphH = spaceHeight; //thirds
		//med.model.bigGraph.setGraphSize(graphW, graphH); //thirds
		bigTemp.setGraphSize(graphW, graphH);
		
		
		
		//bigTemp.setGridSize(bigTemp.gridWidth - 100, bigTemp.gridHeight - 100);
		//bigTemp.displaceGrid(40, 40);
		
		//it is normally 40 between gridWidth and gridHeight
		//"padding" of 20 to top and right between graph and grid
		
		//bigTemp.setGridSize(bigTemp.gridWidth - 40, bigTemp.gridHeight - 40);
		//bigTemp.displaceGrid(40, 40);
		
		//bigTemp.setGridSize(bigTemp.width - 40, bigTemp.height - 40);
		
		
		/**/
		bigTemp.setGridSize(bigTemp.width - 100, bigTemp.height - 100);
		bigTemp.setGridLocRelToGraph(80, 80);
		/**/
		
		//==================================================================
		
		
		
		
		
		//NULL error originates from here?
		//med.model.bigGraph = new Graph_Main(med, med.model);
		
		
		
		/*
		firstGraph = new Graph_Main(med, 25, 25, 400, 400);
		firstGraph.setGridSize(300, 300);
		
		int[] xData = {3, 4, 6, 5, 8};
		int[] yData = {5, 6, 7, 3, 4};
		
		firstGraph.setData(xData, yData);
		
		graphs.add(firstGraph);
		/**/
		
		
	}
	
	
	
	
}
