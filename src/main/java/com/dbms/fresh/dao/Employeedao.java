package com.dbms.fresh.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.dbms.fresh.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Transactional
@Repository
public class Employeedao {

    @Autowired
    JdbcTemplate jt;

    public void save(String name, String contact, String email, String house, String street, String city, String doj,
            Double salary, String account) {
        String sql = "insert into employee (name,contact,email,house_no,street_name,city,joining_date,salary,account_no) values (?,?,?,?,?,?,?,?,?)";
        jt.update(sql, name, contact, email, house, street, city, doj, salary, account);
    }

    public Employee getEmployeebyId(int id) {
        String sql = "select * from employee where employee_id='" + id + "'";
        return jt.queryForObject(sql, new RowMapper<Employee>() {

            public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
                Employee u = new Employee();
                u.setEmployee_id(row.getInt("employee_id"));
                u.setName(row.getString("name"));
                u.setContact(row.getString("contact"));
                u.setEmail(row.getString("email"));
                u.setHouse_no(row.getString("house_no"));
                u.setStreet_name(row.getString("street_name"));
                u.setCity(row.getString("city"));
                u.setJoining_date(row.getString("joining_date"));
                u.setSalary(row.getDouble("salary"));
                u.setAccount_no(row.getString("account_no"));
                return u;
            }
        });
    }

    public List<Employee> showAllEmployees() {
        String sql = "select * from employee";
        return jt.query(sql, new RowMapper<Employee>() {

            public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
                Employee u = new Employee();
                u.setEmployee_id(row.getInt("employee_id"));
                u.setName(row.getString("name"));
                u.setContact(row.getString("contact"));
                u.setEmail(row.getString("email"));
                u.setHouse_no(row.getString("house_no"));
                u.setStreet_name(row.getString("street_name"));
                u.setCity(row.getString("city"));
                u.setJoining_date(row.getString("joining_date"));
                u.setSalary(row.getDouble("salary"));
                u.setAccount_no(row.getString("account_no"));
                return u;
            }
        });
    }

    public void updateEmployee(int id, String name, String contact, String email, String house, String street,
            String city, String doj, Double salary, String account) {
        String sql = "update employee set name=?,contact=?,email=?,house_no=?,street_name=?,city=?,joining_date=?,salary=?,account_no=? where employee_id=?";
        jt.update(sql, name, contact, email, house, street, city, doj, salary, account, id);
    }

    public void deleteEmployee(int id) {
        String sql = "delete from employee where employee_id=?";
        jt.update(sql, id);
    }
}