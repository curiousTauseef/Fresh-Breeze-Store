package com.dbms.fresh.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.dbms.fresh.model.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

@Transactional
@Repository
public class Paymentdao {

    @Autowired
    JdbcTemplate jt;

    public void save(String method, Double price, int order_id) {
        Date dt = new Date();
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdfd.format(dt);
        String sql = "insert into payment (payment_date,method,price,order_id) values (?,?,?,?)";
        jt.update(sql, currentDate, method, price, order_id);
    }

    public Payment getorderbyId(int id) {
        String sql = "select * from payment where order_id='" + id + "'";
        return jt.queryForObject(sql, new RowMapper<Payment>() {

            public Payment mapRow(ResultSet row, int rowNum) throws SQLException {
                Payment u = new Payment();
                u.setPayment_id(row.getInt("payment_id"));
                u.setPayment_date(row.getDate("payment_date"));
                u.setMethod(row.getString("method"));
                u.setPrice(row.getDouble("price"));
                u.setOrder_id(row.getInt("order_id"));
                return u;
            }
        });
    }

    public List<Payment> getPaymentbyusername(String username) {
        String sql = "select * from payment";
        return jt.query(sql, new RowMapper<Payment>() {

            public Payment mapRow(ResultSet row, int rowNum) throws SQLException {
                Payment u = new Payment();
                u.setPayment_id(row.getInt("payment_id"));
                u.setPayment_date(row.getDate("payment_date"));
                u.setMethod(row.getString("method"));
                u.setPrice(row.getDouble("price"));
                u.setOrder_id(row.getInt("order_id"));
                return u;
            }
        });
    }
}