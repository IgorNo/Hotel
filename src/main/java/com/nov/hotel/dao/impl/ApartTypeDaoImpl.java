package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartType;
import org.springframework.beans.factory.annotation.Autowired;
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

@Repository("apartTypeDao")
public class ApartTypeDaoImpl implements CrudDao<ApartType> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void insert(ApartType apartType) {
        String sql = "INSERT INTO apart_types (app_typ_name_s, app_typ_sizing_n, app_typ_price1_n, app_typ_price2_n, app_typ_price3_n, app_typ_slot_n, app_typ_description_s) " +
                "VALUES (:name, :sizing, :price1, :price2, :price3, :nSlots, :description)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = getMapSqlParameterSource(apartType);
        jdbcTemplate.update(sql, params, keyHolder);
        apartType.setId(keyHolder.getKey().intValue());
    }

    @Override
    public ApartType getById(long id) {
        String sql = "SELECT * FROM apart_types WHERE app_typ_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    public List<ApartType> getByName(String name) {
        String sql = "SELECT * FROM apart_types WHERE app_typ_name_s = :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        return jdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public List<ApartType> getAll(){
        String sql = "SELECT * FROM apart_types";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void update(ApartType apartType) {
        String sql = "UPDATE apart_types SET app_typ_name_s= :name, app_typ_sizing_n= :sizing, " +
                "app_typ_price1_n=  :price1, app_typ_price2_n= :price2, app_typ_price3_n= :price3, " +
                "app_typ_slot_n= :nSlots, app_typ_description_s= :description " +
                "WHERE app_typ_id_n = :id";

        MapSqlParameterSource params = getMapSqlParameterSource(apartType);
        jdbcTemplate.update(sql, params);

    }

    private MapSqlParameterSource getMapSqlParameterSource(ApartType apartType) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", apartType.getId());
        params.addValue("name", apartType.getName());
        params.addValue("sizing", apartType.getSize());
        params.addValue("price1", apartType.getPriceDay());
        params.addValue("price2", apartType.getPriceHour());
        params.addValue("price3", apartType.getPriceSlot());
        params.addValue("nSlots", apartType.getnSlots());
        params.addValue("description", apartType.getDescription());
        return params;
    }

    @Override
    public void delete(ApartType elem) {
        String sql = "DELETE FROM apart_types WHERE app_typ_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM apart_types";
        jdbcTemplate.update(sql, new MapSqlParameterSource());
    }

    @Override
    public int count() {
        String sql = "select count(*) from apart_types";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private static final RowMapper<ApartType> rowMapper = new RowMapper<ApartType>() {

        @Override
        public ApartType mapRow(ResultSet rs, int rowNum) throws SQLException {
            ApartType apartType = new ApartType();
            apartType.setId(rs.getInt("app_typ_id_n"));
            apartType.setName(rs.getString("app_typ_name_s"));
            apartType.setSize(rs.getInt("app_typ_sizing_n"));
            apartType.setPriceDay(rs.getFloat("app_typ_price1_n"));
            apartType.setPriceHour(rs.getFloat("app_typ_price2_n"));
            apartType.setPriceSlot(rs.getFloat("app_typ_price3_n"));
            apartType.setnSlots(rs.getInt("app_typ_slot_n"));
            apartType.setDescription(rs.getString("app_typ_description_s"));
            return apartType;
        }
    };

}
