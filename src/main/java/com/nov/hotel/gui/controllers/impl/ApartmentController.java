package com.nov.hotel.gui.controllers.impl;

import com.nov.hotel.collections.impl.ApartmentCollection;
import com.nov.hotel.entities.Apartment;
import com.nov.hotel.entities.interfaces.Entity;
import com.nov.hotel.gui.controllers.abstr.AbstractTableController;
import com.nov.hotel.gui.windows.impl.ApartmentEditWindow;
import com.nov.hotel.gui.windows.impl.ApartmentsWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ApartmentController extends AbstractTableController<Apartment> {

    @FXML
    public TableView tableAppartments;
    @FXML
    public TableColumn columnBlock;
    @FXML
    public TableColumn columnLevel;
    @FXML
    public TableColumn columnRoomNumber;
    @FXML
    public TableColumn columnSizing;
    @FXML
    public TableColumn columnRoomType;
    @FXML
    public TableColumn columnSlots;
    @FXML
    public TableColumn columnPrice1;
    @FXML
    public TableColumn columnPrice2;
    @FXML
    public TableColumn columnPrice3;
    @FXML
    public TableColumn columnRepair;

    @Override
    protected void initData() {
        setEditWindow(ApartmentEditWindow.getInstance());
        setCollection(new ApartmentCollection());
    }

    @Override
    protected TableView getTable() {
        return tableAppartments;
    }

    @Override
    protected boolean isElemFound(Apartment elem) {
        return false;
    }

    public void add(ActionEvent actionEvent) {
        addAbst(new Apartment());
    }

    public void copyAndEdit(ActionEvent actionEvent) {
        addAbst(new Apartment((Apartment) getTable().getSelectionModel().getSelectedItem()));
    }
}
