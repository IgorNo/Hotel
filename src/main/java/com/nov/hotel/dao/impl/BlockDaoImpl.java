package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.Block;
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
import java.util.ArrayList;
import java.util.List;

@Repository("blockDao")
public class BlockDaoImpl implements CrudDao<Block> {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insert(Block elem) {
        String sql = "INSERT INTO blocks (block_name_s) VALUES (:name)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", elem.getName());

        jdbcTemplate.update(sql, params, keyHolder);

        elem.setId(keyHolder.getKey().intValue());
    }

    @Override
    public Block getById(int id) {
        String sql = "SELECT * FROM blocks WHERE block_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    public List<Block> getByName(String name) {
        String sql = "SELECT * FROM blocks WHERE block_name_s = :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public List<Block> getAll() {
        String sql = "SELECT * FROM blocks";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void update(Block elem) {
        String sql = "UPDATE blocks SET block_name_s= :name WHERE block_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());
        params.addValue("name", elem.getName());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(Block elem) {
        String sql = "DELETE FROM blocks WHERE block_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM blocks";
        jdbcTemplate.update(sql, new MapSqlParameterSource());
    }

    @Override
    public int count() {
        String sql = "select count(*) from blocks";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private static final RowMapper<Block> rowMapper = new RowMapper<Block>() {
        @Override
        public Block mapRow(ResultSet rs, int rowNum) throws SQLException {
            Block block = new Block();
            block.setId(rs.getInt("block_id_n"));
            block.setName(rs.getString("block_name_s"));
            return block;
        }
    };


}
