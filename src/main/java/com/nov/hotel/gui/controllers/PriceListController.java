package com.nov.hotel.gui.controllers;

import com.nov.hotel.collections.impl.ApartTypeCollecImpl;
import com.nov.hotel.entities.AppartType;
import com.nov.hotel.gui.windows.properties.PriceListEditWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PriceListController extends AbstractTableController<AppartType> {

    @FXML
    public Label labelCount;

    @FXML
    public TableView tableAppartType;

    @FXML
    public TableColumn<AppartType, String> columnRoomType;
    @FXML
    public TableColumn<AppartType, Float> columnPrice1;
    @FXML
    public TableColumn<AppartType, Float> columnPrice2;
    @FXML
    public TableColumn<AppartType, Float> columnPrice3;

    public TextField txtFind;


    @Override
    protected void initData() {
        setWindow(initModalityWindow(null, new PriceListEditWindow()));
        setCollection(new ApartTypeCollecImpl());
        columnRoomType.setCellValueFactory(new PropertyValueFactory<AppartType, String>("name"));
        columnPrice1.setCellValueFactory(new PropertyValueFactory<AppartType, Float>("price1"));
        columnPrice2.setCellValueFactory(new PropertyValueFactory<AppartType, Float>("price2"));
        columnPrice3.setCellValueFactory(new PropertyValueFactory<AppartType, Float>("price3"));
    }

    @Override
    protected TableView getTable() {
        return tableAppartType;
    }

    @Override
    protected boolean isElemFound(AppartType elem) {

        return elem.getName().toLowerCase().contains(txtFind.getText().toLowerCase());
    }

    public void add(ActionEvent actionEvent) {
        addAbst(new AppartType());
    }

}
