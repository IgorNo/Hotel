package com.nov.hotel.entities;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class AllocClients {

    long idAlloc;
    ObjectProperty<Client> client = new SimpleObjectProperty<>();

}
