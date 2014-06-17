package com.ubuntuserver.frontend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

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
	
	
	
	public int[] x;
	public int[] y;
	public int xCount;
	public int yCount;
	
	
	Mediator mediator;
	
	
	
	public Graph_Main(Mediator med) {
		mediator = med;
	}
	
	
	
	public Graph_Main(Mediator med, int x, int y, int w, int h) {
		
		//mode = GraphMode.BAR_GRAPH;
		mode = GraphMode.LINE_CHART;
		
		mediator = med;
		left = x;
		bottom = y;
		width = w;
		height = h;
		
		
		setGridSize(100,100);
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
		
		
		int xTicIncr = gridWidth / xCount;
		int barLeft;
		int barRight;
		int barWidth;
		int barHeight = 0; //bottom is at gridBottom
		
		int maxValue = y[0];
		for (int i = 1; i < yCount; i++) {
			if (y[i] > maxValue) {
				maxValue = y[i];
			}
		}
		
		
		for (int i = 0; i < yCount; i++) {
			//xTemp = gridLeft + (i+1) * xTicIncr;
			
			barLeft = gridLeft + (i * xTicIncr);
			barRight = gridLeft + ((i+1) * xTicIncr);
			
			barHeight = (int) ((y[i] / (float) maxValue) * gridHeight);
			
			//paint.line(barLeft, gridBottom, barLeft, gridBottom - 10);
			paint.rect(barLeft, gridBottom, barRight - barLeft, barHeight);
		}
		
		
		
		//draw outlines around the bars
		
		paint.end();
		paint.begin(ShapeType.Line);
		
		paint.setColor(Color.BLACK);
		
		for (int i = 0; i < yCount; i++) {
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
	}
	
	
	
	
	public void drawDataPoints(ShapeRenderer paint) {
		
		int dotMargin = 5;
		
		//going to use yData in order for evenly distributed bars
		
		paint.end();
		paint.begin(ShapeType.Filled);
		
		paint.setColor(Color.GREEN);
		
		
		int xTicIncr = gridWidth / xCount;
		int barLeft;
		int barRight;
		int barWidth;
		int barHeight = 0; //bottom is at gridBottom
		
		int dotMid;
		
		
		//determine max value
		int maxValue = y[0];
		for (int i = 1; i < yCount; i++) {
			if (y[i] > maxValue) {
				maxValue = y[i];
			}
		}
		
		
		//draw green rectangles
		
		for (int i = 0; i < yCount; i++) {
			//xTemp = gridLeft + (i+1) * xTicIncr;
			
			barLeft = gridLeft + (i * xTicIncr);
			barRight = gridLeft + ((i+1) * xTicIncr);
			barWidth = barRight - barLeft;
			
			barHeight = (int) ((y[i] / (float) maxValue) * gridHeight);
			
			
			
			
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
	
	public void setData(int[] xNew, int[] yNew) {
		x = xNew;
		y = yNew;
		
		xCount = xNew.length;
		yCount = yNew.length;
	}
	
	
	
	
}
