package com.nov.hotel.gui.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class Window {

    private Stage stage;
    private Scene scene;

    public Window(Stage thatStage) throws IOException {
        if (stage == null) {
            stage = thatStage;
        }
    }

    public Window() throws IOException{
        if (stage == null) {
            stage = new Stage();
        }
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void show(){
        stage.show();
    }

    public void hide() {
        stage.hide();
    }

    public void close() {
        stage.close();
        stage = null;
        scene = null;
    }

    public void init(String fxmlFile, String header, String styleFile, boolean isResize) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AuthorWindow.class.getResource(fxmlFile));
        loader.setResources(ResourceBundle.getBundle("Locale"));

        stage.setTitle(loader.getResources().getString(header));
        stage.setResizable(isResize);

        Parent parent = loader.load();
        scene = new Scene(parent);
        scene.getStylesheets().add(styleFile);
        stage.setScene(scene);
    }

}
