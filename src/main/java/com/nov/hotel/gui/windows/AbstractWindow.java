package com.nov.hotel.gui.windows;

abstract class AbstractWindow {

    static class Properties {
        protected String fxmlFile;
        protected String header;
        protected String style;
        protected Boolean isResize;
        protected int minHeight;
        protected int minWidth;
//        protected Modality modality = Modality.NONE;
//        protected Stage ownerStage;
    }

    protected AbstractWindow.Properties properties;

    public Properties getProperties(){
        return properties;
    }

    protected AbstractWindow setProperties(AbstractWindow.Properties properties) {
        this.properties = properties;
        return this;
    }
}
