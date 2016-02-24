package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.AppartTypeDao;
import com.nov.hotel.entities.AppartType;
import com.nov.hotel.main.Start;
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

@Repository("appartTypeDao")
public class ApartTypeDaoImpl implements AppartTypeDao{

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void insert(AppartType appartType) {
        String sql = "INSERT INTO appart_types (app_typ_name_s, app_typ_sizing_n, app_typ_price1_n, app_typ_price2_n, app_typ_price3_n) " +
                "VALUES (:name, :sizing, :price1, :price2, :price3)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", appartType.getName());
        params.addValue("sizing", appartType.getSizing());
        params.addValue("price1", appartType.getPrice1());
        params.addValue("price2", appartType.getPrice2());
        params.addValue("price3", appartType.getPrice3());

        jdbcTemplate.update(sql, params, keyHolder);

        appartType.setId(keyHolder.getKey().intValue());
    }

    @Override
    public AppartType getById(int id) {
        String sql = "SELECT * FROM appart_types WHERE app_typ_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    public AppartType getByName(String name) {

        String sql = "SELECT * FROM appart_types WHERE app_typ_name_s = :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    public List<AppartType> getAll(){
        String sql = "SELECT * FROM appart_types";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void update(AppartType appartType) {
        String sql = "UPDATE appart_types SET app_typ_name_s= :name, app_typ_sizing_n= :sizing, " +
                "app_typ_price1_n=  :price1, app_typ_price2_n = :price2, app_typ_price3_n= :price3 " +
                "WHERE app_typ_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", appartType.getId());
        params.addValue("name", appartType.getName());
        params.addValue("sizing", appartType.getSizing());
        params.addValue("price1", appartType.getPrice1());
        params.addValue("price2", appartType.getPrice2());
        params.addValue("price3", appartType.getPrice3());

        jdbcTemplate.update(sql, params);

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM appart_types WHERE app_typ_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM appart_types";
        jdbcTemplate.update(sql, new MapSqlParameterSource());
    }

    @Override
    public int count() {
        String sql = "select count(*) from appart_types";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private static final RowMapper<AppartType> rowMapper = new RowMapper<AppartType>() {

        @Override
        public AppartType mapRow(ResultSet rs, int rowNum) throws SQLException {
            AppartType appartType = new AppartType();
            appartType.setId(rs.getInt("app_typ_id_n"));
            appartType.setName(rs.getString("app_typ_name_s"));
            appartType.setSizing(rs.getInt("app_typ_sizing_n"));
            appartType.setPrice1(rs.getFloat("app_typ_price1_n"));
            appartType.setPrice2(rs.getFloat("app_typ_price2_n"));
            appartType.setPrice3(rs.getFloat("app_typ_price3_n"));
            return appartType;
        }
    };

}
