package com.ubuntuserver.frontend.model;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ubuntuserver.frontend.Mediator;

public class Model_Maps {
	
	Mediator mediator;
	
	
	ArrayList<TextureRegion> maps;
	
	
	
	
	public Model_Maps(Mediator med) {
		mediator = med;
		
		maps = new ArrayList<TextureRegion>();
		
		
		
		/**/
		
		//Texture texture = new Texture(Gdx.files.internal("kitten.jpg"));
		Texture texture = new Texture(Gdx.files.internal("maps/Oshaughnessy_Dam.jpg"));
		TextureRegion image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Alum_Creek_at_Africa_Rd.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Big_Walnut_Creek_at_Sunbury.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Olentangy_River_near_Delaware.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Scioto_River_below_Oshaughnessy.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Griggs_Dam.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Hoover_Dam.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Big_Walnut_Creek_at_Central_College.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Big_Walnut_Creek_at_Rees.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Olentangy_River_near_Worthington.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Scioto_River_at_Columbus.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Alum_Creek_Dam.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Delaware_Dam.jpg"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		/**/
		
	}
	
	
	public void setMap(int position) {
		
		mediator.widgets.imageActor.remove();
		
		mediator.widgets.imageActor = new Image( maps.get(position) );
		mediator.widgets.imageActor.setBounds(100, 100, 100, 100);
		mediator.widgets.stage.addActor(mediator.widgets.imageActor);
		
		mediator.core.resize(mediator.core.showWidth, mediator.core.showHeight);
		
		
		//imageActor.setBounds(100, 100, 100, 100);
	}
	
	
	
}



