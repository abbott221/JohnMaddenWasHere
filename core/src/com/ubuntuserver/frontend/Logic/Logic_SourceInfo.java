package com.ubuntuserver.frontend.Logic;

import java.awt.TextArea;
import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.Report_Generator;

public class Logic_SourceInfo {
	
	
	
	/*
	public class ExtraInfo {
		String waterway;
		String source;
	}
	/**/
	
	public String waterway;
	public String source;
	
	
	public void getExtraInfo(int index) {
		
		//ExtraInfo returnMe = new ExtraInfo();
		
		source = "null";
		waterway = "null";
		
		
		
		//O'shaughness Dam
		if (index == 0) {
			source = "USGS";
			waterway = "Scioto River";
		}
		//Alum Creek - Africa Road
		else if (index == 1) {
			source = "USGS";
			waterway = "Alum Creek";
		}
		//Big Walnut Creek - Sunbury
		else if (index == 2) {
			source = "USGS";
			waterway = "Big Walnut Creek";
		}
		//Olentangy River Delaware
		else if (index == 3) {
			source = "USGS";
			waterway = "Olentangy River";
		}
		//Scioto River below O'shaughnessy Dam
		else if (index == 4) {
			source = "USGS";
			waterway = "Scioto River";
		}
		//Grigg's Dam
		else if (index == 5) {
			source = "USGS";
			waterway = "Scioto River";
		}
		//Hoover Dam
		else if (index == 6) {
			source = "USGS";
			waterway = "Big Walnut Creek";
		}
		//Big Walnut Creek - Central College
		else if (index == 7) {
			source = "USGS";
			waterway = "Big Walnut Creek";
		}
		//Big Walnut Creek - Rees
		else if (index == 8) {
			source = "USGS";
			waterway = "Big Walnut Creek";
		}
		//Olentangy River near Worthington
		else if (index == 9) {
			source = "USGS";
			waterway = "Olentangy River";
		}
		//Scioto River near Columbus
		else if (index == 10) {
			source = "USGS";
			waterway = "Scioto River";
		}
		//Alum Creek Dam
		else if (index == 11) {
			source = "USACE";
			waterway = "Alum Creek";
		}
		//Delaware Lake Dam
		else if (index == 12) {
			source = "USACE";
			waterway = "Olentangy River";
		}
		
		//return returnMe;
	}
	
	
}





