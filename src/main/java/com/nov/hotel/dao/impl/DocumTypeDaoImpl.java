package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.DocumType;
import com.nov.hotel.entities.DocumType;
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

@Repository("documTypeDao")
public class DocumTypeDaoImpl implements CrudDao<DocumType> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insert(DocumType elem) {
        String sql = "INSERT INTO doc_types (doc_name_s) VALUES (:name)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", elem.getName());

        jdbcTemplate.update(sql, params, keyHolder);

        elem.setId(keyHolder.getKey().intValue());
    }

    @Override
    public DocumType getById(Object id) {
        String sql = "SELECT * FROM doc_types WHERE doc_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    public List<DocumType> getByName(String name) {
        String sql = "SELECT * FROM doc_types WHERE doc_name_s = :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public List<DocumType> getAll() {
        String sql = "SELECT * FROM doc_types";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void update(DocumType elem) {
        String sql = "UPDATE doc_types SET doc_name_s= :name WHERE doc_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());
        params.addValue("name", elem.getName());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(DocumType elem) {
        String sql = "DELETE FROM doc_types WHERE doc_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM doc_types";
        jdbcTemplate.update(sql, new MapSqlParameterSource());
    }

    @Override
    public int count() {
        String sql = "select count(*) from doc_types";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private static final RowMapper<DocumType> rowMapper = new RowMapper<DocumType>() {
        @Override
        public DocumType mapRow(ResultSet rs, int rowNum) throws SQLException {
            DocumType elem = new DocumType();
            elem.setId(rs.getInt("doc_id_n"));
            elem.setName(rs.getString("doc_name_s"));
            return elem;
        }
    };

}
