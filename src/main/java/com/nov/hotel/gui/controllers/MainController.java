package com.nov.hotel.gui.controllers;


import com.nov.hotel.gui.windows.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends AbstractController{

    public void hotelSettling(ActionEvent actionEvent) {
        WindowInit settlingWindow = new WindowInit(new SettlingWindow().getProperties());
        initModality(actionEvent, settlingWindow);
    }

    public void editPriceList(ActionEvent actionEvent) {
        WindowInit priceListWindow = new WindowInit(new PriceListWindow().getProperties());
        initModality(actionEvent, priceListWindow);
    }

    public void editAppartments(ActionEvent actionEvent) {
        WindowInit appartmentsWindow = new WindowInit(new AppartmentsWindow().getProperties());
        initModality(actionEvent, appartmentsWindow);
    }

    public void editServices(ActionEvent actionEvent) {
        WindowInit servicesWindow = new WindowInit(new ServicesWindow().getProperties());
        initModality(actionEvent, servicesWindow);
    }

    public void editAppartmentStatus(ActionEvent actionEvent) {
        WindowInit appartStatusWindow = new WindowInit(new AppartStatusWindow().getProperties());
        initModality(actionEvent, appartStatusWindow);
    }

}
