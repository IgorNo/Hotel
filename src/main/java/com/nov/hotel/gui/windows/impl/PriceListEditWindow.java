package com.nov.hotel.gui.windows.impl;

import javafx.stage.Modality;

public class PriceListEditWindow extends AbstractWindow {

    private static AbstractWindow uniqueWindow;

    private PriceListEditWindow() {
        properties.fxmlFile = "/fxml/pricelist-edit.fxml";
        properties.header = "header.edit.price.list";
        properties.style = "/styles/styles.css";
        properties.isResize = false;
        properties.modality = Modality.WINDOW_MODAL;
        init();
    }

    public static AbstractWindow getInstance() {
        if (uniqueWindow == null){
            uniqueWindow = new PriceListEditWindow();
        }
        return uniqueWindow;
    }

    public void close(){
        super.close();
        uniqueWindow = null;
    }


}
