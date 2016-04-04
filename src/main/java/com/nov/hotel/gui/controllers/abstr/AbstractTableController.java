package com.nov.hotel.gui.controllers.abstr;

import com.nov.hotel.collections.interfaces.ObservableCollection;
import com.nov.hotel.entities.interfaces.Entity;
import com.nov.hotel.gui.windows.DialogManager;
import com.nov.hotel.gui.windows.impl.AbstractWindow;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

abstract public class AbstractTableController <E extends Entity> extends AbstractController implements Initializable {

    private ObservableCollection<E> collection;

    private AbstractWindow editWindow;

    private AbstractEditDialogController edController;

    private ObservableList<E> backupList = FXCollections.observableArrayList();

    protected ResourceBundle rBundle;

    private E selectedElem;

    @FXML
    public CustomTextField txtFind;
    @FXML
    public Label labelCount;

    private boolean isFind = true;

    private boolean isEdit;

    abstract protected void initData();

    abstract protected TableView getTable();

    abstract protected boolean isElemFound(E elem);

    @FXML
    // Pattern Template Method
    public void initialize(URL location, ResourceBundle resources) {
        this.rBundle = resources;
        initData();
        edController = editWindow.getLoader().getController();
        fillData();
        setupClearButtonField(txtFind);
        initListeners();
    }

    public E getSelectedElem() {
        return selectedElem;
    }


    private void setupClearButtonField(CustomTextField customTextField) {
        try {
            Method m = TextFields.class.getDeclaredMethod("setupClearButtonField", TextField.class, ObjectProperty.class);
            m.setAccessible(true);
            m.invoke(null, customTextField, customTextField.rightProperty());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actionClose(ActionEvent actionEvent) {
        if (!collection.getTransactionsEngine().isEmpty()) {
            Optional<ButtonType> result = DialogManager.showConfirmDialog(rBundle.getString("message.alert"), rBundle.getString("message.save.data"));
            if (result.get() == ButtonType.OK){
                save(actionEvent);
            } else {
                collection.getTransactionsEngine().clear();
            }
        }
        closeWindow();
        return;
    }

    public void save(ActionEvent actionEvent) {
        collection.getTransactionsEngine().run();
        if (collection.getTransactionsEngine().getExceptMess().size() > 0){
            String errMsg = "";
            for (int i = 0; i < collection.getTransactionsEngine().getExceptMess().size(); i++) {
                errMsg += collection.getTransactionsEngine().getExceptMess().get(i);
            }
            DialogManager.showErrorDialog(rBundle.getString("message.error"), errMsg);
        } else {
            DialogManager.showInfoDialog(rBundle.getString("message.information"), rBundle.getString("message.save"));
            collection.getTransactionsEngine().getExceptMess().clear();
        }

    }

    protected void initListeners() {

        collection.getList().addListener(new ListChangeListener<E>() {
            @Override
            public void onChanged(Change<? extends E> c) {
                updateCountLabel();
            }
        });

        getTable().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    select(null);
                }
            }
        });
    }

    public void print(ActionEvent actionEvent) {
    }

    public void prefPrint(ActionEvent actionEvent) {

    }


    public void change(ActionEvent actionEvent) {
        E elem = (E) getTable().getSelectionModel().getSelectedItem();
        if (!elemIsSelected(elem)) {
            return;
        }
        edController.setElem(elem);
        showDialog();
        if (edController.isSaveAction() && collection.update((E) edController.getElem()) == null) {
            DialogManager.showErrorDialog(rBundle.getString("message.error"), rBundle.getString("message.invalid.data"));
            showDialog();
        }
    }

    public void delete(ActionEvent actionEvent) {
        E elem = (E) getTable().getSelectionModel().getSelectedItem();
        if (!elemIsSelected(elem)) {
            return;
        }
        if (collection.delete(elem) == null) {
            DialogManager.showErrorDialog(rBundle.getString("message.error"), rBundle.getString("message.invalid.data"));
            delete(actionEvent);
        }
    }

    public void find(ActionEvent actionEvent) {
        if (isFind){
            backupList.clear();
            backupList.addAll(collection.getList());
            isFind = false;
        }

        collection.getList().clear();

        if (!txtFind.getText().isEmpty()) {
            for (E elem : backupList) {
                if (isElemFound(elem)) {
                    collection.getList().add(elem);
                }
            }
        } else {
            collection.getList().addAll(backupList);
            isFind = true;
        }
    }
    public void select(ActionEvent actionEvent) {
        selectedElem = (E) getTable().getSelectionModel().getSelectedItem();
        if(selectedElem == null){
            DialogManager.showInfoDialog(rBundle.getString("message.error"), rBundle.getString("message.select.element"));
            return;
        }
        actionClose(actionEvent);
    }

    public void help(ActionEvent actionEvent) {

    }

    protected void addAbst(E elem) {
        editElem(elem);
        if (edController.isSaveAction() && collection.add((E) edController.getElem()) == null) {
            DialogManager.showErrorDialog(rBundle.getString("message.error"), rBundle.getString("message.invalid.data"));
            addAbst(elem);
        }
    }

    private void editElem(E elem){
        edController.setElem(elem);
        showDialog();
        return;
    }

    protected void setEditWindow(AbstractWindow editWindow) {
        this.editWindow = editWindow;
    }

    protected void setCollection(ObservableCollection<E> collection) {
        this.collection = collection;
    }

    private void fillData() {
        collection.fillData();

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
        if (editWindow.getStage().getOwner() == null) {
            editWindow.initOwner(getItsStage());
            editWindow.getScene().getRoot().sceneProperty().addListener(new InvalidationListener() {
                @Override public void invalidated(Observable o) {
                    if (editWindow.getScene().getRoot().getScene() != null) {
                        editWindow.getScene().getRoot().getScene().getStylesheets().add(AbstractController.class.getResource("/styles/validation.css").toExternalForm());
                    }
                }
            });

        }
        editWindow.showAndWait(); // wait close
    }

    private void updateCountLabel() {
        labelCount.setText(rBundle.getString("label.records") + ": " + collection.getList().size());
    }

}
