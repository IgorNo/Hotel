package com.nov.hotel.gui.controllers.impl;

import com.nov.hotel.entities.Client;
import com.nov.hotel.gui.controllers.abstr.AbstractController;
import com.nov.hotel.gui.controllers.abstr.AbstractEditDialogController;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

public class ClientEditController extends AbstractEditDialogController<Client> {

    public TextField txtSurname;
    public TextField txtName;
    public TextField txtPatronymic;
    public DatePicker dateBirthday;

    public ToolBar toolbarSex;
    public ToggleGroup tgSex;
    public RadioButton rbtnMan;
    public RadioButton rbtnWoman;
    
    public ComboBox comboCitizenship;
    public Button btnCitizenship;
    
    public ComboBox comboDocType;
    public TextField txtDocSeries;
    public TextField txtDocNumber;
    public DatePicker dateDocDate;
    public TextArea txtDocIssue;
    
    public ComboBox comboCountry;
    public Button btnCountry;
    public ComboBox comboRegion;
    public Button btnRegion;
    public TextArea txtAddress;
    
    public ComboBox comboType;
    public Button btnType;
    public TextField txtDiscount;


    @Override
    protected void fillField() {
        txtSurname.setText(getElem().getSurname());
        validationSupport.registerValidator(txtSurname, Validator.createEmptyValidator(resourceBundle.getString("prompt.text")));
        txtName.setText(getElem().getName());
        validationSupport.registerValidator(txtName, Validator.createEmptyValidator(resourceBundle.getString("prompt.text")));
        txtPatronymic.setText(getElem().getPatronymic());
        dateBirthday.setValue(getElem().getBirthday());
        validationSupport.registerValidator(dateBirthday, Validator.createEmptyValidator(resourceBundle.getString("prompt.date")));
        rbtnMan.setSelected(getElem().getSex());

        txtDocSeries.setText(getElem().getDocSeries());
        validationSupport.registerValidator(txtDocSeries, Validator.createEmptyValidator(resourceBundle.getString("prompt.text")));
        txtDocNumber.setText(getElem().getDocNumber());
        validationSupport.registerValidator(txtDocNumber, Validator.createEmptyValidator(resourceBundle.getString("prompt.text")));
        txtDocIssue.setText(getElem().getDocIssue());
        validationSupport.registerValidator(txtDocIssue, Validator.createEmptyValidator(resourceBundle.getString("prompt.text")));
        dateDocDate.setValue(getElem().getDocDate());
        validationSupport.registerValidator(dateDocDate, Validator.createEmptyValidator(resourceBundle.getString("prompt.date")));

        txtAddress.setText(getElem().getAddress());
        validationSupport.registerValidator(txtAddress, Validator.createEmptyValidator(resourceBundle.getString("prompt.text")));

        txtDiscount.setText(Float.toString(getElem().getDiscount()));
    }

    @Override
    protected void saveField() {
        getElem().setSurname(txtSurname.getText()+" ");
        getElem().setName(txtName.getText()+" ");
        getElem().setPatronymic(txtPatronymic.getText());
        getElem().setBirthday(dateBirthday.getValue());

        getElem().setSex(rbtnMan.isSelected());

        getElem().setDocSeries(txtDocSeries.getText());
        getElem().setDocNumber(txtDocNumber.getText());
        getElem().setDocIssue(txtDocIssue.getText());
        getElem().setDocDate(dateDocDate.getValue());

        getElem().setAddress(txtDocIssue.getText());

        getElem().setDiscount(Float.parseFloat(txtDiscount.getText()));
    }

    @Override
    protected Client copyElem(Client elem) {
        return new Client(elem);
    }
}
