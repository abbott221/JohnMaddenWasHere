package com.ubuntuserver.pages;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.ubuntuserver.frontend.Logic.Logic_Dates;
import com.ubuntuserver.frontend.Logic.Logic_Stage;
import com.ubuntuserver.frontend.Abstract_Screen;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;

public class Page_Event2 extends Abstract_Screen {
	
	
	
	
	//Window window;
	//TextField userText;
	
	public Label temp;
	
	TextButton newEventPage;
	TextButton activeEventsPage;
	
	
	
	
	
	public Page_Event2(MainCoreClass coreIn) {
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		
		
		temp = new Label("2. Broadcast flash flood warnings and flash flood "
				+ "emergencies on Metro Alert", skin);
		temp.setPosition(100, 700);
		this.thisAddWidget(temp);
		
		
		
		
		
		Label temp2 = new Label("1. Depress and hold ALERT 1 tone for about 5 seconds\n"
				+ "2. Depress Red transmit button and say:\n"
				+ "The National Weather Service has issued a flash "
				+ "flood (warning or emergency) for (location) until (time).\n"
				+ "-Repeat message-\n"
				+ "Franklin County Emergency Management and Homeland Security Clear.", skin);
		//temp2.setColor(Color.BLACK);
		temp2.setPosition(100, 550);
		this.thisAddWidget(temp2);
		
		
		
		
		
		
		/*
		TextArea description = new TextArea("Gage site name\nWater level\nLast reading time\n"
				+ "Increase rate in the last 4 hours\nActual precipitation\nForecast\n"
				+ "Flood warning issued: (all alert records in alert table"
				+ " for the last 3 hours)", skin);
		
		description.setBounds(100, 100, 500, 400);
		
		this.thisAddWidget(description);
		/**/
		
		
		
		
		
		TextButton nextButton = new TextButton("Next Page", skin);
		
		nextButton.setBounds(200, 20, 140, 20);
		
		nextButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_Event3 landingScreen = new Page_Event3(core);
			}
		});
		
		this.thisAddWidget(nextButton);
		
		
		
		
		
		
		TextButton landingButton = new TextButton("Landing Page", skin);
		
		landingButton.setBounds(20, 20, 140, 20);
		
		landingButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Screen_Landing landingScreen = new Screen_Landing(core);
			}
		});
		
		this.thisAddWidget(landingButton);
		
		
		
		
	}
	
	
}




