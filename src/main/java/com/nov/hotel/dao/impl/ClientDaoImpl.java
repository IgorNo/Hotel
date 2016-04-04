package com.nov.hotel.dao.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.dao.interfaces.GetDao;
import com.nov.hotel.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("clientDao")
public class ClientDaoImpl implements CrudDao<Client>{

    @Autowired
    ClientTypeDaoImpl clientTypeDao;
    @Autowired
    DocumTypeDaoImpl documTypeDao;
    @Autowired
    RegionDaoImpl regionDao;

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insert(Client elem) {
        String sql = "INSERT INTO clients (client_regdate_d, client_surname_s, client_name_s, client_patronymic_s, " +
        "client_sex_b, client_birthday_d, client_citizen_fk, client_doctype_fk, client_docser_s, client_docnum_s, client_docdate_d, client_docissue_s, " +
        "client_region_fk, client_address_s, client_type_fk, client_discount_n) " +
                "VALUES (:regDate, :surname, :name, :patronimic, :sex, :birthday, :citizenship, " +
                ":docType, :docSeries, :docNumber, :docDate, :docIssue, :regionAddress, :address, :type, :discount)";

        checkId(elem);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = getMapSqlParameterSource(elem);
        jdbcTemplate.update(sql, params, keyHolder);
        elem.setId(keyHolder.getKey().intValue());
    }

    @Override
    // Long id
    public Client getOne(Object id) {
        String sql = "SELECT * FROM clients_view WHERE client_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    @Override
    // String name
    public List<Client> getPart(Object name) {
        String sql = "SELECT * FROM clients_view WHERE client_surname_s = :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public List<Client> getAll() {
        String sql = "SELECT * FROM clients_view";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void update(Client elem) {
        String sql = "UPDATE clients SET client_regdate_d= :regDate, client_surname_s= :surname, client_name_s= :name, client_patronymic_s= :patronimic, " +
                "client_sex_b= :sex, client_birthday_d= :birthday, client_citizen_fk=  :citizenship, client_doctype_fk= :docType, " +
                "client_docser_s= :docSeries, client_docnum_s= :docNumber, client_docdate_d= :docDate, client_docissue_s= :docIssue, " +
                "client_region_fk= :regionAddress, client_address_s= :address, client_type_fk= :type, client_discount_n= :discount " +
                "WHERE client_id_n = :id";

        checkId(elem);
        MapSqlParameterSource params = getMapSqlParameterSource(elem);
        params.addValue("id", elem.getId());
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(Client elem) {
        String sql = "DELETE FROM clients WHERE client_id_n = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", elem.getId());

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM clients";
        jdbcTemplate.update(sql, new MapSqlParameterSource());
    }

    @Override
    public int count() {
        String sql = "SELECT count(*) FROM clients";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private MapSqlParameterSource getMapSqlParameterSource(Client elem) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("regDate",Date.valueOf(elem.getRegDate()));
        params.addValue("surname", elem.getSurname());
        params.addValue("name", elem.getName());
        params.addValue("patronimic", elem.getPatronymic());
        params.addValue("sex", elem.getSex());
        params.addValue("birthday", Date.valueOf(elem.getBirthday()));
        params.addValue("citizenship", elem.getCitizenship().getId());
        params.addValue("docType", elem.getDocType().getId());
        params.addValue("docSeries", elem.getDocSeries());
        params.addValue("docNumber", elem.getDocNumber());
        params.addValue("docDate", Date.valueOf(elem.getDocDate()));
        params.addValue("docIssue", elem.getDocIssue());
        params.addValue("regionAddress", elem.getRegionAddress().getId());
        params.addValue("address", elem.getAddress());
        params.addValue("type", elem.getType().getId());
        params.addValue("discount", elem.getDiscount());

        return params;
    }

    private static final RowMapper<Client> rowMapper = new RowMapper<Client>() {
        @Override
        public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
            ClientType clientType = new ClientType();
            clientType.setId(rs.getInt("cltyp_id_n"));
            clientType.setName(rs.getString("cltyp_name_s"));
            clientType.setDiscount(rs.getFloat("cltyp_discount_n"));
            clientType.setColor(rs.getString("cltyp_color_s"));

            DocumType documType = new DocumType();
            documType.setId(rs.getInt("doc_id_n"));
            documType.setName(rs.getString("doc_name_s"));

            Country sitizenCountry = new Country();
            sitizenCountry.setId(rs.getString("citiz_country_id_iso_s"));
            sitizenCountry.setName(rs.getString("citiz_country_name_s"));

            Country addressCountry = new Country();
            addressCountry.setId(rs.getString("addr_country_id_iso_s"));
            addressCountry.setName(rs.getString("addr_country_name_s"));

            Region addressRegion = new Region();
            addressRegion.setId(rs.getInt("region_id_n"));
            addressRegion.setName(rs.getString("region_name_s"));
            addressRegion.setCountry(addressCountry);

            Client client = new Client();
            client.setId(rs.getLong("client_id_n"));
            client.setRegDate(rs.getDate("client_regdate_d").toLocalDate());

            client.setSurname(rs.getString("client_surname_s"));
            client.setName(rs.getString("client_name_s"));
            client.setPatronymic(rs.getString("client_patronymic_s"));
            client.setSex(rs.getBoolean("client_sex_b"));
            client.setBirthday(rs.getDate("client_birthday_d").toLocalDate());
            client.setCitizenship(sitizenCountry);

            client.setDocType(documType);
            client.setDocSeries(rs.getString("client_docser_s"));
            client.setDocNumber(rs.getString("client_docnum_s"));
            client.setDocDate(rs.getDate("client_docdate_d").toLocalDate());
            client.setDocIssue(rs.getString("client_docissue_s"));

            client.setRegionAddress(addressRegion);
            client.setAddress(rs.getString("client_address_s"));

            client.setType(clientType);
            client.setDiscount(rs.getFloat("cltyp_discount_n"));

            return client;
        }
    };

    private void checkId(Client elem) {
        if (elem.getDocType().getId() == 0) documTypeDao.insert(elem.getDocType());
        if (elem.getType().getId() == 0) clientTypeDao.insert(elem.getType());
        if (elem.getRegionAddress().getId() == 0) regionDao.insert(elem.getRegionAddress());
    }

}
