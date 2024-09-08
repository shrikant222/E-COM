package com.example.ECOM.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name="shoes")
public class ListModel {
   @Id
//   @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
   private String name;
   private int  price;
   @Column(name="category")
   @Enumerated(EnumType.STRING)
   private Type  type;


    public enum Type {
        Casual_Shoes,
        Basketball_Shoes,
        Running_Shoes,
        Lifestyle_Shoes;  // Add this line
    }


}
