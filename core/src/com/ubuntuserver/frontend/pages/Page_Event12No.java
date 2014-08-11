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

public class Page_Event12No extends Abstract_GenericCheckBox {
	
	
	public Page_Event12No(MainCoreClass coreIn) {
		
		super(coreIn);
		
		
		
		this.title.setText("Thank You.");
		
		
		
		this.thisRemoveWidget(this.yesBox);
		this.thisRemoveWidget(this.noBox);
		//this.noBox.setText("No, leave it as active.");
		
		
		
		
		Label temp2 = new Label("The event will remain active.", skin);
		//temp2.setColor(Color.BLACK);
		temp2.setPosition(100, 550);
		this.thisAddWidget(temp2);
		temp2.setColor(Color.BLUE);
		
		
		
		
		
		this.pageNum = 12;
		
		this.postConstruction();
		
		
		
		submitButton.setColor(Color.GRAY);
		submitButton.setDisabled(true);
		
		nextButton.setColor(Color.valueOf("ffffffff"));
		nextButton.setDisabled(false);
	}
	
	
	
	@Override
	public void previousPage() {
		core.currentScreen.thisRemoveScreen();
		core.currentScreen = null;
		Page_Event11 newPage = new Page_Event11(core);
	}
	
	
	
	@Override
	public void nextPage() {
		
		core.currentScreen.thisRemoveScreen();
		core.currentScreen = null;
		//Page_Event03 newPage = new Page_Event03(core);
		Screen_Landing newPage = new Screen_Landing(core);
		
	}



	@Override
	public void sendPacket() {
		// TODO Auto-generated method stub
		
	}
	
	
}




