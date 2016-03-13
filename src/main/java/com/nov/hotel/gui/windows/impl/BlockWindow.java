package com.nov.hotel.gui.windows.impl;

public class BlockWindow extends AbstractWindow {

    private static AbstractWindow uniqueWindow;

    private BlockWindow() {
        properties.fxmlFile = "/fxml/block.fxml";
        properties.header = "header.block";
        properties.style = "/styles/styles.css";
        properties.isResize = true;
        properties.minWidth = 715;
        properties.minHeight = 432;
        init();
    }

    public static AbstractWindow getInstance() {
        if (uniqueWindow == null){
            uniqueWindow = new BlockWindow();
        }
        return uniqueWindow;
    }

    public void close(){
        super.close();
        uniqueWindow = null;
    }


}
