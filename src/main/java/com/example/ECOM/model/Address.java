package com.example.ECOM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;


    private String address1;

    private String address2;
    @NotBlank(message = "Not Blankkk plz")
    private String city;
    @NotBlank(message = "Not Blankkk plz")
    private String state;
    @NotBlank(message = "Not Blankkk plz")
    @Pattern(regexp = "(^$|\\d{5})")
    private String zip_code;



}
