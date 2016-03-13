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
    

    public void hotelSettling(ActionEvent actionEvent) {
        settlingWindow = SettlingWindow.getInstance();
        settlingWindow.initModality(MainWindow.getInstance().getStage());
        settlingWindow.showAndWait();
    }

    public void editPriceList(ActionEvent actionEvent) {
        if (priceListWindow == null) {
            priceListWindow = PriceListWindow.getInstance();
            initWindow(priceListWindow);
        }
        priceListWindow.showAndWait();
    }

    public void editAppartments(ActionEvent actionEvent) {
        if (apartmentsWindow == null) {
            apartmentsWindow = ApartmentsWindow.getInstance();
            initWindow(apartmentsWindow);
        }
        apartmentsWindow.showAndWait();
    }

    public void editServices(ActionEvent actionEvent) {
        servicesWindow = ServicesWindow.getInstance();
        servicesWindow.initModality(MainWindow.getInstance().getStage());
        servicesWindow.showAndWait();
    }

    public void editAppartmentStatus(ActionEvent actionEvent) {
        if (apartStatusWindow == null) {
            apartStatusWindow = ApartStatusWindow.getInstance();
            initWindow(apartStatusWindow);
        }
        apartStatusWindow.showAndWait();
    }

    public void actionClose(ActionEvent actionEvent) {
        System.exit(0);
    }

    private static void initWindow(final AbstractWindow window) {
        window.initModality(MainWindow.getInstance().getStage());
        window.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                AbstractTableController c = window.getLoader().getController();
                c.actionClose(null);
            }
        });
    }

}
