package com.dbms.fresh.model;

public class OrderItem {
    private int ord_item_id;
    private int order_id;
    private int product_id;
    private int quantity;

    public int getOrd_item_id() {
        return this.ord_item_id;
    }

    public void setOrd_item_id(int ord_item_id) {
        this.ord_item_id = ord_item_id;
    }

    public int getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}