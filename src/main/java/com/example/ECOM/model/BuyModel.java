package com.example.ECOM.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name="buyer")
public class BuyModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyer_id;

    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotNull(message = "Age should not be null")
    @Min(value = 1, message = "Select Age")
    @Max(value = 120, message = "Age is too big")
    private int age;

    @NotBlank(message = "Email should not be blank")
    @Email(message = "Enter a valid email")
    private String email;

    @NotBlank(message = "Contact should not be blank")
    @Pattern(regexp = "(^$|\\d{10})", message = "Enter a valid number")
    private String contact;

    @NotBlank(message = "Pincode should not be blank")
    @Pattern(regexp = "(^$|\\d{6})", message = "Enter a valid pincode")
    private String pincode;

    @NotBlank(message = "City should not be blank")
    private String city;

    @NotBlank(message = "Country should not be blank")
    private String country;

    @Min(value =0, message = "Size not available")
    @Max(value = 12, message = "Size not available")
    private int size;

    @Size(max = 500, message = "Additional info cannot exceed 500 characters")
    private String additional_info;

    @Size(max = 10, message = "Status cannot exceed 10 characters")
    private String status;
}
