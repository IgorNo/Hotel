package com.nov.hotel.gui.controllers.abstr;

import com.nov.hotel.gui.controllers.interfaces.Controller;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public abstract class AbstractController implements Controller {

    Stage itsStage;

    public Stage getItsStage() {
        return itsStage;
    }

    public void setItsStage(Stage itsStage) {
        this.itsStage = itsStage;
    }

    protected void closeWindow(){
        itsStage.hide();
    }

    abstract public void actionClose(ActionEvent actionEvent);

}
