package com.app_products.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "identity")
    private int id;
    private String name;
    private String description;
    private int price;
    private int quantity;

    public Product(){}

    public Product(String name, String description, int price, int quantity){
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // getters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    // setters
    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}
