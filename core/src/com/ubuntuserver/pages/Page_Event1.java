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
import com.ubuntuserver.frontend.model.Model_Event.SummaryStep;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;

public class Page_Event1 extends Abstract_Screen {
	
	
	
	
	//Window window;
	//TextField userText;
	
	public Label temp;
	
	TextButton newEventPage;
	TextButton activeEventsPage;
	
	
	public TextButton nextButton;
	
	TextArea description;
	
	//experienced some overflow error from possibly setting off event from setChecked()
	public boolean changing;
	
	
	public Page_Event1(MainCoreClass coreIn) {
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		
		
		temp = new Label("1. Information Verification", skin);
		temp.setPosition(100, 700);
		this.thisAddWidget(temp);
		
		
		//Verify message for warnings and emergencies with NWS Information verification
		
		Label temp2 = new Label("Verify message for warnings "
				+ "and emergencies with NWS Information verification", skin);
		//temp2.setColor(Color.BLACK);
		temp2.setPosition(100, 650);
		this.thisAddWidget(temp2);
		
		
		
		
		
		
		
		description = new TextArea("Gage site name\nWater level\nLast reading time\n"
				+ "Increase rate in the last 4 hours\nActual precipitation\nForecast\n"
				+ "Flood warning issued: (all alert records in alert table"
				+ " for the last 3 hours)", skin);
		
		description.setBounds(100, 100, 500, 400);
		
		this.thisAddWidget(description);
		
		
		
		
		
		
		
		/*
		
		TextButton nextButton = new TextButton("Next Page", skin);
		
		nextButton.setBounds(200, 20, 140, 20);
		
		nextButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_Event2 landingScreen = new Page_Event2(core);
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
		
		/**/
		
		
		
		TextButton prevButton = new TextButton("Previous Page", skin);
		prevButton.setBounds(320, 20, 160, 20);
		prevButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_NewEvent newPage = new Page_NewEvent(core);
			}
		});
		this.thisAddWidget(prevButton);
		
		
		
		TextButton submitButton = new TextButton("Submit", skin);
		submitButton.setBounds(520, 20, 160, 20);
		submitButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				
				//core.currentScreen.thisRemoveScreen();
				//core.currentScreen = null;
				//Page_Event1 landingScreen = new Page_Event1(core);
				submitEvent();
				
			}
		});
		this.thisAddWidget(submitButton);
		
		
		
		nextButton = new TextButton("Next Page", skin);
		nextButton.setBounds(720, 20, 160, 20);
		nextButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_Event2 newPage = new Page_Event2(core);
			}
		});
		this.thisAddWidget(nextButton);
		
		
		
		nextButton.setColor(Color.GRAY);
		nextButton.setDisabled(true);
		
		
	}
	
	
	
	public void submitEvent() {
		
		//newEvent.eventName = this.nameField.getText();
		//newEvent.description = this.description.getText();
		
		
		
		//((SummaryStep) core.modelCore.selectedEvent.steps.get(0)).summary = this.description.getText();
		
		SummaryStep thisStep = (SummaryStep) core.modelCore.selectedEvent.steps.get(0);
		thisStep.summary = this.description.getText();
		
		
		
		nextButton.setColor(Color.valueOf("ffffffff"));
		nextButton.setDisabled(false);
	}
	
	
	
}




