package com.dbms.fresh.model;

import java.util.Date;
import java.util.List;

public class Orders {
    private int order_id;
    private String status;
    private Date order_date;
    private int order_type;
    private String username;
    private int payment_id;
    private int feedback_id;
    private List<OrderItem> items;

    public int getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrder_date() {
        return this.order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getOrder_type() {
        return this.order_type;
    }

    public void setOrder_type(int order_type) {
        this.order_type = order_type;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPayment_id() {
        return this.payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getFeedback_id() {
        return this.feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public List<OrderItem> getItems() {
        return this.items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}