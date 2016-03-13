package com.nov.hotel.gui.windows.impl;

public class ApartmentEditWindow extends AbstractWindow {

    private static AbstractWindow uniqueWindow;

    private ApartmentEditWindow() {
        properties.fxmlFile = "/fxml/apartment-edit.fxml";
        properties.header = "header.edit.appartment";
        properties.style = "/styles/styles.css";
        properties.isResize = false;
        init();
    }

    public static AbstractWindow getInstance() {
        if (uniqueWindow == null){
            uniqueWindow = new ApartmentEditWindow();
        }
        return uniqueWindow;
    }

    public void close(){
        super.close();
        uniqueWindow = null;
    }

}
