package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.AllocClients;
import com.nov.hotel.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository("allocClientsDao")
public class AllocClientsDaoImpl implements CrudDao<Long, AllocClients> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void insert(AllocClients elem) {

    }

    @Override
    public AllocClients getSingle(Long id) {
        return null;
    }

    @Override
    public List<AllocClients> getSelected(Object key) {
        return null;
    }

    @Override
    public List<AllocClients> getAll() {
        return null;
    }

    @Override
    public void update(AllocClients elem) {

    }

    @Override
    public void delete(AllocClients elem) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public int count() {
        return 0;
    }
}
