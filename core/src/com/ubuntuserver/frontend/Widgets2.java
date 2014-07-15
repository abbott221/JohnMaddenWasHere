package com.ubuntuserver.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.ubuntuserver.frontend.Logic.Logic_DateStrings;
import com.ubuntuserver.frontend.Logic.Logic_GraphSizing;
import com.ubuntuserver.frontend.Logic.Logic_JSON;
import com.ubuntuserver.frontend.Logic.Logic_JSON2;
import com.ubuntuserver.frontend.Logic.Logic_JSON3;
import com.ubuntuserver.frontend.Logic.Logic_JSON3.DataSource;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

public class Widgets2 {
	
	public Mediator mediator;
	
	public TextButton optionsButton;
	
	
	
	public Widgets2(Mediator med) {
		
		mediator = med;
		
		optionsButton = new TextButton("Options", mediator.widgets.skin);
		optionsButton.setBounds(1100, 500, 100, 20);
		
		/**/
		optionsButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				displayWindow();
			}
		});
		
		med.widgets.stage.addActor(optionsButton);
		
		/**/
		
		
	}
	
	
	
	
	public void displayWindow() {
		
		//System.out.println("Display Window");
		
		
		//CheckBox thumbnails = new CheckBox("Check me", mediator.widgets.skin);
		
		
		
		
		Window window = new Window("Advanced Options", mediator.widgets.skin);
		
		window.defaults().pad(5.0f);
		
		
		TextButton close = new TextButton("X", mediator.widgets.skin);
		
		window.getButtonTable().add(close).height(window.getPadTop());
		
		close.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//first parent = Table
				//second parent = window
				actor.getParent().getParent().remove();
			}
		});
		
		
		
		
		
		CheckBox thumbnails = new CheckBox("Thumbnails", mediator.widgets.skin);
		thumbnails.setChecked(mediator.model.thumbnailsView);
		
		thumbnails.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//thumbnails.isChecked();
				
				CheckBox useThis = (CheckBox) actor;
				
				//boolean newState = useThis.isChecked();
				//mediator.model.thumbnailsView = newState;
				mediator.model.thumbnailsView = useThis.isChecked();
				
				Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
			}
		});
		
		window.add(thumbnails);
		
		
		
		
		window.row();
		
		CheckBox scrollpanes = new CheckBox("ScrollPanes", mediator.widgets.skin);
		scrollpanes.setChecked(mediator.model.scrollpanesView);
		
		scrollpanes.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//thumbnails.isChecked();
				
				CheckBox useThis = (CheckBox) actor;
				
				boolean newState = useThis.isChecked();
				//mediator.model.thumbnailsView = newState;
				mediator.model.scrollpanesView = newState;
				//mediator.model.scrollpanesView = useThis.isChecked();
				
				
				if (newState == true) {
					mediator.widgets.startDateBox.remove();
					mediator.widgets.endDateBox.remove();
					
					mediator.widgets.stage.addActor(mediator.scrollpanes.startPane);
					mediator.widgets.stage.addActor(mediator.scrollpanes.endPane);
				}
				else {
					mediator.scrollpanes.startPane.remove();
					mediator.scrollpanes.endPane.remove();
					
					mediator.widgets.stage.addActor(mediator.widgets.startDateBox);
					mediator.widgets.stage.addActor(mediator.widgets.endDateBox);
				}
				
				
				
				Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
			}
		});
		
		window.add(scrollpanes);
		
		
		
		
		
		
		window.row();
		
		
		
		
		CheckBox dataTable = new CheckBox("Data Table", mediator.widgets.skin);
		dataTable.setChecked(mediator.model.dataTableView);
		
		dataTable.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//thumbnails.isChecked();
				
				CheckBox useThis = (CheckBox) actor;
				
				boolean newState = useThis.isChecked();
				
				mediator.model.dataTableView = newState;
				
				
				
				if (newState == true) {
					//mediator.tablepane.tablePane.remove();
					mediator.widgets.stage.addActor(mediator.tablepane.tablePane);
				}
				else {
					mediator.tablepane.tablePane.remove();
				}
				
				
				
				Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
			}
		});
		
		window.add(dataTable);
		
		
		
		
		window.row();
		
		
		
		TextButton update = new TextButton("Update", mediator.widgets.skin);
		
		update.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				//Logic_GraphSizing.setSizeByCount(mediator, mediator.model.graphs);
				
				//System.out.println("Run update");
				
				
				
				//Logic_JSON2.getJSONfromURL(mediator);
				
				Logic_JSON3.EntryPoint(mediator, DataSource.LOCALHOST, mediator.model.secondTable);
				//Logic_JSON3.EntryPoint(mediator, DataSource.INTERNAL_IP, mediator.model.secondTable);
				
			}
		});
		
		window.add(update);
		
		
		
		
		
		window.row();
		
		
		
		
		TextField yBottomIn = new TextField("", mediator.widgets.skin);
		yBottomIn.setMessageText("Y Bottom");
		
		yBottomIn.setTextFieldListener(new TextFieldListener() {
			public void keyTyped (TextField textField, char key) {
				
				String inText = textField.getText();
				
				if ( key == ';' ) {
					
					inText = inText.substring(0, inText.length() - 1);
					int thisNum = 0;
					
					try {
						thisNum = Integer.parseInt(inText);
						
						//System.out.println(thisNum);
						Model_Station tempStation = mediator.model.bigGraph.dataModel.myStation;
						
						tempStation.setYScale(thisNum, tempStation.yTop);
						
					} catch (Exception e) {
						//incorrect format
					}
				}
				
			}
		});
		
		window.add(yBottomIn);
		
		
		
		TextField yTopIn = new TextField("", mediator.widgets.skin);
		yTopIn.setMessageText("Y Top");
		
		yTopIn.setTextFieldListener(new TextFieldListener() {
			public void keyTyped (TextField textField, char key) {
				
				String inText = textField.getText();
				
				if ( key == ';' ) {
					
					inText = inText.substring(0, inText.length() - 1);
					int thisNum = 0;
					
					try {
						thisNum = Integer.parseInt(inText);
						
						//System.out.println(thisNum);
						Model_Station tempStation = mediator.model.bigGraph.dataModel.myStation;
						
						tempStation.setYScale(tempStation.yBottom, thisNum);
						
					} catch (Exception e) {
						//incorrect format
					}
				}
				
			}
		});
		
		window.add(yTopIn);
		
		
		
		
		
		window.row();
		
		
		
		TextButton runLogic = new TextButton("Run Logic", mediator.widgets.skin);
		
		runLogic.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				//Logic_JSON.getJSONfromURL(mediator);
				Logic_DateStrings.determineDates(mediator);
				
			}
		});
		
		window.add(runLogic);
		
		
		
		
		
		TextButton runSQLping = new TextButton("Ping SQL", mediator.widgets.skin);
		
		runSQLping.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					//Class.forName("com.mysql.jdbc.Driver").newInstance();
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					
					System.out.println("Driver failed");
					
					e1.printStackTrace();
				}
				/*
				catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/**/
				
				//Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				//Logic_JSON.getJSONfromURL(mediator);
				//Logic_DateStrings.determineDates(mediator);
				
				//work internal ip
				//"http://10.119.0.52/michael/michael_recorded.php"
				
				
				//String url = "jdbc:mysql://localhost/";
				//String url = "jdbc:mysql://192.168.1.140/";
				
				//String url = "jdbc:mysql://10.119.0.52/";
				String url = "jdbc:mysql://10.119.0.52:3306/";
				
				
				
				/**/
				String user = "root";
				String password = "gisintern";
				/**/
				
				/*
				String user = "gisintern";
				String password = "gisinterns";
				/**/
				
				try {
					Connection con = DriverManager.getConnection(url, user, password);
					
					//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mypassword");
					
					System.out.println("Success");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		window.add(runSQLping);
		
		
		
		
		//window.getButtonTable().add(close).height(window.getPadTop());
		//window.getButtonTable().add(close);
		
		
		//window.setPosition(300, 300);
		//window.setBounds(300, 300, 250, 150);
		window.setBounds(300, 300, 350, 350);
		
		
		//window.pack();
		
		mediator.widgets.stage.addActor(window);
		
	}
	
	
	
	
	
	
	public void adjustBox() {
		
		//int boxLeft = 100;
		int boxBottom = 500;
		
		int h = mediator.displayHeight;
		int w = mediator.displayWidth;
		
		if (h > 540 && w > 960) {
			
			//boxLeft = 100;
			boxBottom = h - 40;
			
			
			
			
			//thumbnails.setBounds(1000, boxBottom, 100, 20);
			optionsButton.setBounds(1100, boxBottom, 100, 20);
			
		}
		
		
	}
	
	
}




