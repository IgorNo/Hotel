package com.nov.hotel.dao.impl;

import com.nov.hotel.collections.impl.ApartTypeCollection;
import com.nov.hotel.collections.impl.ApartmentCollection;
import com.nov.hotel.collections.impl.BlockCollection;
import com.nov.hotel.dao.abstr.CrudDaoAbstractLong;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.entities.Apartment;
import com.nov.hotel.entities.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("apartmentDao")
public class ApartmentDaoImpl extends CrudDaoAbstractLong<Apartment> {

    @Autowired
    BlockDaoImpl blockDao;
    @Autowired
    ApartTypeDaoImpl apartTypeDao;

    {
          nameDataBase = "apartments";

          sqlInsert = "INSERT INTO apartments (apart_room_number_s, apart_level_number_n, apart_status_b, apart_block_fk, apart_type_fk) " +
                "VALUES (:room, :level, :status, :blockId, :typeId)";
          sqlUpdate = "UPDATE apartments SET apart_room_number_s= :room, apart_level_number_n= :level, apart_status_b= :status, apart_block_fk= :blockId, apart_type_fk= :typeId " +
                "WHERE apart_id_n = :id";
          sqlDelete = "DELETE FROM apartments WHERE apart_id_n = :id";
          sqlSelectSingle = "SELECT * FROM apartments_view WHERE apart_id_n";
          sqlSelectSome = "SELECT * FROM apartments_view WHERE apart_room_number_s";
          sqlSelectAll = "SELECT * FROM apartments_view";
    }

    protected MapSqlParameterSource getParams(Apartment elem) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());
        params.addValue("room", elem.getRoomNumber());
        params.addValue("level", elem.getLevelNumber());
        params.addValue("status", elem.getStatus());
        params.addValue("blockId", elem.getBlock().getId());
        params.addValue("typeId", elem.getType().getId());
        return params;
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
            apartType = ApartTypeCollection.getInstance().putValue(apartType);

            Block block = new Block();
            block.setId(rs.getInt("block_id_n"));
            block.setName(rs.getString("block_name_s"));
            block = BlockCollection.getInstance().putValue(block);

            Apartment apartment = new Apartment();
            apartment.setId(rs.getLong("apart_id_n"));
            apartment.setRoomNumber(rs.getString("apart_room_number_s"));
            apartment.setLevelNumber(rs.getInt("apart_level_number_n"));
            apartment.setStatus(rs.getBoolean("apart_status_b"));
            apartment.setBlock(block);
            apartment.setType(apartType);

            return ApartmentCollection.getInstance().putValue(apartment);
        }
    };

    @Override
    protected void checkId(Apartment elem) {
        if (elem.getBlock().getId() == null) blockDao.insert(elem.getBlock());
        if (elem.getType().getId() == null) apartTypeDao.insert(elem.getType());
    }

    public BlockDaoImpl getBlockDao() {
        return blockDao;
    }

    public ApartTypeDaoImpl getApartTypeDao() {
        return apartTypeDao;
    }

    @Override
    public RowMapper<Apartment> getRowMapper() {
        return rowMapper;
    }
}

