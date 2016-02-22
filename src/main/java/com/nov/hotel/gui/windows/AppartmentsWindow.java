package com.nov.hotel.gui.windows;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppartmentsWindow {
    private static Window window;

    private static final String FXML_FILE = "/fxml/appartments.fxml";
    private static final String HEADER = "header.appartments";
    private static final String STYLE = "/styles/styles.css";
    private static final Boolean IS_RESIZE = true;

    public static void create(Stage stage) throws IOException{
        window = new Window(stage);
        window.init(FXML_FILE, HEADER, STYLE, IS_RESIZE);
    }

    public static void create() throws IOException{
        window = new Window();
        window.init(FXML_FILE, HEADER, STYLE, IS_RESIZE);
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
        getStage().close();
        window = null;
    }
}
