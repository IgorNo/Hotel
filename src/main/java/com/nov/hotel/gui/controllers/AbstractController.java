package com.nov.hotel.gui.controllers;

import com.nov.hotel.gui.controllers.interfaces.Controller;
import com.nov.hotel.gui.windows.WindowInit;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public abstract class AbstractController {

    protected void initModality(ActionEvent actionEvent, WindowInit priceListWindow) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        priceListWindow.initModality(stage);
    }

}
