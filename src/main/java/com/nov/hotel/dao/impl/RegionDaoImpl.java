package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.dao.interfaces.GetDao;
import com.nov.hotel.entities.Country;
import com.nov.hotel.entities.Region;
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

@Repository("regionDao")
public class RegionDaoImpl implements CrudDao<Region>{

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void insert(Region elem) {
        String sql = "INSERT INTO regions (region_name_s, region_country_fk) VALUES (:name, :countryId)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = getMapSqlParameterSource(elem);
        jdbcTemplate.update(sql, params, keyHolder);
        elem.setId(keyHolder.getKey().intValue());
    }

    private MapSqlParameterSource getMapSqlParameterSource(Region elem) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", elem.getName());
        params.addValue("countryId", elem.getCountry().getId());
        return params;
    }
    
    @Override
    // int id
    public Region getOne(Object id) {
        String sql = "SELECT * FROM regions_view WHERE region_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    // int name
    public List<Region> getPart(Object countryId) {
        String sql = "SELECT * FROM regions_view WHERE region_country_fk = :countryId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("countryId", countryId);

        return jdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public List<Region> getAll() {
        String sql = "SELECT * FROM regions_view";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void update(Region elem) {
        String sql = "UPDATE regions SET region_name_s= :name, region_country_fk= :countryId WHERE region_id_n = :id";

        MapSqlParameterSource params = getMapSqlParameterSource(elem);
        params.addValue("id", elem.getId());
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(Region elem) {
        String sql = "DELETE FROM regions WHERE region_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM regions";
        jdbcTemplate.update(sql, new MapSqlParameterSource());
    }

    @Override
    public int count() {
        String sql = "SELECT count(*) FROM regions";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private static final RowMapper<Region> rowMapper = new RowMapper<Region>() {
        @Override
        public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
            Country country = new Country();
            country.setId(rs.getString("country_id_iso_s"));
            country.setName(rs.getString("country_name_s"));

            Region region = new Region();
            region.setId(rs.getInt("region_id_n"));
            region.setName(rs.getString("region_name_s"));
            region.setCountry(country);
            
            return region;
        }
    };

}
