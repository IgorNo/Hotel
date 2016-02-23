package com.nov.hotel.gui.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ResourceBundle;

public class WindowInit {

    private Stage stage;
    private Scene scene;

    private static Logger LOG = Logger.getLogger(AuthorWindow.class);

    public WindowInit(Stage thatStage, AbstractWindow.Properties properties)  {
        if (stage == null) {
            stage = thatStage;
            init(properties);
        }
    }

    public WindowInit( AbstractWindow.Properties properties) {
        if (stage == null) {
            stage = new Stage();
            init(properties);
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

    private void init(AbstractWindow.Properties properties)  {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(WindowInit.class.getResource(properties.fxmlFile));
        loader.setResources(ResourceBundle.getBundle("Locale"));
        stage.setTitle(loader.getResources().getString(properties.header));
        stage.setResizable(properties.isResize);
        if (properties.isResize){
            stage.setMinHeight(150);
            stage.setMinWidth(300);
        }
        try {
            Parent parent = loader.load();
            scene = new Scene(parent);
        } catch (IOException e) {
            LOG.error("Can't load resource", e);
            throw new RuntimeException(e);
        }
        scene.getStylesheets().add(properties.style);
        stage.setScene(scene);
    }

    public void initModality(Stage ownerSager){
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(ownerSager);
        stage.showAndWait();
    }
}
