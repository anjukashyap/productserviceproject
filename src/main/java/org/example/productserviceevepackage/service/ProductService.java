package org.example.productserviceevepackage.service;

import org.example.productserviceevepackage.models.Product;

import java.util.List;

public interface ProductService {


    Product getProductById(Long id);

    List<Product> getAllProducts();
}
