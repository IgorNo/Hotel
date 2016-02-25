package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.interfaces.ObservaableCollection;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.main.Start;
import com.nov.hotel.services.interfaces.ApartTypeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ApartTypeCollecImpl implements ObservaableCollection<ApartType> {

    private ApartTypeService service = (ApartTypeService) Start.APPLICATION_CONTEXT.getBean("appartTypeService");

    private ObservableList<ApartType> list = FXCollections.observableArrayList();;

    @Override
    public void fillData() {
        list.addAll(service.getAll());
    }

    @Override
    public ObservaableCollection<ApartType> add(ApartType element) {
        if (service.insert(element) == null){
            return null;
        }
        list.add(element);
        return this;
    }

    @Override
    public ObservaableCollection<ApartType> update(ApartType element) {
        if (service.update(element) == null){
            return null;
        }
        return this;
    }

    @Override
    public ObservaableCollection<ApartType> delete(ApartType element) {
        if (service.delete(element.getId()) == null){
            return null;
        }
        list.remove(element);
        return this;
    }

    @Override
    public ObservableList<ApartType> getList() {
        return list;
    }
}
