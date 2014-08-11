package com.ubuntuserver.frontend.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.UITest;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		
		//h and w are the dimensions of the intended display
		//the widgets scale best to these dimensions
		
		int h = 100;
		int w = 100;
		
		//h = 540;
		//w = 960;
		
		
		
		
		//my laptop
		h = 744;
		w = 1301;
		
		//work monitor
		//h = 962;
		//w = 1280;
		
		//work laptop
		//h = 746;
		//w = 1366;
		
		
		
		
		//h = 838;
		//w = 1600;
		
		//h = 1080;
		//w = 1920;
		
		
		
		config.title = "Flood SOP Automation System";
		//config.title = "FSAS";
		
		
		
		config.height = h;
		config.width = w;
		
		
		MainCoreClass core = new MainCoreClass();
		
		new LwjglApplication(core, config);
		//new LwjglApplication(new UITest(), config);
		
		
		//System.out.println("blah");
		
		core.showHeight = h;
		core.showWidth = w;
		
	}
}