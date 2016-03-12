package com.nov.hotel.gui.controllers.impl;

import com.nov.hotel.collections.impl.ApartTypeCollection;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.gui.controllers.abstr.AbstractTableController;
import com.nov.hotel.gui.windows.impl.AbstractWindow;
import com.nov.hotel.gui.windows.impl.PriceListEditWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PriceListController extends AbstractTableController<ApartType> {

    @FXML
    public TableView tableAppartType;

    @FXML
    public TableColumn<ApartType, String> columnRoomType;
    @FXML
    public TableColumn<ApartType, Integer> columnSizing;
    @FXML
    public TableColumn<ApartType, Float> columnPrice1;
    @FXML
    public TableColumn<ApartType, Float> columnPrice2;
    @FXML
    public TableColumn<ApartType, Float> columnPrice3;



    @Override
    protected void initData() {
        setEditWindow(PriceListEditWindow.getInstance());
        setCollection(new ApartTypeCollection());
        columnRoomType.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnSizing.setCellValueFactory(new PropertyValueFactory<>("sizing"));
        columnPrice1.setCellValueFactory(new PropertyValueFactory<>("price1"));
        columnPrice2.setCellValueFactory(new PropertyValueFactory<>("price2"));
        columnPrice3.setCellValueFactory(new PropertyValueFactory<>("price3"));
    }

    @Override
    protected TableView getTable() {
        return tableAppartType;
    }

    @Override
    protected boolean isElemFound(ApartType elem) {

        return elem.getName().toLowerCase().contains(txtFind.getText().toLowerCase());
    }

    public void add(ActionEvent actionEvent) {
        addAbst(new ApartType());
    }

    public void copyAndEdit(ActionEvent actionEvent) {
        addAbst(new ApartType((ApartType) getTable().getSelectionModel().getSelectedItem()));
    }

}
