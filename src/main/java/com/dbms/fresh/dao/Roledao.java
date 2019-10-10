package com.dbms.fresh.dao;

import javax.transaction.Transactional;

// import com.dbms.fresh.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class Roledao {

    @Autowired
    JdbcTemplate jt;

    // public Object findAll() {

    // }

}
