package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;


/**
 * not implemented or referenced anywhere, but possible for consideration
 */
public class Model_WidgetSizes {
	
	Mediator mediator;
	
	
	public float dropDown_Space = 120;
	
	public float dropDown_Row1 = 40; //labels
	public float dropDown_Row2 = 70; //start, end, and station
	
	
	
	
	public final float PARS_MARGNS = 25;
	
	
	
	
	public final int PARS_COLS = 2;
	
	//public static final float PAR_1_WIDTH = 0.4f;
	
	
	
	
	/*
	 * partition 1 is the big graph
	 */
	public final float PAR1_WIDTH = 0.4f;
	public final float PAR1_HEIGHT = 0.5f;
	public final float PAR1_LEFT = 0.0f;
	public final float PAR1_BOTTOM = 0.5f;
	
	//of 3, past 1
	public final float PAR1_ABS_USE_LEFT = PARS_MARGNS;
	public final float PAR1_ABS_TTL_LEFT = 3 * PARS_MARGNS;
	
	//of 3, past 2
	public final float PAR1_ABS_USE_BOTTOM = 2 * PARS_MARGNS;
	public final float PAR1_ABS_TTL_BOTTOM = 3 * PARS_MARGNS;
	
	
	
	
	
	public Model_WidgetSizes(Mediator med) {
		
		mediator = med;
		
		
		
		//do the math for sizing here?
		
		
		
	}
	
	
	
	public void adjustBox() {
		//
	}
	
}



