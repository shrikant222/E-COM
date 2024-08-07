package com.example.demo.model;

import lombok.Data;

@Data
public class ListModel {
   private String name;
   private int  price;
   private Type  type;

    public ListModel(String name, int price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }


    public enum Type{
       Casual_Shoes,
       Basketball_Shoes,
       Running_Shoes;
   }

}
