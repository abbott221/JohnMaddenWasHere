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

public class Page_NewOrActive extends Abstract_Screen {
	
	
	
	
	//Window window;
	//TextField userText;
	
	public Label temp;
	
	TextButton newEventPage;
	TextButton activeEventsPage;
	
	
	
	
	
	public Page_NewOrActive(MainCoreClass coreIn) {
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		
		
		temp = new Label("Event Creator", skin);
		
		temp.setPosition(300, 500);
		
		this.thisAddWidget(temp);
		
		
		
		
		
		newEventPage = new TextButton("Create New Event", skin);
		
		newEventPage.setBounds(100, 200, 200, 20);
		
		newEventPage.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_NewEvent newPage = new Page_NewEvent(core);
			}
		});
		this.thisAddWidget(newEventPage);
		
		
		
		
		
		activeEventsPage = new TextButton("Active Events", skin);
		
		activeEventsPage.setBounds(400, 200, 200, 20);
		
		activeEventsPage.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_ActiveEvents newPage = new Page_ActiveEvents(core);
			}
		});
		this.thisAddWidget(activeEventsPage);
		
		
		
		
		
		
		
		
		
		
		TextButton landingButton = new TextButton("Landing Page", skin);
		
		landingButton.setBounds(20, 20, 140, 20);
		
		landingButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Screen_Landing newPage = new Screen_Landing(core);
			}
		});
		
		this.thisAddWidget(landingButton);
		
		
		
		
	}
	
	
}




