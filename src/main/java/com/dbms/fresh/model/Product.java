package com.dbms.fresh.model;

import java.util.List;

public class Product {
    private int product_id;
    private String name;
    private Double selling_price;
    private int quantity_left;
    private int category_id;
    private List<OrderItem> items;
    private List<SupplyOrder> orders;
    private List<Supplies> supplies;

    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSelling_price() {
        return this.selling_price;
    }

    public void setSelling_price(Double selling_price) {
        this.selling_price = selling_price;
    }

    public int getQuantity_left() {
        return this.quantity_left;
    }

    public void setQuantity_left(int quantity_left) {
        this.quantity_left = quantity_left;
    }

    public int getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public List<OrderItem> getItems() {
        return this.items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public List<SupplyOrder> getOrders() {
        return this.orders;
    }

    public void setOrders(List<SupplyOrder> orders) {
        this.orders = orders;
    }

    public List<Supplies> getSupplies() {
        return this.supplies;
    }

    public void setSupplies(List<Supplies> supplies) {
        this.supplies = supplies;
    }
}