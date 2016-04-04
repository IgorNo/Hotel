package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.dao.interfaces.GetDao;
import com.nov.hotel.entities.ApartStatus;
import com.nov.hotel.entities.Apartment;
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

@Repository("apartStatusDao")
public class ApartStatusDaoImpl implements CrudDao<ApartStatus>{

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void insert(ApartStatus elem) {
        String sql = "INSERT INTO apart_status (app_stat_name_s, app_stat_color_s) " +
                "VALUES (:name, :color)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", elem.getName());
        params.addValue("color", elem.getColor());

        jdbcTemplate.update(sql, params, keyHolder);

        elem.setId(keyHolder.getKey().intValue());
    }

    @Override
    // int id
    public ApartStatus getOne(Object id) {
        String sql = "SELECT * FROM apart_status WHERE app_stat_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    // String name
    public List<ApartStatus> getPart(Object name) {
        String sql = "SELECT * FROM apart_status WHERE app_stat_name_s = :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public List<ApartStatus> getAll(){
        String sql = "SELECT * FROM apart_status";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void update(ApartStatus elem) {
        String sql = "UPDATE apart_status SET app_stat_name_s= :name, app_stat_color_s= :color " +
                "WHERE app_stat_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());
        params.addValue("name", elem.getName());
        params.addValue("color", elem.getColor());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(ApartStatus elem) {
        String sql = "DELETE FROM apart_status WHERE app_stat_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM apart_status";
        jdbcTemplate.update(sql, new MapSqlParameterSource());
    }

    @Override
    public int count() {
        String sql = "select count(*) from apart_status";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private static final RowMapper<ApartStatus> rowMapper = new RowMapper<ApartStatus>() {
        @Override
        public ApartStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
            ApartStatus apartStatus = new ApartStatus();
            apartStatus.setId(rs.getInt("app_stat_id_n"));
            apartStatus.setName(rs.getString("app_stat_name_s"));
            apartStatus.setColor(rs.getString("app_stat_color_s"));
            return apartStatus;
        }
    };

}
