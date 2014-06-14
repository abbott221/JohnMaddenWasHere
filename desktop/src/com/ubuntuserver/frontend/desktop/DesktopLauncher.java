package com.ubuntuserver.frontend.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.UITest;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.height = 540;
		config.width = 960;
		
		//config.height = 1080;
		//config.width = 1920;
		
		new LwjglApplication(new MainCoreClass(), config);
		//new LwjglApplication(new UITest(), config);
	}
}
