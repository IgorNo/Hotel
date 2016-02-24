package com.nov.hotel.gui.controllers;


import com.nov.hotel.gui.windows.*;
import com.nov.hotel.gui.windows.properties.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MainController extends AbstractController{

    WindowInit settlingWindow;
    WindowInit priceListWindow;
    WindowInit apartmentsWindow;
    WindowInit servicesWindow;
    WindowInit apartStatusWindow;
    

    public void hotelSettling(ActionEvent actionEvent) {
        settlingWindow = initModalityWindow(settlingWindow, new SettlingWindow());
        settlingWindow.showAndWait();
    }

    public void editPriceList(ActionEvent actionEvent) {
        priceListWindow = initModalityWindow(priceListWindow, new PriceListWindow());
        priceListWindow.showAndWait();
    }

    public void editAppartments(ActionEvent actionEvent) {
        apartmentsWindow = initModalityWindow(apartmentsWindow, new ApartmentsWindow());
        apartmentsWindow.showAndWait();
    }

    public void editServices(ActionEvent actionEvent) {
        servicesWindow = initModalityWindow(servicesWindow, new ServicesWindow());
        servicesWindow.showAndWait();
    }

    public void editAppartmentStatus(ActionEvent actionEvent) {
        apartStatusWindow = initModalityWindow(apartStatusWindow, new ApartStatusWindow());
        apartStatusWindow.showAndWait();
    }

    public void actionClose(ActionEvent actionEvent) {
        System.exit(0);
    }

}
