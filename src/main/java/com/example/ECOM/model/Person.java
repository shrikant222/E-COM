package com.example.ECOM.model;

import com.example.ECOM.annotation.FieldsValueMatch;
import com.example.ECOM.annotation.PasswordValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@Entity
@FieldsValueMatch.s({
        @FieldsValueMatch(field = "pwd", fieldMatch = "confirmPwd", message = "Passwords do not match!"),
        @FieldsValueMatch(field = "email", fieldMatch = "confirmEmail", message = "Email addresses do not match!")
})
public class Person extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Confirm Email must not be blank")
    @Email(message = "Please provide a valid confirm email address")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 5, message = "Password must be at least 5 characters long")
    @PasswordValidator
    private String pwd;

    @NotBlank(message = "Confirm Password must not be blank")
    @Size(min = 5, message = "Confirm Password must be at least 5 characters long")
    @Transient
    private String confirmPwd;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Roles.class)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    private Roles roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_cart",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Set<Cart> carts = new HashSet<>();
}
