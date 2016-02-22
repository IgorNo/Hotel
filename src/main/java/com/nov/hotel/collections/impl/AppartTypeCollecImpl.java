package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.interfaces.ObservaableCollection;
import com.nov.hotel.entities.AppartType;
import com.nov.hotel.main.Start;
import com.nov.hotel.services.impl.AppartTypeServiceImpl;
import com.nov.hotel.services.interfaces.AppartTypeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;


public class AppartTypeCollecImpl implements ObservaableCollection<AppartType> {

    private AppartTypeService service = (AppartTypeService) Start.APPLICATION_CONTEXT.getBean("appartTypeService");

    private ObservableList<AppartType> list = FXCollections.observableArrayList(service.getAll());


    @Override
    public ObservaableCollection<AppartType> add(AppartType element) {
        if (service.insert(element) == null){
            return null;
        }
        list.add(element);
        return this;
    }

    @Override
    public ObservaableCollection<AppartType> update(AppartType element) {
        if (service.update(element) == null){
            return null;
        }
        return this;
    }

    @Override
    public ObservaableCollection<AppartType> delete(AppartType element) {
        if (service.delete(element.getId()) == null){
            return null;
        }
        list.remove(element);
        return this;
    }

    @Override
    public ObservableList<AppartType> getList() {
        return list;
    }
}
