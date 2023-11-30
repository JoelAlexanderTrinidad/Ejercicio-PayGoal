package com.app_products.dtos;


import com.app_products.models.Product;

import java.util.Optional;

public class ProductsDTO {

    private int id;
    private String name;
    private String description;
    private int price;
    private int quantity;

    public ProductsDTO(){}

    public ProductsDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
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
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
