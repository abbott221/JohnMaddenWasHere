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
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Widgets_Scrollpanes {
	
	Mediator mediator;
	
	public List startDateList;
	public List endDateList;
	
	ScrollPane startPane;
	ScrollPane endPane;
	
	
	public Widgets_Scrollpanes(Mediator med) {
		
		mediator = med;
		
		
		Object[] listEntries = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		
		
		
		startDateList = new List( med.widgets.skin );
		startDateList.setItems(listEntries);
		
		//startDateList.setBounds(100, 500, 100, 20);
		
		startDateList.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				Logic_Dates.startDateChange(mediator, startDateList);
				
			}
		});
		
		//med.widgets.stage.addActor(startDateList);
		
		
		
		
		/**/
		endDateList = new List( med.widgets.skin );
		endDateList.setItems(1, 2, 3, 4);
		endDateList.setItems(listEntries);
		
		//endDateList.setBounds(250, 500, 100, 20);
		
		endDateList.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				Logic_Dates.endDateChange(mediator, endDateList);
				
			}
		});
		
		//med.widgets.stage.addActor(endDateList);
		/**/
		
		
		startPane = new ScrollPane(startDateList, med.widgets.skin);
		endPane = new ScrollPane(endDateList, med.widgets.skin);
		
		startPane.setBounds(100, 500, 100, 20);
		endPane.setBounds(250, 500, 100, 20);
	}
	
	
	
	
	
	
	
	public void adjustBox() {
		
		//int boxLeft = 100;
		int boxBottom = 500;
		
		int h = mediator.displayHeight;
		int w = mediator.displayWidth;
		
		if (h > 540 && w > 960) {
			
			//boxLeft = 100;
			//boxBottom = h - 40;
			
			//int boxHeight = 100;
			
			
			
			//boxBottom = h - 100; //original
			//boxBottom = h - 210;
			boxBottom = h - 185;
			
			
			//startDateList.setBounds(100, boxBottom, 100, 80);
			//endDateList.setBounds(250, boxBottom, 100, 80);
			
			
			
			//startPane.setBounds(50, boxBottom, 150, 100);
			//endPane.setBounds(250, boxBottom, 100, 80);
			
			startPane.setBounds(25, boxBottom, 150, 160);
			endPane.setBounds(200, boxBottom, 150, 160);
		}
		
		
	}
	
	
}




