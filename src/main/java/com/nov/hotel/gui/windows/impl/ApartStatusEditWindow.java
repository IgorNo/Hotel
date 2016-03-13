package com.nov.hotel.gui.windows.impl;

public class ApartStatusEditWindow extends AbstractWindow {

    private static ApartStatusEditWindow uniqueWindow;

    private ApartStatusEditWindow() {
        properties.fxmlFile = "/fxml/apart_status-edit.fxml";
        properties.header = "header.edit.appart.status";
        properties.style = "/styles/styles.css";
        properties.isResize = false;
//        properties.minWidth = 557;
//        properties.minHeight = 126;
        init();
    }

    public static AbstractWindow getInstance() {
        if (uniqueWindow == null){
            uniqueWindow = new ApartStatusEditWindow();
        }
        return uniqueWindow;
    }

    public void close(){
        super.close();
        uniqueWindow = null;
    }


}
