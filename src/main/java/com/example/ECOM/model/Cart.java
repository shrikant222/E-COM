package com.example.ECOM.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotNull(message = "Price must not be null")
    private Double price;

    private String description;

    @ManyToMany(mappedBy = "carts",fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Person> persons = new HashSet<>();
}
