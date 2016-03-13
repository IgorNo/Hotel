package com.nov.hotel.gui.windows.impl;

public class BlockEditWindow extends AbstractWindow {

    private static AbstractWindow uniqueWindow;

    private BlockEditWindow() {
        properties.fxmlFile = "/fxml/block-edit.fxml";
        properties.header = "header.edit.block";
        properties.style = "/styles/styles.css";
        properties.isResize = false;
        init();
    }

    public static AbstractWindow getInstance() {
        if (uniqueWindow == null){
            uniqueWindow = new BlockEditWindow();
        }
        return uniqueWindow;
    }

    public void close(){
        super.close();
        uniqueWindow = null;
    }


}
