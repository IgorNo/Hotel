package com.nov.hotel.gui.controllers;


import com.nov.hotel.gui.windows.*;
import com.nov.hotel.gui.windows.properties.*;
import javafx.event.ActionEvent;

public class MainController extends AbstractController{

    WindowInit settlingWindow;
    WindowInit priceListWindow;
    WindowInit apartmentsWindow;
    WindowInit servicesWindow;
    WindowInit apartStatusWindow;
    

    public void hotelSettling(ActionEvent actionEvent) {
        initModalityWindow(settlingWindow);
        settlingWindow.showAndWait();
    }

    public void editPriceList(ActionEvent actionEvent) {
        initModalityWindow(priceListWindow);
        priceListWindow.showAndWait();
    }

    public void editAppartments(ActionEvent actionEvent) {
        initModalityWindow(apartmentsWindow);
        apartmentsWindow.showAndWait();
    }

    public void editServices(ActionEvent actionEvent) {
        initModalityWindow(servicesWindow); 
        servicesWindow.showAndWait();
    }

    public void editAppartmentStatus(ActionEvent actionEvent) {
        initModalityWindow(apartStatusWindow);
        apartStatusWindow.showAndWait();
    }
    protected void initModalityWindow(WindowInit window) {
        if (window != null) {
            window = new WindowInit(new ApartStatusWindow().getProperties());
            window.initModality(this.getOwnerStage());
        } 
    }


}
