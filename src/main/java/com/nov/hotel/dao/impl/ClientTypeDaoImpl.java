package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ClientType;
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

@Repository("clientTypeDao")
public class ClientTypeDaoImpl implements CrudDao<ClientType> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insert(ClientType elem) {
        String sql = "INSERT INTO client_types (cltyp_name_s, cltyp_color_s, cltyp_discount_n) VALUES (:name, :color, :discount)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", elem.getName());
        params.addValue("color", elem.getColor());
        params.addValue("discount", elem.getDiscount());

        jdbcTemplate.update(sql, params, keyHolder);

        elem.setId(keyHolder.getKey().intValue());
    }

    @Override
    public ClientType getById(Object id) {
        String sql = "SELECT * FROM client_types WHERE cltyp_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    public List<ClientType> getByName(String name) {
        String sql = "SELECT * FROM client_types WHERE cltyp_name_s = :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public List<ClientType> getAll() {
        String sql = "SELECT * FROM client_types";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void update(ClientType elem) {
        String sql = "UPDATE client_types SET cltyp_name_s= :name, cltyp_discount_n= :discount, cltyp_color_s= :color  WHERE cltyp_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());
        params.addValue("name", elem.getName());
        params.addValue("color", elem.getColor());
        params.addValue("discount", elem.getDiscount());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(ClientType elem) {
        String sql = "DELETE FROM client_types WHERE cltyp_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM client_types";
        jdbcTemplate.update(sql, new MapSqlParameterSource());
    }

    @Override
    public int count() {
        String sql = "select count(*) from client_types";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private static final RowMapper<ClientType> rowMapper = new RowMapper<ClientType>() {
        @Override
        public ClientType mapRow(ResultSet rs, int rowNum) throws SQLException {
            ClientType elem = new ClientType();
            elem.setId(rs.getInt("cltyp_id_n"));
            elem.setDiscount(rs.getFloat("cltyp_discount_n"));
            elem.setName(rs.getString("cltyp_name_s"));
            elem.setColor(rs.getString("cltyp_color_s"));
            return elem;
        }
    };

}
