package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("appartStatusDao")
public class ApartStatusDaoImpl implements CrudDao<ApartStatus> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void insert(ApartStatus apartStatus) {
        String sql = "INSERT INTO apart_status (app_stat_name_s, app_stat_color_s) " +
                "VALUES (:name, :color)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", apartStatus.getName());
        params.addValue("color", apartStatus.getColor());

        jdbcTemplate.update(sql, params, keyHolder);

        apartStatus.setId(keyHolder.getKey().intValue());
    }

    @Override
    public ApartStatus getById(int id) {
        String sql = "SELECT * FROM apart_status WHERE app_stat_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    public List<ApartStatus> getByName(String name) {
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
    public void update(ApartStatus apartStatus) {
        String sql = "UPDATE apart_status SET app_stat_name_s= :name, app_stat_color_s= :color " +
                "WHERE app_stat_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", apartStatus.getId());
        params.addValue("name", apartStatus.getName());
        params.addValue("color", apartStatus.getColor());

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
