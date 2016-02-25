package com.nov.hotel.gui.windows.impl;


public class SettlingWindow extends AbstractWindow {

    private static AbstractWindow uniqueWindow;

    private SettlingWindow() {
        properties.fxmlFile = "/fxml/settling.fxml";
        properties.header = "header.settling";
        properties.style = "/styles/styles.css";
        properties.isResize = true;
        properties.minWidth = 715;
        properties.minHeight = 432;
        init();
    }

    public static AbstractWindow getInstance() {
        if (uniqueWindow == null){
            uniqueWindow = new SettlingWindow();
        }
        return uniqueWindow;
    }

    public void close(){
        super.close();
        uniqueWindow = null;
    }


}
