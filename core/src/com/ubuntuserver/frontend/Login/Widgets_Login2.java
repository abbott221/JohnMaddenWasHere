package com.ubuntuserver.frontend.Login;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
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

public class Widgets_Login2 extends Abstract_Screen {
	
	//Mediator mediator;
	
	//public List startDateList;
	//public List endDateList;
	
	//ScrollPane startPane;
	//ScrollPane endPane;
	
	
	
	
	
	//MainCoreClass core;
	
	//public Stage stage;
	//public Skin skin;
	
	Window window;
	TextField userText;
	
	//TextField userText;
	
	
	
	public Widgets_Login2(MainCoreClass coreIn) {
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		
		
		
		window = new Window("Log In Options", skin);
		
		window.defaults().pad(5.0f);
		
		/*
		TextButton close = new TextButton("X", skin);
		
		window.getButtonTable().add(close).height(window.getPadTop());
		
		close.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//first parent = Table
				//second parent = window
				actor.getParent().getParent().remove();
			}
		});
		/**/
		
		
		
		
		userText = new TextField("", skin);
		
		userText.setMessageText("Username");
		window.add(userText).colspan(2);
		
		//this.addWidget(userText);
		
		
		
		
		window.row();
		
		
		
		
		TextField passText = new TextField("", skin);
		passText.setMessageText("Password");
		
		passText.setPasswordCharacter('*');
		passText.setPasswordMode(true);
		
		window.add(passText).colspan(2);
		
		//this.addWidget(passText);
		
		
		
		
		window.row();
		
		
		
		TextButton logInButton = new TextButton("Log In", skin);
		
		logInButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				actor.getParent().remove();
				
				//core.loggedIn = true;
				
				//userText.getText();
				getUser();
				
				
				
				
				//core.setupGraphView();
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Screen_Landing  landingScreen = new Screen_Landing(core);
			}
		});
		window.add(logInButton);
		
		
		
		
		
		TextButton forgotButton = new TextButton("Forgot Password", skin);
		
		forgotButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				
			}
		});
		window.add(forgotButton);
		
		
		
		//=====================================================
		
		
		
		//window.setBounds(300, 300, 350, 350);
		window.setBounds(300, 300, 350, 250);
		
		
		
		
		//stage.addActor(window);
		this.thisAddWidget(window);
		
		
		
	}
	
	
	public String getUser() {
		return userText.getText();
	}
	
	
	
}




