package com.example.ECOM.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Roles extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleID;

    private String roleName;
}
