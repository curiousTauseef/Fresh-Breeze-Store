package com.dbms.fresh.model;

import java.util.Date;

public class SupplyOrder {
    private int supply_order_id;
    private Date supply_order_date;
    private String supply_order_status;
    private int quantity;
    private Double price;
    private int product_id;
    private int supplier_id;
    private int employee_id;

    public int getSupply_order_id() {
        return this.supply_order_id;
    }

    public void setSupply_order_id(int supply_order_id) {
        this.supply_order_id = supply_order_id;
    }

    public Date getSupply_order_date() {
        return this.supply_order_date;
    }

    public void setSupply_order_date(Date supply_order_date) {
        this.supply_order_date = supply_order_date;
    }

    public String getSupply_order_status() {
        return this.supply_order_status;
    }

    public void setSupply_order_status(String supply_order_status) {
        this.supply_order_status = supply_order_status;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getEmployee_id() {
        return this.employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getSupplier_id() {
        return this.supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

}