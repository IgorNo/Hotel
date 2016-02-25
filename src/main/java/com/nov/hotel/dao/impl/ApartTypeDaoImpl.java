package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.AppartTypeDao;
import com.nov.hotel.entities.ApartType;
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
    public void insert(ApartType apartType) {
        String sql = "INSERT INTO appart_types (app_typ_name_s, app_typ_sizing_n, app_typ_price1_n, app_typ_price2_n, app_typ_price3_n) " +
                "VALUES (:name, :sizing, :price1, :price2, :price3)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", apartType.getName());
        params.addValue("sizing", apartType.getSizing());
        params.addValue("price1", apartType.getPrice1());
        params.addValue("price2", apartType.getPrice2());
        params.addValue("price3", apartType.getPrice3());

        jdbcTemplate.update(sql, params, keyHolder);

        apartType.setId(keyHolder.getKey().intValue());
    }

    @Override
    public ApartType getById(int id) {
        String sql = "SELECT * FROM appart_types WHERE app_typ_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    public ApartType getByName(String name) {

        String sql = "SELECT * FROM appart_types WHERE app_typ_name_s = :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    public List<ApartType> getAll(){
        String sql = "SELECT * FROM appart_types";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void update(ApartType apartType) {
        String sql = "UPDATE appart_types SET app_typ_name_s= :name, app_typ_sizing_n= :sizing, " +
                "app_typ_price1_n=  :price1, app_typ_price2_n = :price2, app_typ_price3_n= :price3 " +
                "WHERE app_typ_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", apartType.getId());
        params.addValue("name", apartType.getName());
        params.addValue("sizing", apartType.getSizing());
        params.addValue("price1", apartType.getPrice1());
        params.addValue("price2", apartType.getPrice2());
        params.addValue("price3", apartType.getPrice3());

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

    private static final RowMapper<ApartType> rowMapper = new RowMapper<ApartType>() {

        @Override
        public ApartType mapRow(ResultSet rs, int rowNum) throws SQLException {
            ApartType apartType = new ApartType();
            apartType.setId(rs.getInt("app_typ_id_n"));
            apartType.setName(rs.getString("app_typ_name_s"));
            apartType.setSizing(rs.getInt("app_typ_sizing_n"));
            apartType.setPrice1(rs.getFloat("app_typ_price1_n"));
            apartType.setPrice2(rs.getFloat("app_typ_price2_n"));
            apartType.setPrice3(rs.getFloat("app_typ_price3_n"));
            return apartType;
        }
    };

}
