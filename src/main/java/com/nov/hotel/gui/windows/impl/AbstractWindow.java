package com.nov.hotel.gui.windows.impl;

import com.nov.hotel.gui.controllers.interfaces.Controller;
import com.nov.hotel.gui.windows.interfaces.Singelton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.log4j.Logger;

import java.beans.EventHandler;
import java.io.IOException;
import java.util.ResourceBundle;

public abstract class AbstractWindow implements Singelton<AbstractWindow> {

    private static Logger LOG = Logger.getLogger(AbstractWindow.class);

    public static class Properties {
        protected String fxmlFile;
        protected String header;
        protected String style;
        protected Boolean isResize;
        protected int minHeight;
        protected int minWidth;
//        protected Modality modality = Modality.NONE;
//        protected Stage ownerStage;
    }

    protected AbstractWindow.Properties properties = new Properties();

    private Stage stage = new Stage();
    private Scene scene;
    private FXMLLoader loader;

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    public FXMLLoader getLoader() {
        return loader;
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

    protected void init()  {

        loader = new FXMLLoader();
        loader.setLocation(AbstractWindow.class.getResource(properties.fxmlFile));
        loader.setResources(ResourceBundle.getBundle("bundles.Locale"));
        stage.setTitle(loader.getResources().getString(properties.header));
        stage.setResizable(properties.isResize);
        if (properties.isResize){
            stage.setMinHeight(properties.minHeight);
            stage.setMinWidth(properties.minWidth);
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
        Controller controller = loader.getController();
        controller.setOwnerStage(getStage());
    }

    public void initModality(Stage ownerStage){
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(ownerStage);
    }
}
