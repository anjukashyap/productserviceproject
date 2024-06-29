package org.example.productserviceevepackage.controller;

import lombok.Getter;
import org.example.productserviceevepackage.models.Product;
import org.example.productserviceevepackage.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("updateproduct/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return  productService.updateProduct(id,product);
    }
}
