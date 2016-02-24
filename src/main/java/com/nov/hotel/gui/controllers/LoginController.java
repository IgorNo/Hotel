package com.nov.hotel.gui.controllers;

import com.nov.hotel.gui.windows.properties.MainWindow;
import com.nov.hotel.gui.windows.WindowInit;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginController {

    public void login(ActionEvent actionEvent) throws IOException {
//        AuthorWindow.hide();
        WindowInit mainWindow = new WindowInit(new MainWindow().getProperties());
      //  mainWindow.getController().setOwnerStage(mainWindow.getStage());
        mainWindow.show();
    }
}
