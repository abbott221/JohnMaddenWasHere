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
import com.ubuntuserver.frontend.Abstract_Screen;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;

public class Page_Event4 extends Abstract_Screen {
	
	
	
	
	//Window window;
	//TextField userText;
	
	public Label temp;
	
	TextButton newEventPage;
	TextButton activeEventsPage;
	
	
	
	
	
	public Page_Event4(MainCoreClass coreIn) {
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		
		
		temp = new Label("4. Determine the appropriate staff for the event", skin);
		temp.setPosition(100, 700);
		this.thisAddWidget(temp);
		
		
		
		
		
		
		TextButton nextButton = new TextButton("Next Page", skin);
		
		nextButton.setBounds(200, 20, 140, 20);
		
		nextButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Page_Event4 landingScreen = new Page_Event4(core);
			}
		});
		
		this.thisAddWidget(nextButton);
		
		
		
		
		
		
		
		
		TextButton landingButton = new TextButton("Landing Page", skin);
		
		landingButton.setBounds(20, 20, 140, 20);
		
		landingButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				core.currentScreen.thisRemoveScreen();
				core.currentScreen = null;
				Screen_Landing landingScreen = new Screen_Landing(core);
			}
		});
		
		this.thisAddWidget(landingButton);
		
		
		
		
	}
	
	
}




