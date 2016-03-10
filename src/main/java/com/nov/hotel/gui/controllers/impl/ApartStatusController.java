package com.nov.hotel.gui.controllers.impl;

import com.nov.hotel.gui.controllers.abstr.AbstractTableController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ApartStatusController extends AbstractTableController {


    @FXML
    public TableView tableAppartType;
    @FXML
    public TableColumn columnRoomType;
    @FXML
    public TableColumn columnSizing;

    @Override
    protected void initData() {

    }

    @Override
    protected TableView getTable() {
        return null;
    }

    @Override
    protected boolean isElemFound(Object elem) {
        return false;
    }

    public void add(ActionEvent actionEvent) {
    }

    public void copyAndEdit(ActionEvent actionEvent) {
    }
}
