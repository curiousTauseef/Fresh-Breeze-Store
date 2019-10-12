package com.dbms.fresh.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.dbms.fresh.model.OrderItem;
import com.dbms.fresh.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

@Transactional
@Repository
public class Ordersdao {

    @Autowired
    JdbcTemplate jt;

    public int save(String username) {
        Date dt = new Date();
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdfd.format(dt);
        String sql = "insert into orders (status,order_date,username) values (?,?,?)";
        KeyHolder holder = new GeneratedKeyHolder();

        jt.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, "delivered");
                ps.setString(2, currentDate);
                ps.setString(3, username);
                return ps;
            }
        }, holder);

        int newPersonId = holder.getKey().intValue();
        return newPersonId;
    }

    public Orders getorderbyId(int id) {
        String sql = "select * from orders where order_id='" + id + "'";
        return jt.queryForObject(sql, new RowMapper<Orders>() {

            public Orders mapRow(ResultSet row, int rowNum) throws SQLException {
                Orders u = new Orders();
                u.setOrder_id(row.getInt("order_id"));
                u.setStatus(row.getString("status"));
                u.setOrder_date(row.getDate("order_date"));
                u.setUsername(row.getString("username"));
                return u;
            }
        });
    }

    public List<Orders> getOrdersbyusername(String username) {
        String sql = "select * from orders where username='" + username + "'";
        return jt.query(sql, new RowMapper<Orders>() {

            public Orders mapRow(ResultSet row, int rowNum) throws SQLException {
                Orders u = new Orders();
                u.setOrder_id(row.getInt("order_id"));
                u.setStatus(row.getString("status"));
                u.setOrder_date(row.getDate("order_date"));
                u.setUsername(row.getString("username"));
                return u;
            }
        });
    }

    public void updateorder(int order_id) {
        String sql = "update orders set status='delivered' where order_id=?";
        jt.update(sql, order_id);
    }

    public void deleteorder(int order_id) {
        String sql = "delete from orders where order_id=?";
        jt.update(sql, order_id);
    }

    public void check() {
        String sql = "delete from orders where order_id not in (select cid from (select distinct order_item.order_id as cid from order_item natural join orders) as c)";
        jt.update(sql);
    }

    public void createOrderItem(int order_id, int product_id, int quantity) {
        String sql = "insert into order_item (order_id,product_id,quantity) values (?,?,?)";
        jt.update(sql, order_id, product_id, quantity);
    }

    public List<OrderItem> getItemsByOrderId(int order_id) {
        String sql = "select * from order_item where order_id='" + order_id + "'";
        return jt.query(sql, new RowMapper<OrderItem>() {

            public OrderItem mapRow(ResultSet row, int rowNum) throws SQLException {
                OrderItem u = new OrderItem();
                u.setOrder_item_id(row.getInt("ord_item_id"));
                u.setOrder_id(row.getInt("order_id"));
                u.setProduct_id(row.getInt("product_id"));
                u.setQuantity(row.getInt("quantity"));
                return u;
            }
        });
    }

    public void saveFeedback(String type, int rating, String comment, int order_id) {
        String sql = "insert into feedback (type,rating,comment,order_id) values (?,?,?,?)";
        jt.update(sql, type, rating, comment, order_id);
    }

    public boolean feebackExist(int order_id) {
        String sql = "select count(*) from feedback where order_id=?";
        int p = jt.queryForObject(sql, Integer.class, order_id);
        if (p == 0)
            return false;
        else
            return true;
    }
}