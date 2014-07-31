package com.ubuntuserver.frontend.pageAbstraction;

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
import com.ubuntuserver.frontend.model.Model_Event.SelectBoxStep;
import com.ubuntuserver.frontend.model.Model_Event.SummaryStep;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.pages.Page_Event3;
import com.ubuntuserver.frontend.pages.Page_NewOrActive;
import com.ubuntuserver.frontend.pages.Screen_Landing;

public class Page_ButtonBar2 extends Abstract_StepPage {
	
	
	
	public Label temp;
	
	
	
	public CheckBox yesBox;
	public CheckBox noBox;
	
	
	
	//experienced some overflow error from possibly setting off event from setChecked()
	public boolean changing = false;
	
	
	
	
	
	
	public Page_ButtonBar2(MainCoreClass coreIn) {
		
		
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
	
	
	
	
	
	
	@Override
	public void previousPage() {
		core.currentScreen.thisRemoveScreen();
		core.currentScreen = null;
		Page_NewOrActive landingScreen = new Page_NewOrActive(core);
	}
	
	
	@Override
	public void nextPage() {
		core.currentScreen.thisRemoveScreen();
		core.currentScreen = null;
		Page_Event3 newPage = new Page_Event3(core);
	}
	
	
	
	
	
	
	@Override
	public boolean submitAttempt() {
		
		boolean result = false;
		
		/*
		if (yesBox.isChecked() == true || noBox.isChecked() == true) {
			result = true;
		}
		if (yesBox.isChecked() == true && noBox.isChecked() == true) {
			result = false;
		}
		/**/
		
		if (submitAttemptLocal() == true) {
			if (submitAttemptNetwork() == true) {
				result = true;
			}
		}
		
		
		return result;
	}
	
	
	public boolean submitAttemptLocal() {
		boolean result = false;
		
		if (yesBox.isChecked() == true || noBox.isChecked() == true) {
			result = true;
		}
		if (yesBox.isChecked() == true && noBox.isChecked() == true) {
			result = false;
		}
		
		return result;
	}
	
	public boolean submitAttemptNetwork() {
		//
		return false;
	}
	
	
	
	@Override
	public void submitSuccess() {
		
		/**/
		core.modelCore.selectedEvent.steps.get(1);
		SelectBoxStep thisStep = (SelectBoxStep) core.modelCore.selectedEvent.steps.get(1);
		
		//thisStep.selection = 2;
		if (yesBox.isChecked() == true) {
			thisStep.selection = 1;
		}
		else {
			thisStep.selection = 2;
		}
		/**/
		
		nextButton.setColor(Color.valueOf("ffffffff"));
		nextButton.setDisabled(false);
		
	}
	
	
	
}




