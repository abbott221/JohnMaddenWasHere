package com.ubuntuserver.frontend.pageAbstraction;

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
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
import com.ubuntuserver.frontend.pages.Page_Event1;
import com.ubuntuserver.frontend.pages.Screen_Landing;

public class Page_ButtonDisableExample extends Abstract_Screen {
	
	
	
	
	//Window window;
	//TextField userText;
	
	public Label title;
	
	TextButton newEventPage;
	TextButton activeEventsPage;
	
	
	
	TextField nameField;
	TextArea description;
	
	
	//==============================
	
	public List eventList;
	public List dateList;
	public ScrollPane scrollPane;
	public Table table;
	
	
	public Page_ButtonDisableExample(MainCoreClass coreIn) {
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		
		title = new Label("Active Events", skin);
		title.setPosition(100, 700);
		this.thisAddWidget(title);
		
		
		//nameField = new TextField("Event Name", skin);
		//nameField.setBounds(100, 600, 200, 20);
		//this.thisAddWidget(nameField);
		
		
		
		
		
		//==============================================================
		
		
		//use this space
		//description = new TextArea("Description", skin);
		//description.setBounds(100, 100, 500, 400);
		//this.thisAddWidget(description);
		
		table = new Table();
		scrollPane = new ScrollPane(table, skin);
		scrollPane.setBounds(100, 100, 500, 400);
		
		eventList = new List( skin );
		dateList = new List( skin );
		
		
		int arraySize = core.modelCore.events.size();
		System.out.println( "Event Count: " + arraySize );
		
		
		Object[] eventEntries = new Object[arraySize];
		Object[] dateEntries = new Object[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			eventEntries[i] = core.modelCore.events.get(i).eventName;
			
			String dateObject = Integer.toString(i+1) + "  " + core.modelCore.events.get(i).date;
			dateEntries[i] = dateObject;
		}
		
		
		eventList.setItems(eventEntries);
		eventList.getSelection().setMultiple(true);
		eventList.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				int index = eventList.getSelectedIndex();
				
				eventList.setSelectedIndex( index );
				dateList.setSelectedIndex( index );
				
				core.modelCore.selectedEvent = core.modelCore.events.get(index);
			}
		});
		
		
		dateList.setItems(dateEntries);
		dateList.getSelection().setMultiple(true);
		dateList.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				int index = dateList.getSelectedIndex();
				
				eventList.setSelectedIndex( index );
				dateList.setSelectedIndex( index );
				
				core.modelCore.selectedEvent = core.modelCore.events.get(index);
			}
		});
		
		
		
		
		
		Label temp = new Label("Event List", skin);
		table.add(temp).expandX().fillX().colspan(2);
		table.row();
		
		
		
		
		
		table.add(dateList);
		
		table.add(eventList);
		//table.add(eventList).expandX().fillX();
		//table.add(eventList).expandX().fillX().colspan(2);
		
		
		
		
		
		//this.thisAddWidget(table);
		this.thisAddWidget(scrollPane);
		
		
		//==============================================================
		
		
		
		
		
		/**/
		
		TextButton nextButton = new TextButton("Disabled button", skin);
		
		nextButton.setBounds(200, 20, 140, 20);
		
		ChangeListener listener = new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Listener is active");
				
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_Event1 landingScreen = new Page_Event1(core);
			}
		};
		
		nextButton.addListener(listener);
		
		/*
		nextButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_Event1 landingScreen = new Page_Event1(core);
			}
		});
		/**/
		
		
		this.thisAddWidget(nextButton);
		
		
		nextButton.removeListener(listener);
		
		//nextButton.setDisabled(true);
		//nextButton.setColor(Color.DARK_GRAY);
		nextButton.setColor(Color.GRAY);
		//nextButton.setColor(Color.LIGHT_GRAY);
		
		
		
		
		
		
		/**/
		
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
		
		
		
	}
	
	
}




