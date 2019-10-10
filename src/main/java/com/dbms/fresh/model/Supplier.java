package com.dbms.fresh.model;

import java.util.List;

public class Supplier {
    private int supplier_id;
    private String name;
    private String contact;
    private String email;
    private String house_no;
    private String street_name;
    private String city;
    private String account_no;
    private List<SupplyOrder> orders;
    private List<Supplies> supplies;

    public int getSupplier_id() {
        return this.supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHouse_no() {
        return this.house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public String getStreet_name() {
        return this.street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAccount_no() {
        return this.account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
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