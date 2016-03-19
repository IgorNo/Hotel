package com.nov.hotel.gui.controllers.impl;

import com.nov.hotel.collections.impl.ApartTypeCollection;
import com.nov.hotel.collections.impl.BlockCollection;
import com.nov.hotel.collections.interfaces.ObservableCollection;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.entities.Apartment;
import com.nov.hotel.entities.Block;
import com.nov.hotel.gui.controllers.abstr.AbstractEditDialogController;
import com.nov.hotel.gui.controllers.abstr.AbstractTableController;
import com.nov.hotel.gui.windows.impl.AbstractWindow;
import com.nov.hotel.gui.windows.impl.ApartmentsWindow;
import com.nov.hotel.gui.windows.impl.BlockWindow;
import com.nov.hotel.gui.windows.impl.ApartTypeWindow;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ApartmentEditController extends AbstractEditDialogController<Apartment> {

    public ComboBox comboBlock;
    public ComboBox comboType;
    public TextField txtRoomNumber;
    public TextField txtLevel;
    public CheckBox chekbStatus;

    ObservableCollection<Block> blocks = BlockCollection.getInstance();
    ObservableCollection<ApartType> types = ApartTypeCollection.getInstance();

    @Override
    protected void fillField() {
        txtRoomNumber.setText(getElem().getRoomNumber());
        txtLevel.setText(Integer.toString(getElem().getLevelNumber()));
        chekbStatus.setSelected(getElem().getStatus());
        blocks.fillData();
        comboBlock.getItems().clear();
        for (Block s:blocks.getList()) {
            comboBlock.getItems().add(s.getName());
        }
        comboBlock.getSelectionModel().select(getElem().getBlock().getName());
        types.fillData();
        comboType.getItems().clear();
        for (ApartType s:types.getList()) {
            comboType.getItems().add(s.getName());
        }
        comboType.getSelectionModel().select(getElem().getType().getName());
    }

    @Override
    protected void saveField() {
        getElem().setRoomNumber(txtRoomNumber.getText());
        getElem().setLevelNumber(Integer.parseInt(txtLevel.getText()));
        getElem().setStatus(chekbStatus.isSelected());
        int selectedElement = comboBlock.getSelectionModel().getSelectedIndex();
        if (selectedElement>=0) {
            Block block = blocks.getList().get(selectedElement);
            getElem().setBlock(block);
        }
        selectedElement = comboType.getSelectionModel().getSelectedIndex();
        if (selectedElement>=0) {
            ApartType type = types.getList().get(selectedElement);
            getElem().setType(type);
        }
    }

    @Override
    protected Apartment copyElem(Apartment elem) {
        return new Apartment(elem);
    }

    public void selectBlock(ActionEvent actionEvent) {
        AbstractWindow window = BlockWindow.getInstance();
        window.initOwner(ApartmentsWindow.getInstance().getStage());
        window.showAndWait();
        AbstractTableController<Block> controller = window.getLoader().getController();
        comboBlock.getItems().clear();
        comboBlock.getItems().addAll(blocks.getList());
        if (controller.getSelectedElem() != null) {
            comboBlock.getSelectionModel().select(controller.getSelectedElem().getName());
        }
    }

    public void selectType(ActionEvent actionEvent) {
        AbstractWindow window = ApartTypeWindow.getInstance();
        window.initOwner(ApartmentsWindow.getInstance().getStage());
        window.showAndWait();
        AbstractTableController<ApartType> controller = window.getLoader().getController();
        comboType.getItems().clear();
        comboType.getItems().addAll(types.getList());
        if (controller.getSelectedElem() != null) {
            comboType.getSelectionModel().select(controller.getSelectedElem().getName());
        }
    }
}
