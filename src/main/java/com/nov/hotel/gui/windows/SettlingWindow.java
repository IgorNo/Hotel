package com.nov.hotel.gui.windows;


import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SettlingWindow extends Window{

    private static WindowInit window;

    private static Window.Properties properties = getProperties();

    public static void create() {

        properties.fxmlFile = "/fxml/pricelist.fxml";
        properties.header = "header.price.list";
        properties.style = "/styles/styles.css";
        properties.isResize = true;

        window = new WindowInit(properties);
    }

    public static Stage getStage() {
        return window.getStage();
    }

    public static Scene getScene() {
        return window.getScene();
    }

    public static void show(){
        getStage().show();
    }

    public static void hide() {
        getStage().hide();
    }

    public static void close() {
        window.close();
        window = null;
    }
}
