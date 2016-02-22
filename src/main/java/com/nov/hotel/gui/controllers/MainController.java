package com.nov.hotel.gui.controllers;


import com.nov.hotel.gui.windows.*;
import javafx.event.ActionEvent;
import javafx.stage.Modality;

import java.io.IOException;

public class MainController {


    public void hotelSettling(ActionEvent actionEvent) {
        SettlingWindow.create();
        SettlingWindow.show();
    }

    public void editPriceList(ActionEvent actionEvent) {
        PriceListWindow.create();
        PriceListWindow.initModality(MainWindow.getStage());
    }

    public void editAppartments(ActionEvent actionEvent) {
        AppartmentsWindow.create();
        AppartmentsWindow.show();
    }

    public void editServices(ActionEvent actionEvent) {
        ServicesWindow.create();
        ServicesWindow.show();
    }

    public void editAppartmentStatus(ActionEvent actionEvent) {
        AppartStatusWindow.create();
        AppartStatusWindow.show();
    }
}
