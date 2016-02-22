package com.nov.hotel.gui.controllers;

import com.nov.hotel.gui.windows.AuthorWindow;
import com.nov.hotel.gui.windows.MainWindow;
import javafx.event.ActionEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginController extends AbstractController {

    public void login(ActionEvent actionEvent) throws IOException {
//        AuthorWindow.hide();
        MainWindow.create();
        MainWindow.show();
    }
}
