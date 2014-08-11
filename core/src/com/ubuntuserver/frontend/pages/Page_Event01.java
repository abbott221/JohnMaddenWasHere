package com.ubuntuserver.frontend.pages;

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
import com.ubuntuserver.frontend.ListenerEvents.Logic_EventCall;
import com.ubuntuserver.frontend.Logic.Logic_DateStrings;
import com.ubuntuserver.frontend.Logic.Logic_Dates;
import com.ubuntuserver.frontend.Logic.Logic_Stage;
import com.ubuntuserver.frontend.Networking.Logic_JSON3;
import com.ubuntuserver.frontend.Networking.Logic_PHP;
import com.ubuntuserver.frontend.Networking.Logic_JSON3.DataSource;
import com.ubuntuserver.frontend.Abstract_Screen;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.Report_Generator;
import com.ubuntuserver.frontend.model.Model_Event.SelectBoxStep;
import com.ubuntuserver.frontend.model.Model_Event.SummaryStep;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.pageAbstraction.Abstract_StepPage;

public class Page_Event01 extends Abstract_StepPage {
	
	
	SelectBox stationBox;
	
	//Window window;
	//TextField userText;
	
	public Label temp;
	
	//TextButton newEventPage;
	//TextButton activeEventsPage;
	
	
	//public TextButton nextButton;
	
	TextArea description;
	
	//experienced some overflow error from possibly setting off event from setChecked()
	//public boolean changing;
	
	
	public Page_Event01(MainCoreClass coreIn) {
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		//System.out.println("reconstructed");
		
		
		
		
		
		String name = "ACTION PLAN FOR FLOOD EVENT " + core.modelCore.selectedEvent.eventName;
		Label eventName = new Label(name, skin);
		eventName.setPosition(100, 700);
		this.thisAddWidget(eventName);
		eventName.setColor(Color.BLUE);
		
		
		
		
		
		
		temp = new Label("1. Information Verification", skin);
		//temp.setPosition(100, 700);
		temp.setPosition(150, 625);
		this.thisAddWidget(temp);
		temp.setColor(Color.BLUE);
		
		
		//Verify message for warnings and emergencies with NWS Information verification
		
		Label temp2 = new Label("Verify message for warnings "
				+ "and emergencies with NWS Information verification", skin);
		//temp2.setColor(Color.BLACK);
		temp2.setPosition(100, 550);
		this.thisAddWidget(temp2);
		temp2.setColor(Color.BLUE);
		
		
		
		
		
		
		
		if (core.mediator == null) {
			System.out.println("No mediator");
		}
		
		
		//final Mediator mediator = new Mediator(this.stage);
		
		stationBox = new SelectBox( skin );
		String s1 = "O'shaughness Dam";
		String s2 = "Alum Creek - Africa Road";
		String s3 = "Big Walnut Creek - Sunbury";
		String s4 = "Olentangy River Delaware";
		String s5 = "Scioto River below O'shaughnessy Dam";
		String s6 = "Grigg's Dam";
		String s7 = "Hoover Dam";
		String s8 = "Big Walnut Creek - Central College";
		String s9 = "Big Walnut Creek - Rees";
		String s10 = "Olentangy River near Worthington";
		String s11 = "Scioto River near Columbus";
		String s12 = "Alum Creek Dam";
		String s13 = "Delaware Lake Dam";
		
		Object[] stationEntries = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13};
		
		stationBox.setItems(stationEntries);
		
		//stationBox.setBounds(100, 550, 300, 20);
		stationBox.setBounds(100, 500, 300, 20);
		
		stationBox.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				core.modelCore.pageOnePosition = ((SelectBox) actor).getSelectedIndex();
				
				
				
				
				Logic_EventCall.stationEvent(core.mediator, (SelectBox) actor);
				
				//Logic_Dates.stationChange(mediator, stationBox);
				
				
				
				
				
				reportUpdate();
				/*
				int stationIndex = ((SelectBox) actor).getSelectedIndex();
				Report_Generator report = new Report_Generator();
				String useThis = report.updateReport(core.mediator, stationIndex, true);
				
				
				
				//System.out.println(useThis);
				
				
				core.modelCore.pageOneString = useThis;
				
				//String text = core.mediator.model.report.getText();
				//updateDescription(text);
				updateDescription(useThis);
				
				
				
				core.modelCore.pageOneString = useThis;
				
				
				
				
				
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_Event01 newPage = new Page_Event01(core);
				/**/
			}
		});
		
		this.thisAddWidget(stationBox);
		
		
		
		
		TextButton updateButton = new TextButton("Update", skin);
		//updateButton.setBounds(850, 450, 100, 20);
		//updateButton.setBounds(450, 550, 100, 20);
		updateButton.setBounds(450, 500, 100, 20);
		
		updateButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//Logic_EventCall.stationEvent(mediator, stationBox);
				
				//Logic_JSON3.EntryPoint(mediator, DataSource.LOCALHOST, mediator.model.secondTable);
				
				
				
				Logic_JSON3.EntryPoint(core.mediator, DataSource.INTERNAL_IP, core.mediator.model.secondTable);
				
				//Logic_DateStrings.determineDates(mediator);
				
				
				
				
				
				reportUpdate();
				/*
				int stationIndex = ((SelectBox) actor).getSelectedIndex();
				Report_Generator report = new Report_Generator();
				String useThis = report.updateReport(core.mediator, stationIndex, true);
				
				core.modelCore.pageOneString = useThis;
				updateDescription(useThis);
				core.modelCore.pageOneString = useThis;
				
				
				
				
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_Event01 newPage = new Page_Event01(core);
				/**/
			}
		});
		
		//stage.addActor(updateButton);
		this.thisAddWidget(updateButton);
		
		
		
		
		
		
		description = new TextArea("Gage site name\nWater level\nLast reading time\n"
				+ "Increase rate in the last 4 hours\nActual precipitation\nForecast\n"
				+ "Flood warning issued: (all alert records in alert table"
				+ " for the last 3 hours)", skin);
		
		//description.setBounds(100, 100, 500, 400);
		description.setBounds(100, 100, 500, 350);
		
		this.thisAddWidget(description);
		//description.setColor(Color.BLUE);
		
		
		
		
		stationBox.setSelectedIndex(core.modelCore.pageOnePosition);
		description.setText(core.modelCore.pageOneString);
		
		
		
		
		
		//SelectBoxStep thisStep = (SelectBoxStep) core.modelCore.selectedEvent.steps.get(0);
		SummaryStep thisStep = (SummaryStep) core.modelCore.selectedEvent.steps.get(0);
		
		if ( thisStep.completed ) {
			nextButton.setColor(Color.valueOf("ffffffff"));
			nextButton.setDisabled(false);
		}
		
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
		
		
		
		/*
		SelectBoxStep thisStep = (SelectBoxStep) core.modelCore.selectedEvent.steps.get(0);
		
		if (yesBox.isChecked() == true) {
			thisStep.selection = 1;
		}
		else {
			thisStep.selection = 2;
		}
		/**/
		
		
		
		SummaryStep thisStep = (SummaryStep) core.modelCore.selectedEvent.steps.get(0);
		thisStep.summary = this.description.getText();
		
		
		
		
		thisStep.completed = true;
		
		//nextButton.setColor(Color.valueOf("ffffffff"));
		//nextButton.setDisabled(false);
		//this.nextButton
		
		super.nextButton.setColor(Color.valueOf("ffffffff"));
		super.nextButton.setDisabled(false);
	}



	@Override
	public void previousPage() {
		//core.currentScreen.thisRemoveScreen();
		//core.currentScreen = null;
		//Page_NewEvent newPage = new Page_NewEvent(core);
	}



	@Override
	public void nextPage() {
		core.currentScreen.thisRemoveScreen();
		core.currentScreen = null;
		Page_Event02 newPage = new Page_Event02(core);
		
		//System.out.println("Completed: " + core.modelCore.selectedEvent.steps.get(0).completed);
	}
	
	
	
	public void updateDescription(String text) {
		this.description.setText(text);
	}
	
	
	
	
	public void reportUpdate() {
		int stationIndex = stationBox.getSelectedIndex();
		Report_Generator report = new Report_Generator();
		String useThis = report.updateReport(core.mediator, stationIndex, true);
		
		core.modelCore.pageOneString = useThis;
		updateDescription(useThis);
		core.modelCore.pageOneString = useThis;
		
		
		
		core.currentScreen.thisRemoveScreen();
		core.currentScreen = null;
		Page_Event01 newPage = new Page_Event01(core);
	}











	@Override
	public void sendPacket() {
		// TODO Auto-generated method stub
		
		Abstract_StepPage currentPage = (Abstract_StepPage) core.currentScreen;
		
		StringBuilder theURL = new StringBuilder();
		
		theURL.append(core.modelCore.targetURL);
		theURL.append("michael/updateevent.php?");
		theURL.append("page=" + "two" +"&"); //page = "three"&
		theURL.append("name=" + core.modelCore.selectedEvent.eventName +"&");
		theURL.append("answer=" + description.getText() +"&");
		theURL.append("user=" + core.modelCore.username);
		
		System.out.println( theURL.toString() );
		
		Logic_PHP.getResponseFromURL(core, theURL.toString());
	}
	
	
}




