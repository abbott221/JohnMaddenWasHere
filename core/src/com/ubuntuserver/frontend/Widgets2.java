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
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Widgets2 {
	
	Mediator mediator;
	
	TextButton optionsMenu;
	
	
	
	public Widgets2(Mediator med) {
		
		mediator = med;
		
		optionsMenu = new TextButton("New Graph", mediator.widgets.skin);
		optionsMenu.setBounds(1100, 500, 100, 20);
		
		/*
		newGraph.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				Graph_Main tempGraph = new Graph_Main(mediator, mediator.model);
				mediator.model.graphs.add(tempGraph);
				
				Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
				
			}
		});
		
		stage.addActor(newGraph);
		
		/**/
		
		
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
			
		}
		
		
	}
	
	
}




