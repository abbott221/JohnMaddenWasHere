package com.ubuntuserver.frontend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Graph_Main {
	
	
	public static enum GraphMode {
		BAR_GRAPH, LINE_CHART
	}
	
	private GraphMode mode;
	
	
	public int left;
	public int bottom;
	public int height;
	public int width;
	
	public int gridLeft;
	public int gridBottom;
	
	public int gridWidth;
	public int gridHeight;
	
	
	
	Mediator mediator;
	
	
	public Model_Graph dataModel;
	
	//public int[] x;
	//public int[] y;
	//public int xCount;
	//public int yCount;
	
	//public int dataClipStart;
	//public int dataClipEnd;
	
	
	
	
	public Graph_Main(Mediator med, Model_General mod) {
		
		//mode = GraphMode.BAR_GRAPH;
		mode = GraphMode.LINE_CHART;
		
		mediator = med;
		
		left = 25;
		bottom = 25;
		width = 500;
		height = 500;
		
		setGridSize(100,100);
		
		
		/*
		if (mediator.model == null) {
			System.out.println("LOL NULL");
		}
		if (mod == null) {
			System.out.println("LOL NULL 2");
		}
		/**/
		
		dataModel = new Model_Graph(med, mod);
		
		dataModel.dataClipStart = 0;
		
		
		//dataModel.dataClipEnd = mod.waterDataSize - 1;
		//dataModel.setData(mod.waterData);
		
		if (dataModel.dataMode == ShowMode.SHOW_GAUGE)
		{
			dataModel.dataClipEnd = dataModel.myStation.gaugeCount - 1;
			dataModel.setData(dataModel.myStation.gauge);
		}
		else //ShowMode.SHOW_FORECAST
		{
			dataModel.dataClipEnd = dataModel.myStation.forecastCount - 1;
			dataModel.setData(dataModel.myStation.forecast);
		}
		
		
		//dataClipStart = 0;
		//dataClipEnd = mod.waterDataSize - 1;
		
		//this.y = mediator.model.waterData;
		//this.setData(mod.waterData); //sets yCount as well
	}
	
	
	
	
	
	public void drawMainGraph(ShapeRenderer paint) {
		
		//background
		paint.begin(ShapeType.Filled);
		paint.setColor(Color.WHITE);
		paint.rect(left, bottom, width, height);
		
		
		//System.out.println(gridLeft);
		//System.out.println(gridBottom);
		//System.out.println(gridWidth);
		//System.out.println(gridHeight);
		
		paint.end();
		paint.begin(ShapeType.Line);
		
		paint.setColor(Color.BLACK);
		
		//draw the axises
		paint.line(gridLeft, gridBottom, gridLeft+gridWidth, gridBottom);
		paint.line(gridLeft, gridBottom, gridLeft, gridBottom+gridHeight);
		
		
		/*
		//draw ticks
		int xTicIncr = gridWidth / xCount;
		int yTicIncr = gridHeight / yCount;
		int xTemp;
		int yTemp;
		for (int i = 0; i < xCount; i++) {
			xTemp = gridLeft + (i+1) * xTicIncr;
			paint.line(xTemp, gridBottom, xTemp, gridBottom - 10);
		}
		
		for (int i = 0; i < yCount; i++) {
			yTemp = gridLeft + (i+1) * yTicIncr;
			paint.line(gridLeft, yTemp, gridLeft - 10, yTemp);
		}
		/**/
		
		
		
		
		if (mode == GraphMode.BAR_GRAPH) {
			drawBars(paint);
		}
		else if (mode == GraphMode.LINE_CHART) {
			drawDataPoints(paint);
		}
		
		paint.end();
		
	}
	
	
	
	public void drawBars(ShapeRenderer paint) {
		
		//going to use yData in order for evenly distributed bars
		
		paint.end();
		paint.begin(ShapeType.Filled);
		
		paint.setColor(Color.GREEN);
		
		
		int xTicIncr = gridWidth / dataModel.dataCount;
		int barLeft;
		int barRight;
		int barWidth;
		int barHeight = 0; //bottom is at gridBottom
		
		int maxValue = dataModel.data[0];
		for (int i = 1; i < dataModel.dataCount; i++) {
			if (dataModel.data[i] > maxValue) {
				maxValue = dataModel.data[i];
			}
		}
		
		
		for (int i = 0; i < dataModel.dataCount; i++) {
			//xTemp = gridLeft + (i+1) * xTicIncr;
			
			barLeft = gridLeft + (i * xTicIncr);
			barRight = gridLeft + ((i+1) * xTicIncr);
			
			barHeight = (int) ((dataModel.data[i] / (float) maxValue) * gridHeight);
			
			//paint.line(barLeft, gridBottom, barLeft, gridBottom - 10);
			paint.rect(barLeft, gridBottom, barRight - barLeft, barHeight);
		}
		
		
		
		//draw outlines around the bars
		
		paint.end();
		paint.begin(ShapeType.Line);
		
		paint.setColor(Color.BLACK);
		
		for (int i = 0; i < dataModel.dataCount; i++) {
			//xTemp = gridLeft + (i+1) * xTicIncr;
			
			barLeft = gridLeft + (i * xTicIncr);
			barRight = gridLeft + ((i+1) * xTicIncr);
			barWidth = barRight - barLeft;
			
			barHeight = (int) ((dataModel.data[i] / (float) maxValue) * gridHeight);
			
			//paint.line(barLeft, gridBottom, barLeft, gridBottom - 10);
			//paint.rect(barLeft, gridBottom, barRight - barLeft, barHeight);
			
			//bottom isn't needed
			
			//left
			paint.line(barLeft, gridBottom, barLeft, gridBottom + barHeight);
			
			//top
			paint.line(barLeft, gridBottom + barHeight, barLeft + barWidth, gridBottom + barHeight);
			
			//right
			paint.line(barLeft + barWidth, gridBottom, barLeft + barWidth, gridBottom + barHeight);
			
		}
	}
	
	
	
	
	public void drawDataPoints(ShapeRenderer paint) {
		
		int dotMargin = 5;
		
		//going to use yData in order for evenly distributed bars
		
		paint.end();
		paint.begin(ShapeType.Filled);
		
		paint.setColor(Color.GREEN);
		
		
		int xTicIncr = gridWidth / dataModel.dataCount;
		int barLeft;
		int barRight;
		int barWidth;
		int barHeight = 0; //bottom is at gridBottom
		
		int dotMid;
		
		
		//determine max value
		int maxValue = dataModel.data[0];
		for (int i = 1; i < dataModel.dataCount; i++) {
			if (dataModel.data[i] > maxValue) {
				maxValue = dataModel.data[i];
			}
		}
		
		
		//draw green rectangles
		
		for (int i = 0; i < dataModel.dataCount; i++) {
			//xTemp = gridLeft + (i+1) * xTicIncr;
			
			barLeft = gridLeft + (i * xTicIncr);
			barRight = gridLeft + ((i+1) * xTicIncr);
			barWidth = barRight - barLeft;
			
			barHeight = (int) ((dataModel.data[i] / (float) maxValue) * gridHeight);
			
			
			
			
			dotMid = barLeft + (barWidth / 2);
			
			//paint.rect(barLeft, gridBottom, barRight - barLeft, barHeight);
			//paint.rect(barLeft-dotMargin, gridHeight-dotMargin, 2*dotMargin, 2*dotMargin);
			//paint.rect(barLeft-dotMargin, barHeight-dotMargin, 2*dotMargin, 2*dotMargin);
			paint.rect(dotMid-dotMargin, gridBottom+barHeight-dotMargin, 2*dotMargin, 2*dotMargin);
			
		}
		
		
		
		//draw outlines around the bars
		
		/*
		
		paint.end();
		paint.begin(ShapeType.Line);
		
		paint.setColor(Color.BLACK);
		
		for (int i = 0; i < xCount; i++) {
			//xTemp = gridLeft + (i+1) * xTicIncr;
			
			barLeft = gridLeft + (i * xTicIncr);
			barRight = gridLeft + ((i+1) * xTicIncr);
			barWidth = barRight - barLeft;
			
			barHeight = (int) ((y[i] / (float) maxValue) * gridHeight);
			
			//paint.line(barLeft, gridBottom, barLeft, gridBottom - 10);
			//paint.rect(barLeft, gridBottom, barRight - barLeft, barHeight);
			
			//bottom isn't needed
			
			//left
			paint.line(barLeft, gridBottom, barLeft, gridBottom + barHeight);
			
			//top
			paint.line(barLeft, gridBottom + barHeight, barLeft + barWidth, gridBottom + barHeight);
			
			//right
			paint.line(barLeft + barWidth, gridBottom, barLeft + barWidth, gridBottom + barHeight);
			
		}
		
		/**/
		
	}
	
	
	
	
	
	public void setGridSize(int w, int h) {
		gridWidth = w;
		gridHeight = h;
		
		gridLeft = left + ((width - w) / 2);
		gridBottom = bottom + ((height - h) / 2);
	}
	
	
	
	/*
	public void setData(int[] xNew, int[] yNew) {
		//x = xNew;
		y = yNew;
		
		//xCount = xNew.length;
		yCount = yNew.length;
	}
	/**/
	
	
	public void setData(int[] data) {
		//x = xNew;
		dataModel.data = data;
		
		//xCount = xNew.length;
		dataModel.dataCount = data.length;
	}
	
	
	
	
	
	
	public void setGraphLocation(int x, int y) {
		this.left = x;
		this.bottom = y;
	}
	
	public void setGraphSize(int w, int h) {
		this.width = w;
		this.height = h;
		
		this.setGridSize(w - 40, h - 40);
	}
	
	
}