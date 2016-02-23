package com.nov.hotel.gui.controllers;

import com.nov.hotel.entities.AppartType;

import java.util.ResourceBundle;

public class PriceListEditController extends AbstractController {

    private AppartType appartType;

    private ResourceBundle resourceBundle;



    public void setAppType(AppartType appartType) {
        if (appartType == null){
            return;
        }
        this.appartType = appartType;
//        txtName.setText(person.getFio());
//        txtPhone.setText(person.getPhone());
    }

    public AppartType getAppartType() {
        return appartType;
    }

}
