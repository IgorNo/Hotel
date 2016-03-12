package com.nov.hotel.gui.windows.impl;

public class ApartStatusWindow extends AbstractWindow {

    private static AbstractWindow uniqueWindow;

    private ApartStatusWindow() {
        properties.fxmlFile = "/fxml/apart_status.fxml";
        properties.header = "header.appart.status";
        properties.style = "/styles/styles.css";
        properties.isResize = true;
        properties.minWidth = 715;
        properties.minHeight = 432;
        init();
    }

    public static AbstractWindow getInstance() {
        if (uniqueWindow == null){
            uniqueWindow = new ApartStatusWindow();
        }
        return uniqueWindow;
    }

    public void close(){
        super.close();
        uniqueWindow = null;
    }

}
