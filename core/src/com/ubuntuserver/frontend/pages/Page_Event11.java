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
import com.ubuntuserver.frontend.pageAbstraction.Abstract_GenericCheckBox;
import com.ubuntuserver.frontend.pageAbstraction.Abstract_StepPage;

public class Page_Event11 extends Abstract_GenericCheckBox {
	
	
	public Page_Event11(MainCoreClass coreIn) {
		
		super(coreIn);
		
		
		
		this.title.setText("11. Close this flood event");
		
		
		
		//this.yesBox.setText("Yes, close the event.");
		//this.noBox.setText("No, leave it as active.");
		
		this.thisRemoveWidget(yesBox);
		//this.thisAddWidget(yesBox);
		this.thisRemoveWidget(noBox);
		//this.thisAddWidget(noBox);
		
		
		yesBox = new CheckBox("Yes, close the event.", skin);
		//yesBox.setChecked(false);
		yesBox.setPosition(100, 450);
		yesBox.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (changing) {
					//do nothing
				} else {
					changing = true;
					checkEvent(true);
					changing = false;
				}
			}
		});
		this.thisAddWidget(yesBox);
		
		
		
		noBox = new CheckBox("No, leave it as active.", skin);
		//noBox.setChecked(false);
		noBox.setPosition(100, 400);
		noBox.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (changing) {
					//do nothing
				} else {
					changing = true;
					checkEvent(false);
					changing = false;
				}
			}
		});
		this.thisAddWidget(noBox);
		
		
		
		
		
		
		this.pageNum = 11;
		
		this.postConstruction();
		
		
		
	}
	
	
	
	@Override
	public void previousPage() {
		core.currentScreen.thisRemoveScreen();
		core.currentScreen = null;
		Page_Event10 newPage = new Page_Event10(core);
	}
	
	
	
	@Override
	public void nextPage() {
		
		//if-else block goes here
		if ( yesBox.isChecked() ) {
			core.currentScreen.thisRemoveScreen();
			core.currentScreen = null;
			Page_Event12Yes newPage = new Page_Event12Yes(core);
		} else {
			core.currentScreen.thisRemoveScreen();
			core.currentScreen = null;
			Page_Event12No newPage = new Page_Event12No(core);
		}
		
		//core.currentScreen.thisRemoveScreen();
		//core.currentScreen = null;
		//Page_Event03 newPage = new Page_Event03(core);
	}



	@Override
	public void sendPacket() {
		// TODO Auto-generated method stub
		
	}
	
	
}




