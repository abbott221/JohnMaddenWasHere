package com.ubuntuserver.frontend.Login;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.JsonValue;
import com.ubuntuserver.frontend.Logic.Logic_Dates;
import com.ubuntuserver.frontend.Logic.Logic_JSONPI;
import com.ubuntuserver.frontend.Logic.Logic_Stage;
import com.ubuntuserver.frontend.Networking.Logic_JSON;
import com.ubuntuserver.frontend.MainCoreClass;
import com.ubuntuserver.frontend.Model_Graph.ShowMode;

/**
 * @author Brandon
 */
public class Widgets_Login {

    //Mediator mediator;

    //public List startDateList;
    //public List endDateList;

    //ScrollPane startPane;
    //ScrollPane endPane;





    MainCoreClass core;

    public Stage stage;
    public Skin skin;

    Window window;
    TextField userText;
    TextField passText;



    public Widgets_Login(MainCoreClass coreIn) {

        core = coreIn;

        stage = core.stage;

        Gdx.input.setInputProcessor(stage);

        //mediator = med;
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));



        //=====================================================



        window = new Window("Log In Options", skin);

        window.defaults().pad(5.0f);


        userText = new TextField("", skin);

        userText.setMessageText("Username");
        window.add(userText).colspan(2);
        userText.remove();



        window.row();




        passText = new TextField("", skin);
        passText.setMessageText("Password");

        passText.setPasswordCharacter('*');
        passText.setPasswordMode(true);

        window.add(passText).colspan(2);
        passText.remove();



        window.row();



        TextButton logInButton = new TextButton("Log In", skin);

        logInButton.addListener(
            new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    try {
login();

if(core.loggedIn = true && core.id >0)
{
	actor.getParent().remove();
	core.loggedIn = true;
	core.logInSuccess();
}
else
{
	core.loggedIn = false;
       Dialog dialog = new Dialog("Improper login", skin, "dialog") {
               protected void result (Object object) {
                   System.out.println("Improper login");
               }
       }.text("If this problem remains then please contact your IT department").button("Cancel", true).key(Keys.ENTER, true).show(stage);
}
} catch (Exception e) {
e.printStackTrace();
}

                }
            }
        );
        window.add(logInButton);


        TextButton exitButton = new TextButton("exit", skin);

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.exit(1);
            }
        }
        );
        window.add(exitButton);



        //=====================================================



        //window.setBounds(300, 300, 350, 350);
        window.setBounds(300, 300, 350, 250);


        stage.addActor(window);

    }

    public void login()
    {
        String user = System.getProperty("user.name");
        user = user.replaceAll("[-+.^:,]","");
        String url = "http://10.119.0.52/login.php?username="+user;
        Logic_JSONPI.EntryPoint(core, url);
    }


}
