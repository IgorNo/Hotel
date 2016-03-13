package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.Block;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository("blockDao")
public class BlockDaoImpl implements CrudDao<Block> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insert(Block elem) {

    }

    @Override
    public Block getById(int id) {
        return null;
    }

    @Override
    public List<Block> getByName(String name) {
        return null;
    }

    @Override
    public List<Block> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void update(Block elem) {

    }

    @Override
    public void delete(Block elem) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public int count() {
        return 0;
    }
}
