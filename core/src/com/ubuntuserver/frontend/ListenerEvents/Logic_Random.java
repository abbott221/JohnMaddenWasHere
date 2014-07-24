package com.ubuntuserver.frontend.ListenerEvents;

import java.awt.TextArea;
import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ubuntuserver.frontend.Graph_Main;
import com.ubuntuserver.frontend.Mediator;
import com.ubuntuserver.frontend.model.Model_Graph.ShowMode;
import com.ubuntuserver.frontend.Report_Generator;

public class Logic_Random {
	
	
	
	//thumbnail change
	public static void respondWidgets(Mediator mediator) {
		int posStart = mediator.model.selectedGraph.positionStartDate;
		int posEnd = mediator.model.selectedGraph.positionEndDate;
		int posStation = mediator.model.selectedGraph.positionStation;
		
		//remove these if statements?
		if (posStart >= 0) {
			mediator.widgets.startDateBox.setSelectedIndex(posStart);
		}
		
		if (posEnd >= 0) {
			mediator.widgets.endDateBox.setSelectedIndex(posEnd);
		}
		
		if (posStation >= 0) {
			mediator.widgets.stationBox.setSelectedIndex(posStation);
		}
		
		
		//mediator.widgets.startDateBox.setSelectedIndex(posStart);
		//mediator.widgets.endDateBox.setSelectedIndex(posEnd);
		//mediator.widgets.stationBox.setSelectedIndex(posStation);
	}
	
	
	//start date, end date, or station change
	public static void storeWidgets(Mediator mediator) {
		
		int posStart = mediator.widgets.startDateBox.getSelectedIndex();
		int posEnd = mediator.widgets.endDateBox.getSelectedIndex();
		int posStation = mediator.widgets.stationBox.getSelectedIndex();
		
		mediator.model.selectedGraph.positionStartDate = posStart;
		mediator.model.selectedGraph.positionEndDate = posEnd;
		mediator.model.selectedGraph.positionStation = posStation;
		
	}
	
	
	
}





