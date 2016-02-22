package com.nov.hotel.gui.controllers;

import com.nov.hotel.collections.impl.AppartTypeCollecImpl;
import com.nov.hotel.collections.interfaces.ObservaableCollection;
import com.nov.hotel.entities.AppartType;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PriceListController implements Initializable {

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

    private ObservaableCollection<AppartType> price = new AppartTypeCollecImpl();
    private PriceListEditController editDialogController;
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

            initListeners();
            updateCountLabel();
        }

    }

    private void initListeners() {
        price.getList().addListener(new ListChangeListener<AppartType>() {
            @Override
            public void onChanged(Change<? extends AppartType> c) {
                updateCountLabel();
            }
        });


        tableAppartType.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    editDialogController.setAppType((AppartType) tableAppartType.getSelectionModel().getSelectedItem());
//                    showDialog();
                }
            }
        });

    }

    public void print(ActionEvent actionEvent) {
    }

    public void prefPrint(ActionEvent actionEvent) {
    }

    public void exit(ActionEvent actionEvent) {
    }

    public void add(ActionEvent actionEvent) {
//        editDialogController.setPerson(new Person());
//        showDialog();
//        addressBookImpl.add(editDialogController.getPerson());
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
