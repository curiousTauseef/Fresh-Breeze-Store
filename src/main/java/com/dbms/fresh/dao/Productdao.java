package com.dbms.fresh.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.dbms.fresh.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Transactional
@Repository
public class Productdao {

    @Autowired
    JdbcTemplate jt;

    public void save(String name, Double price, int quantity, int category) {
        String sql = "insert into product (name,selling_price,quantity_left,category_id) values (?,?,?,?)";
        jt.update(sql, name, price, quantity, category);
    }

    public Product getproductbyId(int id) {
        String sql = "select * from product where product_id='" + id + "'";
        return jt.queryForObject(sql, new RowMapper<Product>() {

            public Product mapRow(ResultSet row, int rowNum) throws SQLException {
                Product u = new Product();
                u.setProduct_id(row.getInt("product_id"));
                u.setName(row.getString("name"));
                u.setSelling_price(row.getDouble("selling_price"));
                u.setQuantity_left(row.getInt("quantity_left"));
                u.setCategory_id(row.getInt("category_id"));
                return u;
            }
        });
    }

    public List<Product> showAllProducts() {
        String sql = "select * from product";
        return jt.query(sql, new RowMapper<Product>() {

            public Product mapRow(ResultSet row, int rowNum) throws SQLException {
                Product u = new Product();
                u.setProduct_id(row.getInt("product_id"));
                u.setName(row.getString("name"));
                u.setSelling_price(row.getDouble("selling_price"));
                u.setQuantity_left(row.getInt("quantity_left"));
                u.setCategory_id(row.getInt("category_id"));
                return u;
            }
        });
    }

    public void updateproduct(int id, String name, Double price, int quantity, int category_id) {
        String sql = "update product set name=?,selling_price=?,quantity_left=?,category_id=? where product_id=?";
        jt.update(sql, name, price, quantity, category_id, id);
    }

    public void updateProductquantity(int id, int quantity) {
        String sql = "update product set quantity_left=? where product_id=?";
        jt.update(sql, quantity, id);
    }

    public void deleteproduct(int id) {
        String sql = "delete from product where product_id=?";
        jt.update(sql, id);
    }
}