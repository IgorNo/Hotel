package com.nov.hotel.gui.controllers;


import com.nov.hotel.gui.controllers.abstr.AbstractController;
import com.nov.hotel.gui.windows.impl.AbstractWindow;
import com.nov.hotel.gui.windows.impl.*;
import javafx.event.ActionEvent;

public class MainController extends AbstractController {

    AbstractWindow settlingWindow;
    AbstractWindow priceListWindow;
    AbstractWindow apartmentsWindow;
    AbstractWindow servicesWindow;
    AbstractWindow apartStatusWindow;
    

    public void hotelSettling(ActionEvent actionEvent) {
        settlingWindow = SettlingWindow.getInstance();
        settlingWindow.initModality(MainWindow.getInstance().getStage());
        settlingWindow.showAndWait();
    }

    public void editPriceList(ActionEvent actionEvent) {
        if (priceListWindow == null) {
            priceListWindow = PriceListWindow.getInstance();
            priceListWindow.initModality(MainWindow.getInstance().getStage());
        }
        priceListWindow.showAndWait();
    }

    public void editAppartments(ActionEvent actionEvent) {
        apartmentsWindow = ApartmentsWindow.getInstance();
        apartmentsWindow.initModality(MainWindow.getInstance().getStage());
        apartmentsWindow.showAndWait();
    }

    public void editServices(ActionEvent actionEvent) {
        servicesWindow = ServicesWindow.getInstance();
        servicesWindow.initModality(MainWindow.getInstance().getStage());
        servicesWindow.showAndWait();
    }

    public void editAppartmentStatus(ActionEvent actionEvent) {
        apartStatusWindow = ApartStatusWindow.getInstance();
        apartStatusWindow.initModality(MainWindow.getInstance().getStage());
        apartStatusWindow.showAndWait();
    }

    public void actionClose(ActionEvent actionEvent) {
        System.exit(0);
    }

}
