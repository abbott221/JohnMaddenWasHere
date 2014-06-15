package com.ubuntuserver.frontend.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.UITest;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		
		int h = 100;
		int w = 100;
		
		//h = 540;
		//w = 960;
		
		h = 744;
		w = 1301;
		
		//h = 1080;
		//w = 1920;
		
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
