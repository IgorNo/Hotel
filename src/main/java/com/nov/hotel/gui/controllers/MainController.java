package com.nov.hotel.gui.controllers;


import com.nov.hotel.gui.windows.*;
import javafx.event.ActionEvent;
import javafx.stage.Modality;

import java.io.IOException;

public class MainController {


    public void hotelSettling(ActionEvent actionEvent) throws IOException {
        SettlingWindow.create();
        SettlingWindow.show();
    }

    public void editPriceList(ActionEvent actionEvent) throws IOException{
        PriceListWindow.create();
        PriceListWindow.getStage().initModality(Modality.WINDOW_MODAL);
        PriceListWindow.getStage().initOwner(MainWindow.getStage());
        PriceListWindow.getStage().showAndWait();
    }

    public void editAppartments(ActionEvent actionEvent) throws IOException{
        AppartmentsWindow.create();
        AppartmentsWindow.show();
    }

    public void editServices(ActionEvent actionEvent) throws IOException{
        ServicesWindow.create();
        ServicesWindow.show();
    }

    public void editAppartmentStatus(ActionEvent actionEvent) throws IOException{
        AppartStatusWindow.create();
        AppartStatusWindow.show();
    }
}
