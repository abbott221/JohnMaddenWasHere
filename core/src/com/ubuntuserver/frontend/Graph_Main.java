package com.ubuntuserver.frontend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.Model_Station.AlertLevel;

public class Graph_Main {
	
	
	public static enum GraphMode {
		BAR_GRAPH, LINE_CHART
	}
	
	public GraphMode mode;
	
	
	public int left;
	public int bottom;
	public int height;
	public int width;
	
	public int gridLeft;
	public int gridBottom;
	
	public float gridWidth;
	public float gridHeight;
	
	
	
	public Mediator mediator;
	
	
	public Model_Graph dataModel;
	
	//public int[] x;
	//public int[] y;
	//public int xCount;
	//public int yCount;
	
	//public int dataClipStart;
	//public int dataClipEnd;
	
	
	public float maxValue;
	
	
	
	
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
		
		
		
		this.setMaxValue();
		
		
		//check if it is currently big graph?
		//also check if forecast or waterlevel is selected -- check ShowMode from Model_Graph
		
		if (this.dataModel.dataMode == ShowMode.SHOW_GAUGE) {
			paint.end();
			paint.begin(ShapeType.Line);
			
			//paint.setColor(Color.GREEN);
			
			int lineLeft = gridLeft;
			int lineRight = (int) (gridLeft + gridWidth);
			
			AlertLevel current;
			
			float lineHeight;
			
			
			
			
			//this.setMaxValue();
			//float maxValue = this.maxValue;
			/*
			float maxValue = dataModel.data[0];
			for (int i = 1; i < dataModel.dataCount; i++) {
				if (dataModel.data[i] > maxValue) {
					maxValue = dataModel.data[i];
				}
			}
			/**/
			
			
			
			//moved out of area specific to rain gauge
			//this.setMaxValue();
			
			
			
			//System.out.println( dataModel.myStation.alerts.size() );
			
			for (int i = 0; i < dataModel.myStation.alerts.size(); i++) {
				
				//System.out.println(i);
				
				current = this.dataModel.myStation.alerts.get(i);
				
				paint.setColor(current.lineColor);
				
				
				
				//lineHeight = (current.waterLevel / this.maxValue) * gridHeight;
				lineHeight = this.scaleValueToGrid(current.waterLevel) * gridHeight;
				
				
				
				paint.line(lineLeft, gridBottom + lineHeight, lineRight, gridBottom + lineHeight);
			}
		}
		
		
		
		
		
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
		
		
		float xTicIncr = gridWidth / dataModel.dataCount;
		float barLeft;
		float barRight;
		float barWidth;
		float barHeight = 0; //bottom is at gridBottom
		
		float maxValue = dataModel.data[0];
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
		
		float dotMargin = 3;
		
		//going to use yData in order for evenly distributed bars
		
		paint.end();
		paint.begin(ShapeType.Filled);
		
		paint.setColor(Color.GREEN);
		
		
		float xTicIncr = gridWidth / dataModel.dataCount;
		float barLeft;
		float barRight;
		float barWidth;
		float barHeight = 0; //bottom is at gridBottom
		
		float dotMid;
		
		
		//determine max value
		float maxValue = dataModel.data[0];
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
			
			
			
			
			//barHeight = (int) ((dataModel.data[i] / (float) maxValue) * gridHeight);
			barHeight = this.scaleValueToGrid(dataModel.data[i]) * gridHeight;
			
			
			
			
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
	
	
	
	
	
	
	/**
	 * scans through the data array for the max value
	 * may, possibly, be affected by the values stored in alert levels
	 * 
	 * set, determine, or reassess maxValue
	 */
	public void setMaxValue() {
		float nMaxValue = dataModel.data[0];
		for (int i = 1; i < dataModel.dataCount; i++) {
			if (dataModel.data[i] > nMaxValue) {
				nMaxValue = dataModel.data[i];
			}
		}
		
		this.maxValue = nMaxValue;
	}
	
	/**
	 * pseudocode:
	 * check if yTop and yBottom are negative
	 * if not, scale values by yTop and yBottom
	 * 
	 * if yTop and yBottom aren't set,
	 * scale incoming value to the maxValue
	 */
	public float scaleValueToGrid(float inValue) {
		
		float outValue = -1;
		
		Model_Station thisStation = this.dataModel.myStation;
		
		
		//if yBounds aren't set
		if (thisStation.yBottom < 0 && thisStation.yTop < 0) {
			outValue = inValue / this.maxValue;
		}
		//yBounds are set
		else {
			outValue = (inValue - thisStation.yBottom) / (thisStation.yTop - thisStation.yBottom);
		}
		
		
		return outValue;
	}
	
	
	
	
	
	
	
	
	
	
	public void setGridSize(int w, int h) {
		gridWidth = w;
		gridHeight = h;
		
		gridLeft = left + ((width - w) / 2);
		gridBottom = bottom + ((height - h) / 2);
	}
	
	
	
	/**
	 * setGridLocationRelativeToGraph
	 */
	public void setGridLocRelToGraph(int x, int y) {
		gridLeft = left + x;
		gridBottom = bottom + y;
	}
	
	
	
	
	public void displaceGrid(int x, int y) {
		gridLeft += x;
		gridBottom += y;
	}
	
	
	
	/*
	public void setData(int[] xNew, int[] yNew) {
		//x = xNew;
		y = yNew;
		
		//xCount = xNew.length;
		yCount = yNew.length;
	}
	/**/
	
	
	public void setData(float[] data) {
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