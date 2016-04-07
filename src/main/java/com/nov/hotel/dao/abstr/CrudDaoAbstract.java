package com.nov.hotel.dao.abstr;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.interfaces.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public abstract class CrudDaoAbstract<K, V extends Entity<K,V>> implements CrudDao<K,V>{


    protected NamedParameterJdbcTemplate jdbcTemplate;

    protected String nameDataBase;
    protected String sqlInsert;
    protected String sqlUpdate;
    protected String sqlDelete;
    protected String sqlSelectSingle;
    protected String sqlSelectSome;
    protected String sqlSelectAll;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    protected abstract MapSqlParameterSource getParams(V elem);

    protected abstract RowMapper<V> getRowMapper();

    protected abstract void checkId(V elem);

    @Override
    public void update(V elem) {
        String sql = sqlUpdate + " = :id";
        jdbcTemplate.update(sql, getParams(elem));
    }

    @Override
    public void delete(V elem) {
        String sql = sqlDelete + " = :id";
        jdbcTemplate.update(sql, getParams(elem));
    }

    @Override
    public V getSingle(K id) {
        String sql = sqlSelectSingle + " = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, getRowMapper());
    }

    @Override
    public List<V> getSelected(Object name) {
        String sql = sqlSelectSome + " = :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbcTemplate.query(sql, params, getRowMapper());
    }

    @Override
    public List<V> getAll() {
        return jdbcTemplate.query(sqlSelectAll, getRowMapper());
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM " + nameDataBase;
        jdbcTemplate.update(sql, new MapSqlParameterSource());
    }

    @Override
    public int count() {
        String sql = "select count(*) from " + nameDataBase;
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

}
