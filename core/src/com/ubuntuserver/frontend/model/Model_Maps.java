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
		Texture texture = new Texture(Gdx.files.internal("maps/Oshaughnessy_Dam.png"));
		TextureRegion image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Alum_Creek_at_Africa_Rd.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Big_Walnut_Creek_at_Sunbury.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Olentangy_River_near_Delaware.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Scioto_River_below_Oshaughnessy.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Griggs_Dam.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Hoover_Dam.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Big_Walnut_Creek_at_Central_College.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Big_Walnut_Creek_at_Rees.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Olentangy_River_near_Worthington.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Scioto_River_at_Columbus.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Alum_Creek_Dam.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		
		texture = new Texture(Gdx.files.internal("maps/Delaware_Dam.png"));
		image = new TextureRegion(texture);
		maps.add(image);
		
		/**/
		
	}
	
	
	public void setMap(int position) {
		
	}
	
	
	
}



