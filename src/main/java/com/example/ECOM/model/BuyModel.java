package com.example.ECOM.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class BuyModel extends BaseEntity {
    private int buyer_id; // Change from ID to buyer_id to match the table

    @NotBlank(message = "Name should not be blank")
    String name;

    @NotNull(message = "Age should not be null")
    @Min(value = 1, message = "Select Age")
    @Max(value = 120, message = "Age is too big")
    int age;

    @NotBlank(message = "Email should not be blank")
    @Email(message = "Enter a valid email")
    String email;

    @NotBlank(message = "Contact should not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Enter a valid number")
    String contact;

    @NotBlank(message = "Pincode should not be blank")
    @Pattern(regexp = "(^$|[0-9]{6})", message = "Enter a valid pincode")
    String pincode;

    @NotBlank(message = "City should not be blank")
    String city;

    @NotBlank(message = "Country should not be blank")
    String country;

    @Min(value =0, message = "Size not available")
    @Max(value = 12, message = "Size not available")
    int size; // You may also change this to String if needed

    @Size(max = 500, message = "Additional info cannot exceed 500 characters")
    String additional_info;

    @Size(max = 10, message = "Status cannot exceed 10 characters")
    String status;
}
