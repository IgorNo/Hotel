package com.nov.hotel.gui.controllers.impl;

import com.nov.hotel.collections.impl.ApartStatusCollection;
import com.nov.hotel.entities.ApartStatus;
import com.nov.hotel.gui.controllers.abstr.AbstractTableController;
import com.nov.hotel.gui.windows.impl.AbstractWindow;
import com.nov.hotel.gui.windows.impl.ApartStatusEditWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;

public class ApartStatusController extends AbstractTableController<ApartStatus> {


    @FXML
    public TableView tableAppartStatus;
    @FXML
    public TableColumn<ApartStatus, String> columnName;
    @FXML
    public TableColumn<ApartStatus, String> columnColor;

    @Override
    protected void initData() {
        setEditWindow(ApartStatusEditWindow.getInstance());
        setCollection(new ApartStatusCollection());
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnColor.setCellValueFactory(new PropertyValueFactory<>("color"));
    }

    @Override
    protected TableView getTable() {
        return tableAppartStatus;
    }

    @Override
    protected boolean isElemFound(ApartStatus elem) {
        return elem.getName().toLowerCase().contains(txtFind.getText().toLowerCase());
    }

    public void add(ActionEvent actionEvent) {
        addAbst(new ApartStatus());
    }

    public void copyAndEdit(ActionEvent actionEvent) {
        addAbst(new ApartStatus((ApartStatus) getTable().getSelectionModel().getSelectedItem()));
    }
}
