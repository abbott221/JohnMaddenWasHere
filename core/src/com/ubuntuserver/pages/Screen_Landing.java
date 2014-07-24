package com.ubuntuserver.pages;

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

public class Screen_Landing extends Abstract_Screen {
	
	
	//Window window;
	//TextField userText;
	
	TextButton DataReporter;
	TextButton EventCreator;
	
	
	
	public Texture texture1;
	public TextureRegion image;
	public Image imageActor;
	
	
	
	public Screen_Landing(MainCoreClass coreIn) {
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		
		
		DataReporter = new TextButton("Data Reporter", skin);
		
		DataReporter.setBounds(450, 200, 100, 20);
		
		DataReporter.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				core.setupGraphView();
				
			}
		});
		this.thisAddWidget(DataReporter);
		
		
		
		
		
		EventCreator = new TextButton("Event Creator", skin);
		
		EventCreator.setBounds(650, 200, 100, 20);
		
		EventCreator.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//
			}
		});
		this.thisAddWidget(EventCreator);
		
		
		
		
		
		
		//texture1 = new Texture(Gdx.files.internal("kitten.jpg"));
		texture1 = new Texture(Gdx.files.internal("Flood_images.jpg"));
		
		image = new TextureRegion(texture1);
		//image.setRegion(100, 100, 100, 100);
		imageActor = new Image(image);
		imageActor.setBounds(400, 250, 400, 400);
		
		//stage.addActor(imageActor);
		this.thisAddWidget(imageActor);
		
		
		
	}
	
	/*
	public String getUser() {
		return userText.getText();
	}
	/**/
	
	
}




