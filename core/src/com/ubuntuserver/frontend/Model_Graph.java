package com.ubuntuserver.frontend;

import java.util.ArrayList;

public class Model_Graph {
	
	Mediator mediator;
	
	public int[] data;
	public int dataCount;
	
	public int dataClipStart;
	public int dataClipEnd;
	
	
	public Model_Graph(Mediator med, Model_General mod) {
		
		mediator = med;
		
		
	}
	
	
	
	public void setData(int[] newData) {
		//x = xNew;
		data = newData;
		
		//xCount = xNew.length;
		dataCount = newData.length;
	}
	
	
	
}
