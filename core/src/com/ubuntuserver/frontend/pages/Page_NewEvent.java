package com.ubuntuserver.frontend.pages;

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
import com.ubuntuserver.frontend.Networking.Logic_PHP;
import com.ubuntuserver.frontend.Abstract_Screen;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.model.Model_Event;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.pageAbstraction.Abstract_StepPage;

public class Page_NewEvent extends Abstract_StepPage {
	
	
	
	
	//Window window;
	//TextField userText;
	
	public Label title;
	
	//TextButton newEventPage;
	//TextButton activeEventsPage;
	
	
	
	TextField nameField;
	TextArea description;
	
	
	
	
	//TextButton nextButton;
	
	
	
	public Page_NewEvent(MainCoreClass coreIn) {
		
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		title = new Label("Create a New Flood Event", skin);
		title.setPosition(100, 700);
		this.thisAddWidget(title);
		title.setColor(Color.BLUE);
		
		
		nameField = new TextField("Event Name", skin);
		nameField.setBounds(100, 600, 200, 20);
		this.thisAddWidget(nameField);
		//nameField.setColor(Color.BLUE);
		
		
		description = new TextArea("Description", skin);
		description.setBounds(100, 100, 500, 400);
		this.thisAddWidget(description);
		//description.setColor(Color.BLUE);
		
		
		
		
	}
	
	
	
	
	
	@Override
	public boolean submitAttempt() {
		
		boolean result = false;
		
		
		
		if (submitAttemptLocal() == true) {
			
			if ( core.modelCore.offlineMode ) {
				result = true;
			} else {
				if (submitAttemptNetwork() == true) {
					result = true;
				}
			}
			
		}
		
		
		
		return result;
	}
	
	
	public boolean submitAttemptLocal() {
		boolean result = true;
		
		/*
		if (yesBox.isChecked() == true || noBox.isChecked() == true) {
			result = true;
		}
		if (yesBox.isChecked() == true && noBox.isChecked() == true) {
			result = false;
		}
		/**/
		
		return result;
	}
	
	
	
	
	public boolean submitAttemptNetwork() {
		//
		return false;
	}
	
	
	@Override
	public void submitSuccess() {
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
		//core.modelCore.selectedEvent = newEvent;
		core.modelCore.selectedEvent = core.modelCore.events.get(core.modelCore.events.size() - 1);
		
		
		
		//nextButton.getColor();
		//System.out.println( nextButton.getColor() );
		nextButton.setColor(Color.valueOf("ffffffff"));
		nextButton.setDisabled(false);
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
		Page_Event01 landingScreen = new Page_Event01(core);
	}





	@Override
	public void sendPacket() {
		// TODO Auto-generated method stub
		
		Abstract_StepPage currentPage = (Abstract_StepPage) core.currentScreen;
		
		StringBuilder theURL = new StringBuilder();
		
		theURL.append(core.modelCore.targetURL);
		theURL.append("michael/eventcreate.php?");
		theURL.append("name=" + this.nameField.getText() +"&");
		theURL.append("description=" + this.description.getText() +"&");
		theURL.append("user=" + core.modelCore.username);
		
		System.out.println( theURL.toString() );
		
		Logic_PHP.getResponseFromURL(core, theURL.toString());
	}
	
	
	
	
	
}




