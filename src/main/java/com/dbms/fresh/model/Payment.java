package com.dbms.fresh.model;

import java.util.Date;
import java.util.List;

public class Payment {
    private int payment_id;
    private Date payment_date;
    private String method;
    private Double price;
    private int order_id;
    private List<Quantity> items;

    public int getPayment_id() {
        return this.payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public Date getPayment_date() {
        return this.payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public List<Quantity> getItems() {
        return this.items;
    }

    public void setItems(List<Quantity> items) {
        this.items = items;
    }

}