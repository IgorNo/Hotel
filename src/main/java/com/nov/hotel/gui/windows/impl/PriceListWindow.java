package com.nov.hotel.gui.windows.impl;

import javafx.stage.Modality;

public class PriceListWindow  extends AbstractWindow {

    private static AbstractWindow uniqueWindow;

    private PriceListWindow() {
        properties.fxmlFile = "/fxml/pricelist.fxml";
        properties.header = "header.price.list";
        properties.style = "/styles/styles.css";
        properties.isResize = true;
        properties.minWidth = 715;
        properties.minHeight = 432;
        properties.modality = Modality.WINDOW_MODAL;
        init();
    }

    public static AbstractWindow getInstance() {
        if (uniqueWindow == null){
            uniqueWindow = new PriceListWindow();
        }
        return uniqueWindow;
    }

    public void close(){
        super.close();
        uniqueWindow = null;
    }
}
