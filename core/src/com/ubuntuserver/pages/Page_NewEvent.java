package com.ubuntuserver.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
import com.ubuntuserver.frontend.model.Model_Event;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;

public class Page_NewEvent extends Abstract_Screen {
	
	
	
	
	//Window window;
	//TextField userText;
	
	public Label title;
	
	TextButton newEventPage;
	TextButton activeEventsPage;
	
	
	
	TextField nameField;
	TextArea description;
	
	
	
	
	TextButton nextButton;
	
	
	
	public Page_NewEvent(MainCoreClass coreIn) {
		
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		title = new Label("Create a New Flood Event", skin);
		title.setPosition(100, 700);
		this.thisAddWidget(title);
		
		
		
		nameField = new TextField("Event Name", skin);
		nameField.setBounds(100, 600, 200, 20);
		this.thisAddWidget(nameField);
		
		
		
		description = new TextArea("Description", skin);
		description.setBounds(100, 100, 500, 400);
		this.thisAddWidget(description);
		
		
		
		
		
		
		
		
		TextButton landingButton = new TextButton("Landing Page", skin);
		landingButton.setBounds(20, 20, 160, 20);
		landingButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Screen_Landing landingScreen = new Screen_Landing(core);
			}
		});
		this.thisAddWidget(landingButton);
		
		
		
		
		
		
		
		
		
		TextButton prevButton = new TextButton("Previous Page", skin);
		prevButton.setBounds(320, 20, 160, 20);
		prevButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_NewOrActive landingScreen = new Page_NewOrActive(core);
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
				Page_Event1 landingScreen = new Page_Event1(core);
			}
		});
		this.thisAddWidget(nextButton);
		
		
		
		nextButton.setColor(Color.GRAY);
		nextButton.setDisabled(true);
		
	}
	
	
	
	public void submitEvent() {
		
		
		Model_Event newEvent = new Model_Event();
		
		newEvent.eventName = this.nameField.getText();
		newEvent.description = this.description.getText();
		
		
		//System.
		Calendar cal = Calendar.getInstance();
		
		int month = 1 + cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		
		//System.out.println("Month:" + month);
		//System.out.println("Day:" + day);
		//System.out.println("Year:" + year);
		
		
		
		
		
		StringBuilder dateBuilder = new StringBuilder();
		
		//newEvent.date = "7/30/14";
		//newEvent.date = Integer.toString(month) + Integer.toString(day) + Integer.toString(year);
		
		dateBuilder.append(Integer.toString(month));
		dateBuilder.append("/");
		dateBuilder.append(Integer.toString(day));
		dateBuilder.append("/");
		dateBuilder.append(Integer.toString(year));
		
		newEvent.date = dateBuilder.toString();
		
		
		//newEvent.date = "7/30/14";
		newEvent.active = true;
		
		
		core.modelCore.events.add(newEvent);
		core.modelCore.selectedEvent = newEvent;
		
		
		//nextButton.getColor();
		//System.out.println( nextButton.getColor() );
		nextButton.setColor(Color.valueOf("ffffffff"));
		nextButton.setDisabled(false);
	}
	
	
}




