package com.nov.hotel.gui.controllers;

import com.nov.hotel.collections.impl.AppartTypeCollecImpl;
import com.nov.hotel.collections.interfaces.ObservaableCollection;
import com.nov.hotel.entities.AppartType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PriceListController implements Initializable {

    public Label labelCount;

    public TableView tableAppartType;

    public TableColumn<AppartType, String> columnRoomType;
    public TableColumn<AppartType, Float> columnPrice1;
    public TableColumn<AppartType, Float> columnPrice2;
    public TableColumn<AppartType, Float> columnPrice3;

    private ObservaableCollection<AppartType> price = new AppartTypeCollecImpl();

    private ResourceBundle resourceBundle;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (price.getList() != null) {
            this.resourceBundle = resources;

            columnRoomType.setCellValueFactory(new PropertyValueFactory<AppartType, String>("name"));
            columnPrice1.setCellValueFactory(new PropertyValueFactory<AppartType, Float>("price1"));
            columnPrice2.setCellValueFactory(new PropertyValueFactory<AppartType, Float>("price2"));
            columnPrice3.setCellValueFactory(new PropertyValueFactory<AppartType, Float>("price3"));

            tableAppartType.setItems(price.getList());

            updateCountLabel();
        }

    }
    public void print(ActionEvent actionEvent) {
    }

    public void prefPrint(ActionEvent actionEvent) {
    }

    public void exit(ActionEvent actionEvent) {
    }

    public void add(ActionEvent actionEvent) {
    }

    public void change(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void help(ActionEvent actionEvent) {
    }

    public void about(ActionEvent actionEvent) {
    }

    public void copy(ActionEvent actionEvent) {
    }

    public void find(ActionEvent actionEvent) {
    }

    private void updateCountLabel() {
        labelCount.setText(resourceBundle.getString("label.records") + ": " + price.getList().size());
    }

}
