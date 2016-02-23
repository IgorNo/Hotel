package com.nov.hotel.gui.controllers;

import com.nov.hotel.gui.controllers.interfaces.Controller;
import com.nov.hotel.gui.windows.WindowInit;
import com.nov.hotel.gui.windows.properties.AbstractWindow;
import com.nov.hotel.gui.windows.properties.ApartStatusWindow;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public abstract class AbstractController implements Controller{

    Stage ownerStage;

    public Stage getOwnerStage() {
        return ownerStage;
    }

    public void setOwnerStage(Stage ownerStage) {
        this.ownerStage = ownerStage;
    }

    protected  WindowInit initModalityWindow(WindowInit windowInit, AbstractWindow window) {
        if (windowInit == null) {
            windowInit = new WindowInit(window.getProperties());
            windowInit.initModality(this.getOwnerStage());
        }
        return windowInit;
    }

}
