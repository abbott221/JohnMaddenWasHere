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
import com.ubuntuserver.frontend.pages.Page_Event03;
import com.ubuntuserver.frontend.pages.Page_NewOrActive;
import com.ubuntuserver.frontend.pages.Screen_Landing;

public abstract class Abstract_StepPage extends Abstract_Screen {
	
	
	
	
	
	
	public TextButton landingButton;
	
	public TextButton prevButton;
	public TextButton submitButton;
	public TextButton nextButton;
	
	
	
	
	
	
	
	public Abstract_StepPage(MainCoreClass coreIn) {
		
		
		super(coreIn);
		
		
		
		
		landingButton = new TextButton("Landing Page", skin);
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
		
		
		
		
		
		prevButton = new TextButton("Previous Page", skin);
		prevButton.setBounds(320, 20, 160, 20);
		prevButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				previousPage();
			}
		});
		this.thisAddWidget(prevButton);
		
		
		submitButton = new TextButton("Submit", skin);
		submitButton.setBounds(520, 20, 160, 20);
		submitButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				submitEvent();
			}
		});
		this.thisAddWidget(submitButton);
		
		
		nextButton = new TextButton("Next Page", skin);
		nextButton.setBounds(720, 20, 160, 20);
		nextButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				nextPage();
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
		
		//SummaryStep thisStep = (SummaryStep) core.modelCore.selectedEvent.steps.get(0);
		//thisStep.summary = this.description.getText();
		
		
		
		
		
		//boolean goodToGo = false;
		
		
		boolean goodToGo = this.submitAttempt();
		
		
		
		
		
		if (goodToGo) {
			submitSuccess();
		} else {
			submitFailed();
		}
		
	}
	
	
	
	
	/**
	 * 
	 * 1) check user input makes sense locally
	 * i.e. a checkbox is selected, but only one
	 * 2) check against database
	 * 
	 * @return whether it was successful
	 * 
	 * new name: submitAttempt
	 * old name: updateGoodToGo
	 */
	public abstract boolean submitAttempt();
	
	
	/**
	 * 1) update local model (  DB was successfully updated in "submitAttempt()"  )
	 * <br>2) enable next button
	 * 
	 * <br><br>old name: goodToGoAction
	 */
	public abstract void submitSuccess();
	
	
	
	public void submitFailed() {
		Dialog dialog = new Dialog("Invalid Data", skin, "dialog") {
			protected void result (Object object) {
				//System.out.println("Improper login");
			}
		}.text("No records have been changed. Please select one option.")
			.button("Cancel", true)
			.key(Keys.ENTER, true).show(stage);
	}
	
	
	
	public abstract void previousPage();
	
	public abstract void nextPage();
	
	
}




