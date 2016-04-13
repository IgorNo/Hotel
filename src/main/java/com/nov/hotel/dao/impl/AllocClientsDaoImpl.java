package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.abstr.CrudDaoAbstrObject;
import com.nov.hotel.entities.AllocClient;
import com.nov.hotel.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("allocClientsDao")
public class AllocClientsDaoImpl extends CrudDaoAbstrObject<Long, AllocClient> {

    @Autowired
    ClientDaoImpl clientDao;

//    protected String nameDataBase;
//    protected String sqlInsert;
//    protected String sqlUpdate;
//    protected String sqlDelete;
//    protected String sqlSelectSingle;
//    protected String sqlSelectSome;
//    protected String sqlSelectAll;

    {


        sqlInsert = "INSERT INTO alloc_clients (alloc_inv_room_fk, alloc_client_fk) VALUES (:idAlloc, :name)";
        sqlUpdate = "UPDATE alloc_clients SET country_name_s= :name WHERE country_id_iso_s";
        sqlDelete = "DELETE FROM alloc_clients WHERE country_id_iso_s";
        sqlSelectSingle = "SELECT * FROM alloc_clients WHERE country_id_iso_s";
        sqlSelectSome = "SELECT * FROM alloc_clients_view WHERE country_name_s";
        sqlSelectAll = "SELECT * FROM alloc_clients_view";
    }
    
    @Override
    protected MapSqlParameterSource getParams(AllocClient elem) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("idAlloc",elem.getIdAlloc());
        params.addValue("idClient",elem.getClient().getId());
        return params;
    }

    private static final RowMapper<AllocClient> rowMapper = new RowMapper<AllocClient>() {
        @Override
        public AllocClient mapRow(ResultSet rs, int rowNum) throws SQLException {
            AllocClient allocClient = new AllocClient();
            return allocClient;
        }
    };

    @Override
    public  RowMapper<AllocClient> getRowMapper() {
        return rowMapper;
    }

    @Override
    protected void checkId(AllocClient elem) {

    }
}
