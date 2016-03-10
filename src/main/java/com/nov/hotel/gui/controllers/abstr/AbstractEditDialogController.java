package com.nov.hotel.gui.controllers.abstr;

import com.nov.hotel.gui.windows.DialogManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


abstract public class AbstractEditDialogController<E>  extends AbstractController implements Initializable {

    private E elem;

    private E backupElem;

    protected ResourceBundle resourceBundle;

    private boolean isSaveAction = false;

    abstract protected void  fillField();

    abstract protected void saveField();

    abstract protected boolean isFieldsNotEmpty();

    abstract protected E copyElem(E elem);

    abstract protected void assign(E leftValue, E rightValue);

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
    }
    // Pattern Template Method
    protected void setElem(E elem) {
        if (elem == null){
            return;

        }
        this.elem = elem;
        backupElem = copyElem(elem);
        fillField();
    }

    public boolean isSaveAction() {
        return isSaveAction;
    }

    protected E getElem() {
        return elem;
    }

    public void actionClose(ActionEvent actionEvent) {
        isSaveAction = false;
        assign(elem,backupElem);
        closeWindow(actionEvent);
    }


// Pattern Template Method
   public void actionSave(ActionEvent actionEvent) {
    try {
        saveField();
        isSaveAction = true;
        closeWindow(actionEvent);
    } catch (NumberFormatException e){
        DialogManager.showInfoDialog(resourceBundle.getString("message.error"), resourceBundle.getString("message.fill.field"));
        return;
    }
    }

    private void closeWindow(ActionEvent actionEvent){
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
