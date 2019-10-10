package com.dbms.fresh.dao;

import javax.transaction.Transactional;

import com.dbms.fresh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
// import com.dbms.fresh.model.RowMapperUser;
import java.sql.ResultSet;
import java.sql.SQLException;

@Transactional
@Repository
public class Userdao {

    @Autowired
    JdbcTemplate jt;

    public void save(String username, String password, String name, String contact, String email, String house,
            String street, String city, String bank) {
        String sql = "insert into user (username, password,name,contact,email,house_no,street_name,city,account_no,role) values (?,?,?,?,?,?,?,?,?,?)";
        jt.update(sql, username, password, name, contact, email, house, street, city, bank, "customer");
    }

    // public User findByUsername(String username) {
    // String sql = "select * from user where username=?";
    // RowMapper<User> rowMapper = new RowMapperUser();
    // User stud = jt.queryForObject(sql, rowMapper, username);
    // return stud;
    // }
    public User findByUsername(String username) {
        String sql = "select * from user where username=?";
        return jt.queryForObject(sql, new RowMapper<User>() {

            public User mapRow(ResultSet row, int rowNum) throws SQLException {
                User u = new User();
                u.setUsername(row.getString("username"));
                u.setPassword(row.getString("password"));
                u.setName(row.getString("name"));
                u.setContact(row.getString("contact"));
                u.setEmail(row.getString("email"));
                u.setHouse_no(row.getString("house_no"));
                u.setStreet_name(row.getString("street_name"));
                u.setCity(row.getString("city"));
                u.setAccount_no(row.getString("account_no"));
                u.setRole(row.getString("role"));
                return u;
            }
        });
    }
}