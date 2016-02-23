package com.nov.hotel.gui.controllers;


import com.nov.hotel.gui.windows.*;
import com.nov.hotel.gui.windows.properties.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MainController extends AbstractController{

    public void hotelSettling(ActionEvent actionEvent) {
        WindowInit settlingWindow = new WindowInit(new SettlingWindow().getProperties());
        initModality(actionEvent, settlingWindow);
    }

    public void editPriceList(ActionEvent actionEvent) {
        WindowInit priceListWindow = new WindowInit(new PriceListWindow().getProperties());
        priceListWindow.initModality(getOwnerStage());
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
    protected void initModality(ActionEvent actionEvent, WindowInit window) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        window.initModality(stage);
    }

}
