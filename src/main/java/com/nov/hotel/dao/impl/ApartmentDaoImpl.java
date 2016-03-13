package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.Apartment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository("appartmentDao")
public class ApartmentDaoImpl implements CrudDao<Apartment>{

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void insert(Apartment elem) {

    }

    @Override
    public Apartment getById(int id) {
        return null;
    }

    @Override
    public List<Apartment> getByName(String name) {
        return null;
    }

    @Override
    public List<Apartment> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void update(Apartment elem) {

    }

    @Override
    public void delete(Apartment elem) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public int count() {
        return 0;
    }
}
