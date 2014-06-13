package com.ubuntuserver.frontend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Graph_Main {
	
	
	public int left;
	public int right;
	public int top;
	public int bottom;
	
	
	Model_Main model;
	
	
	
	
	public Graph_Main(Model_Main mod) {
		model = mod;
	}
	
	
	
	
	public void drawMainGraph(ShapeRenderer paint) {
		paint.setColor(Color.WHITE);
		
		
		paint.rect(left, bottom, right - left, top - bottom);
	}
	
}
