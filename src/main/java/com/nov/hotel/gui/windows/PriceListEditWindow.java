package com.nov.hotel.gui.windows;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PriceListEditWindow extends Window{
    private static WindowInit windowInit;

    private static Window.Properties properties = getProperties();

    public static void create() {
        properties.fxmlFile = "/fxml/pricelist-edi.fxml";
        properties.header = "header.edit.price.list";
        properties.style = "/styles/styles.css";
        properties.isResize = false;

        windowInit = new WindowInit(properties);
    }

    public static Stage getStage() {
        return windowInit.getStage();
    }

    public static Scene getScene() {
        return windowInit.getScene();
    }

    public static void show(){
        getStage().show();
    }

    public static void hide() {
        getStage().hide();
    }

    public static void close() {
        windowInit.close();
        windowInit = null;
    }
}
