package com.dbms.fresh.model;

import java.util.List;

public class Employee {
    private int employee_id;
    private String name;
    private String contact;
    private String email;
    private String house_no;
    private String street_name;
    private String city;
    private String joining_date;
    private Double salary;
    private String account_no;
    private List<Category> category;
    private List<SupplyOrder> orders;

    public int getEmployee_id() {
        return this.employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getJoining_date() {
        return this.joining_date;
    }

    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAccount_no() {
        return this.account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public List<Category> getCategory() {
        return this.category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<SupplyOrder> getOrders() {
        return this.orders;
    }

    public void setOrders(List<SupplyOrder> orders) {
        this.orders = orders;
    }
}