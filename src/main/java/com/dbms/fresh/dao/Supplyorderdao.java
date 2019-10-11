package com.dbms.fresh.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.dbms.fresh.model.SupplyOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

@Transactional
@Repository
public class Supplyorderdao {

    @Autowired
    JdbcTemplate jt;

    public void save(int quantity, Double price, int product_id, int supplier_id, int employee_id) {
        Date dt = new Date();
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdfd.format(dt);
        String sql = "insert into supply_order (supply_order_date,supply_order_status,quantity,price,product_id,supplier_id,employee_id) values (?,?,?,?,?,?,?)";
        jt.update(sql, currentDate, "delivered", quantity, price, product_id, supplier_id, employee_id);
    }

    public List<SupplyOrder> getSupplyOrdersbySupplierId(int supplier_id) {
        String sql = "select * from supply_order where supplier_id='" + supplier_id + "'";
        return jt.query(sql, new RowMapper<SupplyOrder>() {
            public SupplyOrder mapRow(ResultSet row, int rowNum) throws SQLException {
                SupplyOrder s = new SupplyOrder();
                s.setSupply_order_id(row.getInt("supply_order_id"));
                s.setSupply_order_date(row.getDate("supply_order_date"));
                s.setSupply_order_status(row.getString("supply_order_status"));
                s.setQuantity(row.getInt("quantity"));
                s.setPrice(row.getDouble("price"));
                s.setProduct_id(row.getInt("product_id"));
                s.setSupplier_id(row.getInt("supplier_id"));
                s.setEmployee_id(row.getInt("employee_id"));
                return s;
            }
        });
    }

}