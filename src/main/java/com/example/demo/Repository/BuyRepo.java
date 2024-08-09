package com.example.demo.Repository;

import com.example.demo.model.BuyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

}
