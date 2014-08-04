package com.ubuntuserver.frontend;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.ubuntuserver.frontend.ListenerEvents.Logic_EventCall;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Logic.Logic_Polling;
import com.ubuntuserver.frontend.Logic.Logic_Stage;
import com.ubuntuserver.frontend.model.Model_Core;
import com.ubuntuserver.frontend.pages.Page_ActiveEvents;
import com.ubuntuserver.frontend.pages.Page_Event01;
import com.ubuntuserver.frontend.pages.Page_Event02;
import com.ubuntuserver.frontend.pages.Page_Event03;
import com.ubuntuserver.frontend.pages.Page_Event04;
import com.ubuntuserver.frontend.pages.Page_Event05;
import com.ubuntuserver.frontend.pages.Page_Event06;
import com.ubuntuserver.frontend.pages.Page_Event07;
import com.ubuntuserver.frontend.pages.Page_Event08;
import com.ubuntuserver.frontend.pages.Page_Event09;
import com.ubuntuserver.frontend.pages.Page_Event10;
import com.ubuntuserver.frontend.pages.Page_Event11;
import com.ubuntuserver.frontend.pages.Page_NewEvent;
import com.ubuntuserver.frontend.pages.Page_NewOrActive;
import com.ubuntuserver.frontend.pages.Screen_Landing;
import com.ubuntuserver.frontend.pages.Widgets_Login;
import com.ubuntuserver.frontend.pages.Widgets_Login2;

public class MainCoreClass implements ApplicationListener {
	
	public Mediator mediator;
	
	public Stage stage;
	
	
	//public Skin skn;
	
	
	public int showHeight;
	public int showWidth;
	
	
	//change to "graphView"?
	//public boolean loggedIn = false;
	
	
	//possibly unnecessary
	public Abstract_Screen currentScreen;
	
	
	public Model_Core modelCore;
	
	
	@Override
	public void create () {
		
		//skn = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		
		modelCore = new Model_Core(this);
		
		
		
		stage = new Stage();
		
		
		//Widgets_Login loginWidgets = new Widgets_Login(this);
		
		
		
		
		//Widgets_Login loginWidgets2 = new Widgets_Login(this);
		Widgets_Login2 loginWidgets2 = new Widgets_Login2(this);
		
		
		
		//Screen_Landing screenLanding = new Screen_Landing(this);
		
		
		
		
		
		/*
		mediator = new Mediator(stage);
		mediator.registerCore(this);
		
		Logic_Stage.constructStage(mediator);
		/**/
		
		
		modelCore.fillModel();
	}
	
	
	public void setupGraphView () {
		
		//treat as resize event
		
		this.currentScreen.thisRemoveScreen();
		this.currentScreen = null;
		
		
		
		mediator = new Mediator(stage);
		mediator.registerCore(this);
		
		Logic_Stage.constructStage(mediator);
		
		this.resize(this.showWidth, this.showHeight);
		
		Logic_EventCall.dateReporterOnCreate(mediator);
	}
	

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		//DRAW STUFF
		//Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
		
		
		//if (loggedIn || currentScreen == null) {
		if (currentScreen == null) {
			
			mediator.widgets.drawWidgets();
			
			Logic_Polling.checkWidgetTouch(mediator);
		}
		else {
			stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
			stage.draw();
			
			
			
			
			//if ( this.modelCore.offlineMode == false && this.modelCore.networkResponse == true) {
			//when online mode and 
			if ( this.modelCore.networkResponse == true) {
				this.modelCore.networkResponse = false;
				
				System.out.println("The network has responded");
				
				//call dialog or go to next page
				
				//these calls can also be made from the network listener and cast
				//core's current page to one of type Widgets_Login2
				
				//((Widgets_Login2) this.currentScreen).loginComplete();
				if (this.currentScreen instanceof Widgets_Login2) {
					((Widgets_Login2) this.currentScreen).loginComplete();
				}
			}
			
			
			
			
			
			
		}
		
		
		//mediator.widgets.drawWidgets();
		
		//Logic_Polling.checkWidgetTouch(mediator);
		
	}
	
	
	
	//occurs once on initial display
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		//mediator.widgets.stage.setViewport(width, height, false);
		//stage.setViewport(viewport);
		
		
		
		//stage.getViewport().update(width, height, true);
		
		
		
		//====================================================
		
		//Logic_Stage.constructStage(mediator);
		
		
		showHeight = height;
		showWidth = width;
		
		
		
		//"loggedIn = true" == graph screen
		//if (loggedIn || currentScreen == null) {
		if (currentScreen == null) {
			
			
			mediator.displayHeight = height;
			mediator.displayWidth = width;
			
			Logic_Stage.constructStage(mediator);
			
			
			//====================================================
			
			
			//System.out.println(width);
			//System.out.println(height);
			
			
			//mediator.displayHeight = showHeight;
			//mediator.displayWidth = showWidth;
			
			
			//====================================================
			
			
			mediator.widgets.adjustBox();
			mediator.widgets2.adjustBox();
			mediator.scrollpanes.adjustBox();
			mediator.tablepane.adjustBox();
			mediator.labels.adjustBox();
			
			Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
			
		}
		
		
		else {
			//resize log-in stuff
			
			stage = new Stage();
			
			
			
			
			//this.currentScreen.thisResizeEvent();
			
			
			
			
			if (this.currentScreen instanceof Widgets_Login2) {
				this.currentScreen = new Widgets_Login2(this);
			}
			else if (this.currentScreen instanceof Screen_Landing) {
				this.currentScreen = new Screen_Landing(this);
			}
			else if (this.currentScreen instanceof Page_NewOrActive) {
				this.currentScreen = new Page_NewOrActive(this);
			}
			else if (this.currentScreen instanceof Page_NewEvent) {
				this.currentScreen = new Page_NewEvent(this);
			}
			else if (this.currentScreen instanceof Page_ActiveEvents) {
				this.currentScreen = new Page_ActiveEvents(this);
			}
			
			else if (this.currentScreen instanceof Page_Event01) {
				this.currentScreen = new Page_Event01(this);
			}
			else if (this.currentScreen instanceof Page_Event02) {
				this.currentScreen = new Page_Event02(this);
			}
			else if (this.currentScreen instanceof Page_Event03) {
				this.currentScreen = new Page_Event03(this);
			}
			else if (this.currentScreen instanceof Page_Event04) {
				this.currentScreen = new Page_Event04(this);
			}
			else if (this.currentScreen instanceof Page_Event05) {
				this.currentScreen = new Page_Event05(this);
			}
			else if (this.currentScreen instanceof Page_Event06) {
				this.currentScreen = new Page_Event06(this);
			}
			else if (this.currentScreen instanceof Page_Event07) {
				this.currentScreen = new Page_Event07(this);
			}
			else if (this.currentScreen instanceof Page_Event08) {
				this.currentScreen = new Page_Event08(this);
			}
			else if (this.currentScreen instanceof Page_Event09) {
				this.currentScreen = new Page_Event09(this);
			}
			else if (this.currentScreen instanceof Page_Event10) {
				this.currentScreen = new Page_Event10(this);
			}
			else if (this.currentScreen instanceof Page_Event11) {
				this.currentScreen = new Page_Event11(this);
			}
			
			
			
			
			//Widgets_Login2 loginWidgets = new Widgets_Login2(this);
		}
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
}








