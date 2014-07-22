package com.ubuntuserver.frontend.widgets;

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
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.Logic.Logic_Dates;
import com.ubuntuserver.frontend.model.Model_WidgetSizes;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.model.Model_Portion.Results;

public class Widgets_Labels {
	
	Mediator mediator;
	
	
	//public Label temp;
	
	
	//public Texture texture;
	//public TextureRegion image;
	public Image dateImage;
	public Image waterLevelImage;
	
	
	public Widgets_Labels(Mediator med) {
		
		mediator = med;
		
		
		//temp = new Label("Place Holder", med.widgets.skin);
		//temp.setBounds(100, 100, 100, 100);
		
		
		
		
		
		
		Texture texture1 = new Texture(Gdx.files.internal("labels2date.png"));
		TextureRegion image1 = new TextureRegion(texture1);
		//image.setRegion(100, 100, 100, 100);
		dateImage = new Image(image1);
		dateImage.setBounds(100, 100, 73, 18);
		//stage.addActor(imageActor);
		
		
		
		Texture texture2 = new Texture(Gdx.files.internal("labels2waterlevel.png"));
		TextureRegion image2 = new TextureRegion(texture2);
		//image.setRegion(100, 100, 100, 100);
		waterLevelImage = new Image(image2);
		waterLevelImage.setBounds(200, 100, 123, 20);
		waterLevelImage.rotateBy(90.0f);
		
		
	}
	
	
	
	
	
	
	
	public void adjustBox() {
		
		//int boxLeft = 100;
		int boxBottom = 500;
		
		int h = mediator.displayHeight;
		int w = mediator.displayWidth;
		
		if (h > 100 && w > 100) {
			
			Graph_Main graph = mediator.model.bigGraph;
			
			
			//mediator.model.widgetSizes.portions.get(0);
			
			
			Model_WidgetSizes sizing = mediator.model.widgetSizes;
			Results bounds = sizing.portions.get(0).getResults();
			
			
			
			//float x = graph.left + 20;
			float x = bounds.left;
			
			//float y = graph.bottom + 20;
			float y = bounds.bottom;
			
			
			
			
			//temp.setBounds(x, y, 100, 100);
			//temp.setBounds(x + 20, y + 20, 0, 0);
			
			
			
			
			
			dateImage.setPosition(x + 240, y + 10);
			waterLevelImage.setPosition( (x+20) + 10, y + 80);
			
			
			
		}
		
		
	}
	
	
}




