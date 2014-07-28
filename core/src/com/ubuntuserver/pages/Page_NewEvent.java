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

public class Page_NewEvent extends Abstract_Screen {
	
	
	
	
	//Window window;
	//TextField userText;
	
	public Label title;
	
	TextButton newEventPage;
	TextButton activeEventsPage;
	
	
	
	TextField nameField;
	TextArea description;
	
	
	
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
		
		
		
		
		
		/*
		
		newEventPage = new TextButton("Create New Event 2", skin);
		
		newEventPage.setBounds(100, 200, 200, 20);
		
		newEventPage.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				//Page_Event1 landingScreen = new Page_Event1(core);
			}
		});
		this.thisAddWidget(newEventPage);
		
		
		
		
		
		activeEventsPage = new TextButton("Active Events 2", skin);
		
		activeEventsPage.setBounds(400, 200, 200, 20);
		
		activeEventsPage.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				//Page_Event1 landingScreen = new Page_Event1(core);
			}
		});
		this.thisAddWidget(activeEventsPage);
		
		/**/
		
		
		
		
		TextButton nextButton = new TextButton("Next Page", skin);
		
		nextButton.setBounds(200, 20, 140, 20);
		
		nextButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_Event1 landingScreen = new Page_Event1(core);
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




