package com.nov.hotel.gui.controllers;

import com.nov.hotel.collections.interfaces.ObservaableCollection;
import com.nov.hotel.gui.windows.DialogManager;
import com.nov.hotel.gui.windows.WindowInit;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

abstract class AbstractTableController <E> extends AbstractController implements Initializable {

    private ObservaableCollection<E> collection;

    private WindowInit window;

    private AbstractEditDialogController edController;

    private ObservableList<E> backupList = FXCollections.observableArrayList();

    private ResourceBundle rBundle;

    abstract protected void initData();

    abstract protected TableView getTable();

    abstract protected boolean isElemFound(E elem);

    @FXML
    // Pattern Template Method
    public void initialize(URL location, ResourceBundle resources) {
        this.rBundle = resources;
        initData();
        edController = window.getLoader().getController();
        fillData();
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    protected void initListeners(Label label) {

        collection.getList().addListener(new ListChangeListener<E>() {
            @Override
            public void onChanged(Change<? extends E> c) {
                updateCountLabel(label);
            }
        });

        getTable().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    edController.setElem((E) getTable().getSelectionModel().getSelectedItem());
                    showDialog();
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

    public void change(ActionEvent actionEvent) {
        E elem = (E) getTable().getSelectionModel().getSelectedItem();
        if (!elemIsSelected(elem)) {
            return;
        }
        edController.setElem(elem);
        showDialog();
        if (edController.isSaveAction() && collection.update((E) edController.getElem()) == null) {
            DialogManager.showErrorDialog(rBundle.getString("message.error"), rBundle.getString("message.error.database"));
            showDialog();
        }
    }

    public void delete(ActionEvent actionEvent) {
        E elem = (E) getTable().getSelectionModel().getSelectedItem();
        if (!elemIsSelected(elem)) {
            return;
        }
        if (collection.delete(elem) == null) {
            DialogManager.showErrorDialog(rBundle.getString("message.error"), rBundle.getString("message.error.database"));
            delete(actionEvent);
        }
    }

    public void find(ActionEvent actionEvent) {
        collection.getList().clear();

        for (E elem : backupList) {
            if (isElemFound(elem)) {
                collection.getList().add(elem);
            }
        }
    }

    public void help(ActionEvent actionEvent) {

    }

    protected void addAbst(E elem) {
        editElem(elem);
        if (edController.isSaveAction() && collection.add((E) edController.getElem()) == null) {
            DialogManager.showErrorDialog(rBundle.getString("message.error"), rBundle.getString("message.error.database"));
            addAbst(elem);
        }
    }

    private void editElem(E elem){
        edController.setElem(elem);
        showDialog();
        return;
    }

    protected void setWindow(WindowInit window) {
        this.window = window;
    }

    protected void setCollection(ObservaableCollection<E> collection) {
        this.collection = collection;
    }

    private void fillData() {
        collection.fillData();
        backupList.addAll(collection.getList());
        getTable().setItems(collection.getList());
    }

    private boolean elemIsSelected(E elem) {
        if(elem == null){
            DialogManager.showInfoDialog(rBundle.getString("message.error"), rBundle.getString("message.select.element"));
            return false;
        }
        return true;
    }

    private void showDialog() {
        window.showAndWait(); // wait close
    }

    private void updateCountLabel(Label label) {
        label.setText(rBundle.getString("label.records") + ": " + collection.getList().size());
    }

}
