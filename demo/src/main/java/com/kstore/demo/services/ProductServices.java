package com.kstore.demo.services;

import com.kstore.demo.Models.Products;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public interface ProductServices {

    Products createProduct(Products products);

    Products getProductById(long id);

    Products updateProduct(Products products);

    Products deleteProduct(long id);



    Products[] getAllProducts();
}

