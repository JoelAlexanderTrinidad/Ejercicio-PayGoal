package com.app_products.services;


import com.app_products.dtos.ProductsDTO;
import com.app_products.models.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface ProductService {
    void save(Product product);

    Optional<Product> findById(Integer id);
    Optional<Product> findByName(String name);

    Product findByIdDTO(Integer id);

    void deleteById(Integer id);

}
