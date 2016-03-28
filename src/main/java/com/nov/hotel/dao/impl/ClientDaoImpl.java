package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository("clientDao")
public class ClientDaoImpl implements CrudDao<Client>{

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insert(Client elem) {

    }

    @Override
    public Client getById(Object id) {
        return null;
    }

    @Override
    public List<Client> getByName(String name) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void update(Client elem) {

    }

    @Override
    public void delete(Client elem) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public int count() {
        return 0;
    }
}
