package com.nov.hotel.gui.controllers;

import com.nov.hotel.gui.windows.impl.AbstractWindow;
import com.nov.hotel.gui.windows.impl.MainWindow;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginController {

    public void login(ActionEvent actionEvent) throws IOException {
//        AuthorWindow.hide();
        AbstractWindow mainWindow = MainWindow.getInstance();
        mainWindow.show();
    }
}
