package com.dbms.fresh.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.dbms.fresh.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Transactional
@Repository
public class Categorydao {

    @Autowired
    JdbcTemplate jt;

    public void save(String name, int employee) {
        String sql = "insert into category (name,employee_id) values (?,?)";
        jt.update(sql, name, employee);
    }

    public Category getCategorybyId(int id) {
        String sql = "select * from category where category_id='" + id + "'";
        return jt.queryForObject(sql, new RowMapper<Category>() {

            public Category mapRow(ResultSet row, int rowNum) throws SQLException {
                Category u = new Category();
                u.setCategory_id(row.getInt("category_id"));
                u.setName(row.getString("name"));
                u.setEmployee_id(row.getInt("employee_id"));
                return u;
            }
        });
    }

    public List<Category> showAllCategories() {
        String sql = "select * from category";
        return jt.query(sql, new RowMapper<Category>() {

            public Category mapRow(ResultSet row, int rowNum) throws SQLException {
                Category u = new Category();
                u.setCategory_id(row.getInt("category_id"));
                u.setName(row.getString("name"));
                u.setEmployee_id(row.getInt("employee_id"));
                return u;
            }
        });
    }

    public void updateCategory(int id, String name, int employee_id) {
        String sql = "update category set name=?,employee_id=? where category_id=?";
        jt.update(sql, name, employee_id, id);
    }

    public void deleteCategory(int id) {
        String sql = "delete from category where category_id=?";
        jt.update(sql, id);
    }
}