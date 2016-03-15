package com.nov.hotel.gui.controllers;


import com.nov.hotel.gui.controllers.abstr.AbstractController;
import com.nov.hotel.gui.controllers.abstr.AbstractTableController;
import com.nov.hotel.gui.windows.impl.AbstractWindow;
import com.nov.hotel.gui.windows.impl.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class MainController extends AbstractController {

    AbstractWindow settlingWindow;
    AbstractWindow priceListWindow;
    AbstractWindow apartmentsWindow;
    AbstractWindow servicesWindow;
    AbstractWindow apartStatusWindow;
    AbstractWindow blocksWindow;
    

    public void hotelSettling(ActionEvent actionEvent) {
        settlingWindow = SettlingWindow.getInstance();
        settlingWindow.initOwner(MainWindow.getInstance().getStage());
        settlingWindow.showAndWait();
    }

    public void editPriceList(ActionEvent actionEvent) {
        priceListWindow = PriceListWindow.getInstance();
        priceListWindow.initOwner(MainWindow.getInstance().getStage());
        priceListWindow.showAndWait();
    }

    public void editAppartments(ActionEvent actionEvent) {
        apartmentsWindow = ApartmentsWindow.getInstance();
        apartmentsWindow.initOwner(MainWindow.getInstance().getStage());
        apartmentsWindow.showAndWait();
    }

    public void editServices(ActionEvent actionEvent) {
        servicesWindow = ServicesWindow.getInstance();
        servicesWindow.initOwner(MainWindow.getInstance().getStage());
        servicesWindow.showAndWait();
    }

    public void editAppartmentStatus(ActionEvent actionEvent) {
        apartStatusWindow = ApartStatusWindow.getInstance();
        apartStatusWindow.initOwner(MainWindow.getInstance().getStage());
        apartStatusWindow.showAndWait();
    }

    public void editBlocks(ActionEvent actionEvent) {
        blocksWindow = BlockWindow.getInstance();
        blocksWindow.initOwner(MainWindow.getInstance().getStage());
        blocksWindow.showAndWait();
    }

    public void actionClose(ActionEvent actionEvent) {
        System.exit(0);
    }

}
