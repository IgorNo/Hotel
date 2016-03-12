package com.nov.hotel.gui.controllers.abstr;

import com.nov.hotel.gui.controllers.interfaces.Controller;
import com.nov.hotel.gui.windows.impl.AbstractWindow;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public abstract class AbstractController implements Controller {

    Stage ownerStage;

    public Stage getOwnerStage() {
        return ownerStage;
    }

    public void setOwnerStage(Stage ownerStage) {
        this.ownerStage = ownerStage;
    }

    protected void closeWindow(){
        ownerStage.hide();
    }

}
