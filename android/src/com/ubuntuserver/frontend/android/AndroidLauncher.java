package com.ubuntuserver.frontend.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ubuntuserver.frontend.MainCoreClass;

public class AndroidLauncher extends AndroidApplication {
	@SuppressLint("NewApi")
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		
		
		
		int h = 100;
		int w = 100;
		
		
		
		
		//my laptop
		//h = 744;
		//w = 1301;
		
		
		
		
		
		
		
		
		//savedInstanceState.getC
		//WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		//int width = size.x;
		w = size.x;
		h = size.y;
		
		
		
		
		//config.height = h;
		//config.width = w;
		
		MainCoreClass core = new MainCoreClass();
		
		initialize(new MainCoreClass(), config);
		
		
		core.showHeight = h;
		core.showWidth = w;
		
	}
}
