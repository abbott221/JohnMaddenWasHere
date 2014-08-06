package com.ubuntuserver.frontend.pages;

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
import com.ubuntuserver.frontend.Networking.Logic_JSONPI;
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
	TextField passText;
	
	
	
	public Texture texture1;
	public TextureRegion image;
	public Image imageActor;
	
	
	
	public Widgets_Login2(MainCoreClass coreIn) {
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		
		
		
		window = new Window("Flood SOP Automation System", skin);
		
		window.defaults().pad(5.0f);
		
		
		
		
		/*
		
		userText = new TextField("", skin);
		
		userText.setMessageText("Username");
		//window.add(userText).colspan(2);
		
		//this.addWidget(userText);
		
		window.row();
		
		TextField passText = new TextField("", skin);
		passText.setMessageText("Password");
		
		passText.setPasswordCharacter('*');
		passText.setPasswordMode(true);
		
		//window.add(passText).colspan(2);
		
		//this.addWidget(passText);
		
		window.row();
		
		/**/
		
		
		
		//texture1 = new Texture(Gdx.files.internal("logo.png"));
		texture1 = new Texture(Gdx.files.internal("logo2.JPG"));
		image = new TextureRegion(texture1);
		imageActor = new Image(image);
		
		imageActor.setSize(288, 209);
		//imageActor.setBounds(400, 250, 400, 400);
		//this.thisAddWidget(imageActor);
		window.add(imageActor).colspan(2);
		
		
		window.row();
		
		
		
		
		
		TextButton logInButton = new TextButton("Log In", skin);
		
		logInButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				
				
				
				
				//login()'s code has been moved into this function
				//login();
				
				String user = System.getProperty("user.name");
		        user = user.replaceAll("[-+.^:,]","");
		        
		        
		        //String url = "http://10.119.0.52/login.php?username="+user;
		        
		        String url = core.modelCore.targetURL + "login.php?username="+user;
		        
		        
		        Logic_JSONPI.EntryPoint(core, url);
		        
		        
		        
		        //core.currentScreen == null && core.modelCore.id > 0
		        
		        if (core.currentScreen == null) {
		        	System.out.println("Current Screen is null");
		        } else {
		        	System.out.println("Current Screen is NOT null");
		        }
		        System.out.println("Model_Core's id: " + core.modelCore.id);
				
				
				
				
		        
		        
		        
				core.modelCore.buttonWaiting = true;
				
				
				
				
				
				//"core.loggedIn = true" -> "core.loggedIn == true" could've been an issue
				//if(core.loggedIn = true && core.id >0) {
		        
		        //THE PROBLEMATIC IF-ELSE BLOCK
		        /*
				if ( core.modelCore.offlineMode == true || (core.currentScreen == null && core.modelCore.id > 0) ) {
					
					core.currentScreen.thisRemoveScreen();
					core.currentScreen = null;
					Screen_Landing  landingScreen = new Screen_Landing(core);
					
				}
				else {
					//core.loggedIn = false;
					System.out.println("Improper login 1");
					
					Dialog dialog = new Dialog("Improper login", skin, "dialog") {
						protected void result (Object object) {
							System.out.println("Improper login 2");
						}
					}.text("If this problem remains then please contact your IT department")
						.button("Cancel", true)
						.key(Keys.ENTER, true).show(stage);
				}
				
				/**/
				
				
				
				
				
				if ( core.modelCore.offlineMode == true) {
					
					core.currentScreen.thisRemoveScreen();
					core.currentScreen = null;
					Screen_Landing  landingScreen = new Screen_Landing(core);
				}
				
				
				
			}
		});
		window.add(logInButton);
		
		
		
		
		
		TextButton exitButton = new TextButton("exit", skin);

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.exit(1);
            }
        }
        );
        window.add(exitButton);
		
		
		
		
        
        
		
		
		//window.setBounds(300, 300, 350, 350);
		//window.setBounds(300, 300, 350, 250);
		//x, y, width, height
		//window.setBounds(100, 100, 980, 400);
		window.setBounds(250, 150, 400, 350);
		
		
		
		//stage.addActor(window);
		this.thisAddWidget(window);
		
		
		
	}
	
	
	
	public void login()
    {
        String user = System.getProperty("user.name");
        user = user.replaceAll("[-+.^:,]","");
        String url = "http://10.119.0.52/login.php?username="+user;
        Logic_JSONPI.EntryPoint(core, url);
        
        
        
        //core.currentScreen == null && core.modelCore.id > 0
        
        if (core.currentScreen == null) {
        	System.out.println("Current Screen is null");
        } else {
        	System.out.println("Current Screen is NOT null");
        }
        System.out.println("Model_Core's id: " + core.modelCore.id);
        
    }
	
	
	
	public void loginComplete() {
		
		if (core.currentScreen == null) {
        	System.out.println("3 Current Screen is null");
        } else {
        	System.out.println("3 Current Screen is NOT null");
        }
        System.out.println("3 Model_Core's id: " + core.modelCore.id);
		
		
        //if ( core.modelCore.offlineMode == true || (core.currentScreen == null && core.modelCore.id > 0) ) {
		if ( core.modelCore.offlineMode == true || (core.currentScreen != null && core.modelCore.id > 0) ) {
			
			core.currentScreen.thisRemoveScreen();
			core.currentScreen = null;
			Screen_Landing  landingScreen = new Screen_Landing(core);
			
		}
		else {
			//core.loggedIn = false;
			System.out.println("Improper login 1");
			
			Dialog dialog = new Dialog("Improper login", skin, "dialog") {
				protected void result (Object object) {
					System.out.println("Improper login 2");
				}
			}.text("If this problem remains then please contact your IT department")
				.button("Cancel", true)
				.key(Keys.ENTER, true).show(stage);
		}
	}
	
	
}




