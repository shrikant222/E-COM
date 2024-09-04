package com.example.ECOM.rommappers;
import com.example.ECOM.model.BuyModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyModelRowMapper implements RowMapper<BuyModel> {

    @Override
    public BuyModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        BuyModel buyModel = new BuyModel();
        buyModel.setID((int) rs.getInt("ID"));
        buyModel.setName(rs.getString("NAME"));
        buyModel.setAge(rs.getInt("AGE"));
        buyModel.setEmail(rs.getString("EMAIL"));
        buyModel.setContact(rs.getString("CONTACT"));
        buyModel.setPincode(rs.getString("PINCODE"));
        buyModel.setCity(rs.getString("CITY"));
        buyModel.setCountry(rs.getString("COUNTRY"));
        buyModel.setSize(rs.getInt("SIZE"));
        buyModel.setAdditional_info(rs.getString("ADDITIONAL_INFO"));
        buyModel.setStatus(rs.getString("STATUS"));
        buyModel.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
        buyModel.setCreatedBy(rs.getString("CREATED_BY"));

        if (rs.getTimestamp("UPDATED_AT") != null) {
            buyModel.setUpdatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
        }
        buyModel.setUpdatedBy(rs.getString("UPDATED_BY"));

        return buyModel;
    }
}

