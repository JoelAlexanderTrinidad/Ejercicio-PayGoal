package com.app_products.controllers;

import com.app_products.dtos.ProductsDTO;
import com.app_products.models.Product;
import com.app_products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(
            @RequestBody ProductsDTO productsDTO
            ){

        String name = productsDTO.getName();
        String description = productsDTO.getDescription();
        int price = productsDTO.getPrice();
        int quantity = productsDTO.getQuantity();

        String errors = "";

        if(name.isEmpty()){
            errors += "You must enter a name. ";
        }
        if(description.isEmpty()){
            errors += "You must enter a description. ";
        }
        if(price <= 0){
            errors += "Invalid price entered. ";
        }
        if(quantity <= 0){
            errors += "Invalid quantity entered. ";
        }

        if(errors.isEmpty()){
            Product product = new Product(productsDTO.getName(), productsDTO.getDescription(), productsDTO.getPrice(), productsDTO.getQuantity());
            productService.save(product);
            return new ResponseEntity<>("Successfully created product!",HttpStatus.CREATED);
        }

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct(
            @PathVariable Integer id,
            @RequestBody ProductsDTO productsDTO
    ){
        Optional<Product> existingProductOptional = productService.findById(id);

        if(existingProductOptional.isPresent()){
            Product existingProduct = existingProductOptional.get();
            existingProduct.setName(productsDTO.getName());
            existingProduct.setDescription(productsDTO.getDescription());
            existingProduct.setPrice(productsDTO.getPrice());
            existingProduct.setQuantity(productsDTO.getQuantity());

            productService.save(existingProduct);

            return new ResponseEntity<>("Product updated successfully!", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Integer id) {
        Product product = productService.findByIdDTO(id);

        if (product != null) {
            ProductsDTO productsDTO = new ProductsDTO(product);
            return new ResponseEntity<>(productsDTO, HttpStatus.OK);
        } else {
            String errorMessage = "Product not found for id: " + id;
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Integer id){
        Product product = productService.findByIdDTO(id);

        if (product != null) {
            productService.deleteById(id);
            return new ResponseEntity<>("Product successfully removed!" ,HttpStatus.OK);
        } else {

            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
