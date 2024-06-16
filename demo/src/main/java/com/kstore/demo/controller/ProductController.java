package com.kstore.demo.controller;


import com.kstore.demo.Models.Products;
import com.kstore.demo.services.ProductServices;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@Data

@RequestMapping("/products")
public class ProductController {

    private ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/{id}")
   public Products getProductById(@PathVariable ("id") long id) {

         return productServices.getProductById(id);

   }

   @PostMapping("/")
   public Products createProducts(@RequestBody Products products){

        return productServices.createProduct(products);
   }

   @PutMapping("/")
   public Products updateProducts(@RequestBody Products products){

       return productServices.updateProduct(products);

   }

    @DeleteMapping("/{id}")
    public void deleteProducts(@PathVariable ("id") long id){

    }

    @GetMapping({"/"})
    public List<Products> getAllProducts(){

        return List.of(productServices.getAllProducts());


    }
}
