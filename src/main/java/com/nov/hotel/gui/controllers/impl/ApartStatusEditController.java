package com.nov.hotel.gui.controllers.impl;

import com.nov.hotel.entities.ApartStatus;
import com.nov.hotel.gui.controllers.abstr.AbstractEditDialogController;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

import java.awt.*;

public class ApartStatusEditController extends AbstractEditDialogController<ApartStatus> {

    public TextField txtName;
    public ColorPicker colorPicker;

    @Override
    protected void fillField() {
        txtName.setText(getElem().getName());
        colorPicker.setPromptText(getElem().getColor());
    }

    @Override
    protected void saveField() {
        getElem().setName(txtName.getText());
        getElem().setColor(colorPicker.getValue().toString());
    }

    @Override
    protected ApartStatus copyElem(ApartStatus elem) {
        return new ApartStatus(elem);
    }

}
