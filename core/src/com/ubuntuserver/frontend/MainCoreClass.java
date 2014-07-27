package com.ubuntuserver.frontend;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Logic.Logic_Polling;
import com.ubuntuserver.frontend.Logic.Logic_Stage;
import com.ubuntuserver.frontend.Login.Widgets_Login;

public class MainCoreClass implements ApplicationListener {
	
	Mediator mediator;
	
	public Stage stage;
	
	public int showHeight;
	public int showWidth;
	
	
	public boolean loggedIn = false;
	
	public String username;
	public String firstname;
	public String lastname;
	public int id =0;
	public String email;
	public String rights;
	
	
	//possibly unnecessary
	Abstract_Screen currentScreen;
	
	public void userlogin(String[] credentials)
	{
		loggedIn = true;
		id = Integer.parseInt(credentials[0]);
		username = credentials[1];
		lastname = credentials[2];
		firstname = credentials[3];
		email = credentials[4];
		rights = credentials[5];
	}
	
	
	
	@Override
	public void create () {
		
		stage = new Stage();
		
		
		Widgets_Login loginWidgets = new Widgets_Login(this);
		
		/*
		
		mediator = new Mediator(stage);
		mediator.registerCore(this);
		
		
		Logic_Stage.constructStage(mediator);
		
		/**/
		
	}
	
	
	public void logInSuccess () {
		
		//treat as resize event
		
		mediator = new Mediator(stage);
		mediator.registerCore(this);
		
		Logic_Stage.constructStage(mediator);
		
		this.resize(this.showWidth, this.showHeight);
	}
	

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		//DRAW STUFF
		//Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
		
		
		if (loggedIn) {
			
			mediator.widgets.drawWidgets();
			
			Logic_Polling.checkWidgetTouch(mediator);
		}
		else {
			stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
			stage.draw();
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
		
		
		
		if (loggedIn) {
			
			
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
			
			Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
			
		}
		
		
		else {
			//resize log-in stuff
			
			stage = new Stage();
			Widgets_Login loginWidgets = new Widgets_Login(this);
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








