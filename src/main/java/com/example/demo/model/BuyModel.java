package com.example.demo.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class BuyModel extends BaseEntity{
@NotBlank(message = "name should not Blank")
String name;
@NotNull
@Min(value = 1, message = "TOO small")
@Max(value = 120, message = "TOO BIG")
int age;
@NotBlank(message = "email should not Blank")
@Email
String email;
@NotBlank(message = "contact should not Blank")
@Pattern(regexp ="(^$|[0-9]{10})" , message = "Enter valid number")
String contact;
@Pattern(regexp ="(^$|[0-9]{6})" , message = "Enter valid pincode")
@NotBlank(message = "pincode should not Blank")
String pincode;
@NotBlank(message = "city should not Blank")
String city;
@NotBlank(message = "country should not Blank")
String country;
@NotBlank(message = "size should not Blank")
String size;

String additional_info;

private String status;


}
