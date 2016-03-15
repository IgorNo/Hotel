package com.nov.hotel.gui.controllers.impl;

import com.nov.hotel.collections.impl.ApartTypeCollection;
import com.nov.hotel.collections.impl.ApartmentCollection;
import com.nov.hotel.collections.impl.BlockCollection;
import com.nov.hotel.collections.interfaces.ObservableCollection;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.entities.Apartment;
import com.nov.hotel.entities.Block;
import com.nov.hotel.gui.controllers.abstr.AbstractEditDialogController;
import com.nov.hotel.gui.windows.impl.BlockEditWindow;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ApartmentEditController extends AbstractEditDialogController<Apartment> {

    public ComboBox choicebBlock;
    public ComboBox choicebType;
    public TextField txtRoomNumber;
    public TextField txtnAdditionalSlot;
    public TextField txtLevel;
    public CheckBox chekbStatus;


    @Override
    protected void fillField() {
        txtRoomNumber.setText(getElem().getRoomNumber());
        txtnAdditionalSlot.setText(Integer.toString(getElem().getnAdditionalSlot()));
        txtLevel.setText(Integer.toString(getElem().getLevelNumber()));
        chekbStatus.setSelected(getElem().getStatus());

        ObservableCollection<Block> blocks = BlockCollection.getInstance();
        blocks.fillData();

        choicebBlock.getItems().clear();
        choicebBlock.getItems().addAll();
        choicebBlock.getSelectionModel().select(getElem().getBlock());
        ObservableCollection<ApartType> types = ApartTypeCollection.getInstance();
        types.fillData();
    }

    @Override
    protected void saveField() {

    }

    @Override
    protected Apartment copyElem(Apartment elem) {
        return null;
    }

    public void selectBlock(ActionEvent actionEvent) {
    }

    public void selectType(ActionEvent actionEvent) {
    }
}
