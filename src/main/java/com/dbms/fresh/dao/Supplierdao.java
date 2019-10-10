package com.dbms.fresh.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.dbms.fresh.model.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Transactional
@Repository
public class Supplierdao {

    @Autowired
    JdbcTemplate jt;

    public void save(String name, String contact, String email, String house, String street, String city,
            String account) {
        String sql = "insert into supplier (name,contact,email,house_no,street_name,city,account_no) values (?,?,?,?,?,?,?)";
        jt.update(sql, name, contact, email, house, street, city, account);
    }

    public Supplier getSupplierbyId(int id) {
        String sql = "select * from supplier where supplier_id='" + id + "'";
        return jt.queryForObject(sql, new RowMapper<Supplier>() {

            public Supplier mapRow(ResultSet row, int rowNum) throws SQLException {
                Supplier u = new Supplier();
                u.setSupplier_id(row.getInt("supplier_id"));
                u.setName(row.getString("name"));
                u.setContact(row.getString("contact"));
                u.setEmail(row.getString("email"));
                u.setHouse_no(row.getString("house_no"));
                u.setStreet_name(row.getString("street_name"));
                u.setCity(row.getString("city"));
                u.setAccount_no(row.getString("account_no"));
                return u;
            }
        });
    }

    public List<Supplier> showAllsuppliers() {
        String sql = "select * from supplier";
        return jt.query(sql, new RowMapper<Supplier>() {

            public Supplier mapRow(ResultSet row, int rowNum) throws SQLException {
                Supplier u = new Supplier();
                u.setSupplier_id(row.getInt("supplier_id"));
                u.setName(row.getString("name"));
                u.setContact(row.getString("contact"));
                u.setEmail(row.getString("email"));
                u.setHouse_no(row.getString("house_no"));
                u.setStreet_name(row.getString("street_name"));
                u.setCity(row.getString("city"));
                u.setAccount_no(row.getString("account_no"));
                return u;
            }
        });
    }

    public void updateSupplier(int id, String name, String contact, String email, String house, String street,
            String city, String account) {
        String sql = "update supplier set name=?,contact=?,email=?,house_no=?,street_name=?,city=?,account_no=? where supplier_id=?";
        jt.update(sql, name, contact, email, house, street, city, account, id);
    }

    public void deleteSupplier(int id) {
        String sql = "delete from supplier where supplier_id=?";
        jt.update(sql, id);
    }
}