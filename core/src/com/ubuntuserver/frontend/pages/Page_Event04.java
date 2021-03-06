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
import com.ubuntuserver.frontend.Networking.Logic_PHP;
import com.ubuntuserver.frontend.Abstract_Screen;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.model.Model_Event.SelectBoxStep;
import com.ubuntuserver.frontend.model.Model_Event.SummaryStep;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.pageAbstraction.Abstract_GenericCheckBox;
import com.ubuntuserver.frontend.pageAbstraction.Abstract_StepPage;

public class Page_Event04 extends Abstract_GenericCheckBox {
	
	
	public Page_Event04(MainCoreClass coreIn) {
		
		super(coreIn);
		
		
		
		this.title.setText("4. Determine the appropriate staff for the event");
		
		
		
		this.pageNum = 4;
		
		this.postConstruction();
		
		
		
	}
	
	
	
	@Override
	public void previousPage() {
		core.currentScreen.thisRemoveScreen();
		core.currentScreen = null;
		Page_Event03 newPage = new Page_Event03(core);
	}
	
	
	
	@Override
	public void nextPage() {
		core.currentScreen.thisRemoveScreen();
		core.currentScreen = null;
		Page_Event05 newPage = new Page_Event05(core);
	}



	@Override
	public void sendPacket() {
		// TODO Auto-generated method stub
		
		Abstract_StepPage currentPage = (Abstract_StepPage) core.currentScreen;
		
		StringBuilder theURL = new StringBuilder();
		
		theURL.append(core.modelCore.targetURL);
		theURL.append("michael/updateevent.php?");
		theURL.append("page=" + "four" +"&"); //page = "three"&
		theURL.append("name=" + core.modelCore.selectedEvent.eventName +"&");
		theURL.append("answer=" + yesBox.isChecked() +"&");
		theURL.append("user=" + core.modelCore.username);
		
		System.out.println( theURL.toString() );
		
		Logic_PHP.getResponseFromURL(core, theURL.toString());
	}
	
	
}




