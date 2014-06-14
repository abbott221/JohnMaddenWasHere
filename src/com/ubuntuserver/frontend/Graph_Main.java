package com.ubuntuserver.frontend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Graph_Main {
	
	
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
	
	
	Model_Main model;
	
	
	
	public Graph_Main(Model_Main mod) {
		model = mod;
	}
	
	
	
	public Graph_Main(Model_Main mod, int x, int y, int w, int h) {
		model = mod;
		left = x;
		bottom = y;
		width = w;
		height = h;
		
		
		setGridSize(100,100);
	}
	
	
	public void drawMainGraph(ShapeRenderer paint) {
		
		//background
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
