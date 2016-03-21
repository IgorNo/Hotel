package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.entities.Apartment;
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

@Repository("apartmentDao")
public class ApartmentDaoImpl implements CrudDao<Apartment>{

    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    CrudDao<Block> blockDao;
    @Autowired
    CrudDao<ApartType> apartTypeDao;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void insert(Apartment elem) {
        String sql = "INSERT INTO apartments (apart_room_number_s, apart_level_number_n, apart_status_b, apart_block_fk, apart_type_fk) " +
                "VALUES (:room, :level, :status, :blockId, :typeId)";

        checkId(elem);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = getMapSqlParameterSource(elem);
        jdbcTemplate.update(sql, params, keyHolder);
        elem.setId(keyHolder.getKey().intValue());
    }

    private MapSqlParameterSource getMapSqlParameterSource(Apartment elem) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("room", elem.getRoomNumber());
        params.addValue("level", elem.getLevelNumber());
        params.addValue("status", elem.getStatus());
        params.addValue("blockId", elem.getBlock().getId());
        params.addValue("typeId", elem.getType().getId());
        return params;
    }

    private void checkId(Apartment elem) {
        if (elem.getBlock().getId() == 0) blockDao.insert(elem.getBlock());
        if (elem.getType().getId() == 0) apartTypeDao.insert(elem.getType());
    }

    @Override
    public Apartment getById(long id) {
        String sql = "SELECT * FROM apartments_view WHERE apart_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    public List<Apartment> getByName(String name) {
        String sql = "SELECT * FROM apartments_view WHERE apart_room_number_s = :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public List<Apartment> getAll() {
        String sql = "SELECT * FROM apartments_view";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void update(Apartment elem) {
        String sql = "UPDATE apartments SET apart_room_number_s= :room, apart_level_number_n= :level, apart_status_b= :status, apart_block_fk= :blockId, apart_type_fk= :typeId " +
                "WHERE apart_id_n = :id";

        checkId(elem);
        MapSqlParameterSource params = getMapSqlParameterSource(elem);
        params.addValue("id", elem.getId());
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(Apartment elem) {
        String sql = "DELETE FROM apartments WHERE apart_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM apartments";
        jdbcTemplate.update(sql, new MapSqlParameterSource());
    }

    @Override
    public int count() {
        String sql = "SELECT count(*) FROM apartments";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private static final RowMapper<Apartment> rowMapper = new RowMapper<Apartment>() {
        @Override
        public Apartment mapRow(ResultSet rs, int rowNum) throws SQLException {
            ApartType apartType = new ApartType();
            apartType.setId(rs.getInt("app_typ_id_n"));
            apartType.setName(rs.getString("app_typ_name_s"));
            apartType.setSize(rs.getInt("app_typ_sizing_n"));
            apartType.setPriceDay(rs.getFloat("app_typ_price1_n"));
            apartType.setPriceHour(rs.getFloat("app_typ_price2_n"));
            apartType.setPriceSlot(rs.getFloat("app_typ_price3_n"));
            apartType.setnSlots(rs.getInt("app_typ_slot_n"));
            apartType.setDescription(rs.getString("app_typ_description_s"));

            Block block = new Block();
            block.setId(rs.getInt("block_id_n"));
            block.setName(rs.getString("block_name_s"));

            Apartment apartment = new Apartment();
            apartment.setId(rs.getLong("apart_id_n"));
            apartment.setRoomNumber(rs.getString("apart_room_number_s"));
            apartment.setLevelNumber(rs.getInt("apart_level_number_n"));
            apartment.setStatus(rs.getBoolean("apart_status_b"));
            apartment.setBlock(block);
            apartment.setType(apartType);

            return apartment;
        }
    };

}
