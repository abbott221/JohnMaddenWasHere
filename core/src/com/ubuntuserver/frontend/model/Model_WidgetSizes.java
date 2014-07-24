package com.ubuntuserver.frontend.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.ubuntuserver.frontend.Mediator;


/**
 * not implemented or referenced anywhere, but possible for consideration
 */
public class Model_WidgetSizes {
	
	Mediator mediator;
	
	
	//public float dropDown_Space = 120;
	public float dropDown_Space = 95;
	
	public float dropDown_Row1 = 40; //labels
	public float dropDown_Row2 = 70; //start, end, and station
	
	
	
	
	public final float PARS_MARGNS = 25;
	
	
	
	
	//public final int PARS_COLS = 2;
	
	//public static final float PAR_1_WIDTH = 0.4f;
	
	
	public ArrayList<Model_Portion> portions;
	
	
	
	
	
	public Model_WidgetSizes(Mediator med) {
		
		mediator = med;
		
		
		
		portions = new ArrayList<Model_Portion>();
		
		
		
		
		
		//partition 1 is the big graph
		
		Model_Portion portion1 = new Model_Portion(med);
		portion1.setMargin(PARS_MARGNS);
		
		portion1.setRelativeSize(0.5f, 0.5f);
		portion1.setRelativeStart(0.0f, 0.5f);
		
		portion1.setAbsUsageLeft(1 * PARS_MARGNS);
		portion1.setAbsTotalLeft(3 * PARS_MARGNS);
		portion1.setAbsUsageBottom(2 * PARS_MARGNS);
		portion1.setAbsTotalBottom(3 * PARS_MARGNS);
		
		portions.add(portion1);
		
		
		
		
		
		//partition 2 is the map
		
		Model_Portion portion2 = new Model_Portion(med);
		portion2.setMargin(PARS_MARGNS);
		
		portion2.setRelativeSize(0.5f, 0.5f);
		portion2.setRelativeStart(0.0f, 0.0f);
		
		portion2.setAbsUsageLeft(1 * PARS_MARGNS);
		portion2.setAbsTotalLeft(3 * PARS_MARGNS);
		portion2.setAbsUsageBottom(1 * PARS_MARGNS);
		portion2.setAbsTotalBottom(3 * PARS_MARGNS);
		
		portions.add(portion2);
		
		
		
		
		
		//partition 3 is the data table
		
		Model_Portion portion3 = new Model_Portion(med);
		portion3.setMargin(PARS_MARGNS);
		
		portion3.setRelativeSize(0.5f, 0.4f);
		portion3.setRelativeStart(0.5f, 0.0f);
		
		portion3.setAbsUsageLeft(2 * PARS_MARGNS);
		portion3.setAbsTotalLeft(3 * PARS_MARGNS);
		portion3.setAbsUsageBottom(1 * PARS_MARGNS);
		portion3.setAbsTotalBottom(4 * PARS_MARGNS);
		
		portions.add(portion3);
		
		
		
		
		
		//partition 4 is the report TextArea
		
		Model_Portion portion4 = new Model_Portion(med);
		portion4.setMargin(PARS_MARGNS);
		
		portion4.setRelativeSize(0.5f, 0.3f);
		portion4.setRelativeStart(0.5f, 0.4f);
		
		portion4.setAbsUsageLeft(2 * PARS_MARGNS);
		portion4.setAbsTotalLeft(3 * PARS_MARGNS);
		portion4.setAbsUsageBottom(2 * PARS_MARGNS);
		portion4.setAbsTotalBottom(4 * PARS_MARGNS);
		
		portions.add(portion4);
		
		
		
		
		
		//partition 5 is thumbnails
		
		Model_Portion portion5 = new Model_Portion(med);
		portion5.setMargin(PARS_MARGNS);
		
		portion5.setRelativeSize(0.5f, 0.3f);
		portion5.setRelativeStart(0.5f, 0.7f);
		
		portion5.setAbsUsageLeft(2 * PARS_MARGNS);
		portion5.setAbsTotalLeft(3 * PARS_MARGNS);
		portion5.setAbsUsageBottom(3 * PARS_MARGNS);
		portion5.setAbsTotalBottom(4 * PARS_MARGNS);
		
		portions.add(portion5);
		
		
		
		
		
		
		
		//do the math for sizing here?
		
	}
	
	
	
	public void adjustBox() {
		//
	}
	
}



