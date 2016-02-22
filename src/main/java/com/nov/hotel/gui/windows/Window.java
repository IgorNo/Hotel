package com.nov.hotel.gui.windows;

import javafx.stage.Modality;
import javafx.stage.Stage;

abstract class Window {

    static class Properties {
        protected String fxmlFile;
        protected String header;
        protected String style;
        protected Boolean isResize;
        protected int minHeight;
        protected int minWidth;
        protected Modality modality = Modality.NONE;
        protected Stage ownerStage;
    }

    protected static Properties getProperties(){
        return new Properties();
    }

}
