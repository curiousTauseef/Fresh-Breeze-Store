package com.dbms.fresh.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dbms.fresh.model.User;

public class RowMapperUser implements RowMapper<User> {
    @Override
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
        return u;
    }
}