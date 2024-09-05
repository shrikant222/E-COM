package com.example.ECOM.Repository;

import com.example.ECOM.model.BuyModel;
import com.example.ECOM.rommappers.BuyModelRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BuyRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BuyRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int saveBuyer(BuyModel buyModel) {
        String sql = "INSERT INTO buyer (name, age, email, contact, pincode, city, country, size, additional_info, status, created_at, created_by) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, buyModel.getName(), buyModel.getAge(), buyModel.getEmail(), buyModel.getContact(),
                buyModel.getPincode(), buyModel.getCity(), buyModel.getCountry(), buyModel.getSize(),
                buyModel.getAdditional_info(), buyModel.getStatus(), buyModel.getCreatedAt(), buyModel.getCreatedBy());
    }


    public List<BuyModel> findmsgWithOpenStatus(String status) {
        String sql = "SELECT * FROM `buyer` WHERE `status` = ?";
        return jdbcTemplate.query(sql,new PreparedStatementSetter(){
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status);
            }
        },new BuyModelRowMapper());
    }

}
