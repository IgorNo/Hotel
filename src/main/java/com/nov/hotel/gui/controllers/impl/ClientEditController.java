package com.nov.hotel.gui.controllers.impl;

import com.nov.hotel.collections.impl.ClientTypeCollection;
import com.nov.hotel.collections.impl.CountryCollection;
import com.nov.hotel.collections.impl.DocumTypeCollection;
import com.nov.hotel.collections.impl.RegionCollection;
import com.nov.hotel.collections.interfaces.ObservableCollection;
import com.nov.hotel.entities.*;
import com.nov.hotel.gui.controllers.abstr.AbstractController;
import com.nov.hotel.gui.controllers.abstr.AbstractEditDialogController;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.controlsfx.control.IndexedCheckModel;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.util.List;
import java.util.function.Predicate;

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


    ObservableCollection<Country> countries = CountryCollection.getInstance().fillData();
    ObservableCollection<DocumType> docTypes = DocumTypeCollection.getInstance().fillData();
    ObservableCollection<Region> regionsAll = RegionCollection.getInstance().fillData();
    ObservableCollection<ClientType> types = ClientTypeCollection.getInstance().fillData();

    ObservableList<Region> regionsCountry;

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

//        countries.fillData();
        comboCitizenship.setItems(countries.getList());
        comboCitizenship.getSelectionModel().select(getElem().getCitizenship());
        comboCountry.setItems(countries.getList());
        comboCountry.getSelectionModel().select(getElem().getRegionAddress().getCountry());
        comboCountry.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                    Country currCountry = (Country) comboCountry.getValue();
                    regionsCountry = regionsAll.getList().filtered((a) -> a.getCountry().getId().equals(currCountry.getId()));
                comboRegion.setItems(regionsCountry);
                if ( !regionsCountry.isEmpty() )
                    comboRegion.getSelectionModel().select(getElem().getRegionAddress());
                else
                    comboRegion.getSelectionModel().select(null);
            }
        });

//        docTypes.fillData();
        comboDocType.setItems(docTypes.getList());
        comboDocType.getSelectionModel().select(getElem().getDocType());

//        types.fillData();
        comboType.setItems(types.getList());
        comboType.getSelectionModel().select(getElem().getType());

//        regionsAll.fillData();

//        if (getElem().getRegionAddress().getCountry() != null){
//            Country currCountry = getElem().getRegionAddress().getCountry();
//            regionsCountry = regionsAll.getList().filtered((a) -> a.equals(currCountry));
//        }
//        comboRegion.setItems(regionsCountry);
//        comboRegion.getSelectionModel().select(getElem().getRegionAddress());

    }

    @Override
    protected void saveField() {
        getElem().setSurname(txtSurname.getText()+" ");
        getElem().setName(txtName.getText()+" ");
        getElem().setPatronymic(txtPatronymic.getText());
        getElem().setBirthday(dateBirthday.getValue());

        getElem().setSex(rbtnMan.isSelected());

        getElem().setDocSeries(txtDocSeries.getText()+" ");
        getElem().setDocNumber(txtDocNumber.getText());
        getElem().setDocIssue(txtDocIssue.getText());
        getElem().setDocDate(dateDocDate.getValue());

        getElem().setAddress(txtDocIssue.getText());

        getElem().setDiscount(Float.parseFloat(txtDiscount.getText()));

        Country country = (Country) comboCitizenship.getSelectionModel().getSelectedItem();
        if (country != null) {
            getElem().setCitizenship(country);
        }
        DocumType documType = (DocumType) comboDocType.getSelectionModel().getSelectedItem();
        if (documType != null) {
            getElem().setDocType(documType);
        }
        ClientType clientType = (ClientType) comboType.getSelectionModel().getSelectedItem();
        if (clientType != null) {
            getElem().setType(clientType);
        }
        Region region = (Region) comboRegion.getSelectionModel().getSelectedItem();
        if (region != null) {
            getElem().setRegionAddress(region);
        }

    }

    @Override
    protected Client copyElem(Client elem) {
        return new Client(elem);
    }
}
