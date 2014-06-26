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
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Logic.Logic_JSON;
import com.ubuntuserver.frontend.Logic.Logic_JSON2;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Widgets2 {
	
	public Mediator mediator;
	
	public TextButton optionsButton;
	
	
	
	public Widgets2(Mediator med) {
		
		mediator = med;
		
		optionsButton = new TextButton("Options", mediator.widgets.skin);
		optionsButton.setBounds(1100, 500, 100, 20);
		
		/**/
		optionsButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				displayWindow();
			}
		});
		
		med.widgets.stage.addActor(optionsButton);
		
		/**/
		
		
	}
	
	
	
	
	public void displayWindow() {
		
		//System.out.println("Display Window");
		
		
		//CheckBox thumbnails = new CheckBox("Check me", mediator.widgets.skin);
		
		
		
		
		Window window = new Window("Advanced Options", mediator.widgets.skin);
		
		
		
		
		TextButton close = new TextButton("X", mediator.widgets.skin);
		
		window.getButtonTable().add(close).height(window.getPadTop());
		
		close.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//first parent = Table
				//second parent = window
				actor.getParent().getParent().remove();
			}
		});
		
		
		
		
		
		CheckBox thumbnails = new CheckBox("Thumbnails", mediator.widgets.skin);
		thumbnails.setChecked(mediator.model.thumbnailsView);
		
		thumbnails.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//thumbnails.isChecked();
				
				CheckBox useThis = (CheckBox) actor;
				
				//boolean newState = useThis.isChecked();
				//mediator.model.thumbnailsView = newState;
				mediator.model.thumbnailsView = useThis.isChecked();
				
				Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
			}
		});
		
		window.add(thumbnails);
		
		
		
		
		window.row();
		
		CheckBox scrollpanes = new CheckBox("ScrollPanes", mediator.widgets.skin);
		scrollpanes.setChecked(mediator.model.scrollpanesView);
		
		scrollpanes.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//thumbnails.isChecked();
				
				CheckBox useThis = (CheckBox) actor;
				
				boolean newState = useThis.isChecked();
				//mediator.model.thumbnailsView = newState;
				mediator.model.scrollpanesView = newState;
				//mediator.model.scrollpanesView = useThis.isChecked();
				
				
				if (newState == true) {
					mediator.widgets.startDateBox.remove();
					mediator.widgets.endDateBox.remove();
					
					mediator.widgets.stage.addActor(mediator.scrollpanes.startPane);
					mediator.widgets.stage.addActor(mediator.scrollpanes.endPane);
				}
				else {
					mediator.scrollpanes.startPane.remove();
					mediator.scrollpanes.endPane.remove();
					
					mediator.widgets.stage.addActor(mediator.widgets.startDateBox);
					mediator.widgets.stage.addActor(mediator.widgets.endDateBox);
				}
				
				
				
				Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
			}
		});
		
		window.add(scrollpanes);
		
		
		
		
		
		window.row();
		
		
		
		TextButton update = new TextButton("Update", mediator.widgets.skin);
		
		update.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				//Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
				
				//System.out.println("Run update");
				
				Logic_JSON.getJSONfromURL(mediator);
				
			}
		});
		
		window.add(update);
		
		
		
		
		//window.getButtonTable().add(close).height(window.getPadTop());
		//window.getButtonTable().add(close);
		
		
		//window.setPosition(300, 300);
		window.setBounds(300, 300, 250, 150);
		
		
		//window.pack();
		
		mediator.widgets.stage.addActor(window);
		
	}
	
	
	
	
	
	
	public void adjustBox() {
		
		//int boxLeft = 100;
		int boxBottom = 500;
		
		int h = mediator.displayHeight;
		int w = mediator.displayWidth;
		
		if (h > 540 && w > 960) {
			
			//boxLeft = 100;
			boxBottom = h - 40;
			
			
			
			
			//thumbnails.setBounds(1000, boxBottom, 100, 20);
			optionsButton.setBounds(1100, boxBottom, 100, 20);
			
		}
		
		
	}
	
	
}




