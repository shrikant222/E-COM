package com.example.ECOM.rommappers;

import com.example.ECOM.model.ListModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListRowMapper implements RowMapper<ListModel> {
    @Override
    public ListModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        // Extract data from ResultSet
        String name = rs.getString("name");
        int price = rs.getInt("price");
        String category = rs.getString("category");

        // Map category to Type enum
        ListModel.Type type;
        switch (category) {
            case "Casual_Shoes":
                type = ListModel.Type.Casual_Shoes;
                break;
            case "Basketball_Shoes":
                type = ListModel.Type.Basketball_Shoes;
                break;
            case "Running_Shoes":
                type = ListModel.Type.Running_Shoes;
                break;
            case "Lifestyle_Shoes":  // Add case for Lifestyle Shoes
                type = ListModel.Type.Lifestyle_Shoes;
                break;
            default:
                throw new IllegalArgumentException("Unknown shoe category: " + category);
        }

        // Create and return the ListModel object
        return new ListModel(name, price, type);
    }

}
