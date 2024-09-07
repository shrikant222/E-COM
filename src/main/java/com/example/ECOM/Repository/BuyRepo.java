package com.example.ECOM.Repository;

import com.example.ECOM.constants.Constants;
import com.example.ECOM.model.BuyModel;
import com.example.ECOM.rommappers.BuyModelRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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



    public int closeMsg(int id, String name,String status) {
        String sql = "UPDATE `buyer` SET `updated_by` = ?, `updated_at` = ?, `status` = ? WHERE `buyer_id` = ?";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, name);
                ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                ps.setString(3, status);
                ps.setInt(4, id);

            }
        });
    }
//    public int updateMsgStatus(int contactId, String status,String updatedBy) {
//        String sql = "update contact_msg set status = ?, updated_by = ?,updated_at =? where contact_id = ?";
//        return jdbcTemplate.update(sql,new PreparedStatementSetter() {
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setString(1, status);
//                preparedStatement.setString(2, updatedBy);
//                preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
//                preparedStatement.setInt(4, contactId);
//            }
//        });
//    }

}
