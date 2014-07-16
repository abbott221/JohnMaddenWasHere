package com.ubuntuserver.frontend;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;

public class Model_Portion {
	
	Mediator mediator;
	
	
	public float PARS_MARGNS;
	
	
	/*
	 * partition 1 is the big graph
	 */
	
	//start
	public float REL_LEFT;
	public float REL_BOTTOM;
	//size
	public float REL_WIDTH;
	public float REL_HEIGHT;
	
	
	//of 3, past 1
	public float ABS_USE_LEFT;
	public float ABS_TTL_LEFT;
	
	//of 3, past 2
	public float ABS_USE_BOTTOM;
	public float ABS_TTL_BOTTOM;
	
	
	
	public class Results {
		float bottom;
		float left;
		float height;
		float width;
	}
	
	
	public Model_Portion(Mediator med) {
		mediator = med;
	}
	
	
	
	public void setMargin(float margin) {
		this.PARS_MARGNS = margin;
	}
	
	
	
	
	public void setRelativeStart(float left, float bottom) {
		this.REL_LEFT = left;
		this.REL_BOTTOM = bottom;
	}
	
	public void setRelativeSize(float width, float height) {
		this.REL_WIDTH = width;
		this.REL_HEIGHT = height;
	}
	
	
	
	
	public void setAbsoluteLeft(float usageLeft, float totalLeft) {
		this.ABS_USE_LEFT = usageLeft;
		this.ABS_TTL_LEFT = totalLeft;
	}
	
	public void setAbsoluteBottom(float usageBottom, float totalBottom) {
		this.ABS_USE_BOTTOM = usageBottom;
		this.ABS_TTL_BOTTOM = totalBottom;
	}
	
	
	
	
	public void setAbsUsageLeft(float usageLeft) {
		this.ABS_USE_LEFT = usageLeft;
	}
	public void setAbsTotalLeft(float totalLeft) {
		this.ABS_TTL_LEFT = totalLeft;
	}
	
	public void setAbsUsageBottom(float usageBottom) {
		this.ABS_USE_BOTTOM = usageBottom;
	}
	public void setAbsTotalBottom(float totalBottom) {
		this.ABS_TTL_BOTTOM = totalBottom;
	}
	
	
	
	
	public Results getResults() {
		
		Results returnMe = new Results();
		
		Model_WidgetSizes sizing = mediator.model.widgetSizes;
		
		
		float sectionHeight = mediator.displayHeight - sizing.dropDown_Space;
		//sectionHeight -= sizing.PAR2_ABS_TTL_BOTTOM;
		sectionHeight -= this.ABS_TTL_BOTTOM;
		
		float sectionWidth = mediator.displayWidth;
		//sectionWidth -= sizing.PAR2_ABS_TTL_LEFT;
		sectionWidth -= this.ABS_TTL_LEFT;
		
		
		//returnMe.bottom = sizing.PAR2_ABS_USE_BOTTOM;
		//returnMe.bottom += sectionHeight * sizing.PAR2_BOTTOM;
		returnMe.bottom = this.ABS_USE_BOTTOM;
		returnMe.bottom += sectionHeight * this.REL_BOTTOM;
		
		//returnMe.left = sizing.PAR2_ABS_USE_LEFT;
		//returnMe.left += sectionWidth * sizing.PAR2_LEFT;
		returnMe.left = this.ABS_USE_LEFT;
		returnMe.left += sectionWidth * this.REL_LEFT;
		
		
		returnMe.height = sectionHeight * this.REL_HEIGHT;
		
		returnMe.width = sectionWidth * this.REL_WIDTH;
		
		return returnMe;
	}
	
	
}



