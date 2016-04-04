package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.dao.interfaces.GetDao;
import com.nov.hotel.entities.Country;
import com.nov.hotel.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("countryDao")
public class CountryDaoImpl implements CrudDao<Country>{

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insert(Country elem) {
        String sql = "INSERT INTO countries (country_id_iso_s, country_name_s) VALUES (:id, :name)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());
        params.addValue("name", elem.getName());

        jdbcTemplate.update(sql, params);
    }

    @Override
    // String id
    public Country getOne(Object id) {
        String sql = "SELECT * FROM countries WHERE country_id_iso_s = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    // String name
    public List<Country> getPart(Object name) {
        String sql = "SELECT * FROM countries WHERE country_name_s = :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public List<Country> getAll() {
        String sql = "SELECT * FROM countries";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void update(Country elem) {
        String sql = "UPDATE countries SET country_name_s= :name WHERE country_id_iso_s = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());
        params.addValue("name", elem.getName());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(Country elem) {
        String sql = "DELETE FROM countries WHERE country_id_iso_s = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM countries";
        jdbcTemplate.update(sql, new MapSqlParameterSource());
    }

    @Override
    public int count() {
        String sql = "select count(*) from countries";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private static final RowMapper<Country> rowMapper = new RowMapper<Country>() {
        @Override
        public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
            Country country = new Country();
            country.setId(rs.getString("country_id_iso_s"));
            country.setName(rs.getString("country_name_s"));
            return country;
        }
    };

}
