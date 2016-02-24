package com.nov.hotel.gui.controllers;

import com.nov.hotel.entities.AppartType;
import com.nov.hotel.gui.windows.DialogManager;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PriceListEditController extends AbstractEditDialogController<AppartType> {

    public TextField txtName;
    public TextField txtPrice1;
    public TextField txtPrice2;
    public TextField txtPrice3;
    public TextField txtSizing;


    @Override
    protected void fillField() {
        txtName.setText(getElem().getName());
        txtSizing.setText(Integer.toString(getElem().getSizing()));
        txtPrice1.setText(Float.toString(getElem().getPrice1()));
        txtPrice2.setText(Float.toString(getElem().getPrice2()));
        txtPrice3.setText(Float.toString(getElem().getPrice3()));
    }

    @Override
    protected void saveField() {
        getElem().setName(txtName.getText());
        getElem().setSizing(Integer.parseInt(txtSizing.getText()));
        getElem().setPrice1(Float.parseFloat(txtPrice1.getText()));
        getElem().setPrice2(Float.parseFloat(txtPrice2.getText()));
        getElem().setPrice3(Float.parseFloat(txtPrice3.getText()));
    }

    @Override
    protected boolean isFieldsNotEmpty() {
        if (txtName.getText().trim().length() == 0 || txtPrice1.getText().trim().length() == 0
                || txtPrice2.getText().trim().length() == 0 || txtPrice3.getText().trim().length() == 0) {
            return false;
        }
        return true;
    }

    @Override
    protected AppartType copyElem(AppartType elem) {
        return new AppartType(elem);
    }

    @Override
    protected void assign(AppartType leftValue, AppartType rightValue) {
        leftValue.assign(rightValue);
    }
}