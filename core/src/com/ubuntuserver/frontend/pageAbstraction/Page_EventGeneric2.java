package com.ubuntuserver.frontend.pageAbstraction;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.pages.Page_Event01;
import com.ubuntuserver.frontend.pages.Page_Event03;

public class Page_EventGeneric2 extends Abstract_GenericCheckBox {
	
	
	public Page_EventGeneric2(MainCoreClass coreIn) {
		
		super(coreIn);
		
		
		
		this.title.setText("2. Broadcast flash flood warnings and flash flood "
				+ "emergencies on Metro Alert");
		
		
		
		Label temp2 = new Label("1. Depress and hold ALERT 1 tone for about 5 seconds\n"
				+ "2. Depress Red transmit button and say:\n"
				+ "The National Weather Service has issued a flash "
				+ "flood (warning or emergency) for (location) until (time).\n"
				+ "-Repeat message-\n"
				+ "Franklin County Emergency Management and Homeland Security Clear.", skin);
		//temp2.setColor(Color.BLACK);
		temp2.setPosition(100, 550);
		this.thisAddWidget(temp2);
		
		
		
		this.pageNum = 2;
		
		this.postConstruction();
	}
	
	
	
	@Override
	public void previousPage() {
		core.currentScreen.thisRemoveScreen();
		core.currentScreen = null;
		Page_Event01 newPage = new Page_Event01(core);
	}
	
	
	
	@Override
	public void nextPage() {
		core.currentScreen.thisRemoveScreen();
		core.currentScreen = null;
		Page_Event03 newPage = new Page_Event03(core);
	}
	
	
}


