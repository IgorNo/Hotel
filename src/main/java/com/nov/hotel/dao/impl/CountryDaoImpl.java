package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.abstr.CrudDaoAbstrString;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("countryDao")
public class CountryDaoImpl extends CrudDaoAbstrString<Country> {
    {
          nameDataBase = "countries";

          sqlInsert = "INSERT INTO countries (country_id_iso_s, country_name_s) VALUES (:id, :name)";
          sqlUpdate = "UPDATE countries SET country_name_s= :name WHERE country_id_iso_s";
          sqlDelete = "DELETE FROM countries WHERE country_id_iso_s";
          sqlSelectSingle = "SELECT * FROM countries WHERE country_id_iso_s";
          sqlSelectSome = "SELECT * FROM countries WHERE country_name_s";
          sqlSelectAll = "SELECT * FROM countries";
    }
    @Override
    protected MapSqlParameterSource getParams(Country elem) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",elem.getId());
        params.addValue("name", elem.getName());
        return params;
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

    @Override
    public  RowMapper<Country> getRowMapper() {
        return rowMapper;
    }

    @Override
    protected void checkId(Country elem) {

    }
}
