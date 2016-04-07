package com.nov.hotel.dao.abstr;

import com.nov.hotel.entities.interfaces.Entity;

public abstract class CrudDaoAbstrString<V extends Entity<String,V>> extends CrudDaoAbstract<String,V> {

    @Override
    public void insert(V elem) {
        checkId(elem);
        jdbcTemplate.update(sqlInsert, getParams(elem));
    }

}
