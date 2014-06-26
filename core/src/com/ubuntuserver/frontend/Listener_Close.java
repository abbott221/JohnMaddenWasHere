package com.ubuntuserver.frontend;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;


public class Listener_Close extends ChangeListener {
	
	Window window;
	
	public Listener_Close() {
		//
	}
	
	public Listener_Close(Window newObject) {
		window = newObject;
	}
	
	public void registerWindow(Window newObject) {
		window = newObject;
	}

	@Override
	public void changed(ChangeEvent event, Actor actor) {
		window.remove();
	}
	
}





