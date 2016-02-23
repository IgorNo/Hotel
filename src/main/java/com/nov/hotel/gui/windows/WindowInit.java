package com.nov.hotel.gui.windows;

import com.nov.hotel.gui.controllers.AbstractController;
import com.nov.hotel.gui.windows.properties.AbstractWindow;
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
    private AbstractController controller;

    private static Logger LOG = Logger.getLogger(AuthorWindow.class);

    public WindowInit(Stage stage, AbstractWindow.Properties properties)  {
        if (stage == null) {
            this.stage = stage;
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

    public AbstractController getController() {
        return controller;
    }

    public void show(){
        stage.show();
    }

    public void showAndWait(){
        stage.showAndWait();
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
        loader.setLocation(WindowInit.class.getResource(properties.getFxmlFile()));
        loader.setResources(ResourceBundle.getBundle("Locale"));
        stage.setTitle(loader.getResources().getString(properties.getHeader()));
        stage.setResizable(properties.getResize());
        if (properties.getResize()){
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
        controller = loader.getController();
        scene.getStylesheets().add(properties.getStyle());
        stage.setScene(scene);
    }

    public void initModality(Stage ownerStage){
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(ownerStage);
    }
}
