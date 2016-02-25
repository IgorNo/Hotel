package com.nov.hotel.gui.windows.properties;

public abstract class AbstractWindow {

    public static class Properties {
        protected String fxmlFile;
        protected String header;
        protected String style;
        protected Boolean isResize;
        protected int minHeight;
        protected int minWidth;
//        protected Modality modality = Modality.NONE;
//        protected Stage ownerStage;

        public String getFxmlFile() {
            return fxmlFile;
        }

        public String getHeader() {
            return header;
        }

        public String getStyle() {
            return style;
        }

        public Boolean getResize() {
            return isResize;
        }

        public int getMinHeight() {
            return minHeight;
        }

        public int getMinWidth() {
            return minWidth;
        }
    }

    protected AbstractWindow.Properties properties = new Properties();

    public Properties getProperties(){
        return properties;
    }

    protected AbstractWindow setProperties(AbstractWindow.Properties properties) {
        this.properties = properties;
        return this;
    }


}
