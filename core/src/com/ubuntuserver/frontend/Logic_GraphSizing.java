package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;

public class Logic_GraphSizing {
	
	
	
	
	public static void setSizeByCount(Mediator med, ArrayList<Graph_Main> graphL) {
		
		ArrayList<Graph_Main> graphList = graphL;
		
		int graphCount = graphList.size();
		
		
		//also account for number of graphs?
		int spaceHeight = med.displayHeight - 90; //40 + 25 * 2 = 90
		
		
		
		//spaceHeight -= 45; //for extra space between graphs and button stuff
		spaceHeight -= 145; //45 + ?
		
		
		
		
		int spaceWidth = med.displayWidth - 50; //40 + 25 * 2 = 90
		
		int graphHeight;
		int graphWidth;
		
		
		/*
		if (med.widgets == null) {
			System.out.println("NULL");
		}
		/**/
		
		if (med.widgets == null || med.widgets.thumbnails.isChecked() == false)
		{
			if (graphCount == 1) {
				graphList.get(0).setGraphLocation(25, 25);
				graphList.get(0).setGraphSize(spaceWidth, spaceHeight);
			}
			
			else if (graphCount == 2) {
				graphWidth = (spaceWidth - 25) / 2;
				
				graphList.get(0).setGraphLocation(25, 25);
				graphList.get(0).setGraphSize(graphWidth, spaceHeight);
				
				graphList.get(1).setGraphLocation(graphWidth + 50, 25); //25 + width + 25
				graphList.get(1).setGraphSize(graphWidth, spaceHeight);
			}
			
			else if (graphCount == 3) {
				graphWidth = (spaceWidth - 25 * 2) / 3;
				
				graphList.get(0).setGraphLocation(25, 25); //25
				graphList.get(0).setGraphSize(graphWidth, spaceHeight);
				
				graphList.get(1).setGraphLocation(graphWidth + 50, 25); //25 + width + 25
				graphList.get(1).setGraphSize(graphWidth, spaceHeight);
				
				graphList.get(2).setGraphLocation(graphWidth * 2 + 75, 25); //25 + width + 25 + width + 25
				graphList.get(2).setGraphSize(graphWidth, spaceHeight);
			}
			
			else if (graphCount == 4) {
				graphWidth = (spaceWidth - 25) / 2;
				graphHeight = (spaceHeight - 25) / 2;
				
				graphList.get(0).setGraphLocation(25, 25);
				graphList.get(0).setGraphSize(graphWidth, graphHeight);
				
				graphList.get(1).setGraphLocation(graphWidth + 50, 25); //25 + width + 25
				graphList.get(1).setGraphSize(graphWidth, graphHeight);
				
				
				
				graphList.get(2).setGraphLocation(25, graphHeight + 50);
				graphList.get(2).setGraphSize(graphWidth, graphHeight);
				
				graphList.get(3).setGraphLocation(graphWidth + 50, graphHeight + 50);
				graphList.get(3).setGraphSize(graphWidth, graphHeight);
			}
			
			
			else if (graphCount == 5) {
				graphWidth = (spaceWidth - 25 * 2) / 3;
				graphHeight = (spaceHeight - 25) / 2;
				
				graphList.get(0).setGraphLocation(25, 25); //25
				graphList.get(0).setGraphSize(graphWidth, graphHeight);
				
				graphList.get(1).setGraphLocation(graphWidth + 50, 25); //25 + width + 25
				graphList.get(1).setGraphSize(graphWidth, graphHeight);
				
				graphList.get(2).setGraphLocation(graphWidth * 2 + 75, 25); //25 + width + 25 + width + 25
				graphList.get(2).setGraphSize(graphWidth, graphHeight);
				
				
				
				graphList.get(3).setGraphLocation(25, graphHeight + 50);
				graphList.get(3).setGraphSize(graphWidth, graphHeight);
				
				graphList.get(4).setGraphLocation(graphWidth + 50, graphHeight + 50);
				graphList.get(4).setGraphSize(graphWidth, graphHeight);
				
				//graphList.get(5).setGraphLocation(graphWidth * 2 + 75, graphHeight + 50);
				//graphList.get(5).setGraphSize(graphWidth, graphHeight);
			}
			
			else if (graphCount == 6) {
				graphWidth = (spaceWidth - 25 * 2) / 3;
				graphHeight = (spaceHeight - 25) / 2;
				
				graphList.get(0).setGraphLocation(25, 25); //25
				graphList.get(0).setGraphSize(graphWidth, graphHeight);
				
				graphList.get(1).setGraphLocation(graphWidth + 50, 25); //25 + width + 25
				graphList.get(1).setGraphSize(graphWidth, graphHeight);
				
				graphList.get(2).setGraphLocation(graphWidth * 2 + 75, 25); //25 + width + 25 + width + 25
				graphList.get(2).setGraphSize(graphWidth, graphHeight);
				
				
				
				graphList.get(3).setGraphLocation(25, graphHeight + 50);
				graphList.get(3).setGraphSize(graphWidth, graphHeight);
				
				graphList.get(4).setGraphLocation(graphWidth + 50, graphHeight + 50);
				graphList.get(4).setGraphSize(graphWidth, graphHeight);
				
				graphList.get(5).setGraphLocation(graphWidth * 2 + 75, graphHeight + 50);
				graphList.get(5).setGraphSize(graphWidth, graphHeight);
			}
			
			
		}
		else {
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
			
			med.model.bigGraph.setGraphLocation(25, 25);
			med.model.bigGraph.setGraphSize(2*sideWidth + 25, spaceHeight); //thirds
			
		}
		
		
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
