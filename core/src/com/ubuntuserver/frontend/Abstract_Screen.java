package com.ubuntuserver.frontend;

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
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

//Or name is "Parent_Screen" and subclass it, instead of implementing it
public class Abstract_Screen {
	
	
	ArrayList<Actor> widgetsOnStage;
	
	/**
	 * indicates whether the screen is still in use
	 * 
	 * used by Login, other screens may be loaded through listeners that
	 * will unload these components, then construct a new screen and
	 * reference it from mediator, core, or model_general
	 * most likely from core
	 */
	//boolean screenStillInUse = true;
	
	
	
	
	
	public MainCoreClass core;
	
	
	
	public Stage stage;
	public Skin skin;
	
	
	
	
	public Abstract_Screen(MainCoreClass coreIn) {
		
		core = coreIn;
		
		stage = core.stage;
		
		Gdx.input.setInputProcessor(stage);
		
		//mediator = med;
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		
		
		core.currentScreen = this;
		
		//=====================================================
		
		
		widgetsOnStage = new ArrayList<Actor>();
		
		/*
		Window window = new Window("Log In Options", skin);
		
		window.defaults().pad(5.0f);
		
		
		
		//window.setBounds(300, 300, 350, 350);
		window.setBounds(300, 300, 350, 250);
		
		
		stage.addActor(window);
		/**/
		
		
		
	}
	
	
	
	
	
	public void thisRemoveScreen() {
		
		for (Actor widget : widgetsOnStage) {
			widget.remove();
		}
		
		widgetsOnStage.removeAll(widgetsOnStage);
	}
	
	
	
	//"Logic_Stage.constructStage(mediator);"
	//this is just the constructor?
	/**
	 * possibly will be used by resize events
	 */
	public void thisConstructScreen() {
		for (Actor widget : widgetsOnStage) {
			//widget.remove();
			stage.addActor(widget);
		}
	}
	
	
	
	public void thisRemoveWidget(Actor widget) {
		widget.remove();
		widgetsOnStage.remove(widget);
	}
	
	public void thisAddWidget(Actor widget) {
		stage.addActor(widget);
		widgetsOnStage.add(widget);
	}
	
	
	
	//"Logic_Stage.constructStage(mediator);"
	/*
	public void loadOtherScreen(Abstract_Screen other) {
		this.removeScreen();
		
	}
	/**/
	
	
	public void thisResizeEvent() {
		stage = new Stage();
		
		//mediator.core.stage = newStage;
		//mediator.stage = newStage;
		//mediator.widgets.stage = newStage;
		
		Gdx.input.setInputProcessor(stage);
		
		
		
		for (Actor widget : widgetsOnStage) {
			stage.addActor(widget);
		}
	}
	
	
	
	
	
	/*
	public MainCoreClass getCore() {
		return core;
	}
	/**/
	
}




