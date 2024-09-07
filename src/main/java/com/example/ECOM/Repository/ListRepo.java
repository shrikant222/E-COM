package com.example.ECOM.Repository;

import com.example.ECOM.model.BuyModel;
import com.example.ECOM.model.ListModel;
import com.example.ECOM.rommappers.BuyModelRowMapper;
import com.example.ECOM.rommappers.ListRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ListRepo {
    private final JdbcTemplate jdbcTemplate;

    public ListRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ListModel> viewshoes(){
        String sql = "select * from shoes";
        return jdbcTemplate.query(sql, new ListRowMapper());
    }
}



