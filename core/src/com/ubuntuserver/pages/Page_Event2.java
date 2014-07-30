package com.ubuntuserver.pages;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
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
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Logic.Logic_Stage;
import com.ubuntuserver.frontend.Abstract_Screen;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.model.Model_Event.SummaryStep;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;

public class Page_Event2 extends Abstract_Screen {
	
	
	
	
	//Window window;
	//TextField userText;
	
	public Label temp;
	
	TextButton newEventPage;
	TextButton activeEventsPage;
	
	
	
	public TextButton nextButton;
	
	
	
	
	
	
	public CheckBox yesBox;
	public CheckBox noBox;
	
	ChangeListener yesListener;
	
	
	
	
	
	
	
	
	//experienced some overflow error from possibly setting off event from setChecked()
	public boolean changing = false;
	
	
	
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
		
		
		
		
		
		
		yesBox = new CheckBox("Yes, I did it.", skin);
		yesBox.setChecked(false);
		yesBox.setPosition(100, 450);
		yesBox.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (changing) {
					//do nothing
				} else {
					changing = true;
					checkEvent(true);
					changing = false;
				}
			}
		});
		this.thisAddWidget(yesBox);
		
		
		
		noBox = new CheckBox("No, skip it.", skin);
		noBox.setChecked(false);
		noBox.setPosition(100, 400);
		noBox.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (changing) {
					//do nothing
				} else {
					changing = true;
					checkEvent(false);
					changing = false;
				}
			}
		});
		this.thisAddWidget(noBox);
		
		
		
		
		
		
		/*
		
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
		
		/**/
		
		

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
				Page_Event3 newPage = new Page_Event3(core);
			}
		});
		this.thisAddWidget(nextButton);
		
		
		
		nextButton.setColor(Color.GRAY);
		nextButton.setDisabled(true);
	}
	
	
	
	public void checkEvent(boolean state) {
		
		if (state) {
			if (noBox.isChecked() == true) {
				noBox.setChecked(false);
			}
		} else {
			if (yesBox.isChecked() == true) {
				yesBox.setChecked(false);
			}
		}
		
		
	}
	
	
	
	public void submitEvent() {
		
		//newEvent.eventName = this.nameField.getText();
		//newEvent.description = this.description.getText();
		
		
		
		//((SummaryStep) core.modelCore.selectedEvent.steps.get(0)).summary = this.description.getText();
		
		//SummaryStep thisStep = (SummaryStep) core.modelCore.selectedEvent.steps.get(0);
		//thisStep.summary = this.description.getText();
		
		
		boolean goodToGo = false;
		
		if (yesBox.isChecked() == true || noBox.isChecked() == true) {
			goodToGo = true;
		}
		if (yesBox.isChecked() == true && noBox.isChecked() == true) {
			goodToGo = false;
		}
		
		if (goodToGo) {
			nextButton.setColor(Color.valueOf("ffffffff"));
			nextButton.setDisabled(false);
		}
		else {
			//Dialog: check one option
			
			Dialog dialog = new Dialog("Invalid Data", skin, "dialog") {
				protected void result (Object object) {
					//System.out.println("Improper login");
				}
			}.text("No records have been changed. Please select one option.")
				.button("Cancel", true)
				.key(Keys.ENTER, true).show(stage);
		}
		
		//nextButton.setColor(Color.valueOf("ffffffff"));
		//nextButton.setDisabled(false);
	}
	
	
	
}




